//
//  ExamCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxDataSources


class ExamsCell: UITableViewCell, UITableViewDelegate, UITableViewDataSource{
    
    weak var parentVC: ExamsViewController!
    
    @IBOutlet weak var containerViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var containerView: UIView!
    
    @IBOutlet weak var headerContainerView: UIView!
    @IBOutlet weak var headerViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var numberSemestr: UIButton!
    @IBOutlet weak var dropdownButton: UIImageView!
    
    @IBOutlet weak var tableMarks: UITableView!
    @IBOutlet weak var tableMarksHeightConstraiant: NSLayoutConstraint!
    
    var installedGradientLayer: CAGradientLayer!
    var installedGradientLayer2: CAGradientLayer!
    
    var myIndex: IndexPath!
    var disposeBag = DisposeBag()
    
    var dataExam = [ExamsModel]()
    
    
    func configureCell(data: ExamsModel){
        self.makeHeaderGradient()
        self.headerContainerView.makeRounding()
        
        self.setupData(data: data)
        self.setupInOutForTable(countData: data.disciplines.count, data: data)
        self.containerView.makeRounding()
        
        self.tableMarks.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMaxYCorner, .layerMaxXMaxYCorner])
    }
    
    
    func setupData(data: ExamsModel){
        
        self.dataExam = [data]
        self.numberSemestr.setTitle(data.numberSemester, for: .normal)
        self.tableMarks.register(UINib(nibName: "ExamsCellDropdownCell", bundle: nil), forCellReuseIdentifier: "ExamsCellDropdownCellID")
        self.dropdownButton.image = UIImage(named: "dropdown")
        
        self.tableMarks.layoutMargins = UIEdgeInsets.zero
        self.tableMarks.separatorInset = UIEdgeInsets.zero
        
        self.tableMarks.delegate = self
        self.tableMarks.dataSource = self
    }
    
    
    // MARK: Настройка параметров выпадающего списка с оценками
    func setupInOutForTable(countData: Int, data: ExamsModel){
        
        if data.isExpanded{
            self.tableMarks.isHidden = false
            self.dropdownButton.image = UIImage(named: "dropup")
            
            let calculatedTotalHeight = 37 + 76 * countData
            data.myCellHeight = calculatedTotalHeight
            self.tableMarksHeightConstraiant.constant = CGFloat(calculatedTotalHeight)
            self.containerViewHeightConstraint.constant = CGFloat(calculatedTotalHeight)
            self.tableMarks.reloadData()
            
        } else {
            self.containerViewHeightConstraint.constant = 37
        }
        
        let clickedClosure = { [weak self] in
            
            self!.dropdownButton.image = UIImage(named: "dropup")
            data.isExpanded.toggle()
            
            let calculatedTotalHeight = 37 + 76 * countData
            data.myCellHeight = calculatedTotalHeight
            self?.tableMarksHeightConstraiant.constant = CGFloat(calculatedTotalHeight)
            self?.containerViewHeightConstraint.constant = CGFloat(calculatedTotalHeight)
            
            if data.isExpanded{
                self?.parentVC.selectedCellsParametrs.append(SelectedCellParametrs(headerName: data.numberSemester,
                                                                                   selectedCellIndex: (self?.myIndex.section)!,
                                                                                   selecredCellHeight: calculatedTotalHeight))
            } else {
                self?.parentVC.selectedCellsParametrs = (self?.parentVC.selectedCellsParametrs.filter{ [weak self] selectedCellParametr in
                    return selectedCellParametr.headerName != self!.numberSemestr.titleLabel?.text!
                })!
            }
            
            self?.parentVC.contentTableView.isUserInteractionEnabled = false
            self?.tableMarks.reloadData()
            self!.parentVC.contentTableView.performBatchUpdates(nil, completion: { [weak self] _ in
                self?.parentVC.contentTableView.isUserInteractionEnabled = true
                
                if data.isExpanded{
                    self?.tableMarks.isHidden = false
                    self!.dropdownButton.image = UIImage(named: "dropup")
                } else {
                    self?.tableMarks.isHidden = true
                    self!.dropdownButton.image = UIImage(named: "dropdown")
                }
                
            })
        }
        
        self.disposeBag = DisposeBag()
        self.numberSemestr.rx
            .tap
            .subscribe(onNext: { [weak self] _ in
                self!.parentVC.contentTableView.performBatchUpdates(nil, completion: { [weak self] _ in
                    self?.tableMarks.isHidden = false
                    clickedClosure()
                })
        
        }).disposed(by: disposeBag)
        
        self.dropdownButton.rx
            .tapGesture()
            .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            
            self!.parentVC.contentTableView.performBatchUpdates(nil, completion: { [weak self] _ in
                self?.tableMarks.isHidden = false
                clickedClosure()
            })
            
        }).disposed(by: disposeBag)
    }
    
    
    // Градиент для фона ячейки шапки таблицы
    func makeHeaderGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.headerContainerView.bounds
        gradientLayer.colors = [UIColor.secondCourseBackgroundColorStart.cgColor,
                                UIColor.secondCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer != nil{
            self.installedGradientLayer.removeFromSuperlayer()
        }
        self.installedGradientLayer = gradientLayer
        self.headerContainerView.layer.insertSublayer(self.installedGradientLayer, at: 0)
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (dataExam.first?.disciplines.count)!
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ExamsCellDropdownCellID", for: indexPath) as! ExamsCellDropdownCell
        cell.layoutIfNeeded()
        cell.layoutMargins = UIEdgeInsets.zero
        
        if indexPath.row <= (self.dataExam.first?.disciplines.count)! - 1{
            let dataForCell = self.dataExam.first?.disciplines[indexPath.row].discipline
            cell.configureCell(pairDisciplineMark: dataForCell!)
        }
        return cell
    }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView()
        headerView.backgroundColor = .red
        
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = CGRect(x: 0, y: 0, width: self.frame.width,
                                     height: 10)
        gradientLayer.colors = [UIColor.secondCourseBackgroundColorStart.cgColor,
                                UIColor.secondCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer2 != nil{
            self.installedGradientLayer2.removeFromSuperlayer()
        }
        self.installedGradientLayer2 = gradientLayer
        headerView.layer.insertSublayer(self.installedGradientLayer2, at: 0)
        
        return headerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 10.0
    }
    
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        
        //print("Готовлю к переиспользованию: \(self.myIndex.section)")
        self.containerViewHeightConstraint.constant = 37
        self.myIndex = nil
        self.numberSemestr.setTitle("", for: .normal)
        self.disposeBag = DisposeBag()
    }
}


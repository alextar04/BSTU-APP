//
//  AttestationCell.swift
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


class AttestationCell: UITableViewCell, UITableViewDelegate, UITableViewDataSource{
    
    weak var parentVC: AttestationViewController!
    
    @IBOutlet weak var containerViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var containerView: UIView!
    
    @IBOutlet weak var headerContainerView: UIView!
    @IBOutlet weak var headerViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var dateRange: UIButton!
    @IBOutlet weak var dropdownButton: UIImageView!
    
    @IBOutlet weak var tableMarks: UITableView!
    @IBOutlet weak var tableMarksHeightConstraiant: NSLayoutConstraint!
    var installedGradientLayer: CAGradientLayer!
    var installedGradientLayer2: CAGradientLayer!
    
    var myIndex: IndexPath!
    var isExpanded = false
    var disposeBag = DisposeBag()
    
    var dataAttestation = [AttestationModel]()
    
    
    func configureCell(data: AttestationModel){
        self.makeHeaderGradient()
        self.headerContainerView.makeRounding()
        
        self.setupData(data: data)
        self.setupInOutForTable(countData: data.disciplines.count, data: data)
        self.containerView.makeRounding()
        
        self.tableMarks.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMaxYCorner, .layerMaxXMaxYCorner])
    }
    
    
    func setupData(data: AttestationModel){
        
        self.dataAttestation = [data]
        self.dateRange.setTitle(data.dataRange, for: .normal)
        self.tableMarks.register(UINib(nibName: "AttestationCellDropdownCell", bundle: nil), forCellReuseIdentifier: "AttestationCellDropdownCellID")
        self.dropdownButton.image = UIImage(named: "dropdown")
        
        self.tableMarks.layoutMargins = UIEdgeInsets.zero
        self.tableMarks.separatorInset = UIEdgeInsets.zero
        
        self.tableMarks.delegate = self
        self.tableMarks.dataSource = self
        
    }
    
    
    // MARK: Настройка параметров выпадающего списка с оценками
    func setupInOutForTable(countData: Int, data: AttestationModel){
        
        if data.isExpanded{
            self.tableMarks.isHidden = false
            self.dropdownButton.image = UIImage(named: "dropup")
            
            let calculatedTotalHeight = 37 + 44 * countData
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
            
            let calculatedTotalHeight = 37 + 44 * countData
            data.myCellHeight = calculatedTotalHeight
            self?.tableMarksHeightConstraiant.constant = CGFloat(calculatedTotalHeight)
            self?.containerViewHeightConstraint.constant = CGFloat(calculatedTotalHeight)
            
            if data.isExpanded{
                self?.parentVC.selectedCellsParametrs.append(SelectedCellParametrs(headerName: data.dataRange,
                                                                                   selectedCellIndex: (self?.myIndex.section)!,
                                                                                   selecredCellHeight: calculatedTotalHeight))
            } else {
                self?.parentVC.selectedCellsParametrs = (self?.parentVC.selectedCellsParametrs.filter{ [weak self] selectedCellParametr in
                    return selectedCellParametr.headerName != self!.dateRange.titleLabel?.text!
                })!
            }
            
            self?.parentVC.contentView.isUserInteractionEnabled = false
            self?.tableMarks.reloadData()
            self!.parentVC.contentView.performBatchUpdates(nil, completion: { [weak self] _ in
                self?.parentVC.contentView.isUserInteractionEnabled = true
                
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
        self.dateRange.rx
            .tap
            .subscribe(onNext: { [weak self] _ in
                self!.parentVC.contentView.performBatchUpdates(nil, completion: { [weak self] _ in
                    self?.tableMarks.isHidden = false
                    clickedClosure()
                })
        
        }).disposed(by: disposeBag)
        
        self.dropdownButton.rx
            .tapGesture()
            .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            
            self!.parentVC.contentView.performBatchUpdates(nil, completion: { [weak self] _ in
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
        return (dataAttestation.first?.disciplines.count)!
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "AttestationCellDropdownCellID", for: indexPath) as! AttestationCellDropdownCell
        cell.layoutIfNeeded()
        cell.layoutMargins = UIEdgeInsets.zero
    
        if indexPath.row <= (self.dataAttestation.first?.disciplines.count)! - 1{
            let dataForCell = self.dataAttestation.first?.disciplines[indexPath.row].discipline
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
        
        self.containerViewHeightConstraint.constant = 37
        self.myIndex = nil
        self.dateRange.setTitle("", for: .normal)
        self.disposeBag = DisposeBag()
    }
    
}

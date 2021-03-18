//
//  AttestationCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import UIKit

class AttestationCell: UIView{
    
    @IBOutlet weak var containerView: UIView!
    @IBOutlet weak var containerViewHeightConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var headerContainerView: UIView!
    @IBOutlet weak var headerViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var dateRange: UIButton!
    @IBOutlet weak var dropdownButton: UIImageView!
    
    @IBOutlet weak var tableMarks: UITableView!
    @IBOutlet weak var tableMarksHeightConstraiant: NSLayoutConstraint!
    var installedGradientLayer: CAGradientLayer!
    
    var personalInformationViewIsOpen = false
    let disposeBag = DisposeBag()
    
    
    func configureCell(data: AttestationModel){
        self.headerContainerView.makeRounding()
        self.makeGradient()
        self.tableMarks.makeRounding()
        self.containerView.makeRounding()
        
        self.setupData(data: data)
        self.setupInOutForTable(countData: data.disciplines.count)
    }
    
    
    func setupData(data: AttestationModel){
        
        self.tableMarks.register(UINib(nibName: "AttestationCellDropdownCell", bundle: nil), forCellReuseIdentifier: "AttestationCellDropdownCellID")
        
        // Высота таблицы = количество промежутков дат * высота одной ячейки
        let disciplines = data.disciplines
        self.containerViewHeightConstraint.constant = 37
        self.headerViewHeightConstraint.constant = 37
        self.tableMarksHeightConstraiant.constant = 0
        
        Observable.just(disciplines!).bind(to: self.tableMarks.rx.items){
            [weak self] (tableView, row, element) in
            let cell = self!.tableMarks.dequeueReusableCell(withIdentifier: "AttestationCellDropdownCellID") as! AttestationCellDropdownCell
            cell.frame = CGRect(x: 0, y: 0,
                                width: self!.tableMarks.frame.width, height: 44)
            cell.configureCell(pairDisciplineMark: element)
            return cell
        }.disposed(by: self.disposeBag)
    }
    
    
    // MARK: Настройка параметров выпадающего списка с оценками
    func setupInOutForTable(countData: Int){
        self.tableMarksHeightConstraiant.constant = 0
        
        let clickedClosure = { [weak self] in
            var newValueHeight: CGFloat!
            var newValueContainerHeight: CGFloat!
            if self!.personalInformationViewIsOpen{
                newValueHeight = 0
                newValueContainerHeight = 37
            } else{
                newValueHeight = CGFloat(44 * countData)
                newValueContainerHeight = newValueHeight + 37
            }
            
            UIView.animate(
                withDuration: 0.4,
                delay: 0,
                usingSpringWithDamping: 1,
                initialSpringVelocity: 1,
            options: .curveEaseInOut,
            animations: {
                self!.headerViewHeightConstraint.constant = 37
                self!.tableMarksHeightConstraiant.constant = newValueHeight
                self!.containerViewHeightConstraint.constant = newValueContainerHeight
                
                if (!self!.personalInformationViewIsOpen){
                    self!.headerContainerView.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMinYCorner, .layerMaxXMinYCorner])
                    self!.tableMarks.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMaxYCorner, .layerMaxXMaxYCorner])
                }
                
                (!self!.personalInformationViewIsOpen) ?
                    (self!.dropdownButton.image = UIImage(named: "dropup")) : (self!.dropdownButton.image = UIImage(named: "dropdown"))
                
                self!.layoutIfNeeded()
            }, completion: { [weak self] _ in
                self!.personalInformationViewIsOpen.toggle()
                
                if !self!.personalInformationViewIsOpen{
                    self!.headerContainerView.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMinYCorner, .layerMinXMaxYCorner,
                                                                                         .layerMaxXMinYCorner, .layerMaxXMaxYCorner])
                }
            })
        }
        
        self.dateRange.rx
            .tap
            .subscribe(onNext: { [weak self] _ in
            clickedClosure()
        }).disposed(by: disposeBag)
        
        self.dropdownButton.rx
            .tapGesture()
            .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            clickedClosure()
        }).disposed(by: disposeBag)
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
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
}

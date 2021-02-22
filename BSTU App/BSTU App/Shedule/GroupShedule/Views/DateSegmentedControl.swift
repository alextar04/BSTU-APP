//
//  DateSegmentedControl.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa


class DateSegmentedControl{
    
    var firstDraw = true
    var constraintBottomUnderlineLeftOffset: NSLayoutConstraint!
    let disposeBag = DisposeBag()
    
    // Горизонтальная полоса "Дни недели"
    public lazy var weekDaysSegmentedControl: UISegmentedControl = {
        let segmentedControl = UISegmentedControl()
        
        // Стандартное состояние
        segmentedControl.setTitleTextAttributes([
            NSAttributedString.Key.foregroundColor: UIColor.lightGray,
            NSAttributedString.Key.font: UIFont.systemFont(ofSize: 15, weight: .bold)],
                                    for: [.normal])
        
        segmentedControl.backgroundColor = .clear
        segmentedControl.tintColor = .clear
        for (index, day) in ["ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС"].enumerated(){
            segmentedControl.insertSegment(withTitle: day, at: index, animated: true)
        }
        
        segmentedControl.selectedSegmentIndex = 0
        return segmentedControl
    }()
    
    
    // Горизонтальная полоса "Числа календаря"
    public lazy var numbersOfCalendarSegmentedControl: UISegmentedControl = {
        
        let segmentedControl = UISegmentedControl()
        segmentedControl.backgroundColor = .clear
        segmentedControl.tintColor = .clear
        
        // Стандартное состояние
        segmentedControl.setTitleTextAttributes([
            NSAttributedString.Key.foregroundColor: UIColor.black,
            NSAttributedString.Key.font: UIFont.systemFont(ofSize: 15, weight: .bold)],
                                    for: [.normal])

        // Состояние сегодняшней даты
        segmentedControl.setTitleTextAttributes([
            NSAttributedString.Key.foregroundColor: UIColor.blue,
            NSAttributedString.Key.font: UIFont.systemFont(ofSize: 15, weight: .bold)],
            for: .selected)
        
        for (index, day) in ["15", "16", "17", "18", "19", "20", "21"].enumerated(){
            segmentedControl.insertSegment(withTitle: day, at: index, animated: true)
        }
        
        segmentedControl.selectedSegmentIndex = 0
        return segmentedControl
    }()
    
    
    // Горизонтальная полоса под "Числа календаря"
    public lazy var bottomUnderlineView: UIView = {
        let underlineView = UIView()
        underlineView.backgroundColor = .blue
        underlineView.translatesAutoresizingMaskIntoConstraints = false
        return underlineView
    }()
    
    
    // MARK: Установка вида с датой
    func setupView(stackView: UIStackView){
        
        stackView.addArrangedSubview(weekDaysSegmentedControl)
        stackView.addArrangedSubview(numbersOfCalendarSegmentedControl)
        stackView.addArrangedSubview(bottomUnderlineView)
        
        let underlineViewHeight = 2.0
        NSLayoutConstraint.activate([
            bottomUnderlineView.heightAnchor.constraint(equalToConstant: CGFloat(underlineViewHeight)),
            bottomUnderlineView.widthAnchor.constraint(equalTo: numbersOfCalendarSegmentedControl.widthAnchor,
                                                       multiplier: 1 / CGFloat(numbersOfCalendarSegmentedControl.numberOfSegments)),
            ])
        self.constraintBottomUnderlineLeftOffset = bottomUnderlineView.leftAnchor.constraint(equalTo: numbersOfCalendarSegmentedControl.leftAnchor,
                                                                                             constant: 0)
        self.constraintBottomUnderlineLeftOffset.isActive = true
        
        
        numbersOfCalendarSegmentedControl
            .rx
            .selectedSegmentIndex
            .subscribe(onNext: { index in
                if !self.firstDraw{
                    self.changeSegmentedControlLinePosition(stackView: stackView, index: index)
                    let data: [String: Any] = ["dayIndex": index]
                    NotificationCenter.default.post(name: Notification.Name("ChangeDay"), object: nil, userInfo: data)
                }
                self.firstDraw = false
            }).disposed(by: disposeBag)
    }
    
    
    // Смена позиции линии под датой
    public func changeSegmentedControlLinePosition(stackView: UIStackView, index: Int? = nil, direction: direction? = nil) {
       
        var segmentIndex: CGFloat!
        if index != nil{
            segmentIndex = CGFloat(index!)
        }
        
        if direction != nil{
            let currentSelectedIndex = numbersOfCalendarSegmentedControl.selectedSegmentIndex
            
            switch direction! {
            case .increment:
                if currentSelectedIndex != numbersOfCalendarSegmentedControl.numberOfSegments-1{
                    segmentIndex = CGFloat(currentSelectedIndex + 1)
                    numbersOfCalendarSegmentedControl.selectedSegmentIndex = Int(segmentIndex)
                }
            case .decrement:
                if currentSelectedIndex != 0{
                    segmentIndex = CGFloat(currentSelectedIndex - 1)
                    numbersOfCalendarSegmentedControl.selectedSegmentIndex = Int(segmentIndex)
                }
            default:
                fatalError()
            }
        }
        
        if segmentIndex != nil{
            let segmentWidth = numbersOfCalendarSegmentedControl.frame.width / CGFloat(numbersOfCalendarSegmentedControl.numberOfSegments)
            let leadingDistance = segmentWidth * segmentIndex
            
            UIView.animate(withDuration: 0.2, animations: { [weak self] in
                self!.constraintBottomUnderlineLeftOffset.constant = leadingDistance
                stackView.layoutIfNeeded()
            })
        }
    }
}

enum direction{
    case increment
    case decrement
}

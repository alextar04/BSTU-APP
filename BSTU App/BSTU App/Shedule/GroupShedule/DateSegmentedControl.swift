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
    private lazy var weekDaysSegmentedControl: UISegmentedControl = {
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
    private lazy var numbersOfCalendarSegmentedControl: UISegmentedControl = {
        
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
    private lazy var bottomUnderlineView: UIView = {
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
                    self.changeSegmentedControlLinePosition(stackView: stackView)
                }
                self.firstDraw = false
            }).disposed(by: disposeBag)

    }
    
    
    // Смена позиции линии под датой
    private func changeSegmentedControlLinePosition(stackView: UIStackView) {
        let segmentIndex = CGFloat(numbersOfCalendarSegmentedControl.selectedSegmentIndex)
        let segmentWidth = numbersOfCalendarSegmentedControl.frame.width / CGFloat(numbersOfCalendarSegmentedControl.numberOfSegments)
        let leadingDistance = segmentWidth * segmentIndex
        
        UIView.animate(withDuration: 0.2, animations: { [weak self] in
            self!.constraintBottomUnderlineLeftOffset.constant = leadingDistance
            stackView.layoutIfNeeded()
        })
    }
}

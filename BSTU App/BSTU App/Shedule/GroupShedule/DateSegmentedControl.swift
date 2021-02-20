//
//  DateSegmentedControl.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class DataSegmentedControl{
    
    private lazy var bottomUnderlineView: UIView = {
        let underlineView = UIView()
        underlineView.backgroundColor = .blue
        return underlineView
    }()
    
    private lazy var segmentedControl: UISegmentedControl = {
        let segmentedControl = UISegmentedControl()
        
        // Стандартное состояние
        segmentedControl.setTitleTextAttributes([
            NSAttributedString.Key.foregroundColor: UIColor.black],
                                               for: [.normal, .selected])

        // Состояние сегодняшней даты
        /*
        segmentedControl.setTitleTextAttributes([
            NSAttributedString.Key.foregroundColor: UIColor.blue],
            for: .selected)
        */
        
        return segmentedControl
    }()
    
    
    // MARK: Установка вида с датой
    func setupView(){
        
        segmentedControl.backgroundColor = .clear
        segmentedControl.tintColor = .clear

        // Добавить числа дней недели из календаря
        segmentedControl.insertSegment(withTitle: "15", at: 0, animated: true)
        segmentedControl.insertSegment(withTitle: "16", at: 1, animated: true)
        segmentedControl.insertSegment(withTitle: "17", at: 2, animated: true)
        segmentedControl.insertSegment(withTitle: "18", at: 3, animated: true)
        segmentedControl.insertSegment(withTitle: "19", at: 4, animated: true)
        segmentedControl.insertSegment(withTitle: "20", at: 5, animated: true)
        segmentedControl.insertSegment(withTitle: "21", at: 6, animated: true)
        
        segmentedControl.selectedSegmentIndex = 0
        let underlineViewHeight = 2
    }
    
    // Смена позиции линии под датой
    private func changeSegmentedControlLinePosition() {
        let segmentIndex = CGFloat(segmentedControl.selectedSegmentIndex)
        let segmentWidth = segmentedControl.frame.width / CGFloat(segmentedControl.numberOfSegments)
        let leadingDistance = segmentWidth * segmentIndex
        UIView.animate(withDuration: 0.3, animations: { [weak self] in
            print("Какая-то анимация")
        })
    }
}

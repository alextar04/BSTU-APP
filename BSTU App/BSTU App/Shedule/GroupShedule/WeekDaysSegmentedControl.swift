//
//  WeekDaysSegmentedControls.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class WeekDaysSegmentedControl{
    
       private lazy var segmentedControl: UISegmentedControl = {
           let segmentedControl = UISegmentedControl()
           
           // Стандартное состояние
           segmentedControl.setTitleTextAttributes([
               NSAttributedString.Key.foregroundColor: UIColor.black],
                                                  for: .normal, .selected)
           
           return segmentedControl
       }()
       
       
       // MARK: Установка вида с датой
       func setupView(){
           
           segmentedControl.backgroundColor = .clear
           segmentedControl.tintColor = .clear

           segmentedControl.insertSegment(withTitle: "ПН", at: 0, animated: true)
           segmentedControl.insertSegment(withTitle: "ВТ", at: 1, animated: true)
           segmentedControl.insertSegment(withTitle: "СР", at: 3, animated: true)
           segmentedControl.insertSegment(withTitle: "ЧТ", at: 4, animated: true)
           segmentedControl.insertSegment(withTitle: "ПТ", at: 5, animated: true)
           segmentedControl.insertSegment(withTitle: "СБ", at: 6, animated: true)
           segmentedControl.insertSegment(withTitle: "ВС", at: 7, animated: true)
           
           segmentedControl.selectedSegmentIndex = 0
       }
}

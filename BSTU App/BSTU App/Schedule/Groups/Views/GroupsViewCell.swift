//
//  GroupsViewCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 26.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class GroupsViewCell: UITableViewCell{
    
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundedView: UIView!
    @IBOutlet weak var groupLabel: UILabel!
    var installedGradientLayer: CAGradientLayer!
    
    
    func configureCell(name: String, courseNumber: Int){
        self.shadowView.groupsMakeShadow(width: Int(self.shadowView.frame.width), heigth: Int(self.shadowView.frame.height))
        self.roundedView.makeRounding()
        self.makeGradient(courseNumber: courseNumber)
        self.groupLabel.text = name
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(courseNumber: Int){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundedView.bounds
        switch courseNumber {
        case 1:
            gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor, UIColor.firstCourseBackgroundColorFinish.cgColor]
        case 2:
            gradientLayer.colors = [UIColor.secondCourseBackgroundColorStart.cgColor, UIColor.secondCourseBackgroundColorFinish.cgColor]
        case 3:
            gradientLayer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor, UIColor.thirdCourseBackgroundColorFinish.cgColor]
        case 4:
            gradientLayer.colors = [UIColor.fourthCourseBackgroundColorStart.cgColor, UIColor.fourthCourseBackgroundColorFinish.cgColor]
        case 5:
            gradientLayer.colors = [UIColor.fifthCourseBackgroundColorStart.cgColor, UIColor.fifthCourseBackgroundColorFinish.cgColor]
        default:
            gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor, UIColor.firstCourseBackgroundColorStart.cgColor]
        }
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        
        if self.installedGradientLayer != nil{
            self.installedGradientLayer.removeFromSuperlayer()
        }
        self.installedGradientLayer = gradientLayer
        self.roundedView.layer.insertSublayer(self.installedGradientLayer, at: 0)
    }
}

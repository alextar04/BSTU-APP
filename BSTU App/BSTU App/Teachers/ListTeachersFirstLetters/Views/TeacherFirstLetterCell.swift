//
//  TeacherFirstLetterCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class TeacherFirstLetterCell: UICollectionViewCell{
    
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundedView: UIView!
    @IBOutlet weak var firstLetterLabel: UILabel!
    
    var installedGradientLayer: CAGradientLayer!
    
    
    func configureCell(name: String){
        self.shadowView.makeTeacherFirstLetterShadow(width: Int(self.shadowView.frame.width),
                                                     height: Int(self.shadowView.frame.height))
        
        self.makeGradient()
        self.roundedView.layer.backgroundColor = UIColor.white.cgColor
        self.roundedView.layer.cornerRadius = 10.0
        self.roundedView.layer.masksToBounds = false
        
        self.firstLetterLabel.text = name
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        
        gradientLayer.backgroundColor = UIColor.white.cgColor
        gradientLayer.cornerRadius = 10.0
        gradientLayer.masksToBounds = false
        
        gradientLayer.frame = self.roundedView.bounds
        gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor,
                                UIColor.firstCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer != nil{
            self.installedGradientLayer.removeFromSuperlayer()
        }
        self.installedGradientLayer = gradientLayer
        self.roundedView.layer.insertSublayer(self.installedGradientLayer, at: 0)
    }
    
}


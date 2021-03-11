//
//  ListTeachersTableCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 11.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit


class ListTeachersTableCell: UITableViewCell{
    
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundedView: UIView!
    @IBOutlet weak var nameLabel: UILabel!
    var installedGradientLayer: CAGradientLayer!
    
    
    func configureCell(name: String){
        self.shadowView.groupsMakeShadow(width: Int(self.shadowView.frame.width), heigth: Int(self.shadowView.frame.height))
        self.roundedView.makeRounding()
        self.makeGradient()
        self.nameLabel.text = name
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundedView.bounds
        gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor, UIColor.firstCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer != nil{
            self.installedGradientLayer.removeFromSuperlayer()
        }
        self.installedGradientLayer = gradientLayer
        self.roundedView.layer.insertSublayer(self.installedGradientLayer, at: 0)
    }
}


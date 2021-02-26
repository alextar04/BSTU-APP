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
    
    
    func configureCell(name: String){
        self.shadowView.groupsMakeShadow(width: Int(self.shadowView.frame.width), heigth: Int(self.shadowView.frame.height))
        self.roundedView.makeRounding()
        self.makeGradient()
        self.groupLabel.text = name
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundedView.bounds
        gradientLayer.colors = [UIColor.institutionBackgroundColorStart.cgColor, UIColor.institutionBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.roundedView.layer.insertSublayer(gradientLayer, at: 0)
    }
}

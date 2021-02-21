//
//  GroupSheduleCard.swift
//  BSTU App
//
//  Created by Alexey Taran on 21.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class GroupSheduleCard: UIView{
    
    @IBOutlet weak var typeLesson: UILabel!
    
    func setupView(){
        
        self.makeGradient()
        self.makeRounding()
        self.updateStyleTypeLesson()
    }
    
    
    // Градиент для карточки
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.lightGray.cgColor, UIColor.sheduleLightGrayColor.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0)
        gradientLayer.endPoint = CGPoint(x: 1, y: 1)
        
        self.layer.insertSublayer(gradientLayer, at: 0)
    }
    
    
    // Установка стиля label типа урока
    func updateStyleTypeLesson(){
        self.typeLesson.makeRounding()
        self.typeLesson.layer.borderWidth = 3
        self.typeLesson.layer.borderColor = UIColor.lightGray.cgColor
        self.typeLesson.font = UIFont.boldSystemFont(ofSize: 14.0)
        self.typeLesson.backgroundColor = .clear
    }
    
}

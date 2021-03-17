//
//  PersonalCabinetViewExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIView{
    
    // MARK: Добавление серого градиента для фона View
    func addViewGrayGradientStyle(){
        
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.lightGrayColor.cgColor,
                                UIColor.lightGrayColor.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.layer.insertSublayer(gradientLayer, at: 0)
    }
    
    
    // MARK: Добавление голубого градиента для фона View
    func addViewBlueGradientStyle(){
        
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor,
                                UIColor.thirdCourseBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.layer.insertSublayer(gradientLayer, at: 0)
    }
    
    
    // MARK: Тень для карточки разделов личного кабинета
    func personalCabinetCardMakeShadow(width: Int, heigth: Int){
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowRadius = 4.0
        self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: 0, y: heigth/2,
                                                              width: width, height: heigth/2 - 3), transform: nil)

        self.layer.shadowOpacity = 0.15;
        self.layer.shadowOffset = CGSize(width: 0, height: 0)
    }
}


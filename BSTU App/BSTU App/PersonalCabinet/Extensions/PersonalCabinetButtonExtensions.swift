//
//  ButtonExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIButton{
    
    // MARK: Добавление градиента для фона кнопки "Вход в систему"
    func makeSigninButtonStyle(){
        
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor,
                                UIColor.thirdCourseBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.layer.insertSublayer(gradientLayer, at: 0)
    }
}

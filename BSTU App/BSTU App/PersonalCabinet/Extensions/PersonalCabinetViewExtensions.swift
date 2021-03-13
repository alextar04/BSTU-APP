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
    
    // MARK: Добавление градиента для фона "Обратной связи" входа в систему
    func makeSigninFeedbackViewStyle(){
        
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.lightGrayColor.cgColor,
                                UIColor.lightGrayColor.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.layer.insertSublayer(gradientLayer, at: 0)
    }
}

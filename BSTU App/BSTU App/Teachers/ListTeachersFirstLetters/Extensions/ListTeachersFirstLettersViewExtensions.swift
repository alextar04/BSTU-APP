//
//  ListTeachersFirstLettersViewExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIView{
    
    func makeTeacherFirstLetterShadow(width: Int, height: Int){
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowRadius = 15.0
        self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: 0, y: height / 2,
                                                              width: width, height: height / 2),
                                            transform: nil)

        self.layer.shadowOpacity = 0.2;
        self.layer.shadowOffset = CGSize(width: 0, height: 0)
    }
}

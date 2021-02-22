//
//  SheduleViewExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 22.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIView{
    func sheduleMakeShadow(width: Int, heigth: Int){
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowRadius = 4.0
        self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: 0, y: 0,
                                                              width: width, height: heigth + 4), transform: nil)

        self.layer.shadowOpacity = 0.2;
        self.layer.shadowOffset = CGSize(width: 0, height: 0)
    }
}
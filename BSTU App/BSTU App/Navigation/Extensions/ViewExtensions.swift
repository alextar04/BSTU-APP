//
//  ViewExtensions.swift
//  MapMarker
//
//  Created by Alexey Taran on 20.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIView{
    
    func makeShadow(width: Int, heigth: Int){
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowRadius = 8.0
        self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: -8, y: -10,
                                                              width: width + 16, height: heigth), transform: nil)
 
        self.layer.shadowOpacity = 0.2;
        self.layer.shadowOffset = CGSize(width: 0, height: 0)
    }
    
    
    func makeShadowNewDevices(width: Int, heigth: Int, iosBottomBarHeight: Int){
        self.layer.shadowColor = UIColor.black.cgColor
        self.layer.shadowRadius = 8.0
        self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: -8, y: -(iosBottomBarHeight)-10,
                                                                     width: width + 16, height: heigth), transform: nil)
        
        self.layer.shadowOpacity = 0.2;
        self.layer.shadowOffset = CGSize(width: 0, height: 0)
    }
    
    
    func makeCorpShadow(width: Int, heigth: Int){
           self.layer.shadowColor = UIColor.black.cgColor
           self.layer.shadowRadius = 8.0
           self.layer.shadowPath = CGPath.init(rect: CGRect.init(x: -8, y: -10,
                                                                 width: width + 16, height: heigth + 20), transform: nil)
    
           self.layer.shadowOpacity = 0.2;
           self.layer.shadowOffset = CGSize(width: 0, height: 0)
       }
    
    func makeRounding(){
        self.layer.cornerRadius = 10.0
        self.layer.masksToBounds = true
    }
}

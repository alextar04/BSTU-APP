//
//  ButtonExtensions.swift
//  MapSection
//
//  Created by Alexey Taran on 21.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIButton{
    func makeRoundingButton(){
        self.layer.cornerRadius = 5.0
        self.layer.masksToBounds = true
    }
    
    func makeCancelPremiseInputtingView(){
        self.setTitle("Назад", for: .normal)
        self.setTitleColor(.black, for: .normal)
        self.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18.0)
        self.backgroundColor = .cancelInputPremiseColor
        self.makeRoundingButton()
    }
}

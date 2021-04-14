//
//  SheduleImageExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 22.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIImageView{
    func sheduleMakeRoundingImage(){
        self.layer.cornerRadius = self.frame.height/2
        self.layer.masksToBounds = true
    }
}

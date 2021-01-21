//
//  ImageExtensions.swift
//  MapSection
//
//  Created by Alexey Taran on 21.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIImageView{
    func makeRoundingImage(){
        self.layer.cornerRadius = 10.0
        self.layer.masksToBounds = true
    }
}

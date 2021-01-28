//
//  ColorExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 27.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIColor{
    static var lightGrayColor: UIColor{
        return UIColor(red: 229.0/255.0, green: 229.0/255.0, blue: 234.0/255.0, alpha: 0.3)
    }
    
    static var corpBackgroundGrayColor: UIColor{
        let color: UIColor = .lightGray
        return color.withAlphaComponent(0.4)
    }
    
    static var cancelInputPremiseColor: UIColor{
        return UIColor(red: 229.0/255.0, green: 229.0/255.0, blue: 234.0/255.0, alpha: 1.0)
    }
}

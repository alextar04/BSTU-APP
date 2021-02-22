//
//  ColorExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 21.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UIColor{
    static var sheduleLightGrayColor: UIColor{
        return UIColor(red: 229.0/255.0, green: 229.0/255.0, blue: 234.0/255.0, alpha: 1.0)
    }
    
    
    static var lectionsBackgroundColorStart: UIColor{
        return UIColor(red: 250.0/255.0, green: 255.0/255.0, blue: 255.0/255.0, alpha: 1.0)
    }
    static var lectionsBackgroundColorFinish: UIColor{
        return UIColor(red: 220.0/255.0, green: 255.0/255.0, blue: 255.0/255.0, alpha: 1.0)
    }
    static var lectionsSubjectColor: UIColor{
        return UIColor(red: 0/255.0, green: 153/255.0, blue: 204/255.0, alpha: 1.0)
    }
    
    
    static var practiceBackgroundColorStart: UIColor{
        return UIColor(red: 255.0/255.0, green: 255.0/255.0, blue: 250.0/255.0, alpha: 1.0)
    }
    static var practiceBackgroundColorFinish: UIColor{
        return UIColor(red: 255.0/255.0, green: 255.0/255.0, blue: 204/255.0, alpha: 1.0)
    }
    static var practiceSubjectColor: UIColor{
        return UIColor(red: 115/255.0, green: 106/255.0, blue: 168/255.0, alpha: 1.0)
    }
    
    
    static var laboratoryBackgroundColorStart: UIColor{
        return UIColor(red: 255.0/255.0, green: 244/255.0, blue: 250.0/255.0, alpha: 1.0)
    }
    static var laboratoryBackgroundColorFinish: UIColor{
        return UIColor(red: 255.0/255.0, green: 204/255.0, blue: 250.0/255.0, alpha: 1.0)
    }
    static var laboratorySubjectColor: UIColor{
        return UIColor(red: 207/255.0, green: 166/255.0, blue: 87/255.0, alpha: 1.0)
    }
    
}

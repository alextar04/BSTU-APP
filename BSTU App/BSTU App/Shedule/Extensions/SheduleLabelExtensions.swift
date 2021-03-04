//
//  SheduleLabelExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 04.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UILabel{
    
    func countLabelLines() -> Int {
        // Call self.layoutIfNeeded() if your view is uses auto layout
        self.layoutIfNeeded()
        let myText = self.text! as NSString
        let attributes = [NSAttributedString.Key.font : self.font]

        let labelSize = myText.boundingRect(with: CGSize(width: self.bounds.width, height: CGFloat.greatestFiniteMagnitude), options: NSStringDrawingOptions.usesLineFragmentOrigin, attributes: attributes as [NSAttributedString.Key : Any], context: nil)
        return Int(ceil(CGFloat(labelSize.height) / self.font.lineHeight))
    }
    
    func isTruncated() -> Bool {
        if (self.countLabelLines() > self.numberOfLines) {
            return true
        }
        return false
    }
}

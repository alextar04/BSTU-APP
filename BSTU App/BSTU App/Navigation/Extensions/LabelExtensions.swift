//
//  LabelExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 26.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UILabel{
    func setBoldText(placeholderText: String){
        self.attributedText = NSAttributedString(string: placeholderText, attributes: [
            .foregroundColor: UIColor.lightGray,
            .font: UIFont.boldSystemFont(ofSize: 18.0)
        ])
        self.textAlignment = .center
    }
}

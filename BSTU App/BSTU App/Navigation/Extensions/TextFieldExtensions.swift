//
//  TextFieldExtensions.swift
//  MapSection
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

extension UITextField{
    func setPlaceholderBoldFont(placeholderText: String){
        self.attributedText = NSAttributedString(string: placeholderText, attributes: [
            .foregroundColor: UIColor.lightGray,
            .font: UIFont.boldSystemFont(ofSize: 18.0)
        ])
    }
}

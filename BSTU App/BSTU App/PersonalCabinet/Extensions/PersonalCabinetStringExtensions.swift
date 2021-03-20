//
//  PersonalCabinetStringExtensions.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation


extension String {
    func capitalizingFirstLetter() -> String {
        return prefix(1).capitalized + dropFirst()
    }

    mutating func capitalizeFirstLetter() {
        self = self.capitalizingFirstLetter()
    }
}

//
//  AttestationModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class AttestationModel{
    
    var dataRange: String!
    var disciplines: [String: Int]!
    
    init(dataRange: String, disciplines: [String: Int]) {
        self.dataRange = dataRange
        self.disciplines = disciplines
    }
    
}

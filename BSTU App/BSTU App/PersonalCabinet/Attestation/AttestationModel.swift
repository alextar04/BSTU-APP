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
    var disciplines: [DisciplineAttestationModel]!
    
    init(dataRange: String, disciplines: [DisciplineAttestationModel]) {
        self.dataRange = dataRange
        self.disciplines = disciplines
    }
}


class DisciplineAttestationModel{
    
    var discipline: (name: String, mark: Int)!
    
    init(discipline: (name: String, mark: Int)) {
        self.discipline = discipline
    }
}

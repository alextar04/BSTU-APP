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
    var disciplines: [DisciplineModel]!
    
    init(dataRange: String, disciplines: [DisciplineModel]) {
        self.dataRange = dataRange
        self.disciplines = disciplines
    }
}


class DisciplineModel{
    
    var discipline: (name: String, mark: Int)!
    
    init(discipline: (name: String, mark: Int)) {
        self.discipline = discipline
    }
}

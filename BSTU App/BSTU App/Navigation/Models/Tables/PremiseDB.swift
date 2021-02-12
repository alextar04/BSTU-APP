//
//  PremiseDB.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class PremiseDB{
    static let table = Table("PremiseDB")
    static let id = Expression<Int>("id")
    static let idMap = Expression<Int>("idMap")
    static let idTypePremise = Expression<Int>("idTypePremise")
    static let name = Expression<String>("name")
    static let description = Expression<String>("description")
}

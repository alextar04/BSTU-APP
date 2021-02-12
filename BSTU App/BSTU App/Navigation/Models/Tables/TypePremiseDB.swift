//
//  TypePremiseDB.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class TypePremiseDB{
    static let table = Table("TypePremiseDB")
    static let id = Expression<Int>("id")
    static let name = Expression<String>("name")
    static let picture = Expression<String>("picture")
}

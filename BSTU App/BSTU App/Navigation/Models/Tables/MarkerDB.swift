//
//  MarkerDB.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class MarkerDB{
    static let table = Table("MarkerDB")
    static let id = Expression<Int>("id")
    static let idMap = Expression<Int>("idMap")
    static let idOnMap = Expression<Int>("idOnMap")
    static let idPremise = Expression<Int>("idPremise")
    static let x = Expression<Int>("x")
    static let y = Expression<Int>("y")
}

//
//  MapDB.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class MapDB{
    static let table = Table("MapDB")
    static let id = Expression<Int>("id")
    static let idCorp = Expression<Int>("idCorp")
    static let storey = Expression<Int>("storey")
    static let plan = Expression<SQLite.Blob>("plan")
    static let matrixBestWays = Expression<String>("matrixBestWays")
    static let matrixBestDistance = Expression<String>("matrixBestDistance")
}

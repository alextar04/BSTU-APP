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
    var id: Int!
    var idCorp: Int!
    var storey: Int!
    var plan: Data!
    var matrixBestWays: [[Int?]]!
    var matrixBestDistance: [[CGFloat]]!
}

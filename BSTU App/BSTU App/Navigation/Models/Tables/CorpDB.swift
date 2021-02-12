//
//  CorpDB.swift
//  BSTU App
//
//  Created by Alexey Taran on 10.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class CorpDB{
    static let table = Table("CorpDB")
    static let id = Expression<Int>("id")
    static let name = Expression<String>("name")
}

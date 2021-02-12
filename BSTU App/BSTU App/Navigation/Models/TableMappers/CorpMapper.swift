//
//  CorpsMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class CorpMapper{
    
    let tableQuery = Table("CorpDB")
    let idQuery = Expression<Int>("id")
    let nameQuery = Expression<String>("name")
    
    // MARK: Получение списка корпусов
    func getCorpList()->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for corpItem in try! database.prepare(self.tableQuery){
            result.append(corpItem)
        }
        return result
    }
    
}

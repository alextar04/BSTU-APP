//
//  TypePremiseMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class TypePremiseMapper{
    
    let tableQuery = Table("TypePremiseDB")
    let idQuery = Expression<Int>("id")
    let nameQuery = Expression<String>("name")
    let pictureQuery = Expression<Data>("picture")
    
    // MARK: Получение списка типов помещений
    func getTypePremiseList()->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for typePremiseItem in try! database.prepare(self.tableQuery){
            result.append(typePremiseItem)
        }
        return result
    }
    
    // MARK: Получение типа помещения по id
    // Входные параметры: id
    func getTypePremiseById(withId: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for typePremiseItem in try! database.prepare(self.tableQuery.filter(self.idQuery == withId)){
            result.append(typePremiseItem)
        }
        return result
    }
}

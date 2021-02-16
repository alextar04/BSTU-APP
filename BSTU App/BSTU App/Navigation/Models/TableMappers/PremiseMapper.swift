//
//  PremiseMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class PremiseMapper{
    
    let tableQuery = Table("PremiseDB")
    let idQuery = Expression<Int>("id")
    let idMapQuery = Expression<Int>("idMap")
    let idTypePremiseQuery = Expression<Int>("idTypePremise")
    let nameQuery = Expression<String>("name")
    let descriptionQuery = Expression<String>("description")
    
    // MARK: Получение списка помещений
    // Входные параметры: id карты
    func getPremiseList(idMap: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for premiseItem in try! database.prepare(self.tableQuery.filter(self.idMapQuery == idMap)){
            result.append(premiseItem)
        }
        return result
    }
    
    
    // MARK: Получение id-карты
    // Входные параметры: id-помещения
    func getMapIdByPremiseId(withId: Int)->Int{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for premiseItem in try! database.prepare(self.tableQuery.filter(self.idQuery == withId)){
            result.append(premiseItem)
        }
        return result.first![idMapQuery]
    }
    
    
    // MARK: Получение помещения по id
    // Входные параметры: id
    func getPremiseById(withId: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for premiseItem in try! database.prepare(self.tableQuery.filter(self.idQuery == withId)){
            result.append(premiseItem)
        }
        return result
    }
    
    
    
    // MARK: Получение название помещения по id
    // Входные параметры: id
    func getPremiseNameById(withId: Int)->[String]{
        let database = Database.connect()
        var result = [String]()
        
        for premiseItem in try! database.prepare(self.tableQuery.filter(self.idQuery == withId)){
            result.append(premiseItem[nameQuery])
        }
        return result
    }
    
    
    // MARK: Получение помещения по id-карты и описанию
    func getPremiseIdByIdMapAndDescription(idMap: Int, description: String)->SQLite.Row{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for premiseItem in try! database.prepare(self.tableQuery.filter(self.idMapQuery == idMap && self.descriptionQuery == description)){
            result.append(premiseItem)
        }
        return result.first!
        
    }
}

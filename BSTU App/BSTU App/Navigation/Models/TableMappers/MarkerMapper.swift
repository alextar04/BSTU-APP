//
//  MarkerMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class MarkerMapper{
    
    let tableQuery = Table("MarkerDB")
    let idQuery = Expression<Int>("id")
    let idMapQuery = Expression<Int>("idMap")
    let idPremiseQuery = Expression<Int>("idPremise")
    let xQuery = Expression<Int>("x")
    let yQuery = Expression<Int>("y")
    
    // MARK: Получение списка маркеров
    // Входные параметры: id карты
    func getMarkerList(idMap: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for markerItem in try! database.prepare(self.tableQuery.filter(self.idMapQuery == idMap)){
            result.append(markerItem)
        }
        return result
    }
    
    
    // MARK: Получение маркера
    // Входные параметры: id-помещения
    func getMarkerByPremiseId(id: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for markerItem in try! database.prepare(self.tableQuery.filter(self.idPremiseQuery == id)){
            result.append(markerItem)
        }
        return result
    }
    
}

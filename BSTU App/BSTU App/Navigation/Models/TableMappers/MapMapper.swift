//
//  MapMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite


class MapMapper{
    
    let tableQuery = Table("MapDB")
    let idQuery = Expression<Int>("id")
    let idCorpQuery = Expression<Int>("idCorp")
    let storeyQuery = Expression<Int>("storey")
    let planQuery = Expression<Data>("plan")
    let matrixBestWaysQuery = Expression<String>("matrixBestWays")
    let matrixBestDistanceQuery = Expression<String>("matrixBestDistance")
    
    
    // MARK: Получение карты
    // Входные параметры: id-карты
    func getMapById(idMap: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for map in try! database.prepare(self.tableQuery.filter(self.idQuery == idMap)){
            result.append(map)
        }
        return result
    }
    
    
    // MARK: Получение матрицы кратчайших расстояний
    // Входные параметры: id-карты
    func getMatrixBestDistanceById(idMap: Int)->String{
        let database = Database.connect()
        var result = [String]()
        
        for map in try! database.prepare(self.tableQuery.filter(self.idQuery == idMap)){
            result.append(map[matrixBestDistanceQuery])
        }
        return result.first!
    }
    
    
}

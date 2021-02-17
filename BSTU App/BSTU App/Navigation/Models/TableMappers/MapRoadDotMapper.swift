//
//  MapRoadDotMapper.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite


class MapRoadDotMapper{

    let tableQuery = Table("MapRoadDotDB")
    let idQuery = Expression<Int>("id")
    let idMapQuery = Expression<Int>("idMap")
    let idOnMapQuery = Expression<Int>("idOnMap")
    let idPremiseQuery = Expression<Int?>("idPremise")
    let xQuery = Expression<Int>("x")
    let yQuery = Expression<Int>("y")
    let audienceXQuery = Expression<Int?>("audienceX")
    let audienceYQuery = Expression<Int?>("audienceY")

    
    // MARK: Получение списка точек на карте
    func getRoadDotList(idMap: Int)->[SQLite.Row]{
        let database = Database.connect()
        var result = [SQLite.Row]()
        
        for roadDot in try! database.prepare(self.tableQuery.filter(self.idMapQuery == idMap)){
            result.append(roadDot)
        }
        return result
    }
    
    // MARK: Вспомогательная функция для получения id-помещения
    // Входные параметры: id-карты, idOnMap
    func getIdPremiseByIdMapAndIdOnMap(_ idMap: Int, _ idOnMap: Int)->Int{
        let database = Database.connect()
        var result = [Int]()
        
        for roadDot in try! database.prepare(self.tableQuery.filter(self.idMapQuery == idMap &&  self.idOnMapQuery == idOnMap)){
            result.append(roadDot[idPremiseQuery]!)
        }
        return result.first!
    }
    
}

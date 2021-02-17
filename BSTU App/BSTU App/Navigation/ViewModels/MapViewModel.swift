//
//  MapViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 04.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class MapViewModel{
    
    var idMap: Int!
    lazy var mapScheme = UIImageView()
    lazy var markerList = [Marker]()
    lazy var dotsPositions = [MapRoadDotDB]()
    lazy var bestWaysMatrix = [[Int?]]()
    lazy var bestDistanceMatrix = [[CGFloat]]()
    
    
    init(idMap: Int) {
        self.idMap = idMap
        getMarkers(idMap: idMap)
        getDotsPositions(idMap: idMap)
        let map = getMapById(id: idMap)
        self.bestWaysMatrix = map.matrixBestWays
        self.bestDistanceMatrix = map.matrixBestDistance
        self.mapScheme = UIImageView(image: UIImage(data: map.plan))
    }
    
    
    // MARK: Получение списка маркеров
    // Входные параметры: id-карты
    func getMarkers(idMap: Int){
        let premiseMapper = PremiseMapper()
        let markerMapper = MarkerMapper()
        let acceptedData = markerMapper.getMarkerList(idMap: idMap)
        self.markerList.removeAll()
        
        for row in acceptedData{
            let marker = MarkerDB()
            marker.id = row[markerMapper.idQuery]
            marker.idMap = row[markerMapper.idMapQuery]
            marker.idPremise = row[markerMapper.idPremiseQuery]
            marker.x = row[markerMapper.xQuery]
            marker.y = row[markerMapper.yQuery]
            let text = premiseMapper.getPremiseNameById(withId: marker.idPremise).first!
            
            self.markerList.append(Marker(position: (marker.x, marker.y), text: text, idPremise: marker.idPremise))
        }
    }
    
    
    // MARK: Полчение списка точек дороги на карте
    // Входные параметры: id-карты
    func getDotsPositions(idMap: Int){
        let mapRoadDotMapper = MapRoadDotMapper()
        let acceptedData = mapRoadDotMapper.getRoadDotList(idMap: idMap)
        self.dotsPositions.removeAll()
        
        for row in acceptedData{
            let roadDot = MapRoadDotDB()
            roadDot.id = row[mapRoadDotMapper.idQuery]
            roadDot.idMap = row[mapRoadDotMapper.idMapQuery]
            roadDot.idOnMap = row[mapRoadDotMapper.idOnMapQuery]
            roadDot.idPremise = row[mapRoadDotMapper.idPremiseQuery]
            roadDot.x = row[mapRoadDotMapper.xQuery]
            roadDot.y = row[mapRoadDotMapper.yQuery]
            roadDot.audienceX = row[mapRoadDotMapper.audienceXQuery]
            roadDot.audienceY = row[mapRoadDotMapper.audienceYQuery]
            
            self.dotsPositions.append(roadDot)
        }
    }
    
    
    // MARK: Получение маркера
    // Входные параметры: id-помещения
    func getMarkerByIdPremise(id: Int)->Marker{
        return self.markerList.filter{$0.idPremise == id}.first!
    }
    
    
    // MARK: Получение карты
    // Входные параметры: id-карты
    func getMapById(id: Int)->MapDB{
        let mapMapper = MapMapper()
        let acceptedData = mapMapper.getMapById(idMap: id)
        var result = [MapDB]()
        
        for row in acceptedData{
            let map = MapDB()
            map.id = row[mapMapper.idQuery]
            map.idCorp = row[mapMapper.idCorpQuery]
            map.storey = row[mapMapper.storeyQuery]
            map.plan = row[mapMapper.planQuery]
            map.matrixBestWays = matrixBestWaysParser(matrixString: row[mapMapper.matrixBestWaysQuery])
            map.matrixBestDistance = matrixBestDistanceParser(matrixString: row[mapMapper.matrixBestDistanceQuery])
            
            result.append(map)
        }
        return result.first!
    }
    
    
    // MARK: Получение карты этажа
    // Входные параметры: id-карты
    func getMapStoreyById(id: Int)->Int{
        let mapMapper = MapMapper()
        let acceptedData = mapMapper.getMapById(idMap: id).first
        
        return acceptedData![mapMapper.storeyQuery]
    }
    
    
    // MARK: Парсер "матрицы лучших маршрутов" из записи БД
    func matrixBestWaysParser(matrixString: String)->[[Int?]]{
        var result = [[Int?]]()
        // Регулярка для получения строк матрицы
        // "\[[0-9, ]*\]"
        let regex1 = try! NSRegularExpression(pattern: "\\[[0-9, ]*\\]")
        let regex1Matches = regex1.matches(in: matrixString, range: NSRange(location: 0, length: matrixString.utf16.count))
        let matchStrings = regex1Matches.map{
            String(matrixString[Range($0.range, in: matrixString)!])
        }
        for matchString in matchStrings{
            var stringMatrix = [Int]()
            // Регулярка для получения значений строки для заполнения матрицы
            // "[0-9]+"
            let regex2 = try! NSRegularExpression(pattern: "[0-9]+")
            let regex2Matches = regex2.matches(in: matchString, range: NSRange(location: 0, length: matchString.utf16.count))
            for matchItem in regex2Matches{
                stringMatrix.append(Int(String(matchString[Range(matchItem.range, in: matchString)!]))!)
            }
            result.append(stringMatrix)
        }
        return result
    }
    
    
    // MARK: Парсер "матрицы лучших расстояний" из записи БД
    func matrixBestDistanceParser(matrixString: String)->[[CGFloat]]{
        var result = [[CGFloat]]()
        // Регулярка для получения строк матрицы
        // "\[[0-9., ]*\]"
        let regex1 = try! NSRegularExpression(pattern: "\\[[0-9., ]*\\]")
        let regex1Matches = regex1.matches(in: matrixString, range: NSRange(location: 0, length: matrixString.utf16.count))
        let matchStrings = regex1Matches.map{
            String(matrixString[Range($0.range, in: matrixString)!])
        }
        for matchString in matchStrings{
            var stringMatrix = [CGFloat]()
            // Регулярка для получения значений строки для заполнения матрицы
            // "[0-9]+\.[0-9]+"
            let regex2 = try! NSRegularExpression(pattern: "[0-9]+\\.[0-9]+")
            let regex2Matches = regex2.matches(in: matchString, range: NSRange(location: 0, length: matchString.utf16.count))
            for matchItem in regex2Matches{
                stringMatrix.append(CGFloat(Double(String(matchString[Range(matchItem.range, in: matchString)!]))!))
            }
            result.append(stringMatrix)
        }
        return result
    }
    
    
    // MARK: Получение маршрута между двумя точками
    func getPath(vertex1Index: Int, vertex2Index: Int)->[Int]{
        
        var v1 = vertex1Index
        let v2 = vertex2Index
        
        var pathArray = [Int]()
        if self.bestWaysMatrix[v1][v2] == nil{
            return pathArray
        }
        
        pathArray.append(v1)
        while v1 != v2{
            v1 = self.bestWaysMatrix[v1][v2]!
            pathArray.append(v1)
        }
        
        return pathArray
    }
    
}

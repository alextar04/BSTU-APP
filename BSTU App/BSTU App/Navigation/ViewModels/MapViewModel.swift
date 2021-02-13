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
    
    lazy var markerList = [Marker]()
    lazy var dotsPositions = [MapRoadDotDB]()
    
    init() {
        getMarkers(idMap: 0)
        getDotsPositions(idMap: 0)
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
            marker.idOnMap = row[markerMapper.idOnMapQuery]
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
        /*
        let markerMapper = MarkerMapper()
        let premiseMapper = PremiseMapper()
        let acceptedData = markerMapper.getMarkerByPremiseId(id: id)
        var result = [MarkerDB]()
        
        for row in acceptedData{
            let marker = MarkerDB()
            marker.id = row[markerMapper.idQuery]
            marker.idMap = row[markerMapper.idMapQuery]
            marker.idOnMap = row[markerMapper.idOnMapQuery]
            marker.idPremise = row[markerMapper.idPremiseQuery]
            marker.x = row[markerMapper.xQuery]
            marker.y = row[markerMapper.yQuery]
            result.append(marker)
        }
        
        let marker = result.first!
        return Marker(position: (marker.x, marker.y),
                      text: premiseMapper.getPremiseNameById(withId: marker.idPremise).first!,
                      idPremise: marker.idPremise)
        */
        
        return self.markerList.filter{$0.idPremise == id}.first!
    }
    
    
    // MARK: Полчение карты
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
            map.matrixBestWays = row[mapMapper.matrixBestWaysQuery]
            map.matrixBestDistance = row[mapMapper.matrixBestDistanceQuery]
            
            result.append(map)
        }
        
        return result.first!
    }
    
    
    var nextMatrix: [[Int?]]!
    /*
    var dotsPositions: [RoadDot] = [
        RoadDot(CGPoint(x: 575, y: 1035), audience: CGPoint(x: 575, y: 1008), markerText: "122"),
        RoadDot(CGPoint(x: 580, y: 1035), audience: CGPoint(x: 580, y: 1074), markerText: "120"),
        RoadDot(CGPoint(x: 819, y: 1035), audience: CGPoint(x: 819, y: 1074), markerText: "119"),
        RoadDot(CGPoint(x: 825, y: 1035), audience: CGPoint(x: 825, y: 1008), markerText: "124"),
        RoadDot(CGPoint(x: 958, y: 1035), audience: CGPoint(x: 958, y: 1008), markerText: "125"),
        RoadDot(CGPoint(x: 989, y: 1035), audience: nil, markerText: nil),
        RoadDot(CGPoint(x: 989, y: 1268), audience: nil, markerText: nil),
        // Нижний коридор лев. (7 индекс)
        RoadDot(CGPoint(x: 989, y: 1509), audience: CGPoint(x: 1032, y: 1509), markerText: "113"),
        RoadDot(CGPoint(x: 989, y: 1592), audience: CGPoint(x: 954, y: 1592), markerText: "118"),
        RoadDot(CGPoint(x: 989, y: 1631), audience: CGPoint(x: 1032, y: 1631), markerText: "114"),
        RoadDot(CGPoint(x: 989, y: 1754), audience: CGPoint(x: 1032, y: 1754), markerText: "115"),
        RoadDot(CGPoint(x: 989, y: 1800), audience: CGPoint(x: 954, y: 1800), markerText: "117"),
        RoadDot(CGPoint(x: 989, y: 1840), audience: CGPoint(x: 989, y: 1850), markerText: "116"),
        // Горизонтальный коридор (13 индекс)
        RoadDot(CGPoint(x: 1049, y: 1268), audience: CGPoint(x: 1049, y: 1313), markerText: "WC"),
        RoadDot(CGPoint(x: 1114, y: 1268), audience: CGPoint(x: 1114, y: 1313), markerText: "WC"),
        RoadDot(CGPoint(x: 1230, y: 1268), audience: CGPoint(x: 1230, y: 1313), markerText: "111"),
        RoadDot(CGPoint(x: 1263, y: 1268), audience: CGPoint(x: 1263, y: 1225), markerText: "128"),
        RoadDot(CGPoint(x: 1525, y: 1268), audience: CGPoint(x: 1525, y: 1225), markerText: "131"),
        RoadDot(CGPoint(x: 1562, y: 1268), audience: CGPoint(x: 1562, y: 1313), markerText: "109"),
        RoadDot(CGPoint(x: 1637, y: 1268), audience: CGPoint(x: 1637, y: 1313), markerText: "108"),
        RoadDot(CGPoint(x: 1712, y: 1268), audience: CGPoint(x: 1712, y: 1313), markerText: "107"),// 20
        RoadDot(CGPoint(x: 1713, y: 1132), audience: CGPoint(x: 1713, y: 1132), markerText: "Лифт"),// 21
        RoadDot(CGPoint(x: 1892, y: 1268), audience: nil, markerText: nil),
        // Верхний коридор прав. (23 индекс)
        RoadDot(CGPoint(x: 1892, y: 1132), audience: nil, markerText: nil),
        RoadDot(CGPoint(x: 1892, y: 959), audience: CGPoint(x: 1835, y: 959), markerText: "132а"),
        RoadDot(CGPoint(x: 1892, y: 856), audience: CGPoint(x: 1913, y: 856), markerText: "137"),
        RoadDot(CGPoint(x: 1892, y: 836), audience: CGPoint(x: 1835, y: 836), markerText: "132"),
        RoadDot(CGPoint(x: 1892, y: 601), audience: CGPoint(x: 1835, y: 601), markerText: "133"),
        RoadDot(CGPoint(x: 1892, y: 575), audience: CGPoint(x: 1913, y: 575), markerText: "136а"),
        RoadDot(CGPoint(x: 1892, y: 450), audience: CGPoint(x: 1835, y: 450), markerText: "134"),
        RoadDot(CGPoint(x: 1892, y: 416), audience: CGPoint(x: 1913, y: 416), markerText: "136"),
        RoadDot(CGPoint(x: 1892, y: 358), audience: CGPoint(x: 1835, y: 358), markerText: "135"),
        // Нижний коридор прав. (32 индекс)
        RoadDot(CGPoint(x: 1892, y: 1379), audience: CGPoint(x: 1946, y: 1379), markerText: "138"),
        RoadDot(CGPoint(x: 1892, y: 1408), audience: CGPoint(x: 1835, y: 1408), markerText: "106"),
        RoadDot(CGPoint(x: 1892, y: 1641), audience: CGPoint(x: 1835, y: 1641), markerText: "105"),
        RoadDot(CGPoint(x: 1892, y: 1722), audience: CGPoint(x: 1835, y: 1722), markerText: "104"),
        RoadDot(CGPoint(x: 1892, y: 1946), audience: CGPoint(x: 1835, y: 1946), markerText: "101"),
        // Точки, прямо от входа (37 индекс)
        RoadDot(CGPoint(x: 1980, y: 1085), audience: CGPoint(x: 1980, y: 1085), markerText: "Вход"),
        RoadDot(CGPoint(x: 1980, y: 1132), audience: nil, markerText: nil),
        RoadDot(CGPoint(x: 1980, y: 1268), audience: nil, markerText: nil),
    ] */
    
    let indexes: [(Int, Int)] = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7), (6, 13),
                                 (7, 8), (8, 9), (9, 10), (10, 11), (11, 12),
                                 (7, 13), (13, 14), (14, 15), (15, 16), (16, 17), (17, 18), (18, 19), (19, 20), (20, 21), (20, 22), (20, 23), (21, 23), (22, 23), (22, 39),
                                 (22, 23), (23, 24), (24, 25), (25, 26), (26, 27), (27, 28), (28, 29), (29, 30), (30, 31),
                                 (22, 32), (32, 33), (33, 34), (34, 35), (35, 36),
                                 (37, 38), (38, 39), (38, 23)]
    
    
    // MARK: Расстояние между точками
    func distancePoints(_ point1: CGPoint, _ point2: CGPoint)->CGFloat{
        return sqrt(pow((point1.x - point2.x), 2) + pow((point1.y - point2.y), 2))
    }
    
    // Матрица смежности
    func createAdjacenciesMatrix()->[[CGFloat]]{
        var adjacenciesMatrix = [[CGFloat]].init(repeating: [CGFloat].init(repeating: CGFloat.greatestFiniteMagnitude,
                                                                           count: self.dotsPositions.count),
                                                 count: self.dotsPositions.count)
        
        for index in self.indexes{
            adjacenciesMatrix[index.0][index.1] = distancePoints(CGPoint(x: self.dotsPositions[index.0].x, y: self.dotsPositions[index.0].y),
                                                                 CGPoint(x: self.dotsPositions[index.1].x, y: self.dotsPositions[index.1].y))
            adjacenciesMatrix[index.1][index.0] = adjacenciesMatrix[index.0][index.1]
        }
        
        for index in 0..<adjacenciesMatrix.count{
            adjacenciesMatrix[index][index] = 0
        }
        
        return adjacenciesMatrix
    }
    
    
    // Матрица (дерево) пунктов кратчайших пути
    func createMatrixShortestWays()->[[Int?]]{
        var nextMatrix = [[Int?]].init(repeating: [Int?].init(repeating: nil,
                                                 count: self.dotsPositions.count),
                                       count: self.dotsPositions.count)
        
        for index in self.indexes{
            nextMatrix[index.0][index.1] = index.1
            nextMatrix[index.1][index.0] = index.0
        }
        
        for index in 0..<nextMatrix.count{
            nextMatrix[index][index] = index
        }
        
        return nextMatrix
    }
    
    
    // Поиск кратчайших путей (Алгоритм Флойда-Уоршалла)
    func searchShortestWays(){
        var matrix = createAdjacenciesMatrix()
        self.nextMatrix = createMatrixShortestWays()
        
        for k in 0..<dotsPositions.count{
            for i in 0..<dotsPositions.count{
                for j in 0..<dotsPositions.count{
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j]
                        nextMatrix[i][j] = nextMatrix[i][k]
                    }
                }
            }
        }
        //printMatrix(nextMatrix)
    }
    
    /*
    func printMatrix(_ matrix: [[CGFloat]]){
        for lines in matrix{
            for item in lines{
                if item == CGFloat.greatestFiniteMagnitude{
                    print("INF", terminator: "  ")
                } else {
                    print(NSString(format: "%.2f", item), terminator: "  ")
                }
            }
            print()
        }
    }*/
    
    /*
    func printMatrix(_ matrix: [[Int?]]){
        for lines in matrix{
            for item in lines{
                if item == nil{
                    print("-", terminator: "  ")
                } else {
                    print(item!, terminator: "  ")
                }
            }
            print()
        }
    }*/
    
    
    // MARK: Получение маршрута между двумя точками
    func getPath(vertex1Index: Int, vertex2Index: Int)->[Int]{
        
        var v1 = vertex1Index
        let v2 = vertex2Index
        
        var pathArray = [Int]()
        if self.nextMatrix[v1][v2] == nil{
            return pathArray
        }
        
        pathArray.append(v1)
        while v1 != v2{
            v1 = self.nextMatrix[v1][v2]!
            pathArray.append(v1)
        }
        
        return pathArray
    }
    
    
    // MARK: Получение индекса точки в хранилище по id-помещения
    func getIndexStorageByPremiseId(id: Int)->Int{
        return self.dotsPositions.firstIndex{
            return $0.idPremise == id
            }!
    }
}
/*
class RoadDot{
    var coordinates: CGPoint!
    var toAudience: CGPoint? = nil
    var markerText: String? = nil
    
    init(_ coordinates: CGPoint, audience toAudience: CGPoint?, markerText: String?) {
        self.coordinates = coordinates
        self.toAudience = toAudience
        self.markerText = markerText
    }
}*/

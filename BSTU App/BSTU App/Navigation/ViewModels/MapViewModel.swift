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
    
    var nextMatrix: [[Int?]]!
    var dotsPositions: [RoadDot] = [
        RoadDot(CGPoint(x: 341, y: 1090), audience: nil, markerText: nil),
        RoadDot(CGPoint(x: 465, y: 1090), audience: CGPoint(x: 465, y: 1051), markerText: "113"),
        RoadDot(CGPoint(x: 488, y: 1090), audience: CGPoint(x: 488, y: 1129), markerText: "114"),
        RoadDot(CGPoint(x: 596, y: 1090), audience: CGPoint(x: 596, y: 1051), markerText: "115"),
        RoadDot(CGPoint(x: 675, y: 1090), audience: CGPoint(x: 675, y: 1129), markerText: "116"),
        RoadDot(CGPoint(x: 725, y: 1090), audience: CGPoint(x: 725, y: 1051), markerText: "117"),
        RoadDot(CGPoint(x: 844, y: 1090), audience: CGPoint(x: 844, y: 1051), markerText: "118"),
        RoadDot(CGPoint(x: 846, y: 1090), audience: CGPoint(x: 846, y: 1129), markerText: "119"),
        RoadDot(CGPoint(x: 1023, y: 1090), audience: CGPoint(x: 1023, y: 1051), markerText: "120"),
        RoadDot(CGPoint(x: 1035, y: 1090), audience: nil, markerText: nil),
        RoadDot(CGPoint(x: 1035, y: 1308), audience: nil, markerText: nil),
        // Нижний коридор (11 индекс)
        RoadDot(CGPoint(x: 1035, y: 1420), audience: CGPoint(x: 1006, y: 1420), markerText: "121"),
        RoadDot(CGPoint(x: 1035, y: 1546), audience: CGPoint(x: 1073, y: 1546), markerText: "122"),
        RoadDot(CGPoint(x: 1035, y: 1560), audience: CGPoint(x: 1073, y: 1560), markerText: "123"),
        // Горизонтальный коридор (14 индекс)
        RoadDot(CGPoint(x: 1323, y: 1308), audience: CGPoint(x: 1323, y: 1351), markerText: "124"),
    ]
    
    let indexes: [(Int, Int)] = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7), (7, 8), (8, 9), (9, 10),
                                 (10, 14),
                                 (10, 11), (11, 12), (12, 13)]
    
    
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
            adjacenciesMatrix[index.0][index.1] = distancePoints(self.dotsPositions[index.0].coordinates,
                                                                 self.dotsPositions[index.1].coordinates)
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
    
    
    // MARK: Получение индекса точки в хранилище по названию маркера
    func getIndexStorageByMarkerName(markerName: String)->Int{
        return self.dotsPositions.firstIndex{ $0.markerText == markerName }!
    }
}


class RoadDot{
    var coordinates: CGPoint!
    var toAudience: CGPoint? = nil
    var markerText: String? = nil
    
    init(_ coordinates: CGPoint, audience toAudience: CGPoint?, markerText: String?) {
        self.coordinates = coordinates
        self.toAudience = toAudience
        self.markerText = markerText
    }
}
//
//  NavigationViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class NavigationViewModel{
    
    lazy var premiseList = [PremiseDB]()
    lazy var premisesTypesList = [TypePremiseDB]()
    
    
    init(idMap: Int) {
        getPremises(idMap: idMap)
        getTypesPremises()
    }
    
    
    // MARK: Получение списка помещений
    func getPremises(idMap: Int){

        let mapper = PremiseMapper()
        let acceptedData = mapper.getPremiseList(idMap: idMap)
        self.premiseList.removeAll()
        
        for row in acceptedData{
            let premise = PremiseDB()
            premise.id = row[mapper.idQuery]
            premise.idMap = row[mapper.idMapQuery]
            premise.idTypePremise = row[mapper.idTypePremiseQuery]
            premise.name = row[mapper.nameQuery]
            premise.description = row[mapper.descriptionQuery]
            
            self.premiseList.append(premise)
        }
    }
    
    
    // MARK: Получение списка помещений
    func getAllPremises()->[PremiseDB]{

        let mapper = PremiseMapper()
        let acceptedData = mapper.getPremiseList()
        var result = [PremiseDB]()
        
        for row in acceptedData{
            let premise = PremiseDB()
            premise.id = row[mapper.idQuery]
            premise.idMap = row[mapper.idMapQuery]
            premise.idTypePremise = row[mapper.idTypePremiseQuery]
            premise.name = row[mapper.nameQuery]
            premise.description = row[mapper.descriptionQuery]
            
            result.append(premise)
        }
        return result
    }
    
    
    // MARK: Получение списка типов помещений
    func getTypesPremises(){

        let mapper = TypePremiseMapper()
        let acceptedData = mapper.getTypePremiseList()
        self.premisesTypesList.removeAll()
        
        for row in acceptedData{
            let typePremise = TypePremiseDB()
            typePremise.id = row[mapper.idQuery]
            typePremise.name = row[mapper.nameQuery]
            typePremise.picture = row[mapper.pictureQuery]
            
            self.premisesTypesList.append(typePremise)
        }
    }
    
    
    // MARK: Получение помещения по id
    func getPremiseById(withId: Int)->PremiseDB{
        
        let mapper = PremiseMapper()
        let acceptedData = mapper.getPremiseById(withId: withId).first!
        
        let premise = PremiseDB()
        premise.id = acceptedData[mapper.idQuery]
        premise.idMap = acceptedData[mapper.idMapQuery]
        premise.idTypePremise = acceptedData[mapper.idTypePremiseQuery]
        premise.name = acceptedData[mapper.nameQuery]
        premise.description = acceptedData[mapper.descriptionQuery]
        
        return premise
    }
    
    
    // MARK: Получение типа помещения с заданным id
    func getTypePremiseById(id: Int)->TypePremiseDB{
        return self.premisesTypesList.filter{
            $0.id == id
        }.first!
    }
    
    
    // MARK: Получение id-карты и индекс точки в списке точек карты по id-помещения
    func getIndexInStorageByPremiseId(idPremise: Int)->(Int, Int){
        
        let mapper = PremiseMapper()
        let idMap = mapper.getMapIdByPremiseId(withId: idPremise)
        let mapperDotsPositions = MapRoadDotMapper()
        let dotsPositions = mapperDotsPositions.getRoadDotList(idMap: idMap)
        
        return (idMap, (dotsPositions.firstIndex{
            return $0[mapperDotsPositions.idPremiseQuery] == idPremise
            }!))
    }
    
    
    // MARK: Поиск оптимального пути для помещений на разных этажах
    // Входные параметры: Пункт отправления, пункт прибытия - mapId, idOnMap
    func getOptimalWayForPremiseFromDifferentStoreys(inPremise: (Int, Int), outPremise: (Int, Int))->(Int, Int, Int, Int){
        
        // Получение id-помещений "Входа 1" и "Входа 2" этажей in, out
        let localIdInMapOneExitOne = searchLocalIdInMap(idMap: inPremise.0, description: "Вход 1")
        let localIdInMapOneExitTwo = searchLocalIdInMap(idMap: inPremise.0, description: "Вход 2")
        let localIdInMapTwoExitOne = searchLocalIdInMap(idMap: outPremise.0, description: "Вход 1")
        let localIdInMapTwoExitTwo = searchLocalIdInMap(idMap: outPremise.0, description: "Вход 2")
        
        // Получение матриц кратчайших расстояний двух карт
        let mapMapper = MapMapper()
        let matrixBestDistanceMapOne = matrixBestDistanceParser(matrixString: mapMapper.getMatrixBestDistanceById(idMap: inPremise.0))
        let matrixBestDistanceMapTwo = matrixBestDistanceParser(matrixString: mapMapper.getMatrixBestDistanceById(idMap: outPremise.0))
        
        // Путь 1: точка1->вход1 + вход1->точка2
        let pathOneLength = matrixBestDistanceMapOne[inPremise.1][localIdInMapOneExitOne] +
                            matrixBestDistanceMapTwo[localIdInMapTwoExitOne][outPremise.1]
        
        // Путь 2: точка1->вход2 + вход2->точка2
        let pathTwoLength = matrixBestDistanceMapOne[inPremise.1][localIdInMapOneExitTwo] +
                            matrixBestDistanceMapTwo[localIdInMapTwoExitTwo][outPremise.1]
        
        // Выбор кратчайшего пути из двух
        if pathOneLength < pathTwoLength{
            return (inPremise.1, localIdInMapOneExitOne, localIdInMapTwoExitOne, outPremise.1)
        }
        return (inPremise.1, localIdInMapOneExitTwo, localIdInMapTwoExitTwo, outPremise.1)
    }
    
    
    // MARK: Вспомогательная функция для получения индексов точек на карте
    // Входные параметры: id-карты, описание карты
    func searchLocalIdInMap(idMap: Int, description: String)->Int{
        
        let premiseIdExit = getPremiseIdByIdMapAndDescription(idMap: idMap, description: description)
        let localIdInMapExit = getIndexInStorageByPremiseId(idPremise: premiseIdExit).1
        return localIdInMapExit
    }
    
    
    // MARK: Вспомогательная функция для получения id-помещения
    // Входные параметры: id-карты, описание карты
    func getPremiseIdByIdMapAndDescription(idMap: Int, description: String)->Int{
        
        let mapper = PremiseMapper()
        let dataExit = mapper.getPremiseIdByIdMapAndDescription(idMap: idMap, description: description)
        return dataExit[mapper.idQuery]
    }
    
    
    // MARK: Вспомогательная функция для получения id-помещения
    // Входные параметры: id-карты, idOnMap
    func getIdPremiseByIdMapAndIdOnMap(_ idMap: Int, _ idOnMap: Int)->Int{
        
        let mapper = MapRoadDotMapper()
        let data = mapper.getIdPremiseByIdMapAndIdOnMap(idMap, idOnMap)
        return data
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
    
    
    // MARK: Загрузка помещений, имеющих заданный префикс
    func loadArrayPremise(prefix: String)->[PremiseDB]?{
    
        if prefix == ""{
            return Array(self.getAllPremises().prefix(10))
        }
        
        let result = try? getAllPremises().filter{ premise in
            premise.description.lowercased().hasPrefix(prefix.lowercased())
        }
        return result
    }
    
}


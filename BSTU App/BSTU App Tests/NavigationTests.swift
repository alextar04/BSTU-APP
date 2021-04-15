//
//  NavigationTests.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 15.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import XCTest
@testable import BSTU_App

class NavigationTests: XCTestCase{
    
    // MARK: Получение списка корпусов
    func testGetCorpList(){
        
        let viewModel = UniversityCorpViewModel()
        XCTAssertTrue(viewModel.corpsList.first?.name == "Главный корпус")
        XCTAssertTrue(viewModel.corpsList.count == 1)
    }
    
    // MARK: Парсер матрицы кратчайших расстояний
    func testMatrixShortestWaysParser(){
        
        let viewModel = MapViewModel(idMap: 1)
        XCTAssertTrue(viewModel.bestDistanceMatrix.first?.count == 42)
        XCTAssertTrue(viewModel.bestDistanceMatrix[1].first == 5.0)
    }
    
    // MARK: Помещения, имеющие заданный префикс
    func testSearchPlaceWithPrefix(){
        
        let viewModel = NavigationViewModel(idMap: 1)
        let data = viewModel.loadArrayPremise(prefix: "ГУК 12")
        XCTAssertTrue(data?.count == 5)
        XCTAssertTrue(data?.first?.description == "ГУК 122")
    }
    
    // MARK: Поиск аудитории по id
    func testSearchPremiseById(){
        
        let viewModel = NavigationViewModel(idMap: 1)
        let premise = viewModel.getPremiseById(withId: 1)
        XCTAssertTrue(premise.description == "ГУК 124")
    }
    
    // MARK: Построение маршрута между двумя точками на одном этаже
    func testCreateWayBetweenAudienceInOneStage(){
        let viewModel = MapViewModel(idMap: 2)
        // ГУК 221 -> ГУК 204
        let result = viewModel.getPath(vertex1Index: 1, vertex2Index: 15)
        
        XCTAssertTrue(result.count == 12)
        XCTAssertTrue(result.first == 1)
        XCTAssertTrue(result.last == 15)
    }
    
    
    // MARK: Построение маршрута между двумя точками на разных этажах
    func testCreateWayBetweenAudienceInAnotherStages(){
        let viewModel = NavigationViewModel(idMap: 1)
        // ГУК 114 -> ГУК 214
        let result = viewModel.getOptimalWayForPremiseFromDifferentStoreys(inPremise: (1, 9),
                                                                           outPremise: (2, 7))
        XCTAssertTrue(result.0 == 9)
        XCTAssertTrue(result.1 == 40)
        XCTAssertTrue(result.2 == 4)
        XCTAssertTrue(result.3 == 7)
        
    }
    
}

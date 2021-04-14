//
//  FoodPointsTests.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 14.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import XCTest
@testable import BSTU_App

class FoodPointsTests: XCTestCase{
    
    // MARK: Тестирование пунктов питания
    func testSuccessPoint(){
        let server = MockFoodPointsServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting11")
        let viewModel = FoodPointsViewModel()
        viewModel.getFoodRooms(completion: {
            XCTAssertEqual(viewModel.totalRooms.count, 10)
            alamofireExpectation.fulfill()
        }, errorClosure: { _ in
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование меню пункта питания
    func testSuccessMenu(){
        let server = MockFoodPointsServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting12")
        let viewModel = FoodPointsViewModel()
        viewModel.totalRooms.append(FoodRoom(numberRoom: "1", nameRoom: "Test room"))
        viewModel.getFoodMenuForRooms(completion: {
            XCTAssertEqual(viewModel.totalMenus.first?!.first?.items.count, 3)
            alamofireExpectation.fulfill()
        }, errorClosure: { _ in
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
}

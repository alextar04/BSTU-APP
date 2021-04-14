//
//  ScheduleTests.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 13.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import XCTest
@testable import BSTU_App

class ScheduleTests: XCTestCase{
    
    // MARK: Тестирование запроса списка институтов (удачный)
    func testSuccessGetListInstitutions(){
        let server = MockScheduleServer()
        server.start()
        
        let viewModel = InstitutionViewModel()
        let alamofireExpectation = expectation(description: "AlamofireWaiting1")
        viewModel.getInstitutionList(startLink: "http://info.bstu.ru/index.php/", completion: { institutionsName in
            XCTAssertEqual(institutionsName.first?.name, "АИ")
            alamofireExpectation.fulfill()
        }, errorClosure: {
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса списка институтов (неудачный)
    func testErrorGetListInstitutions(){
        let server = MockScheduleServer()
        server.start()
        
        let viewModel = InstitutionViewModel()
        let alamofireExpectation = expectation(description: "AlamofireWaiting2")
        viewModel.getInstitutionList(startLink: "http://info.bstu_error.ru/index.php/",
                                     completion: { _ in
                                        XCTAssertTrue(false)
                                        alamofireExpectation.fulfill()
        }, errorClosure: {
            XCTAssertTrue(true)
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса списка групп (удачный)
    func testSuccessGetListGroups(){
        let server = MockScheduleServer()
        server.start()
        
        let viewModel = GroupsViewModel()
        let alamofireExpectation = expectation(description: "AlamofireWaiting3")
        viewModel.getGroupsList(link: server.makeUrlFromString(someString: "http://info.bstu.ru/index.php/institut/groups"),
                                completion: { institution in
                                    XCTAssertEqual(institution.first!.groups[1].name, "АР-201")
                                    alamofireExpectation.fulfill()
        },
            errorClosure: {
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса списка групп (неудачный)
    func testErrorGetListGroups(){
        let server = MockScheduleServer()
        server.start()
        
        let viewModel = GroupsViewModel()
        let alamofireExpectation = expectation(description: "AlamofireWaiting4")
        viewModel.getGroupsList(link: server.makeUrlFromString(someString: "http://info.bstu_error.ru/index.php/institut/groups"),
                                completion: { _ in
                                                                XCTAssertTrue(false)
                                                                alamofireExpectation.fulfill()
                                }, errorClosure: {
                                    XCTAssertTrue(true)
                                    alamofireExpectation.fulfill()
                                })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса расписания очных групп (удачный)
    func testSuccessScheduleFullTimeGroups(){
        let server = MockScheduleServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting5")
        let viewModel = GroupSheduleViewModel()
        viewModel.getSheduleForGroup(groupName: "АП-41",
                                     isCorrespondenceGroup: false,
                                     completion: {
                                        XCTAssertEqual(viewModel.resultDaysCurrentWeek[0].count, 0)
                                        XCTAssertEqual(viewModel.resultDaysCurrentWeek[3].count, 2)
                                        alamofireExpectation.fulfill()
        }, errorClosure: {
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса расписания заочных групп (удачный)
    func testSuccessScheduleCorrespondenceGroups(){
        let server = MockScheduleServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting6")
        let viewModel = GroupSheduleViewModel()
        viewModel.getSheduleForGroup(groupName: "ИТз-41",
                                     isCorrespondenceGroup: true,
                                     completion: {
                                        XCTAssertEqual(viewModel.resultDaysCurrentWeek.first!.count, 11)
                                        XCTAssertEqual(viewModel.resultDaysNextWeek.first?.count, 0)
                                        alamofireExpectation.fulfill()
        }, errorClosure: {
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса расписания заочных групп (удачный)
    func testSuccessScheduleExams(){
        let server = MockScheduleServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting7")
        let viewModel = GroupSheduleViewModel()
        viewModel.getSheduleForGroup(groupName: "ПВ-41",
                                     isCorrespondenceGroup: false,
                                     completion: {
                                        XCTAssertEqual(viewModel.resultExams.count, 4)
                                        alamofireExpectation.fulfill()
        }, errorClosure: {
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
}

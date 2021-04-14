//
//  TeacherTests.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 13.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import XCTest
@testable import BSTU_App

class TeacherTests: XCTestCase{
    
    // MARK: Тестирование запроса фамилий (удачный)
    func testSuccessSurname(){
        let server = MockTeacherServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting8")
        let viewModel = ListTeachersViewModel()
        viewModel.getTeachersListByFirstLetter(firstLetter: Unicode.Scalar("А").value,
                                               completion: { teachers in
                                                XCTAssertEqual(teachers.count, 40)
                                                alamofireExpectation.fulfill()
        }, errorClosure: { _ in
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса расписания
    func testSuccessSchedule(){
        let server = MockTeacherServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting9")
        let viewModel = TeacherScheduleViewModel()
        viewModel.getSheduleForTeacher(teacherName: "",
                                       teacherLink: server.makeUrlFromString(someString: "http://www.bstu.ru/static/themes/bstu/schedule/index.php?tid=1832"),
                                       completion: {
                                        XCTAssertEqual(viewModel.resultDaysCurrentWeek.first!.count, 1)
                                        alamofireExpectation.fulfill()
        },
                                       errorClosure: {
                                        alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование запроса экзаменов
    func testSuccessScheduleExam(){
        let server = MockTeacherServer()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting10")
        let viewModel = TeacherScheduleViewModel()
        viewModel.getSheduleForTeacher(teacherName: "",
                                       teacherLink: server.makeUrlFromString(someString: "http://www.bstu.ru/static/themes/bstu/schedule/index.php?tid=1832"),
                                       completion: {
                                        XCTAssertEqual(viewModel.resultExams.count, 14)
                                        alamofireExpectation.fulfill()
        },
                                       errorClosure: {
                                        alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
}

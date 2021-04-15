//
//  PersonalCabinetTests.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 14.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//
import Foundation
import XCTest
@testable import BSTU_App

class PersonalCabinetTests: XCTestCase{
    
    // MARK: Тестирование успешной авторизации
    func testSuccessAutorization(){
        let server = MockPersonalCabinetServer()
        server.createSuccessAutorizationRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting13")
        let viewModel = SigninViewModel()
        viewModel.autorizate(login: "trueLogin", password: "truePassword",
                             completion: { _ in
                                
                                let defaults = UserDefaults.standard
                                defaults.set(nil, forKey: "login")
                                defaults.set(nil, forKey: "password")
                                
                                XCTAssertTrue(true)
                                alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            XCTAssertTrue(false)
            alamofireExpectation.fulfill()
        }, isTestConfiguration: true)
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование неуспешной авторизации
    func testErrorAutorization(){
        let server = MockPersonalCabinetServer()
        server.createErrorDataAutorizationRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting14")
        let viewModel = SigninViewModel()
        viewModel.autorizate(login: "falseLogin", password: "falsePassword",
                             completion: { _ in
                                XCTAssertTrue(false)
                                alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            XCTAssertTrue(true)
            alamofireExpectation.fulfill()
        }, isTestConfiguration: true)
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование успешной повторной авторизации
    func testSuccessSecondaryAutorization(){
        let server = MockPersonalCabinetServer()
        server.createSuccessAutorizationRequest()
        server.start()
        
        let defaults = UserDefaults.standard
        defaults.set("trueLogin", forKey: "login")
        defaults.set("truePassword", forKey: "password")
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting15")
        let viewModel = PersonalCabinetMainPageViewModel()
        viewModel.autorizate(login: defaults.string(forKey: "login")!, password: defaults.string(forKey: "password")!,
                             completion: { _ in
                                
                                let defaults = UserDefaults.standard
                                defaults.set(nil, forKey: "login")
                                defaults.set(nil, forKey: "password")
                                
                                XCTAssertTrue(true)
                                alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            XCTAssertTrue(false)
            alamofireExpectation.fulfill()
        }, isTestConfiguration: true)
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование неуспешной повторной авторизации
    func testErrorSecondaryAutorazation(){
        let server = MockPersonalCabinetServer()
        server.createErrorDataAutorizationRequest()
        server.start()
        
        let defaults = UserDefaults.standard
        defaults.set("trueLogin", forKey: "login")
        defaults.set("truePassword", forKey: "password")
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting16")
        let viewModel = PersonalCabinetMainPageViewModel()
        viewModel.autorizate(login: "falseLogin", password: "falsePassword",
                             completion: { _ in
                                XCTAssertTrue(false)
                                alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            
            let defaults = UserDefaults.standard
            defaults.set(nil, forKey: "login")
            defaults.set(nil, forKey: "password")
            
            XCTAssertTrue(true)
            alamofireExpectation.fulfill()
        }, isTestConfiguration: true)
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование успешного выхода из системы
    func testSuccessLogout(){
        let server = MockPersonalCabinetServer()
        server.createSuccessLogoutRequest()
        server.start()
        
        let defaults = UserDefaults.standard
        defaults.set("trueLogin", forKey: "login")
        defaults.set("truePassword", forKey: "password")
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting17")
        let viewModel = PersonalCabinetMainPageViewModel()
        viewModel.logout(completion: {
            XCTAssertNil(defaults.string(forKey: "login"))
            alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            XCTAssertTrue(false)
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование неуспешного выхода из системы
    func testErrorLogout(){
        let server = MockPersonalCabinetServer()
        server.createErrorLogoutRequest()
        server.start()
        
        let defaults = UserDefaults.standard
        defaults.set("trueLogin", forKey: "login")
        defaults.set("truePassword", forKey: "password")
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting18")
        let viewModel = PersonalCabinetMainPageViewModel()
        viewModel.logout(completion: {
            XCTAssertTrue(false)
            alamofireExpectation.fulfill()
        }, errorCallback: { _ in
            XCTAssertNotNil(defaults.string(forKey: "login"))
            
            defaults.set(nil, forKey: "login")
            defaults.set(nil, forKey: "password")
            
            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование успешного получения аттестации
    func testSuccessGetingAttestation(){
        let server = MockPersonalCabinetServer()
        server.createSuccessListAttestationRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting19")
        let viewModel = AttestationViewModel()
        viewModel.getUserAttestationInfo(idUser: 1,
                                         completion: { _ in
                                            XCTAssertTrue(true)
                                            alamofireExpectation.fulfill()
        },
                                         errorCallback: { _ in
                                            XCTAssertTrue(false)
                                            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование неуспешного получения аттестации
    func testErrorGetingAttestation(){
        let server = MockPersonalCabinetServer()
        server.createErrorListAttestationRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting20")
        let viewModel = AttestationViewModel()
        viewModel.getUserAttestationInfo(idUser: 1,
                                         completion: { _ in
                                            XCTAssertTrue(false)
                                            alamofireExpectation.fulfill()
        },
                                         errorCallback: { _ in
                                            XCTAssertTrue(true)
                                            alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование успешного получения экзаменов
    func testSuccessGetingExam(){
        let server = MockPersonalCabinetServer()
        server.createSuccessListExamRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting21")
        let viewModel = ExamsViewModel()
        viewModel.getUserExamsInfo(idUser: 1,
                                   completion: { _ in
                                    XCTAssertTrue(true)
                                    alamofireExpectation.fulfill()
        },
                                  errorCallback: { _ in
                                    XCTAssertTrue(false)
                                    alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
    
    
    // MARK: Тестирование неуспешного получения экзаменов
    func testErrorGetingExam(){
        let server = MockPersonalCabinetServer()
        server.createErrorListExamRequest()
        server.start()
        
        let alamofireExpectation = expectation(description: "AlamofireWaiting22")
        let viewModel = ExamsViewModel()
        viewModel.getUserExamsInfo(idUser: 1,
                                   completion: { _ in
                                    XCTAssertTrue(false)
                                    alamofireExpectation.fulfill()
        },
                                  errorCallback: { _ in
                                    XCTAssertTrue(true)
                                    alamofireExpectation.fulfill()
        })
        
        wait(for: [alamofireExpectation], timeout: 10.0)
        server.stop()
    }
}


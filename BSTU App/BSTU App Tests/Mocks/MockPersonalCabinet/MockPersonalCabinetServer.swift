//
//  MockPersonalCabinetServer.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 14.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Hippolyte
import SwiftSoup

class MockPersonalCabinetServer{
    
    func start() {
        Hippolyte.shared.start()
    }
    
    
    func stop() {
        Hippolyte.shared.stop()
    }
    
    // Авторизация (1-я) успешная
    // Авторизация (1-я) неуспешная – изменились данные
    // Авторизация (повторная) успешная
    // Авторизация (повторная) неуспешная – изменились данные
    // Выход – успешный
    // Выход – неуспешный
    
    // Получение информации о аттестации - успешно
    // Получение информации о аттестации – неуспешно
    // Получение информации об успеваемости – успешно
    // Получение информации о успеваемости – неуспешно

    
    func copyFile(fileName: String){
        
        let pathOnDevice = URL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.libraryDirectory, .userDomainMask, true).first!, isDirectory: true).appendingPathComponent(fileName)
        let bundleUrl = Bundle.main.url(forResource: fileName, withExtension: nil)!

        if FileManager.default.fileExists(atPath: pathOnDevice.path) {
            try! FileManager.default.removeItem(at: pathOnDevice)
        }
        try! FileManager.default.copyItem(at: bundleUrl, to: pathOnDevice)
        
    }

    
    func getDataUrl(fileName: String) -> URL{
        
        return URL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.libraryDirectory,
                                                            .userDomainMask, true).first!,
        isDirectory: true).appendingPathComponent(fileName)
    }
    
    
    func makeUrlFromString(someString: String) -> URL{
        return try! someString
            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
            .asURL()
    }
    
    
    // MARK: Успешный вход в систему
    func createSuccessAutorizationRequest() {
        
        let fileName = "FakeSuccessAutorizationRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let postData = Login(email: "trueLogin", password: "truePassword")
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .POST,
                         url: makeUrlFromString(someString: "http://cabinet.bstu.ru/auth/login"))
            .addMatcher(JSONMatcher<Login>(object: postData))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }

    
    // MARK: Неуспешный вход в систему
    func createErrorDataAutorizationRequest() {
        
        let fileName = "FakeErrorDataAutorizationRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let postData = Login(email: "falseLogin", password: "falsePassword")
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .POST,
                         url: URL(string: "http://cabinet.bstu.ru/auth/login")!)
            .addMatcher(JSONMatcher<Login>(object: postData))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Выход - успешный
    func createSuccessLogoutRequest(){
        let fileName = "FakeSuccessLogoutRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/auth/logout")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Выход - неуспешный
    func createErrorLogoutRequest(){
        let fileName = "FakeErrorLogoutRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/auth/logout")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Получение списка аттестации - успешный
    func createSuccessListAttestationRequest(){
        let fileName = "FakeSuccessAttestationRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/json; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/api/1.0/certification?dataId=1")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Получение списка аттестации - неуспешный
    func createErrorListAttestationRequest(){
        let fileName = "FakeErrorAttestationRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/json; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/api/1.0/certification?dataId=1")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Получение списка экзаменов - успешный
    func createSuccessListExamRequest(){
        let fileName = "FakeSuccessExamRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/json; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/api/1.0/progress?dataId=1")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Получение списка экзаменов - неуспешный
    func createErrorListExamRequest(){
        let fileName = "FakeErrorExamRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
         
        let response = StubResponse.Builder()
             .stubResponse(withStatusCode: 200)
             .addHeader(withKey: "Content-Type", value: "text/json; charset=utf-8")
             .addBody(stringifyData.data(using: .utf8)!)
             .build()
         
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                          url: URL(string: "http://cabinet.bstu.ru/api/1.0/progress?dataId=1")!)
             .addResponse(response)
             .build()
         
        Hippolyte.shared.add(stubbedRequest: request)
    }
}


struct Login: Codable, Hashable {
    let email: String
    let password: String
}

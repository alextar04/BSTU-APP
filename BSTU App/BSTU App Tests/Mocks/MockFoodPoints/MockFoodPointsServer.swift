//
//  MockFoodPointsServer.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 14.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Hippolyte
import SwiftSoup

class MockFoodPointsServer{
    
    func start() {
        Hippolyte.shared.start()
    }
    
    
    func stop() {
        Hippolyte.shared.stop()
    }
    
    // Пункты питания
    // Меню пункта питания
    init() {
        createPointsRequest()
        createMenuRequest()
    }
    
    
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
    
    
    // MARK: Запрос пунктов питания
    func createPointsRequest() {
        
        let fileName = "FakeSuccessPointsRequest.html"
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
                         url: makeUrlFromString(someString: "http://menu.bstu.ru/"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }

    
    // MARK: Запрос меню
    func createMenuRequest() {
        
        let fileName = "FakeSuccessMenuRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .POST,
                         url: URL(string: "http://menu.bstu.ru/")!)
            .addHeader(withKey: "Content-Type", value: "application/x-www-form-urlencoded")
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
}

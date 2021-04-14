//
//  MockTeachersServer.swift
//  BSTU App Tests
//
//  Created by Alexey Taran on 14.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Hippolyte
import SwiftSoup

class MockTeacherServer{
    
    func start() {
        Hippolyte.shared.start()
    }
    
    
    func stop() {
        Hippolyte.shared.stop()
    }
    
    // Запрос фамилий по букве
    // Расписание занятий / экзаменов
    init() {
        createSuccessSurnameRequest()
        createScheduleRequest()
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
    
    
    // MARK: Запрос фамилий (удачный)
    func createSuccessSurnameRequest() {
        
        let fileName = "FakeSuccessSurnameRequest.html"
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
                         url: makeUrlFromString(someString: "https://www.bstu.ru/about/useful/schedule/staff/\(Unicode.Scalar("А"))"))
            .addHeader(withKey: "X-Requested-With", value: "XMLHttpRequest")
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Расписание занятий/экзаменов
    func createScheduleRequest() {
        
        let fileName = "FakeSuccessScheduleRequest.html"
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
                         url: URL(string: "http://www.bstu.ru/static/themes/bstu/schedule/index.php?tid=1832")!)
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
}

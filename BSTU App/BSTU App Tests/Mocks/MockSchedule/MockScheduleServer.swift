//
//  MockScheduleServer.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.04.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Hippolyte
import SwiftSoup

class MockScheduleServer{
    
    func start() {
        Hippolyte.shared.start()
    }
    
    
    func stop() {
        Hippolyte.shared.stop()
    }
    
    //Запрос списка институтов
    //Ошибка запроса списка институтов
    //Запрос списка групп
    //Ошибка запроса списка групп
    //Расписание очной группы числитель + знаменатель
    //Расписание заочной группы
    //Расписание экзаменов
    init() {
        createSuccessListInstitutionsRequest()
        createErrorListInstitutionsRequest()
        
        createSuccessListNumberCoursesRequest()
        createSuccessListGroupsRequest()
        
        createErrorListGroupsRequest()
        createScheduleFullTimeGroup()
        createScheduleCorrespondenceGroup()
        createExamScheduleRequest()
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
    
    // MARK: Запрос списка институтов (удачный)
    func createSuccessListInstitutionsRequest() {
        
        let fileName = "FakeCreateSuccessListInstitutionsRequest.html"
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
                         url: URL(string: "http://info.bstu.ru/index.php/")!)
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Запрос списка институтов (неудачный)
    func createErrorListInstitutionsRequest() {
        
        let fileName = "FakeErrorListInstitutionsRequest.html"
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
                         url: URL(string: "http://info.bstu_error.ru/index.php/")!)
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Запрос списка ссылок на номера курсов института
    func createSuccessListNumberCoursesRequest(){
        
        let fileName = "FakeSuccessListCourseNumbersRequest.html"
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
                         url: makeUrlFromString(someString: "http://info.bstu.ru/index.php/institut/groups"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    // MARK: Запрос списка групп
    func createSuccessListGroupsRequest(){
        
        let fileName = "FakeSuccessListGroupsRequest.html"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "text/html; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        for i in 1...5{
            let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                         url: makeUrlFromString(someString: "http://info.bstu.ru/index.php/institut/groups?course=\(i)&test=\(i)&inst=0&name=АИ"))
            .addResponse(response)
            .build()
            
            Hippolyte.shared.add(stubbedRequest: request)
        }
    }
    
    
    // MARK: Запрос списка групп (неудачный)
    func createErrorListGroupsRequest(){
        
        let fileName = "FakeErrorListGroupsRequest.html"
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
                         url: makeUrlFromString(someString: "http://info.bstu_error.ru/index.php/institut/groups"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
 
    
    // MARK: Запрос расписания очной группы
    func createScheduleFullTimeGroup(){
        
        let fileName = "FakeSuccessScheduleFullTimeGroupRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "application/json; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                         url: makeUrlFromString(someString: "http://cabinet.bstu.ru/api/1.0/timetable?role=student&groupName=АП-41&wholeWeek=true"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Запрос расписания заочной группы
    func createScheduleCorrespondenceGroup(){
        
        let fileName = "FakeSuccessScheduleCorrespondenceGroupRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "application/json; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                         url: makeUrlFromString(someString: "http://cabinet.bstu.ru/api/1.0/timetable?role=student&groupName=ИТз-41&wholeWeek=true"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
    // MARK: Запрос расписания группы с экзаменами
    func createExamScheduleRequest(){
        
        let fileName = "FakeSuccessScheduleExamRequest.json"
        copyFile(fileName: fileName)
        let url = getDataUrl(fileName: fileName)
        let stringifyData = try! String(contentsOf: url, encoding: .utf8)
        
        let response = StubResponse.Builder()
            .stubResponse(withStatusCode: 200)
            .addHeader(withKey: "Content-Type", value: "application/json; charset=utf-8")
            .addBody(stringifyData.data(using: .utf8)!)
            .build()
        
        let request = StubRequest.Builder()
            .stubRequest(withMethod: .GET,
                         url: makeUrlFromString(someString: "http://cabinet.bstu.ru/api/1.0/timetable?role=student&groupName=ПВ-41&wholeWeek=true"))
            .addResponse(response)
            .build()
        
        Hippolyte.shared.add(stubbedRequest: request)
    }
    
    
}

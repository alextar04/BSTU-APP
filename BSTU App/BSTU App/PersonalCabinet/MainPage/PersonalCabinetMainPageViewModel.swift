//
//  PersonalCabinetMainPageViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 16.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup
import SwiftyJSON

class PersonalCabinetMainPageViewModel{
    
    // MARK: Метод авторизации на сервере
    func autorizate(login: String, password: String,
                    completion: @escaping (PersonalCabinetMainPageModel)->Void,
                    errorCallback: @escaping (TypeError)->Void){
        
        let queryParameters: [String: String] = [
            "email" : login,
            "password" : password,
        ]
        
        AF.request("http://cabinet.bstu.ru/auth/login",
                   method: .post,
                   parameters: queryParameters,
                   encoding: URLEncoding.httpBody)
            .responseString{ [weak self] html in
                do {
                    let document = try SwiftSoup.parse(html.result.get())
                    let title = try (document.title())
                    
                    if title == "Вход в систему"{
                        errorCallback(.wrongDataError)
                        return
                    }
                    
                    completion(self!.getUserInfoFromServerResponse(html: document))
                } catch{
                    errorCallback(.networkError)
                }
            }
    }
    
    
    // MARK: Функция выхода из личного кабинета
    func logout(completion: @escaping ()->Void,
                errorCallback: @escaping (TypeError)->Void){
        
        AF.request("http://cabinet.bstu.ru/auth/logout",
                   method: .get)
            .responseString{ [weak self] html in
                do {
                    let document = try SwiftSoup.parse(html.result.get())
                    let headScripts = try (document.head()?.select("script"))
                    
                    var neededScriptDefine: String!
                    for connectedScript in headScripts!{
                        let data = connectedScript.data()
                        if data.hasPrefix("define"){
                            neededScriptDefine = data
                            break
                        }
                    }
                    if neededScriptDefine == nil{
                        errorCallback(.networkError)
                    }
                    
                    // Регулярное выражение для получения JSON c данными о вышедшем пользователе
                    // "{.*}"
                    let regex = try! NSRegularExpression(pattern: "\\{.*\\}")
                    let regexMatches = regex.matches(in: neededScriptDefine,
                                                      range: NSRange(location: 0,
                                                                     length: neededScriptDefine.utf16.count))
                    let matchStrings = regexMatches.map{
                        String(neededScriptDefine[Range($0.range, in: neededScriptDefine)!])
                    }
                    
                    // Проверка авторизации пользователя
                    if matchStrings.count != 0{
                        var stringifyJSON = matchStrings.first!
                        stringifyJSON = stringifyJSON.replacingOccurrences(of: "undefined", with: "-1")
                        let json = try! JSON(data: Data(stringifyJSON.utf8))
                        if json["currentUser"].int! == -1{
                            completion()
                            self!.removeUserDataFromStorage()
                            return
                        }
                    }
                    errorCallback(.networkError)
                } catch{
                    errorCallback(.networkError)
                }
            }
    }
    
    
    // MARK: Получение данных о пользователе при авторизации
    // Входной параметр: html: SwiftSoup.Document
    func getUserInfoFromServerResponse(html: Document)->PersonalCabinetMainPageModel{
        
        let userInfo = PersonalCabinetMainPageModel()
        
        do {
            let headScripts = try (html.head()?.select("script"))
            
            var neededScriptDefine: String!
            for connectedScript in headScripts!{
                let data = connectedScript.data()
                if data.hasPrefix("define"){
                    neededScriptDefine = data
                    break
                }
            }
            if neededScriptDefine == nil{
                return userInfo
            }
            
            // Регулярное выражение для получения JSON из HTML c данными о пользователе
            // "{.*}"
            let regex = try! NSRegularExpression(pattern: "\\{.*\\}")
            let regexMatches = regex.matches(in: neededScriptDefine,
                                              range: NSRange(location: 0,
                                                             length: neededScriptDefine.utf16.count))
            let matchStrings = regexMatches.map{
                String(neededScriptDefine[Range($0.range, in: neededScriptDefine)!])
            }
            
            // Конвертирование String -> JSON
            if matchStrings.count != 0{
                var stringifyJSON = matchStrings.first!
                stringifyJSON = stringifyJSON.replacingOccurrences(of: "undefined", with: "-1")
                let json = try! JSON(data: Data(stringifyJSON.utf8))
                
                // Получение инициалов пользователя, вошедшего в кабинет
                if let fullNameUser = json["currentUser"]["fullName"].string{
                    
                    // Выделение инициалов пользователя
                    let fullNameUserParts = fullNameUser.split(separator: " ").map{
                        return String($0)
                    }
                    
                    // Сокращенные инициалы (без фамилии)
                    let notSurnamePart = fullNameUserParts[1..<fullNameUserParts.count].map{ names in
                        return ("\(names.first!).")
                    }.joined(separator: " ")
                    
                    userInfo.headerName = "\(fullNameUserParts.first!) \(notSurnamePart)"
            
                } else {
                    userInfo.headerName = "(Нет)"
                }
                
                
                userInfo.instituteName = json["currentUser"]["defaultAccount"]["data"]["group"]["institute"]["shortName"].string ?? "(Нет)"
                userInfo.groupName = json["currentUser"]["defaultAccount"]["data"]["group"]["name"].string ?? "(Нет)"
                userInfo.numberRecordBookValue = json["currentUser"]["defaultAccount"]["data"]["recordBook"].string ?? "(Нет)"
                userInfo.typePerson = json["currentUser"]["defaultAccount"]["data"]["status"]["name"].string?.capitalizingFirstLetter() ?? "(Нет)"
                userInfo.educationForm = json["currentUser"]["defaultAccount"]["data"]["studyForm"]["name"].string ?? "(Нет)"
                userInfo.educationType = json["currentUser"]["defaultAccount"]["data"]["financialBase"]["name"].string ?? "(Нет)"
                
                if let birthday = json["currentUser"]["defaultAccount"]["data"]["birthday"].string{
                    userInfo.birthday = birthday.split(separator: " ").first?
                        .split(separator: "-")
                        .reversed()
                        .joined(separator: ".") ?? ("Нет")
                } else {
                    userInfo.birthday = "(Нет)"
                }
                
                userInfo.gender = json["currentUser"]["defaultAccount"]["data"]["sex"].string?.capitalizingFirstLetter() ?? "(Нет)"
                userInfo.citizenship = json["currentUser"]["defaultAccount"]["data"]["citizenship"].string ?? "(Нет)"
                userInfo.telephone = json["currentUser"]["defaultAccount"]["data"]["phone"].string ?? "(Нет)"
                userInfo.email = json["currentUser"]["defaultAccount"]["data"]["email"].string ?? "(Нет)"
                userInfo.snils = json["currentUser"]["defaultAccount"]["data"]["snils"].string ?? "(Нет)"
                
                return userInfo
            }
            return userInfo
        } catch{
            return userInfo
        }
    }
    
    
    // MARK: Функция удаления их хранилища данных о пользователе
    func removeUserDataFromStorage(){
        let defaults = UserDefaults.standard
        defaults.set(nil, forKey: "login")
        defaults.set(nil, forKey: "password")
    }
    
}

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
                    completion: @escaping ()->Void,
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
                    
                    completion()
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
                    
                    // Регулярка для получения JSON c данными о вышедшем пользователе
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
    
    
    // MARK: Функция удаления их хранилища данных о пользователе
    func removeUserDataFromStorage(){
        let defaults = UserDefaults.standard
        defaults.set(nil, forKey: "login")
        defaults.set(nil, forKey: "password")
    }
    
}

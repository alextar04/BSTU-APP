//
//  SigninViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 16.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup

class SigninViewModel{
    
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
                    
                    if title == "502 Bad Gateway"{
                        errorCallback(.networkError)
                        return
                    }
                    
                    let personalCabinetViewModel = PersonalCabinetMainPageViewModel()
                    completion(personalCabinetViewModel.getUserInfoFromServerResponse(html: document))
                    self!.setUserDataToStorage(login: login,
                                               password: password)
                } catch{
                    errorCallback(.networkError)
                }
            }
    }
    
    
    // MARK: Функция записи в хранилище данных о пользователе
    func setUserDataToStorage(login: String, password: String){
        let defaults = UserDefaults.standard
        defaults.set(login, forKey: "login")
        defaults.set(password, forKey: "password")
    }
    
}


enum TypeError{
    case networkError
    case wrongDataError
}


enum TypePersonalCabinetStartPage{
    case login
    case mainPage
}

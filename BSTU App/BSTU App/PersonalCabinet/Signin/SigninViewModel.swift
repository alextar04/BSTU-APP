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
    
    // MARK: Функция авторизации на сервере
    func autorizate(login: String, password: String,
                    completion: @escaping ()->Void,
                    errorCallback: @escaping (TypeError)->Void){
        
        /*
         http://cabinet.bstu.ru/auth/login
         POST: email, password
         */
        
        let queryParameters: [String: String] = [
            "email" : login,
            "password" : password,
        ]
        
        AF.request("http://cabinet.bstu.ru/auth/login",
                   method: .post,
                   parameters: queryParameters,
                   encoding: URLEncoding.httpBody)
            .responseString{ html in
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
}


enum TypeError{
    case networkError
    case wrongDataError
}

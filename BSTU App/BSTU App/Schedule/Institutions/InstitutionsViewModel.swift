//
//  InstitutionsViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 01.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup
import SwiftyJSON

class InstitutionViewModel{
    
    // MARK: Получение и обработка данных об институтах
    func getInstitutionList(startLink: String,
                            completion: @escaping (([Institution]) -> Void),
                            errorClosure: @escaping (()->Void)){
        
        var listInstitutionName = [Institution]()
        AF.request(try! startLink.asURL()).responseString{ html in
            do {
                let document = try SwiftSoup.parse(html.result.get())
                let listInstitutions = try (document.getElementById("content")?.getElementsByClass("list").select("a"))
                if listInstitutions != nil{
                    for institution in listInstitutions!{
                        let link = try "http://info.bstu.ru\(institution.attr("href"))"
                                .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
                                .asURL()
                        let components = URLComponents(url: link, resolvingAgainstBaseURL: false)
                        let nameInstitution = components?.queryItems?.first(where: { $0.name == "name" })?.value
                        if nameInstitution != nil{
                            listInstitutionName.append(Institution(name: nameInstitution, link: link))
                        }
                    }
                    completion(listInstitutionName)
                } else{
                    errorClosure()
                }
            } catch{
                //"Ошибка при парсинге страницы списка институтов!"
                errorClosure()
        }}
    }
}

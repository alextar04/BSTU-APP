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

class InstitutionViewModel{
    
    // MARK: Получение и обработка данных об институтах
    func getInstitutionList(completion: @escaping (([String]) -> Void)){
        
        var listInstitutionName = [String]()
        AF.request("http://info.bstu.ru/index.php/").responseString{ html in
            do {
                let document = try SwiftSoup.parse(html.result.get())
                let listInstitutions = try (document.getElementById("content")?.getElementsByClass("list").select("a"))!
                for institution in listInstitutions{
                    let link = try! "http://info.bstu.ru\(institution.attr("href"))"
                            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
                            .asURL()
                    let components = URLComponents(url: link, resolvingAgainstBaseURL: false)
                    let nameInstitution = components?.queryItems?.first(where: { $0.name == "name" })?.value
                    if nameInstitution != nil{
                        listInstitutionName.append(nameInstitution!)
                    }
                }
                completion(listInstitutionName)
            } catch{
            fatalError("Ошибка при парсинге страницы списка институтов!")
        }}
    }
}

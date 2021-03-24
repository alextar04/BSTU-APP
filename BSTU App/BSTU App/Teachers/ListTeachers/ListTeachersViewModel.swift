//
//  ListTeachersViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 11.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup


class ListTeachersViewModel{
    
    // MARK: Получение списка преподавателей с ссылками на расписание
    // Входной параметр: Первая буква в фамилии
    func getTeachersListByFirstLetter(firstLetter: UInt32,
                                      completion: @escaping (([Teacher])->Void),
                                      errorClosure: @escaping (TypeError)->Void){
        
        var arrayTeachers = [Teacher]()
        let suffixUrl: UnicodeScalar = Unicode.Scalar(firstLetter)!
        let url = "https://www.bstu.ru/about/useful/schedule/staff/\(suffixUrl)"
                .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
        let header: HTTPHeaders = [
                "X-Requested-With": "XMLHttpRequest"
        ]
        
        AF.request(url!, method: .get, headers: header)
                .validate()
                .responseString{ [weak self] html in
                do {
                    let document = try SwiftSoup.parse(html.result.get())
                    let listTeachers = try document.getElementsByClass("employee")
                        
                    if listTeachers.count != 0{
                        for teacher in listTeachers{
                            let teacherScheduleLink = try teacher.attr("href")
                            let teacherScheduleUrl = teacherScheduleLink.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
                            let teacherName = try teacher.text()
                                
                            arrayTeachers.append(Teacher(teacherName, try! teacherScheduleUrl!.asURL()))
                        }
                    }
                    
                    completion(arrayTeachers)
                } catch{
                        errorClosure(.networkError)
                    }
                }
    }
}

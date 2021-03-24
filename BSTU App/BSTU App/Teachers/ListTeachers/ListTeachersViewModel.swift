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
    func getTeachersList(completion: @escaping (([Teacher])->Void),
                         errorClosure: @escaping (TypeError)->Void){
        
        /*
        completion([Teacher("Иванов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Икунов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Ировов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Петров", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Пецров", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Попов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Сидоров", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Могов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Погов", try! "http://info.bstu.ru/index.php/".asURL())
        ])*/
        
        var arrayTeachers = [Teacher]()
        let dispatchGroup = DispatchGroup()
        
        for firstLetter in getRussianAlphabet(){
            dispatchGroup.enter()
            let url = "https://www.bstu.ru/about/useful/schedule/staff/\(firstLetter)"
                .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
            let header: HTTPHeaders = [
                "X-Requested-With": "XMLHttpRequest"
            ]
            
            DispatchQueue.global().async(group: dispatchGroup){
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
                        dispatchGroup.leave()
                    } catch{
                        errorClosure(.networkError)
                        dispatchGroup.leave()
                    }
                }
            }
        }
        
        dispatchGroup.notify(queue: DispatchQueue.main){
            completion(arrayTeachers)
        }
        
    }
    
    
    // MARK: Метод для получения русского алфавита для запроса преподавателей
    func getRussianAlphabet()->[UnicodeScalar]{
        var alphabetArray = [UnicodeScalar]()
        
        let startChar = Unicode.Scalar("А").value
        let endChar = Unicode.Scalar("Я").value

        for alphabetChar in startChar...endChar {
            if let char = Unicode.Scalar(alphabetChar) {
                alphabetArray.append(char)
            }
        }
        return alphabetArray
    }
    
}

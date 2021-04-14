//
//  GroupsViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 01.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup

class GroupsViewModel{
    
    // MARK: Получение и обработка данных о группах
    func getGroupsList(link: URL, completion: @escaping (([CourseGroups])->Void), errorClosure: @escaping (()->Void)){
        
        // Список -> Номер курса: Название группы
        var listCoursesGroups = [CourseGroups]()
        AF.request(link).responseString{ html in
            do {
                var document = try SwiftSoup.parse(html.result.get())
                let listCourses = try (document.getElementById("content")?.getElementsByClass("list").select("a"))
                if listCourses != nil{
                    for course in listCourses!{
                        let courseGroupslink = try "http://info.bstu.ru\(course.attr("href"))"
                                .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
                                .asURL()
                        // Получение цифры курса
                        let courseGroupslinkComponents = URLComponents(url: courseGroupslink, resolvingAgainstBaseURL: false)
                        let numberCourse = courseGroupslinkComponents?.queryItems?.first(where: { $0.name == "course" })?.value
                            
                        // Запрос групп определенного курса
                        AF.request(courseGroupslink).responseString{ htmlGroupsCourse in
                            do {
                                document = try SwiftSoup.parse(htmlGroupsCourse.result.get())
                                let listGroups = try (document.getElementById("content")?.getElementsByClass("list").select("a"))
                                var listGroupsModel = [Group]()
                                if listGroups != nil {
                                    for group in listGroups!{
                                        let grouplink = try "http://info.bstu.ru\(group.attr("href"))"
                                                .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!
                                                .asURL()
                                        // Получение названия группы
                                        let groupLinkComponents = URLComponents(url: grouplink, resolvingAgainstBaseURL: false)
                                        let nameGroup = groupLinkComponents?.queryItems?.first(where: { $0.name == "group" })?.value
                                        listGroupsModel.append(Group(nameGroup ?? "Ошибка", Int(numberCourse ?? "1") ?? 1, grouplink))
                                    }
                                    
                                    
                                    listCoursesGroups.append(CourseGroups(Int(numberCourse ?? "1") ?? 1, listGroupsModel))
                                    (listCoursesGroups.count == listCourses!.count) ? completion(listCoursesGroups) : ()
                                } else {
                                   errorClosure()
                                }
                            } catch{
                                //"Ошибка при парсинге страницы списка групп!"
                                errorClosure()
                            }
                        }
                    }
                } else {
                    errorClosure()
                }
            } catch{
            //"Ошибка при парсинге страницы списка курсов институтов!"
            errorClosure()
        }}
    }
    
    
    // Вспомогательная структура для хранения пар:
    // Номер курса: Название группы
    class CourseGroups{
        
        var numberCourse: Int!
        var groups: [Group]!
        
        init(_ numberCourse: Int, _ groups: [Group]) {
            self.numberCourse = numberCourse
            self.groups = groups
        }
    }
}

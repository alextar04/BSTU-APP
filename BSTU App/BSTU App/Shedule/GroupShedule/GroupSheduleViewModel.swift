//
//  GroupSheduleViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup
import UIKit


class GroupSheduleViewModel{
    
    // MARK: Получение расписания для группы
    // Входные параметры: id-группы
    func getSheduleForGroup(idGroup: Int){
        
        let link = "http://info.bstu.ru/schedule.php?gid=\(idGroup)"
        AF.request(link).responseString{ html in
            
            do{
                let document = try SwiftSoup.parse(html.result.get())
                let listLessons = try document.getElementsByClass("schedule_std")
                
                // Список занятий по дням
                var listLessonByDaysNumerator = [[String]].init(repeating: [], count: 6)
                var listLessonByDaysDenomentor = [[String]].init(repeating: [], count: 6)
                for (index, lesson) in listLessons.enumerated(){
                    
                    var lessonParsed: Bool = false
                    for cellType in [TypeLesson.schedule_half,
                                     TypeLesson.schedule_hq,
                                     TypeLesson.shedule_quater]{
                        if !lessonParsed{
                            switch cellType {
                            // Обработка ячеек с занятиями числитель/знаменатель
                            case .schedule_half:
                                let notPermanentLesson = try lesson.getElementsByClass("schedule_half")
                                if notPermanentLesson.count != 0{
                                    listLessonByDaysNumerator[index % 6].append(try notPermanentLesson.first()?.text() as! String)
                                    listLessonByDaysDenomentor[index % 6].append(try notPermanentLesson.last()?.text() as! String)
                                    lessonParsed = true
                                    break
                                }
                            // Обработка ячеек с постоянными занятиями по полупаре
                            case .schedule_hq:
                                listLessonByDaysNumerator[index % 6].append(try lesson.text())
                                listLessonByDaysDenomentor[index % 6].append(try lesson.text())
                                lessonParsed = true
                                break
                            // Обработка ячеек с с занятиями числитель/знаменатель по полупаре
                            case .shedule_quater:
                                listLessonByDaysNumerator[index % 6].append(try lesson.text())
                                listLessonByDaysDenomentor[index % 6].append(try lesson.text())
                                lessonParsed = true
                                break
                            default:
                                break
                            }
                        }
                    }
                }
                
                for day in listLessonByDaysNumerator{
                    print("Новый день")
                    for lesson in day{
                        print(lesson)
                    }
                    print()
                }
                
            } catch {
              fatalError()
            }
        }
    }
    
    
    enum TypeLesson{
        case schedule_std
        case schedule_half
        case schedule_hq
        case shedule_quater
    }
    
    
    // MARK: Получение числа и названия дня недели
    func getCurrentDayOfWeek()->(Int, String){
        let date = Date()
        let calendar = Calendar.current
        let todayName = calendar.component(.weekday, from: date)
        let todayNumber = calendar.component(.day, from: date)
        
        switch todayName {
        case 1:
            return(todayNumber, "Воскресенье")
        case 2:
            return(todayNumber, "Понедельник")
        case 3:
            return(todayNumber, "Вторник")
        case 4:
            return(todayNumber, "Среда")
        case 5:
            return(todayNumber, "Четверг")
        case 6:
            return(todayNumber, "Пятница")
        case 7:
            return(todayNumber, "Суббота")
        default:
            return(-1, "")
        }
    }
    
    
    // MARK: Получение информации о типе недели
    func getCurrentWeekType()->String{
        let date = Date()
        let calendar = Calendar.current
        let weekNumber = calendar.component(.weekOfMonth, from: date)
        
        if weekNumber == 1{
            return "Числитель"
        }
        
        return "Знаменатель"
    }
    
    
    // MARK: Получение чисел текущей и следующей недели
    func getNumbersOfCalendarDates()->([Int], [Int]){
        
        var currentWeekNumbers = [Int]()
        var nextWeekNumbers = [Int]()
        
        var calendar = Calendar.autoupdatingCurrent
        calendar.firstWeekday = 2
        let today = calendar.startOfDay(for: Date())
        if let weekInterval = calendar.dateInterval(of: .weekOfYear, for: today) {
            
            // Заполнение чисел текущей недели
            for i in 0...6 {
                if let day = calendar.date(byAdding: .day, value: i, to: weekInterval.start) {
                    currentWeekNumbers.append(calendar.component(.day, from: day))
                }
            }
            
            // Заполнение чисел следующей недели
            for i in 7...13 {
                if let day = calendar.date(byAdding: .day, value: i, to: weekInterval.start) {
                    nextWeekNumbers.append(calendar.component(.day, from: day))
                }
            }
        }
        
        return (currentWeekNumbers, nextWeekNumbers)
    }
    
    
    // MARK: Получение названия дня по выбранную индексу дня
    func getNameOfDayByIndex(index: Int)->String{
        
        switch index {
        case 0:
            return "Понедельник"
        case 1:
            return "Вторник"
        case 2:
            return "Среда"
        case 3:
            return "Четверг"
        case 4:
            return "Пятница"
        case 5:
            return "Суббота"
        case 6:
            return "Воскресенье"
        default:
            return ""
        }
    }
}

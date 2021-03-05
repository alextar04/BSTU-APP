//
//  GroupSheduleViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON


class GroupSheduleViewModel{
    
    var resultDaysCurrentWeek: [[GroupSheduleModel]]!
    var resultDaysNextWeek: [[GroupSheduleModel]]!
    var resultExams = [GroupSheduleModel]()
    
    // MARK: Получение расписания для группы (для self.resultDaysCurrentWeek)
    // Входные параметры: id-группы
    func getSheduleForGroup(groupName: String, completion: @escaping (()->Void), errorClosure: @escaping ()->Void){
        
        let url = "http://cabinet.bstu.ru/api/1.0/timetable?role=student&groupName=\(groupName)&wholeWeek=true"
            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
        AF.request(url!, method: .get).validate().responseJSON{ response in
            
            switch response.result{
            case .success(let value):
                let resultJson = JSON(value)
                
                let currentWeek = resultJson["current_week"]
                let nextWeek = resultJson["next_week"]
                let isCurrentWeekNumerator = currentWeek["now_denom"].int
                
                // Парсинг информации о неделе
                for (index, week) in [currentWeek, nextWeek].enumerated(){
                    var resultDays = [[GroupSheduleModel]].init(repeating: [GroupSheduleModel](), count: 7)
                    let arrayDays = week["days"].array
                    
                    if arrayDays != nil{
                        for day in arrayDays!{
                            
                            // Заполнение информации по дню
                            let dayActivities = day["pairs"].array
                            for activity in dayActivities!{
                                let lesson = GroupSheduleModel()
                                
                                // Если в дисциплине есть разделение по подгруппам
                                // Добавить информацию о подгруппе к строке названия дисциплины
                                var additionalNameSubject = ""
                                if let subGroupInfo = activity["group_part"].string{
                                    let parsedSubgroupInfo = subGroupInfo.split(separator: "/").map{
                                            return String($0)
                                    }
                                    if parsedSubgroupInfo.last != "1"{
                                        additionalNameSubject = " \(parsedSubgroupInfo.first!) гр."
                                    }
                                }
                                lesson.nameSubject = "\(activity["subject_name_short"].string!)\(additionalNameSubject)"
                                
                                switch activity["event_type_name"].string {
                                case "лек.":
                                    lesson.typeActivity = .lection
                                case "лаб.":
                                    lesson.typeActivity = .laboratory
                                case "практ.":
                                    lesson.typeActivity = .practice
                                case "конс.":
                                    lesson.typeActivity = .consultation
                                case "экз.":
                                    lesson.typeActivity = .examination
                                default:
                                    break
                                }
                                
                                if [TypeActivity.consultation, TypeActivity.examination].contains(lesson.typeActivity){
                                    
                                    lesson.timeStart = activity["ev_start"].string
                                    var dateComponents = Array(String(lesson.timeStart.split(separator: " ").first!)
                                        .split(separator: "-")
                                        .reversed()
                                        .map{
                                        return String($0)
                                    })
                                    let indexYearShort1 = dateComponents[2].index(dateComponents[2].startIndex, offsetBy: 2)
                                    let indexYearShort2 = dateComponents[2].index(indexYearShort1, offsetBy: 1)
                                    dateComponents[2] = String(dateComponents[2][indexYearShort1...indexYearShort2])
                                    let dateString = dateComponents.joined(separator: ".")
                                    
                                    let indexTimeStart1 = lesson.timeStart.index(lesson.timeStart.startIndex, offsetBy: 11)
                                    let indexTimeStart2 = lesson.timeStart.index(indexTimeStart1, offsetBy: 4)
                                    lesson.timeStart = "\(dateString) \(String(lesson.timeStart[indexTimeStart1...indexTimeStart2]))"
                                    
                                } else {
                                    lesson.timeStart = activity["pair_time_start"].string
                                    let indexTimeStart1 = lesson.timeStart.index(lesson.timeStart.startIndex, offsetBy: 11)
                                    let indexTimeStart2 = lesson.timeStart.index(indexTimeStart1, offsetBy: 4)
                                    lesson.timeStart = String(lesson.timeStart[indexTimeStart1...indexTimeStart2])
                                    
                                    lesson.timeEnd = activity["pair_time_end"].string
                                    let indexTimeEnd1 = lesson.timeEnd.index(lesson.timeEnd.startIndex, offsetBy: 11)
                                    let indexTimeEnd2 = lesson.timeEnd.index(indexTimeEnd1, offsetBy: 4)
                                    lesson.timeEnd = String(lesson.timeEnd[indexTimeEnd1...indexTimeEnd2])
                                }
                                
                                lesson.audiences = [String]()
                                for item in activity["audiences"].array!{
                                    if let value = item["name"].string{
                                         lesson.audiences.append(value)
                                    }
                                }
                                
                                lesson.teachers = [String]()
                                for item in activity["teachers"].array!{
                                    if let value = item["name"].string{
                                         lesson.teachers.append(value)
                                    }
                                }
                                
                                if [TypeActivity.consultation, TypeActivity.examination].contains(lesson.typeActivity){
                                    self.resultExams.append(lesson)
                                } else {
                                    let dayOfWeek = (day["num_day"].int)! - 1
                                    resultDays[dayOfWeek].append(lesson)
                                }
                            }
                        }
                    }
    
                    switch index {
                    case 0:
                        self.resultDaysCurrentWeek = resultDays
                    case 1:
                        self.resultDaysNextWeek = resultDays
                    default:
                        break
                    }
                }
                completion()
                
            case .failure(let error):
                errorClosure()
            }
        }
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

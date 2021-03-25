//
//  TeacherScheduleViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 25.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire


class TeacherScheduleViewModel{
    
    var resultDaysCurrentWeek: [[TeacherScheduleModel]]!
    var resultDaysNextWeek: [[TeacherScheduleModel]]!
    var resultExams = [TeacherScheduleModel]()
    var isCurrentWeekNumerator: Bool!
    
    
    // MARK: Получение расписания для группы
    // Входные параметры: id-группы
    func getSheduleForTeacher(teacherName: String,
                              completion: @escaping (()->Void), errorClosure: @escaping ()->Void){
        
        self.resultDaysCurrentWeek = [[TeacherScheduleModel]]()
        self.resultDaysNextWeek = [[TeacherScheduleModel]]()
        
        for _ in 0...4{
            let a = TeacherScheduleModel()
            a.typeActivity = .lection
            a.audiences = ["ГУК 555"]
            a.groups = ["ПВ-31, ПВ-41, ПВ-51"]
            a.nameSubject = "Филология"
            a.timeStart = "15:55"
            a.timeEnd = "17:55"
            resultExams.append(a)
        }
        
        for _ in 0...6{
            var tempArray = [TeacherScheduleModel]()
            for _ in 0...4{
                let a = TeacherScheduleModel()
                a.typeActivity = .lection
                a.audiences = ["ГУК 555"]
                a.groups = ["ПВ-31, ПВ-41, ПВ-51"]
                a.nameSubject = "Филология"
                a.timeStart = "15:55"
                a.timeEnd = "17:55"
                tempArray.append(a)
            }
            self.resultDaysCurrentWeek.append(tempArray)
            self.resultDaysNextWeek.append(tempArray)
        }
        
        self.isCurrentWeekNumerator = false
        completion()
        
        /*
        let url = "http://cabinet.bstu.ru/api/1.0/timetable?role=student&groupName=\(groupName)&wholeWeek=true"
            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
        AF.request(url!, method: .get).validate().responseJSON{ response in
            
            switch response.result{
            case .success(let value):
                let resultJson = JSON(value)
                
                let currentWeek = resultJson["current_week"]
                let nextWeek = resultJson["next_week"]
                (currentWeek["now_denom"].int == 1) ? (self.isCurrentWeekNumerator = false) : (self.isCurrentWeekNumerator = true)
                
                // Парсинг каждой неделе
                for (index, week) in [currentWeek, nextWeek].enumerated(){
                    
                    var resultDays: [[GroupSheduleModel]]!
                    (isCorrespondenceGroup) ? (resultDays = [[GroupSheduleModel]].init(repeating: [GroupSheduleModel](), count: 1)) :
                                              (resultDays = [[GroupSheduleModel]].init(repeating: [GroupSheduleModel](), count: 7))
                    
                    // Парсинг каждого дня недели
                    if let arrayDays = week["days"].array{
                        for day in arrayDays{
                            
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
                                case "зач.":
                                    lesson.typeActivity = .test
                                case "конс.":
                                    lesson.typeActivity = .consultation
                                case "экз.":
                                    lesson.typeActivity = .examination
                                default:
                                    break
                                }
                                
                                if [TypeActivity.consultation, TypeActivity.examination].contains(lesson.typeActivity) || isCorrespondenceGroup{
                                    
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
                                
                                // Формирование контейнеров для очных групп
                                if !isCorrespondenceGroup{
                                    if [TypeActivity.consultation, TypeActivity.examination].contains(lesson.typeActivity){
                                        self.resultExams.append(lesson)
                                    } else {
                                        let dayOfWeek = (day["num_day"].int)! - 1
                                        resultDays[dayOfWeek].append(lesson)
                                    }
                                } else {
                                    // Формирование контейнера для заочных групп
                                    resultDays[0].append(lesson)
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
        }*/
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
        
        if self.isCurrentWeekNumerator{
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
    
    
    
    // Получение сокращенной записи для идентификации преподавателя
    func getShortTeacherRecord(teacher: String)->String{
        
        if teacher == ""{
            return teacher
        }
        
        // Выделение инициалов преподавателя
        let teacherParts = teacher.split(separator: " ").map{
            return String($0)
        }
        // Сокращенные инициалы (без фамилии)
        let notSurnamePart = teacherParts[1..<teacherParts.count].map{ names in
            return ("\(names.first!).")
        }.joined(separator: " ")
        
        return "\(teacherParts.first!) \(notSurnamePart)"
    }
    
    
}

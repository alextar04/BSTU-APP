//
//  TeacherScheduleViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 25.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup


class TeacherScheduleViewModel{
    
    var resultDaysCurrentWeek: [[TeacherScheduleModel]]!
    var resultDaysNextWeek: [[TeacherScheduleModel]]!
    var resultExams = [TeacherScheduleModel]()
    var isCurrentWeekNumerator: Bool!
    
    
    // MARK: Получение расписания для группы
    // Входные параметры: id-группы
    func getSheduleForTeacher(teacherName: String, teacherLink: URL,
                              completion: @escaping (()->Void), errorClosure: @escaping ()->Void){
        
        self.resultDaysCurrentWeek = [[TeacherScheduleModel]]()
        self.resultDaysNextWeek = [[TeacherScheduleModel]]()
        
        AF.request(teacherLink).responseString(encoding: String.Encoding.utf8) {
            [weak self] html in
                
                do{
                    let document = try SwiftSoup.parse(html.result.get())
                    
                    let notCorrespondenceGroupsSchedule = try document.select("table").tagName("schedule").first()
                    
                    let timeArray = try self!.getTimeIntervalsArray(timeElements: try notCorrespondenceGroupsSchedule?.getElementsByClass("time") as! Elements)
                    
                    let typeWeekInformation = try notCorrespondenceGroupsSchedule?.getElementsByClass("bottom_banner").first()?.text()
                    ((typeWeekInformation?.contains("числитель"))!) ? (self?.isCurrentWeekNumerator = true) : (self?.isCurrentWeekNumerator = false)
                    
                    let listLessons = try notCorrespondenceGroupsSchedule?.getElementsByClass("schedule_std")
                    
                    // Список занятий по дням
                    var listLessonByDaysNumerator = [[TeacherScheduleModel]].init(repeating: [], count: 7)
                    var listLessonByDaysDenomentor = [[TeacherScheduleModel]].init(repeating: [], count: 7)
                    for (index, lesson) in listLessons!.enumerated(){
                        
                    var lessonParsed: Bool = false
                    for cellType in [TypeLesson.schedule_half,
                                    TypeLesson.schedule_std]{
                        if !lessonParsed{
                            switch cellType {
                            // Обработка ячеек с занятиями числитель/знаменатель
                            case .schedule_half:
                                let notPermanentLesson = try lesson.getElementsByClass("schedule_half")
                                if notPermanentLesson.count != 0{
                                    let numeratorRecord = notPermanentLesson.first()
                                    let denomenatorRecord = notPermanentLesson.last()
                                    
                                    for (indexIteration, record) in [numeratorRecord, denomenatorRecord].enumerated(){
                                        
                                        if try record?.text() != ""{
                                            let typeLessonAndPlace = try record!.getElementsByClass("place_half").first()?.text()
                                            let audience = try record!.getElementsByClass("a_style").first()?.text()
                                            let subject = try record!.getElementsByClass("center_p").first()?.text()
                                            let groups = try record!.getElementsByClass("sp_half").first()?.text()
                                            
                                            var timeStart = timeArray[index / 6].0
                                            var timeFinish = timeArray[index / 6].1
                                            if timeStart == "11:45"{
                                                let breakTop = try record!.getElementsByClass("break_top")
                                                let breakBottom = try record!.getElementsByClass("break_bottom")
                                                if breakTop.count != 0{
                                                    // Перерыв до часовика
                                                    (timeStart, timeFinish) = self!.makeTimePairWithBreak(breakAtFirst: true,
                                                                                                           unpreparedTime: (timeStart, timeFinish))
                                                }
                                                if breakBottom.count != 0{
                                                    // Перерыв после часовика
                                                    (timeStart, timeFinish) = self!.makeTimePairWithBreak(breakAtFirst: false,
                                                                                                          unpreparedTime: (timeStart, timeFinish))
                                                }
                                            }
                                            
                                            let scheduleCell = TeacherScheduleModel()
                                            scheduleCell.nameSubject = subject
                                            scheduleCell.groups = [String](arrayLiteral: groups!)
                                            scheduleCell.audiences = [String](arrayLiteral: audience!)
                                            scheduleCell.typeActivity = self!.getTypeSubjectByStringName(name: String((typeLessonAndPlace?
                                                .prefix(typeLessonAndPlace!.count - audience!.count))!))
                                            scheduleCell.timeStart = timeStart
                                            scheduleCell.timeEnd = timeFinish
                                            
                                            (indexIteration == 0) ? (listLessonByDaysNumerator[index % 6].append(scheduleCell)):
                                                                     listLessonByDaysDenomentor[index % 6].append(scheduleCell)
                                        }
                                    }
                                    
                                    lessonParsed = true
                                    break
                                }
                            // Обработка ячеек с постоянными занятиями
                            case .schedule_std:
                                
                                if try lesson.text() != ""{
                                    
                                    let typeLessonAndPlace = try lesson.getElementsByClass("place_std").first()?.text()
                                    let audience = try lesson.getElementsByClass("a_style").first()?.text()
                                    let subject = try lesson.getElementsByClass("center_p").first()?.text()
                                    let groups = try lesson.getElementsByClass("sp_std").first()?.text()
                                    
                                    var timeStart = timeArray[index / 6].0
                                    var timeFinish = timeArray[index / 6].1
                                    if timeStart == "11:45"{
                                        let breakTop = try lesson.getElementsByClass("break_top")
                                        let breakBottom = try lesson.getElementsByClass("break_bottom")
                                        if breakTop.count != 0{
                                            // Перерыв до часовика
                                            (timeStart, timeFinish) = self!.makeTimePairWithBreak(breakAtFirst: true,
                                                                                                   unpreparedTime: (timeStart, timeFinish))
                                        }
                                        if breakBottom.count != 0{
                                            // Перерыв после часовика
                                            (timeStart, timeFinish) = self!.makeTimePairWithBreak(breakAtFirst: false,
                                                                                                  unpreparedTime: (timeStart, timeFinish))
                                        }
                                    }
                                    
                                    let scheduleCell = TeacherScheduleModel()
                                    scheduleCell.nameSubject = subject
                                    scheduleCell.groups = [String](arrayLiteral: groups!)
                                    scheduleCell.audiences = [String](arrayLiteral: audience!)
                                    scheduleCell.typeActivity = self!.getTypeSubjectByStringName(name: String((typeLessonAndPlace?
                                        .prefix(typeLessonAndPlace!.count - audience!.count))!))
                                    scheduleCell.timeStart = timeStart
                                    scheduleCell.timeEnd = timeFinish
                                    
                                    listLessonByDaysNumerator[index % 6].append(scheduleCell)
                                    listLessonByDaysDenomentor[index % 6].append(scheduleCell)
                                }
                                lessonParsed = true
                                break
                            }
                        }
                    }
                }
                
                if (self!.isCurrentWeekNumerator) {
                    self!.resultDaysCurrentWeek = listLessonByDaysNumerator
                    self!.resultDaysNextWeek = listLessonByDaysDenomentor
                } else {
                    self!.resultDaysCurrentWeek = listLessonByDaysDenomentor
                    self!.resultDaysNextWeek = listLessonByDaysNumerator
                }
                    
                completion()
            } catch {
                errorClosure()
            }
        }
    }
        
        
    enum TypeLesson{
        case schedule_std
        case schedule_half
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
    
    
    // MARK: Получение типа предмета по названию
    func getTypeSubjectByStringName(name: String)->TypeActivity{
        
        switch name {
        case "лек ":
            return TypeActivity.lection
        case "лаб ":
            return TypeActivity.laboratory
        case "пр ":
            return TypeActivity.practice
        case "зач ":
            return TypeActivity.test
        case "конс ":
            return TypeActivity.consultation
        case "экз ":
            return TypeActivity.examination
        default:
            return TypeActivity.test
        }
    }
    
    
    // MARK: Получение списка временных интервалов
    func getTimeIntervalsArray(timeElements: Elements) throws ->[(String, String)]{
        var resultArray = [(String, String)]()
        
        for time in timeElements{
            
            var firstValue = ""
            var secondValue = ""
            
            let timeCheckpoints = (try time.text()).split(separator: " ")
            firstValue = String(timeCheckpoints.first!)
            
            var endDateComponents = DateComponents()
            let endDate = String(timeCheckpoints.last!).split(separator: ":")
            endDateComponents.hour = Int(endDate.first!)
            endDateComponents.minute = Int(endDate.last!)
            var calendaredDate = Calendar.current.date(from: endDateComponents)
            calendaredDate = calendaredDate!.addingTimeInterval(45 * 60)
            
            secondValue = String(format: "%02ld:%02ld",
                                 Calendar.current.component(.hour, from: calendaredDate!),
                                 Calendar.current.component(.minute, from: calendaredDate!))
            resultArray.append((firstValue, secondValue))
        }
        return resultArray
    }
    
    
    // MARK: Конструирование времени пары с учетом часовика
    func makeTimePairWithBreak(breakAtFirst: Bool,
                               unpreparedTime: (String, String)) -> (String, String){
        
        var neededCheckpoint: String!
        (breakAtFirst) ? (neededCheckpoint = unpreparedTime.0) : (neededCheckpoint = unpreparedTime.1)
        var neededDateComponents = DateComponents()
        let neededDate = String(neededCheckpoint).split(separator: ":")
        neededDateComponents.hour = Int(neededDate.first!)
        neededDateComponents.minute = Int(neededDate.last!)
        var calendaredDate = Calendar.current.date(from: neededDateComponents)
        (breakAtFirst) ? (calendaredDate = calendaredDate!.addingTimeInterval(50 * 60)) :
            (calendaredDate = calendaredDate!.addingTimeInterval(-50 * 60))
        let newNeededValue = String(format: "%02ld:%02ld",
                                Calendar.current.component(.hour, from: calendaredDate!),
                                Calendar.current.component(.minute, from: calendaredDate!))
        
        return (breakAtFirst) ? (newNeededValue, unpreparedTime.1) : (unpreparedTime.0, newNeededValue)
    }
}

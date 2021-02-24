//
//  GroupSheduleViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit


class GroupSheduleViewModel{
    
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

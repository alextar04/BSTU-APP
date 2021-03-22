//
//  ExamsViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 22.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class ExamsViewModel{
    
    // MARK: Получение данных об оценках сессии пользователя
    // Входной параметр: id пользователя
    func getUserExamsInfo(idUser: Int,
                                completion: @escaping ([ExamsModel])->Void,
                                errorCallback: @escaping (TypeError)->Void) -> Void{
        
        let url = "http://cabinet.bstu.ru/api/1.0/progress?dataId=\(idUser)"
            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
        AF.request(url!, method: .get).validate()
            .responseJSON{ response in
                
                switch response.result{
                case .success(let value):
                
                    let resultJson = JSON(value)
                    let allExams = resultJson["progress"].array
                    var resultExams = [ExamsModel]()
                    
                    guard let unwarpedAllExams = allExams else {
                        errorCallback(.serverError)
                        return
                    }
                    
                    for examPeriod in unwarpedAllExams{
                        let numberSemestr = examPeriod["period"].string
                        let yearSemestr = examPeriod["year"].string
                        
                        
                        var disciplinesResult = [DisciplineExamModel]()
                        for discipline in examPeriod["subjects"].array!{
                            let nameExam = discipline["subjectname"].string!
                            let markname = discipline["stypename"].string!
                            var typeExam: TypeExam!
                            switch markname{
                            case "Зачет":
                                if let _ = Int(discipline["markname"].string!){
                                    typeExam = .differentialСredit
                                } else {
                                    typeExam = .credit
                                }
                            case "Экзамен":
                                typeExam = .exam
                            case "Курсовая работа":
                                typeExam = .courseWork
                            case "Курсовой проект":
                                typeExam = .courseProject
                            default:
                                typeExam = .credit
                            }
                            
                            var mark = discipline["markname"].string!
                            if Int(mark) == nil{
                                (discipline["isgood"].int == 1) ? (mark = "Зач.") : (mark = "Незач.")
                            }
                            
                            disciplinesResult.append(DisciplineExamModel(discipline: (nameExam, typeExam, mark)))
                        }
                        
                        resultExams.append(ExamsModel(numberSemester: "Семестр \(numberSemestr!) (\(yearSemestr!))",
                            disciplines: disciplinesResult))
                    }
                    completion(resultExams)
                    
                case .failure(_):
                    errorCallback(.networkError)
                }
        }
    }
}

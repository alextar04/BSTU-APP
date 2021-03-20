//
//  ExamsModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class ExamsModel{
    
    var numberSemester: String!
    var disciplines: [DisciplineExamModel]!
    
    init(numberSemester: String, disciplines: [DisciplineExamModel]) {
        self.numberSemester = numberSemester
        self.disciplines = disciplines
    }
}


class DisciplineExamModel{
    
    var discipline: (numberSemester: String, typeExam: TypeExam, mark: Int)!
    
    init(discipline: (numberSemester: String, typeExam: TypeExam, mark: Int)) {
        self.discipline = discipline
    }
}


enum TypeExam: String{
    case differentialСredit = "Диф. зач."
    case credit = "Зач."
    case courseWork = "Курс. раб."
    case courseProject = "Курс. проект"
    case exam = "Экз."
}

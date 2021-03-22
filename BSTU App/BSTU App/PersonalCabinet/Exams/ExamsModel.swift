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
    
    var myCellHeight: Int!
    var isExpanded = false
    
    init(numberSemester: String, disciplines: [DisciplineExamModel]) {
        self.numberSemester = numberSemester
        self.disciplines = disciplines
    }
}


class DisciplineExamModel{
    
    var discipline: (name: String, typeExam: TypeExam, mark: String)!
    
    init(discipline: (name: String, typeExam: TypeExam, mark: String)) {
        self.discipline = discipline
    }
}


class SelectedCellParametrs{
    var headerName: String!
    var selectedCellIndex: Int!
    var selectedCellHeight: Int!
    
    init(headerName: String, selectedCellIndex: Int, selecredCellHeight: Int) {
        self.headerName = headerName
        self.selectedCellIndex = selectedCellIndex
        self.selectedCellHeight = selecredCellHeight
    }
}


enum TypeExam: String{
    case differentialСredit = "Диф. зач."
    case credit = "Зач."
    case courseWork = "Курс. раб."
    case courseProject = "Курс. пр."
    case exam = "Экз."
}

//
//  GroupSheduleModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 03.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class GroupSheduleModel{
    
    var nameSubject: String!
    var typeActivity: TypeActivity!
    var timeStart: String!
    var timeEnd: String!
    var audiences: [String]!
    var teachers: [String]!
    
    /*
    init(nameSubject: String, typeActivity: TypeActivity, timeStart: String, timeEnd: String, audiences: [String], teachers: [String]) {
        self.nameSubject = nameSubject
        self.typeActivity = typeActivity
        self.timeStart = timeStart
        self.timeEnd = timeEnd
        self.audiences = audiences
        self.teachers = teachers
    }*/
}

enum TypeActivity{
    case lection
    case laboratory
    case practice
    case consultation
    case examination
}

//
//  GroupsModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 01.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class Group{
    var name: String!
    var numberCourse: Int!
    var link: URL!
    
    init(_ name: String, _ numberCourse: Int, _ link: URL) {
        self.name = name
        self.numberCourse = numberCourse
        self.link = link
    }
}

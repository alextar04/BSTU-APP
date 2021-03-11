//
//  ListTeachersModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 11.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation


class Teacher{
    var name: String!
    var link: URL!
    
    init(_ name: String, _ link: URL) {
        self.name = name
        self.link = link
    }
}

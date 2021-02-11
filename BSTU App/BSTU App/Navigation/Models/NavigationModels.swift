//
//  NavigationModels.swift
//  BSTU App
//
//  Created by Alexey Taran on 10.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RealmSwift

/*
class Marker: Object {
    @objc dynamic var name: String = ""
    @objc dynamic var description: String = ""
}*/

class QOQ: Object {
    @objc dynamic var name: String = ""
    @objc dynamic var value: String = ""
    @objc dynamic var qwerty: String = ""
}

class RealmTestClass0: Object {
    @objc dynamic var integerValue: Int = 0
    @objc dynamic var stringValue: String? = nil
    @objc dynamic var dataValue: Data? = nil
}

class RealmTestClass1: Object {
    @objc dynamic var integerValue: Int = 0
    @objc dynamic var boolValue: Bool = false
    @objc dynamic var floatValue: Float = 0
    @objc dynamic var doubleValue: Double = 0
    @objc dynamic var stringValue: String? = nil
    @objc dynamic var dateValue: Date? = nil
    let arrayReference = List<RealmTestClass0>()
}

class RealmTestClass2: Object {
    @objc dynamic var integerValue: Int = 0
    @objc dynamic var boolValue: Bool = false
    @objc dynamic var objectReference: RealmTestClass1?
}

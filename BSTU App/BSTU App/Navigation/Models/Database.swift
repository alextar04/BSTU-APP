//
//  Database.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SQLite

class Database{
    
    // MARK: Перезапись файла с базой данных на устройстве
    static func copyDatabaseToDevice(){
        let pathOnDevice = URL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.libraryDirectory, .userDomainMask, true).first!, isDirectory: true).appendingPathComponent("bstuDB.sqlite3")
        let bundleUrl = Bundle.main.url(forResource: "bstuDB.sqlite3", withExtension: nil)!

        if FileManager.default.fileExists(atPath: pathOnDevice.path) {
            try! FileManager.default.removeItem(at: pathOnDevice)
        }
        try! FileManager.default.copyItem(at: bundleUrl, to: pathOnDevice)
    }
    
    
    // MARK: Подключение к БД
    static func connect()->Connection{
        let pathOnDevice = URL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.libraryDirectory, .userDomainMask, true).first!, isDirectory: true).appendingPathComponent("bstuDB.sqlite3")
        return(try! Connection(pathOnDevice.absoluteString))
    }
    
}

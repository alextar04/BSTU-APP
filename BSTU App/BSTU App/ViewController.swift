//
//  ViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        /******/
        // Инициализация БД
        let pathOnDevice = URL(fileURLWithPath: NSSearchPathForDirectoriesInDomains(.libraryDirectory, .userDomainMask, true).first!, isDirectory: true).appendingPathComponent("bstuDB.sqlite3")
        let bundleUrl = Bundle.main.url(forResource: "bstuDB.sqlite3", withExtension: nil)!

        if FileManager.default.fileExists(atPath: pathOnDevice.path) {
            try! FileManager.default.removeItem(at: pathOnDevice)
        }
        try! FileManager.default.copyItem(at: bundleUrl, to: pathOnDevice)
        /******/
        
        /******/
        let configuration = Realm.Configuration(fileURL: pathOnDevice, schemaVersion: 7)
        let realm = try! Realm(configuration: configuration)
        let qoq = realm.objects(QOQ.self)
        print(qoq[0].name)
        print(qoq[0].qwerty)
        print(qoq[0].value)
        /******/
        
        
        let navigationController = NavigationViewController()
        self.addChild(navigationController)
        self.view.addSubview(navigationController.view)
        
    }


}


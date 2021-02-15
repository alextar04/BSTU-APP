//
//  ViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import UIKit
import SQLite

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        /*
        /******/
        print("Точки")
        print(pathOnDevice)
        let db = try! Connection(pathOnDevice.absoluteString)
        let dots = Table("MapRoadDotDB")
        let id = Expression<Int64>("id")
        for dot in try! db.prepare(dots) {
            print(dot[id])
        }
        /******/
        */
        Database.copyDatabaseToDevice()
        /*
        let mapper = CorpMapper()
        mapper.getCorpList()
         */
        
        
        let navigationController = NavigationViewController()
        self.addChild(navigationController)
        self.view.addSubview(navigationController.view)
    }


}


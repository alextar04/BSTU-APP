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
        let navigationController = NavigationViewController()
        self.addChild(navigationController)
        self.view.addSubview(navigationController.view)
        
        /*
        let temp = Path()
        temp.searchShortestWays()
        _ = temp.getPath(vertex1Index: 0, vertex2Index: 10)
        print()
        _ = temp.getPath(vertex1Index: 7, vertex2Index: 12)
        print()
        _ = temp.getPath(vertex1Index: 7, vertex2Index: 14)
        */
    }


}


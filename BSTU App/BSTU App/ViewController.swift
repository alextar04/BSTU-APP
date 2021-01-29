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
    }


}


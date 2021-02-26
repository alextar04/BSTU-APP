//
//  AppDelegate.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
        window?.rootViewController = UINavigationController(rootViewController: institutionsController)
        return true
    }

}


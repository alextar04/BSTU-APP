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
        
        self.window = UIWindow(frame: UIScreen.main.bounds)
        self.window?.rootViewController = RootViewController()
        self.window?.makeKeyAndVisible()
        return true
    }
    
    /* Обеспечим доступ к RootViewController */
    /* 1. Доступ к экземпляру делегата
       2. Непосредственный доступ   */
    static var appDelegate : AppDelegate{
        return UIApplication.shared.delegate as! AppDelegate
    }
    var rootViewController : RootViewController{
        return window?.rootViewController as! RootViewController
    }
}


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

    var isSlideInMenuPresented = false
    let leftMenuController = UIStoryboard(name: "MenuViewController", bundle: nil).instantiateViewController(withIdentifier: "MenuViewControllerID") as! MenuViewController
    let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
    
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        NotificationCenter.default.addObserver(self, selector: #selector(openLeftMenu), name: Notification.Name("OpenLeftMenu"), object: nil)
        window?.rootViewController = ViewController()
        
        window?.rootViewController?.view.addSubview(leftMenuController.view)
        window?.rootViewController?.view.addSubview(institutionsController.view)
        //window?.rootViewController = UINavigationController(rootViewController: institutionsController)
        
        return true
    }
    
    
    // MARK: Открыть/закрыть левое меню
    @objc func openLeftMenu(){
        UIView.animate(withDuration: 0.5,
                       delay: 0,
                       usingSpringWithDamping: 0.8,
                       initialSpringVelocity: 0,
                       options: .curveEaseInOut,
                       animations: {
                        self.institutionsController.view.frame.origin.x = self.isSlideInMenuPresented ? 0 : 200
            }, completion: {(finished) in
                print("Animation finished: \(finished)")
                self.isSlideInMenuPresented.toggle()
            })
    }

}


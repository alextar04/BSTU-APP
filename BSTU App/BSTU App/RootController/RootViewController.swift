//
//  RootViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import SQLite


class RootViewController: UIViewController {

    var currentView: UIView!
    var isSlideInMenuPresented: Bool!
    var leftMenuController: MenuViewController!
    
    
    init() {
        self.leftMenuController = UIStoryboard(name: "MenuViewController", bundle: nil).instantiateViewController(withIdentifier: "MenuViewControllerID") as! MenuViewController
        self.isSlideInMenuPresented = false
        super.init(nibName: nil, bundle: nil)
    }
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        NotificationCenter.default.addObserver(self, selector: #selector(switchLeftMenu), name: Notification.Name("SwitchLeftMenu"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(changeChapter), name: Notification.Name("ChangeChapter"), object: nil)
        
        let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
        let institutionsNavigationController = UINavigationController(rootViewController: institutionsController)
        self.addChild(institutionsNavigationController)
        self.currentView = institutionsNavigationController.view
        
        self.view.addSubview(self.leftMenuController.view)
        self.view.addSubview(self.currentView)
        self.currentView.sheduleMakeShadow(width: Int(self.currentView.frame.width),
                                          heigth: Int(self.currentView.frame.height))
        
        /*
        // Навигация
        Database.copyDatabaseToDevice()
        let navigationController = NavigationViewController()
        self.addChild(navigationController)
        self.view.addSubview(navigationController.view)
        */
    }

    
    // MARK: Открыть/закрыть левое меню
    @objc func switchLeftMenu(){
        UIView.animate(withDuration: 0.5,
                       delay: 0,
                       usingSpringWithDamping: 0.8,
                       initialSpringVelocity: 0,
                       options: .curveEaseInOut,
                       animations: {
                        self.currentView.frame.origin.x = self.isSlideInMenuPresented ? 0 : 200
                        print(self.currentView.frame.origin.x)
            }, completion: {(finished) in
                print("Animation finished: \(finished)")
                self.isSlideInMenuPresented.toggle()
            })
    }
    
    
    // MARK: Смена текущего раздела
    @objc func changeChapter(_ notification: Notification){
        
        if let chapter = notification.userInfo!["selectedItem"] as? ChapterType{
            switch chapter {
                
            case .schedule:
                //self.currentView.removeFromSuperview()
                let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
                
                let navigationController = UINavigationController(rootViewController: institutionsController)
                self.addChild(navigationController)
                self.currentView = institutionsController.view
                
                //self.view.addSubview(self.currentView)
                switchLeftMenu()
                
            case .navigation:
                //self.currentView.removeFromSuperview()
                let navigationController = NavigationViewController()
                self.currentView = navigationController.view
                //self.view.addSubview(self.currentView)
                switchLeftMenu()
            }
        }
    }

}


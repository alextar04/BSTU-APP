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
    var currentNavigationController: UINavigationController?
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
        
        Database.copyDatabaseToDevice()
        
        NotificationCenter.default.addObserver(self, selector: #selector(switchLeftMenu), name: Notification.Name("SwitchLeftMenu"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(changeChapter), name: Notification.Name("ChangeChapter"), object: nil)
        
        let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
        self.currentNavigationController = UINavigationController(rootViewController: institutionsController)
        self.addChild(self.currentNavigationController!)
        self.currentView = self.currentNavigationController!.view
        
        self.view.addSubview(self.leftMenuController.view)
        self.view.addSubview(self.currentView)
        self.currentView.sheduleMakeShadow(width: Int(self.currentView.frame.width),
                                          heigth: Int(self.currentView.frame.height))
         
        self.currentNavigationController!.didMove(toParent: self)
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
                        (self.currentView.frame.origin.x == 0) ? (print("Бар Закрыт")) : (print("Бар Открыт"))
            }, completion: {(finished) in
                print("Animation finished: \(finished)")
                self.isSlideInMenuPresented.toggle()
            })
    }
    
    
    // MARK: Смена текущего раздела
    @objc func changeChapter(_ notification: Notification){
        
        if let chapter = notification.userInfo!["selectedItem"] as? ChapterType{
            
            self.currentNavigationController!.willMove(toParent: nil)
            self.currentView.removeFromSuperview()
            self.currentNavigationController!.removeFromParent()
            
            switch chapter {
        
            case .schedule:
                
                let institutionsController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
                self.currentNavigationController = UINavigationController(rootViewController: institutionsController)
                
            case .navigation:
                
                self.currentNavigationController = UINavigationController(rootViewController: NavigationViewController())
                
            }
            
            self.addChild(self.currentNavigationController!)
            self.currentView = self.currentNavigationController!.view
            self.view.addSubview(self.currentView)
            self.currentView.sheduleMakeShadow(width: Int(self.currentView.frame.width),
                                              heigth: Int(self.currentView.frame.height))
            self.currentNavigationController!.didMove(toParent: self)
            self.currentView.frame.origin.x = 200
            
            switchLeftMenu()
            
        }
    }

}


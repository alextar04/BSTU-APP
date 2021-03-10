//
//  RootViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxGesture


class RootViewController: UIViewController {

    var currentView: UIView!
    var currentNavigationController: UINavigationController?
    var isSlideInMenuPresented: Bool!
    var leftMenuController: MenuViewController!
    
    var animator: UIViewPropertyAnimator!
    let disposeBag = DisposeBag()
    
    
    init() {
        self.leftMenuController = UIStoryboard(name: "MenuViewController", bundle: nil).instantiateViewController(withIdentifier: "MenuViewControllerID") as? MenuViewController
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
        NotificationCenter.default.addObserver(self, selector: #selector(changeChapter), name:
            Notification.Name("ChangeChapter"), object: nil)
        
        // Установка стартового экрана: Список институтов
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
    @objc func switchLeftMenu(_ notification: Notification){
        
        if let listDisablers = notification.userInfo!["listDisablers"] as? [UIView]{
            UIView.animate(withDuration: 0.25,
                           delay: 0,
                           usingSpringWithDamping: 0.75,
                           initialSpringVelocity: 0.9,
                           options: .curveEaseInOut,
                           animations: {
                            self.currentView.frame.origin.x = self.isSlideInMenuPresented ? 0 : 200
                }, completion: {(finished) in
                    
                    self.isSlideInMenuPresented.toggle()
                        for view in listDisablers{
                            (self.isSlideInMenuPresented) ? (view.isUserInteractionEnabled = false) : (view.isUserInteractionEnabled = true)
                        }
                    })
        }
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
            
            let swipeObject = UISwipeGestureRecognizer()
            swipeObject.direction = .left
            self.currentViewMoving(recognizer: swipeObject, listDisablers: nil)
        }
    }
    
    
    // MARK: Движение экрана над меню
    @objc func currentViewMoving(recognizer: UISwipeGestureRecognizer, listDisablers: [UIView]?) {
        
        var currentFrame = self.currentView.frame
        switch recognizer.direction {
        case .left:
            if isSlideInMenuPresented{
                currentFrame.origin.x -= 200
                if listDisablers != nil{
                    for view in listDisablers!{
                        view.isUserInteractionEnabled = true
                    }
                }
                UIView.animate(withDuration: 0.25, delay: 0,
                               usingSpringWithDamping: 0.75,
                               initialSpringVelocity: 0.9,
                               animations: {
                    self.currentView.frame = currentFrame
                }, completion: { _ in
                    self.isSlideInMenuPresented.toggle()
                })
            }
        case .right:
            if !isSlideInMenuPresented{
                currentFrame.origin.x += 200
                if listDisablers != nil{
                    for view in listDisablers!{
                        view.isUserInteractionEnabled = false
                    }
                }
                UIView.animate(withDuration: 0.25, delay: 0,
                usingSpringWithDamping: 0.75,
                initialSpringVelocity: 0.9,
                animations: {
                    self.currentView.frame = currentFrame
                }, completion: { _ in
                    self.isSlideInMenuPresented.toggle()
                })
            }
        default:
            break
        }
    }

}


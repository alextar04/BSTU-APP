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

    var currentView: UIView?
    var currentController: UIViewController?
    var currentNavigationController: UINavigationController?
    var isSlideInMenuPresented: Bool!
    var leftMenuController: MenuViewController!
    
    var cachedNavigationController: NavigationViewController!
    
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
        self.currentController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
        self.currentNavigationController = UINavigationController(rootViewController: self.currentController!)
        self.addChild(self.currentNavigationController!)
        self.currentView = self.currentNavigationController!.view
        
        self.view.addSubview(self.leftMenuController.view)
        self.view.addSubview(self.currentView!)
        self.currentView!.sheduleMakeShadow(width: Int(self.currentView!.frame.width),
                                            heigth: Int(self.currentView!.frame.height))
         
        self.currentNavigationController!.didMove(toParent: self)
    }

    
    // MARK: Открыть/закрыть левое меню
    @objc func switchLeftMenu(_ notification: Notification){
        
        if let listDisablers = notification.userInfo!["listDisablers"] as? [UIView]{
            UIView.animate(withDuration: 0.4,
                           delay: 0,
                           usingSpringWithDamping: 0.75,
                           initialSpringVelocity: 0.9,
                           options: .curveEaseInOut,
                           animations: {
                            self.currentView!.frame.origin.x = self.isSlideInMenuPresented ? 0 : 200
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
            self.currentView!.removeFromSuperview()
            self.currentNavigationController!.removeFromParent()
            
            self.currentView = nil
            self.currentController = nil
            self.currentNavigationController = nil
            
            switch chapter {
        
            case .schedule:
                self.currentController = UIStoryboard(name: "InstitutionsScreen", bundle: nil).instantiateViewController(withIdentifier: "InstitutionsScreenID") as! InstitutionsViewController
                self.currentNavigationController = UINavigationController(rootViewController: self.currentController!)
                
            case .navigation:
                if self.cachedNavigationController != nil{
                    _ = [self.cachedNavigationController.topBarView.startPlaceTextField,
                        self.cachedNavigationController.topBarView.finishPlaceTextField,
                        self.cachedNavigationController.topBarView.chooseCorpButton,
                        self.cachedNavigationController.map,
                        self.cachedNavigationController.storeySwitcherView
                    ].map({ view in
                            view?.isUserInteractionEnabled = true
                    })

                    (self.cachedNavigationController.bottomBarView != nil) ? (self.cachedNavigationController.bottomBarView!.isUserInteractionEnabled = true) : ()
                } else{
                    self.cachedNavigationController = NavigationViewController()
                }
                self.currentController = self.cachedNavigationController
                self.currentNavigationController = UINavigationController(rootViewController: self.currentController!)
                self.currentNavigationController!.setNavigationBarHidden(true, animated: false)
                
            case .teachers:
                print("Учитель")
                return
            case .news:
                print("Новости")
                return
            case .cabinet:
                print("Кабинет")
                return
            }
            
            self.addChild(self.currentNavigationController!)
            self.currentView = self.currentNavigationController!.view
            self.view.addSubview(self.currentView!)
            self.currentNavigationController!.didMove(toParent: self)
            
            self.currentView!.sheduleMakeShadow(width: Int(self.currentView!.frame.width),
                                              heigth: Int(self.currentView!.frame.height))
            self.currentView!.frame.origin.x = 200
            
            let swipeObject = UISwipeGestureRecognizer()
            swipeObject.direction = .left
            self.currentViewMoving(recognizer: swipeObject, listDisablers: nil)
        }
    }
    
    
    // MARK: Движение экрана над меню
    @objc func currentViewMoving(recognizer: UISwipeGestureRecognizer, listDisablers: [UIView]?) {
        
        var currentFrame = self.currentView!.frame
        switch recognizer.direction {
        case .left:
            if isSlideInMenuPresented{
                currentFrame.origin.x -= 200
                if listDisablers != nil{
                    for view in listDisablers!{
                        view.isUserInteractionEnabled = true
                    }
                }
                UIView.animate(withDuration: 0.4, delay: 0,
                               usingSpringWithDamping: 0.75,
                               initialSpringVelocity: 0.9,
                               animations: {
                                self.currentView!.frame = currentFrame
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
                UIView.animate(withDuration: 0.4, delay: 0,
                usingSpringWithDamping: 0.75,
                initialSpringVelocity: 0.9,
                animations: {
                    self.currentView!.frame = currentFrame
                }, completion: { _ in
                    self.isSlideInMenuPresented.toggle()
                })
            }
        default:
            break
        }
    }

}


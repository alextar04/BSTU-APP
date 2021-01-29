//
//  NavigationViewController.swift
//  MapMarker
//
//  Created by Alexey Taran on 19.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import UIKit

import RxGesture
import RxSwift
import RxCocoa

class NavigationViewController: UIViewController {
    
    var viewModel: NavigationViewModel!
    var bottomBarView: BottomBarNavigation? = nil
    var topBarView: TopBarNavigation!
    var storeySwitcherView: StoreySwitcherView!
    
    var currentSelectedName: String!
    var changeMarkerStatus = false
    var bottomBarIsOpen = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.viewModel = NavigationViewModel()
        
        let someView = Marker(position: (50, 100), text: "153a")
        let someView1 = Marker(position: (200, 100), text: "Столовая")
        let someView2 = Marker(position: (100, 200), text: "Гардероб")
        let someView3 = Marker(position: (150, 300), text: "Преподавательская")
        let someView4 = Marker(position: (300, 250), text: "182")
        let someView5 = Marker(position: (150, 400), text: "Туалет")
        self.view.addSubview(someView)
        self.view.addSubview(someView1)
        self.view.addSubview(someView2)
        self.view.addSubview(someView3)
        self.view.addSubview(someView4)
        self.view.addSubview(someView5)
        
        NotificationCenter.default.addObserver(self, selector: #selector(openBottomBar), name: Notification.Name("OpenBottomBar"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(closeBottomBar), name: Notification.Name("CloseBottomBar"), object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(fillStartPlaceLabel), name: Notification.Name("FillStartPlace"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(fillFinishPlaceLabel), name: Notification.Name("FillFinishPlace"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillShow(_:)), name: UIResponder.keyboardWillShowNotification, object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeCorp), name: Notification.Name("ChangeCorp"), object: nil)
        
        self.addTopBarView()
        self.addStoreySwitcherView()
    }
    
    
    // MARK: Функция открытия нижнего бара
    @objc func openBottomBar(_ notification: NSNotification){
        closeOldMarker(notification)
        
        // Загрузка информации на бар
        bottomBarView = Bundle.main.loadNibNamed("BottomBarView", owner: self, options: nil)?.first as? BottomBarNavigation
        let heightBottomBar = bottomBarView?.frame.height
        bottomBarView?.makeShadow(width: Int(self.view.frame.width),
                                  heigth: Int(heightBottomBar!))
        bottomBarView?.setupView(namePremise: notification.userInfo!["stickerText"] as! String,
                                 heightBar: heightBottomBar!)
        
        // Положение бара на странице
        self.bottomBarView?.frame = CGRect(x: 0, y: self.view.frame.height,
                                           width: self.view.frame.width, height: heightBottomBar!)
        self.view.addSubview(bottomBarView!)
        
        // "Смена маркера" или "Бар открыт": нет анимации открытия
        // "Не смена маркера" или "Бар закрыт": есть анимация открытия
        if !self.changeMarkerStatus || !self.bottomBarIsOpen{
            let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.bottomBarView?.frame = self.bottomBarView?.frame
                    .offsetBy(dx: 0, dy: -heightBottomBar!) as! CGRect
            }
            animator.startAnimation()
            
            // Изменить положение переключателя этажей
            let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                    .offsetBy(dx: 0, dy: -heightBottomBar!) as! CGRect
            }
            animatorSwitcherStorey.startAnimation(afterDelay: TimeInterval(0.3))
            
        } else {
            self.bottomBarView?.frame = self.bottomBarView?.frame
                .offsetBy(dx: 0, dy: -heightBottomBar!) as! CGRect
            self.changeMarkerStatus = false
        }
        self.bottomBarIsOpen = true
        self.currentSelectedName = bottomBarView?.namePremise
    }
    
    
    // MARK: Функция закрытия нижнего бара
    @objc func closeBottomBar(_ notification: NSNotification){
        for view in self.view.subviews {
            if view is BottomBarNavigation {
                
                // "Ручное закрытие окна": нет анимации закрытия
                if let _ = notification.userInfo!["staySelected"] as? Bool{
                    view.removeFromSuperview()
                    self.bottomBarIsOpen = false
                    
                    // Изменить положение переключателя этажей
                    let heightBottomBar = bottomBarView?.frame.height
                    let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                        self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                            .offsetBy(dx: 0, dy: heightBottomBar!) as! CGRect
                    }
                    animatorSwitcherStorey.startAnimation(afterDelay: TimeInterval(0.3))
                     
                    continue
                }
                
                // "Смена маркера": нет анимации закрытия
                if self.changeMarkerStatus == true{
                    view.removeFromSuperview()
                }
            }
        }
    }
    
        
    // MARK: Функция закрытия старого маркера
    func closeOldMarker(_ notification: NSNotification){
        for view in self.view.subviews{
            if let currentMarkerView = view as? Marker {
                let newMarkerName = notification.userInfo!["stickerText"] as! String
                
                // Закрытие старого маркера
                if (currentMarkerView.statusSelected == true) && (currentMarkerView.text == self.currentSelectedName)
                    && (newMarkerName != self.currentSelectedName){
                    self.changeMarkerStatus = true
                    currentMarkerView.closeMarker(sender: notification.userInfo!["tapRecognizer"] as! UITapGestureRecognizer)
                }
                // Удалить окно уже включенного маркера
                if (currentMarkerView.statusSelected == true) && (currentMarkerView.text == self.currentSelectedName)
                    && (newMarkerName == self.currentSelectedName){
                    self.changeMarkerStatus = self.bottomBarIsOpen
                    self.bottomBarView?.removeFromSuperview()
                }
            }
        }
    }
    
    
    // MARK: Добавление верхнего бара
    func addTopBarView(){
        self.topBarView = Bundle.main.loadNibNamed("TopBarView", owner: self, options: nil)?.first as? TopBarNavigation
        self.topBarView.setupView(navigationControllerHeight: self.view.frame.height)
        self.topBarView?.frame = CGRect(x: 0, y: (UIApplication.shared.windows.first?.safeAreaInsets.top)!,
                                           width: self.view.frame.width, height: (topBarView?.frame.height)!)
        self.view.addSubview(self.topBarView)
    }
    
    
    // MARK: Функция выбора пункта отбытия
    @objc func fillStartPlaceLabel(){
        self.topBarView.startPlaceTextField.text = self.currentSelectedName
        closeBottomBarAfterChoosingPlace()
    }
    
    
    // MARK: Функция выбора пункта назначения
    @objc func fillFinishPlaceLabel(){
        self.topBarView.finishPlaceTextField.text = self.currentSelectedName
        closeBottomBarAfterChoosingPlace()
    }
    
    
    // MARK: Функция закрытия нижнего бара после выбора пункта
    func closeBottomBarAfterChoosingPlace(){
        let heightBottomBar = bottomBarView?.frame.height
        self.bottomBarIsOpen = false
        
        let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
            self.bottomBarView?.frame = self.bottomBarView?.frame
                .offsetBy(dx: 0, dy: heightBottomBar!) as! CGRect
        }
        animator.startAnimation()
        
        // Изменить положение переключателя этажей
        let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
            self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                .offsetBy(dx: 0, dy: heightBottomBar!) as! CGRect
        }
        animatorSwitcherStorey.startAnimation(afterDelay: TimeInterval(0.3))
    }
    
    
    // MARK: Функция смены корпуса
    @objc func changeCorp(_ notification: NSNotification){
        
        if let nameCorp = notification.userInfo!["nameCorp"] as? String{
            self.topBarView.nameCorpLabel.text = nameCorp
        }
        
        // Загрузка карты!!
        self.topBarView.chooseCorpBackground.isUserInteractionEnabled = false
        
        for view in self.view.subviews{
            if let universityCorpsView = view as? UniversityCorpsView {
                
                let cellHeight = universityCorpsView.cellHeigth
                let headerHeight = universityCorpsView.headerHeigth
                let countCells = universityCorpsView.corpsCount
                
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    universityCorpsView.frame = universityCorpsView.frame
                        .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + headerHeight + 30)) as! CGRect
                }
                animator.startAnimation(afterDelay: 1)
                
                animator.addCompletion({ _ in
                    self.topBarView.closeGrayScreenUnderCorpChoosenView()
                    self.topBarView.chooseCorpBackground.isUserInteractionEnabled = true
                    universityCorpsView.removeFromSuperview()
                })
            }
        }
   }
    
    // MARK: Функция подсчета высоты клавиатуры
    @objc func keyboardWillShow(_ notification: Notification) {
        if let keyboardFrame: NSValue = notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue {
            let keyboardRectangle = keyboardFrame.cgRectValue
            self.topBarView.keyboardHeight = keyboardRectangle.height
        }
    }
    
    // MARK: Функция добавления переключателя этажей
    func addStoreySwitcherView(){
        self.storeySwitcherView = Bundle.main.loadNibNamed("StoreySwitcherView", owner: self, options: nil)?.first as? StoreySwitcherView
        self.storeySwitcherView.setupView(rangeStorey: 0...7)
        self.storeySwitcherView?.frame = CGRect(x: 10, y: self.view.frame.height - 98,
                                           width: 42, height: 88)
        self.storeySwitcherView.makeRounding()
        self.view.addSubview(self.storeySwitcherView)
    }
}

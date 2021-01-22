//
//  ViewController.swift
//  MapMarker
//
//  Created by Alexey Taran on 19.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var bottomBarView: BottomBar? = nil
    
    var currentSelectedName: String!
    var changeMarkerStatus = false
    var bottomBarIsOpen = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
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
    }
    
    
    // MARK: Функция открытия нижнего бара
    @objc func openBottomBar(_ notification: NSNotification){
        closeOldMarker(notification)
        
        // Загрузка информации на бар
        bottomBarView = Bundle.main.loadNibNamed("BottomBarView", owner: self, options: nil)?.first as? BottomBar
        let heightBottomBar = bottomBarView?.frame.height
        bottomBarView?.makeShadow(width: Int(self.view.frame.width),
                                  heigth: Int(heightBottomBar!))
        bottomBarView?.setupView(namePremise: notification.userInfo!["stickerText"] as! String,
                                 heightBar: heightBottomBar!)
        
        // Положение бара на странице
        self.bottomBarView?.frame = CGRect(x: 0, y: self.view.frame.height,
                                           width: self.view.frame.width, height: (bottomBarView?.frame.height)!)
        self.view.addSubview(bottomBarView!)
        
        // "Смена маркера" или "Бар открыт": нет анимации открытия
        // "Не смена маркера" или "Бар закрыт": есть анимация открытия
        if !self.changeMarkerStatus || !self.bottomBarIsOpen{
            let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.bottomBarView?.frame = self.bottomBarView?.frame
                    .offsetBy(dx: 0, dy: -heightBottomBar!) as! CGRect
            }
            animator.startAnimation()
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
            if view is BottomBar {
                
                // "Ручное закрытие окна": нет анимации закрытия
                if let _ = notification.userInfo!["staySelected"] as? Bool{
                    view.removeFromSuperview()
                    self.bottomBarIsOpen = false
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
            if let markerView = view as? Marker {
                let newMarkerName = notification.userInfo!["stickerText"] as! String
                
                // Закрытие старого маркера
                if (markerView.statusSelected == true) && (markerView.text == self.currentSelectedName)
                    && (newMarkerName != self.currentSelectedName){
                    self.changeMarkerStatus = true
                    markerView.closeMarker(sender: notification.userInfo!["tapRecognizer"] as! UITapGestureRecognizer)
                }
                // Удалить окно уже включенного маркера
                if (markerView.statusSelected == true) && (markerView.text == self.currentSelectedName)
                    && (newMarkerName == self.currentSelectedName){
                    self.changeMarkerStatus = true
                    self.bottomBarView?.removeFromSuperview()
                }
            }
        }
    }
    
}

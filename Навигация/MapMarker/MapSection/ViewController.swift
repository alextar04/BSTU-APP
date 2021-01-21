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
    var currentSelectedIn: String!
    var currentSelectedOut: String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        let someView = Marker(position: (50, 100), text: "153a")
        let someView1 = Marker(position: (200, 100), text: "Столовая")
        let someView2 = Marker(position: (100, 200), text: "Гардероб")
        let someView3 = Marker(position: (150, 300), text: "Преподавательская")
        let someView4 = Marker(position: (300, 250), text: "182")
        self.view.addSubview(someView)
        self.view.addSubview(someView1)
        self.view.addSubview(someView2)
        self.view.addSubview(someView3)
        self.view.addSubview(someView4)
        
        NotificationCenter.default.addObserver(self, selector: #selector(openBottomBar), name: Notification.Name("OpenBottomBar"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(closeBottomBar), name: Notification.Name("CloseBottomBar"), object: nil)
    }
    
    // MARK: Функция открытия нижнего бара
    @objc func openBottomBar(){
        for view in self.view.subviews {
            // Закрытие открытых баров
            if view is BottomBar {
                view.removeFromSuperview()
                continue
            }
            // Закрытие старого маркера
            if let markerView = view as? Marker {
                if markerView.text == self.currentSelectedIn{
                    markerView.markerTapped(sender: UITapGestureRecognizer())
                    self.currentSelectedIn = ""
                }
            }
        }
        
        
        // Загрузка нового бара
        bottomBarView = Bundle.main.loadNibNamed("BottomBarView", owner: self, options: nil)?.first as! BottomBar
        bottomBarView?.namePremise = "153a"
        bottomBarView?.setupView()
        let heightBottomBar = bottomBarView?.frame.height
        bottomBarView?.makeShadow(width: Int(self.view.frame.width), heigth: Int(heightBottomBar!))
        
        // Отображение бара на странице
        self.bottomBarView?.frame = CGRect(x: 0, y: self.view.frame.height,
                                           width: self.view.frame.width, height: heightBottomBar!)
        self.view.addSubview(bottomBarView!)
        
        // Анимация движения бара вверх
        let animator = UIViewPropertyAnimator(duration:0.3, dampingRatio: 12.0){
            self.bottomBarView?.frame = self.bottomBarView?.frame.offsetBy(dx:0, dy:-heightBottomBar!) as! CGRect
        }
        animator.startAnimation()
        self.currentSelectedIn = bottomBarView?.namePremise
    }
    
    // MARK: Функция закрытия нижнего бара
    @objc func closeBottomBar(){
        for view in self.view.subviews {
            if view is BottomBar {
                // Анимация движения бара вниз
                let heightBottomBar = bottomBarView?.frame.height
                let animator = UIViewPropertyAnimator(duration:0.3, dampingRatio: 12.0){
                    self.bottomBarView?.frame = self.bottomBarView?.frame.offsetBy(dx:0, dy:heightBottomBar!) as! CGRect
                }
                animator.startAnimation()
                
                // Удаление бара
                animator.addCompletion{ _ in
                    view.removeFromSuperview()
                    self.bottomBarView = nil
                }
           }
        }
    }

}

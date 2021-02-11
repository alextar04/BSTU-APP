//
//  TopBarNavigation.swift
//  MapSection
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxGesture

class TopBarNavigation: UIView{
    
    @IBOutlet weak var nameCorpLabel: UILabel!
    @IBOutlet weak var chooseCorpButton: UIImageView!
    var chooseCorpButtonIsActive: Bool = false
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    var oldStartPlaceText: String!
    var oldFinishPlaceText: String!
    
    var universityCorpView: UniversityCorpsView!
    var chooseCorpBackground: UIView!
    
    var tablePremiseView: SearchPremiseView? = nil
    var backButton: UIButton? = nil
    var navigationControllerHeight: CGFloat!
    var keyboardHeight: CGFloat!
    
    let disposeBag = DisposeBag()
    
    
    func setupView(navigationControllerHeight: CGFloat){
        
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        NotificationCenter.default.addObserver(self, selector: #selector(changePremiseLabel), name: Notification.Name("ChangePremiseLabel"), object: nil)
        self.startPlaceTextField.text = ""
        self.finishPlaceTextField.text = ""
        
        self.chooseCorpButton.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                
                var delay = 0.0
                if self.tablePremiseView != nil{
                    self.endEditingData()
                    delay = 0.3
                }
                
                // Экран под окном выбора корпуса
                self.setGrayScreenUnderCorpChoosenView(delay: delay)
                    
                if self.universityCorpView == nil{
                    self.universityCorpView = Bundle.main.loadNibNamed("UniversityCorpsView", owner: self, options: nil)?.first as? UniversityCorpsView
                    self.universityCorpView?.setupView()
                }
                
                let cellHeight = self.universityCorpView.cellHeigth
                let headerHeight = self.universityCorpView.headerHeigth
                let countCells = self.universityCorpView.corpsCount
                let parentVC = self.parentViewController
                self.universityCorpView?.frame = CGRect(x: (Double((parentVC?.view.frame.size.width)!) / 2) - 150,
                                                       y: Double((parentVC?.view.frame.size.height)!),
                                                       width: 300,
                                                       height: Double(cellHeight * countCells) + Double(headerHeight))
                
                parentVC!.view.addSubview(self.universityCorpView!)
                    
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self.universityCorpView?.frame = self.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: -CGFloat((cellHeight * countCells) + headerHeight + 30)) as! CGRect
                    }
                animator.startAnimation(afterDelay: TimeInterval(delay))
                
        }).disposed(by: disposeBag)
        
        self.navigationControllerHeight = navigationControllerHeight
        customizationSelectionFormPlaceTap()
    }
    
    
    // MARK: Экран под окном выбора корпуса
    func setGrayScreenUnderCorpChoosenView(delay: Double){
        let parentVC = self.parentViewController
        self.chooseCorpBackground = UIView()
        chooseCorpBackground.frame = CGRect(x: 0, y: 0,
                                            width: Double((parentVC?.view.frame.width)!),
                                            height: Double((parentVC?.view.frame.height)!))
        chooseCorpBackground.backgroundColor = .clear
        parentVC!.view.addSubview(chooseCorpBackground)
        
        UIView.animate(withDuration: 0.3, delay: delay, animations: {
            self.chooseCorpBackground.backgroundColor = .corpBackgroundGrayColor
        })
        
        chooseCorpBackground.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                let cellHeight = self.universityCorpView.cellHeigth
                let headerHeight = self.universityCorpView.headerHeigth
                let countCells = self.universityCorpView.corpsCount
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self.universityCorpView?.frame = self.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + headerHeight + 50)) as! CGRect
                }
                animator.startAnimation()
                
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self.chooseCorpBackground.backgroundColor = .clear
                },
                               completion: { _ in
                                self.chooseCorpBackground.removeFromSuperview()
                                self.universityCorpView.removeFromSuperview()
                })
            })
            .disposed(by: disposeBag)
    }
    
    
    // MARK: Закрытие экрана под окном выбора корпуса
    func closeGrayScreenUnderCorpChoosenView(){
        UIView.animate(withDuration: 0.3,
                       animations: {
                        self.chooseCorpBackground.backgroundColor = .clear
        },
                       completion: { _ in
                        self.chooseCorpBackground.removeFromSuperview()
        })
    }
    
    
    // MARK: Обработка нажатия на форму выбора кабинета
    func customizationSelectionFormPlaceTap(){
        _ = [self.startPlaceTextField, self.finishPlaceTextField].map{ label in
            // Начало редактирования
            label!.rx.tapGesture()
                .when(.recognized)
                .subscribe(onNext: { _ in

                    if self.startPlaceTextField.text == "Откуда"{
                        self.startPlaceTextField.text = ""
                    }
                    
                    if self.finishPlaceTextField.text == "Куда"{
                        self.finishPlaceTextField.text = ""
                    }
                    
                    self.oldStartPlaceText = self.startPlaceTextField.text
                    self.oldFinishPlaceText = self.finishPlaceTextField.text
                    
                    let timeForBindings = self.tablePremiseView == nil
                    
                    // Инициализация таблицы
                    if self.tablePremiseView == nil{
                        self.tablePremiseView = Bundle.main.loadNibNamed("SearchPremiseView", owner: self, options: nil)?.first as? SearchPremiseView
                        
                        var tableHeight: CGFloat = 0.0
                        var yStartTable: CGFloat = 0.0
                        if !(self.parentViewController as! NavigationViewController).isEnabledTopBarInInit{
                            tableHeight = (self.parentViewController?.view.frame.height)! - self.keyboardHeight - (self.frame.height + ((UIApplication.shared.windows.first?.safeAreaInsets.top)!))
                            yStartTable = self.frame.height + (self.window?.safeAreaInsets.top)!
                        } else {
                            tableHeight = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self.keyboardHeight - self.frame.height
                            yStartTable = self.frame.height
                        }
                        
                        self.tablePremiseView?.setupView(height: tableHeight, parentController: self.parentViewController as! NavigationViewController)
                        self.tablePremiseView?.frame = CGRect(x: 0, y: yStartTable,
                                                          width: self.frame.width,
                                                          height: tableHeight)
                        self.parentViewController?.view.addSubview(self.tablePremiseView!)
                        
                        // Базовая инициализация данными таблицы
                        let data = (self.parentViewController as! NavigationViewController)
                            .viewModel
                            .loadArrayPremise(prefix: (label?.text)!)
                        self.tablePremiseView?.sections.accept([SearchPremiseView.SectionOfPremise(header: "Кабинеты",
                                                                                                   items: data!)])
                    }
                    
                    // Кнопка "Назад"
                    if self.backButton == nil{
                        self.backButton = UIButton()
                        self.backButton!.makeCancelPremiseInputtingView()
                        
                        var yStartBackButton: CGFloat = 0.0
                        if !(self.parentViewController as! NavigationViewController).isEnabledTopBarInInit{
                            yStartBackButton = (self.parentViewController?.view.frame.height)! - self.keyboardHeight - 50
                        } else {
                            yStartBackButton = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self.keyboardHeight - 50
                        }
                        self.backButton!.frame = CGRect(x: self.center.x - 60, y: yStartBackButton,
                                                  width: 120, height: 40)
                        self.parentViewController?.view.addSubview(self.backButton!)
                    }
                    
                    if timeForBindings{
                        self.backButton!.rx.tap.bind{
                            if self.startPlaceTextField.text != ""{
                                self.startPlaceTextField.text = self.oldStartPlaceText
                            }
                            if self.finishPlaceTextField.text != ""{
                                self.finishPlaceTextField.text = self.oldFinishPlaceText
                            }
                            if self.startPlaceTextField.text == "" || self.finishPlaceTextField.text == ""{
                                // Удаление старого нарисованного пути
                                let parentVC = self.parentViewController as! NavigationViewController
                                if parentVC.map.pathLayer != nil{
                                    parentVC.map.pathLayer.removeFromSuperlayer()
                                    parentVC.map.pathLayer.removeAllAnimations()
                                }
                            }
                            self.endEditingData()
                        }.disposed(by: self.disposeBag)
                    }
                    }).disposed(by: disposeBag)
            
                    // Отслеживание набранного текста
                    label?.rx
                        .controlEvent([.editingChanged])
                        .asObservable()
                        .subscribe(onNext: { _ in
                            let data = (self.parentViewController as! NavigationViewController)
                                .viewModel
                                .loadArrayPremise(prefix: (label?.text)!)
                            
                            self.tablePremiseView?.sections.accept([SearchPremiseView.SectionOfPremise(header: "Кабинеты",
                                                                                                       items: data!)])
                        }).disposed(by: disposeBag)
            
                    label?.autocorrectionType = .no
                    label?.clearButtonMode = .always
                    label?.clearButtonMode = .whileEditing
            }
    }
    
    
    // MARK: Изменение точки отправления/назначения
    @objc func changePremiseLabel(_ notification: NSNotification){
        let labelText = notification.userInfo!["namePremise"] as? String
        self.startPlaceTextField.isEditing ? (self.startPlaceTextField.text = labelText) : (self.finishPlaceTextField.text = labelText)
        endEditingData()
        
        // Перемещение камеры и выбор маркера
        let parentVC = self.parentViewController as! NavigationViewController
        // Выбор одного из пунктов отбытия/прибытия
        if startPlaceTextField.text == "" || finishPlaceTextField.text == "" {
            let marker = parentVC.map.getMarkerWithName(name: labelText!)
            parentVC.map.zoomScale = 0.6
            marker.statusSelected = true
            marker.paintingPriority = 1
            let userInfo: [String: Any] = ["tapRecognizer": notification,
                                           "stickerText": marker.text]
            NotificationCenter.default.post(name: Notification.Name("OpenBottomBar"), object: nil, userInfo: userInfo)
            UIView.animate(withDuration: 0.6, animations: {
                    parentVC.map.setContentOffset(CGPoint(x: marker.xPosition * parentVC.map.zoomScale - parentVC.map.frame.width/2,
                                                          y: marker.yPosition * parentVC.map.zoomScale - parentVC.map.frame.height/2), animated: false)
            })
        } else {
            // Пункты отбытия/прибытия выбраны
            cameraMovement()
            parentVC.createWay()
        }
    }
    
    
    // MARK: Перемещение камеры
    func cameraMovement(){
        
        let parentVC = self.parentViewController as! NavigationViewController
        let marker1 = parentVC.map.getMarkerWithName(name: self.startPlaceTextField.text!)
        let marker2 = parentVC.map.getMarkerWithName(name: self.finishPlaceTextField.text!)
        
        let xChanging = abs(marker2.xPosition - marker1.xPosition)
        let yChanging = abs(marker2.yPosition - marker1.yPosition)
        // Если невозможно отобразить оба пункта одновременно,
        // то перейти камерой в пункт отправления
        if xChanging * parentVC.map.zoomScale > parentVC.view.frame.width || yChanging * parentVC.map.zoomScale > parentVC.map.frame.height{
            parentVC.map.zoomScale = 0.6
            UIView.animate(withDuration: 0.6, animations: {
                    parentVC.map.setContentOffset(CGPoint(x: marker1.xPosition * parentVC.map.zoomScale - parentVC.map.frame.width/2,
                                                          y: marker1.yPosition * parentVC.map.zoomScale - parentVC.map.frame.height/2), animated: false)
            })
        } else {
            // Иначе, перейти в позицию между ними
            let xMiddleBetweenMarkers = marker1.xPosition + (marker2.xPosition - marker1.xPosition)/2
            let yMiddleBetweenMarkers = marker1.yPosition + (marker2.yPosition - marker1.yPosition)/2
            UIView.animate(withDuration: 0.6, animations: {
                    parentVC.map.setContentOffset(CGPoint(x: xMiddleBetweenMarkers * parentVC.map.zoomScale - parentVC.map.frame.width/2,
                                                          y: yMiddleBetweenMarkers * parentVC.map.zoomScale - parentVC.map.frame.height/2), animated: false)
            })
        }
    }
    
    
    // MARK: Завершение редактирования данных
    func endEditingData(){
        self.startPlaceTextField.endEditing(true)
        self.finishPlaceTextField.endEditing(true)
        
        self.tablePremiseView!.removeFromSuperview()
        self.backButton!.removeFromSuperview()
        self.tablePremiseView = nil
        self.backButton = nil
    }
    
    }

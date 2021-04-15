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
    
    var parentVC: NavigationViewController!
    @IBOutlet weak var nameCorpLabel: UILabel!
    @IBOutlet weak var chooseCorpButton: UIImageView!
    var chooseCorpButtonIsActive: Bool = false
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    var startPlacePremiseId: Int!
    var finishPlacePremiseId: Int!
    var oldStartPlaceText: String!
    var oldFinishPlaceText: String!
    
    var universityCorpView: UniversityCorpsView!
    var chooseCorpBackground: UIView!
    
    var tablePremiseView: SearchPremiseView? = nil
    var backButton: UIButton? = nil
    var navigationControllerHeight: CGFloat!
    var keyboardHeight: CGFloat!
    
    @IBOutlet weak var leftMenuButton: UIImageView!
    let disposeBag = DisposeBag()
    
    
    func setupView(navigationControllerHeight: CGFloat, parentVC: NavigationViewController){
        
        self.parentVC = parentVC
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        NotificationCenter.default.addObserver(self, selector: #selector(changePremiseLabel), name: Notification.Name("ChangePremiseLabel"), object: nil)
        self.startPlaceTextField.text = ""
        self.finishPlaceTextField.text = ""
        
        self.chooseCorpButton.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                
                var delay = 0.0
                if self!.tablePremiseView != nil{
                    self!.endEditingData()
                    delay = 0.3
                }
                
                // Экран под окном выбора корпуса
                self!.setGrayScreenUnderCorpChoosenView(delay: delay)
                    
                if self!.universityCorpView == nil{
                    self!.universityCorpView = Bundle.main.loadNibNamed("UniversityCorpsView", owner: self, options: nil)?.first as? UniversityCorpsView
                    self!.universityCorpView?.setupView()
                }
                
                let cellHeight = self!.universityCorpView.cellHeigth
                let headerHeight = self!.universityCorpView.headerHeigth
                let countCells = self!.universityCorpView.corpsCount

                self!.universityCorpView?.frame = CGRect(x: (Double((parentVC.view.frame.size.width)) / 2) - 150,
                                                        y: Double((parentVC.view.frame.size.height)),
                                                       width: 300,
                                                       height: Double(cellHeight * countCells) + Double(headerHeight))
                
                parentVC.view.addSubview(self!.universityCorpView!)
                    
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self!.universityCorpView?.frame = self!.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: -CGFloat((cellHeight * countCells) + headerHeight + 30)) as! CGRect
                    }
                animator.startAnimation(afterDelay: TimeInterval(delay))
                
        }).disposed(by: disposeBag)
        
        self.navigationControllerHeight = navigationControllerHeight
        customizationSelectionFormPlaceTap()
        setupLeftMenuButton()
    }
    
    
    // MARK: Экран под окном выбора корпуса
    func setGrayScreenUnderCorpChoosenView(delay: Double){
        
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
            .subscribe(onNext: { [weak self] _ in
                let cellHeight = self!.universityCorpView.cellHeigth
                let headerHeight = self!.universityCorpView.headerHeigth
                let countCells = self!.universityCorpView.corpsCount
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self!.universityCorpView?.frame = self!.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + headerHeight + 50)) as! CGRect
                }
                animator.startAnimation()
                
                UIView.animate(withDuration: 0.3,
                               animations: { [weak self] in
                                self!.chooseCorpBackground.backgroundColor = .clear
                },
                               completion: { [weak self] _ in
                                self!.chooseCorpBackground.removeFromSuperview()
                                self!.universityCorpView.removeFromSuperview()
                })
            })
            .disposed(by: disposeBag)
    }
    
    
    // MARK: Закрытие экрана под окном выбора корпуса
    func closeGrayScreenUnderCorpChoosenView(){
        UIView.animate(withDuration: 0.3,
                       animations: { [weak self] in
                        self!.chooseCorpBackground.backgroundColor = .clear
        },
                       completion: { [weak self] _ in
                        self!.chooseCorpBackground.removeFromSuperview()
        })
    }
    
    
    // MARK: Обработка нажатия на форму выбора кабинета
    func customizationSelectionFormPlaceTap(){
        _ = [self.startPlaceTextField, self.finishPlaceTextField].map{ label in
            // Начало редактирования
            label!.rx.tapGesture()
                .when(.recognized)
                .subscribe(onNext: { [weak self] _ in

                    self!.leftMenuButton.isHidden = true
                    if self!.startPlaceTextField.text == "Откуда"{
                        self!.startPlaceTextField.text = ""
                    }
                    
                    if self!.finishPlaceTextField.text == "Куда"{
                        self!.finishPlaceTextField.text = ""
                    }
                    
                    self!.oldStartPlaceText = self!.startPlaceTextField.text
                    self!.oldFinishPlaceText = self!.finishPlaceTextField.text
                    
                    let timeForBindings = self!.tablePremiseView == nil
                    
                    // Инициализация таблицы
                    if self!.tablePremiseView == nil{
                        self!.tablePremiseView = Bundle.main.loadNibNamed("SearchPremiseView", owner: self, options: nil)?.first as? SearchPremiseView
                        
                        var tableHeight: CGFloat = 0.0
                        var yStartTable: CGFloat = 0.0
                        if !self!.parentVC.isEnabledTopBarInInit{
                            tableHeight = (self!.parentVC?.view.frame.height)! - self!.keyboardHeight - (self!.frame.height + ((UIApplication.shared.windows.first?.safeAreaInsets.top)!))
                            yStartTable = self!.frame.height + (self!.window?.safeAreaInsets.top)!
                        } else {
                            tableHeight = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self!.keyboardHeight - self!.frame.height
                            yStartTable = self!.frame.height
                        }
                        
                        self!.tablePremiseView?.setupView(height: tableHeight, parentController: self!.parentVC)
                        self!.tablePremiseView?.frame = CGRect(x: 0, y: yStartTable,
                                                          width: self!.frame.width,
                                                          height: tableHeight)
                        self!.parentVC?.view.addSubview(self!.tablePremiseView!)
                        
                        // Базовая инициализация данными таблицы
                        let data = self!.parentVC
                            .viewModel
                            .loadArrayPremise(prefix: (label?.text)!)
                        self!.tablePremiseView?.sections.accept([SearchPremiseView.SectionOfPremise(header: "Кабинеты",
                                                                                                   items: data!)])
                    }
                    
                    // Кнопка "Назад"
                    if self!.backButton == nil{
                        self!.backButton = UIButton()
                        self!.backButton!.makeCancelPremiseInputtingView()
                        
                        var yStartBackButton: CGFloat = 0.0
                        if !(self!.parentVC).isEnabledTopBarInInit{
                            yStartBackButton = (self!.parentVC.view.frame.height) - self!.keyboardHeight - 50
                        } else {
                            yStartBackButton = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self!.keyboardHeight - 50
                        }
                        self!.backButton!.frame = CGRect(x: self!.center.x - 60, y: yStartBackButton,
                                                  width: 120, height: 40)
                        self!.parentVC?.view.addSubview(self!.backButton!)
                    }
                    
                    if timeForBindings{
                        self!.backButton!.rx.tap.bind{
                            if self!.startPlaceTextField.text != ""{
                                self!.startPlaceTextField.text = self!.oldStartPlaceText
                            }
                            if self!.finishPlaceTextField.text != ""{
                                self!.finishPlaceTextField.text = self!.oldFinishPlaceText
                            }
                            if self!.startPlaceTextField.text == "" || self!.finishPlaceTextField.text == ""{
                                // Удаление старого нарисованного пути
                     
                                if self!.parentVC.map.pathLayer != nil{
                                    self!.parentVC.map.pathLayer.removeFromSuperlayer()
                                    self!.parentVC.map.pathLayer.removeAllAnimations()
                                }
                                self!.parentVC.anotherStageButton.isHidden = true
                                self!.parentVC.storeySwitcherView.isHidden = false
                            }
                            self!.endEditingData()
                        }.disposed(by: self!.disposeBag)
                    }
                    }).disposed(by: disposeBag)
            
                    // Отслеживание набранного текста
                    label?.rx
                        .controlEvent([.editingChanged])
                        .asObservable()
                        .subscribe(onNext: { [weak self] _ in
                            let data = self!.parentVC
                                .viewModel
                                .loadArrayPremise(prefix: (label?.text)!)
                            
                            self!.tablePremiseView?.sections.accept([SearchPremiseView.SectionOfPremise(header: "Кабинеты",
                                                                                                       items: data!)])
                        }).disposed(by: disposeBag)
                    
            
                    label?.rx
                        .controlEvent(.editingDidBegin)
                        .asObservable()
                        .subscribe(onNext: { [weak self] _ in
                            UIView.setAnimationsEnabled(false)
                            self!.startPlaceTextField.isEditing ? (self!.finishPlaceTextField.isUserInteractionEnabled = false) : (self!.startPlaceTextField.isUserInteractionEnabled = false)
                        }).disposed(by: disposeBag)
            
                    label?.autocorrectionType = .no
                    label?.clearButtonMode = .always
                    label?.clearButtonMode = .whileEditing
            }
    }
    
    
    // MARK: Изменение точки отправления/назначения
    @objc func changePremiseLabel(_ notification: NSNotification){
        
        let idPremise = notification.userInfo!["idPremise"] as! Int
        self.startPlaceTextField.isEditing ?
            (self.startPlacePremiseId = idPremise) :
            (self.finishPlacePremiseId = idPremise)
        self.startPlaceTextField.isEditing ?
            (self.startPlaceTextField.text = parentVC.viewModel.getPremiseById(withId: self.startPlacePremiseId).description) :
            (self.finishPlaceTextField.text = parentVC.viewModel.getPremiseById(withId: self.finishPlacePremiseId).description)
        endEditingData()
        
        // Перемещение камеры и выбор маркера
        // Выбор одного из пунктов отбытия/прибытия
        if startPlaceTextField.text == "" || finishPlaceTextField.text == "" {
            let needsOpenNewMap = parentVC.map.viewModel.idMap != parentVC.viewModel.getPremiseById(withId: idPremise).idMap
            
            let closureToPremise = {
                let marker = self.parentVC.map.viewModel.getMarkerByIdPremise(id: idPremise)
                marker.statusSelected = true
                self.parentVC.map.zoomScale = 0.8
                marker.paintingPriority = 1
                let userInfo: [String: Any] = ["tapRecognizer": notification,
                                               "idPremise": marker.idPremise]
                NotificationCenter.default.post(name: Notification.Name("OpenBottomBar"), object: nil, userInfo: userInfo)
                UIView.animate(withDuration: 0.6, animations: {
                    self.parentVC.map.setContentOffset(CGPoint(x: marker.xPosition * self.parentVC.map.zoomScale - self.parentVC.map.frame.width/2,
                                                               y: marker.yPosition * self.parentVC.map.zoomScale - self.parentVC.map.frame.height/2), animated: false)
                })
            }
            // Если помещение принадлежит текущей карте, то: перейти к маркеру помещению
            // Если помещение не принадлежит текущей карте, то: открыть новую карту и перейти к помещению
            if !needsOpenNewMap{
                closureToPremise()
            } else {
                // Загрузка карты пункта отправления/назначения
                let data: [String: Any] = ["storey": parentVC.viewModel.getPremiseById(withId: idPremise).idMap, "closure": closureToPremise, "needsOpenNewMap": true]
                NotificationCenter.default.post(name: Notification.Name("ChangeStorey"), object: nil, userInfo: data)
                parentVC.storeySwitcherView.storeyNumberLabel.text! = String(parentVC.viewModel.getPremiseById(withId: idPremise).idMap)
            }
        } else {
            // Пункты отбытия/прибытия выбраны
            let userInfo: [String: Any] = ["tapRecognizer": notification]
            NotificationCenter.default.post(name: Notification.Name("CloseMarkerAndBottomBar"), object: nil, userInfo: userInfo)
            parentVC.createWay()
        }
    }
    
    
    // MARK: Перемещение камеры
    func cameraMovement(startPremiseId: Int, finishPremiseId: Int, changeStorey: Bool){
        
        let marker1 = parentVC.map.viewModel.getMarkerByIdPremise(id: startPremiseId)
        let marker2 = parentVC.map.viewModel.getMarkerByIdPremise(id: finishPremiseId)
        
        let xChanging = abs(marker2.xPosition - marker1.xPosition)
        let yChanging = abs(marker2.yPosition - marker1.yPosition)

        // Если невозможно отобразить оба пункта одновременно,
        // то перейти камерой в пункт отправления
        if xChanging * parentVC.map.zoomScale > parentVC.view.frame.width || yChanging * parentVC.map.zoomScale > parentVC.map.frame.height{
            
            UIView.animate(withDuration: 0.6, animations: {
                self.parentVC.map.setContentOffset(CGPoint(x: marker1.xPosition * self.parentVC.map.zoomScale - self.parentVC.map.frame.width/2,
                                                           y: marker1.yPosition * self.parentVC.map.zoomScale - self.parentVC.map.frame.height/2), animated: false)
            })
        } else {
            // Иначе, перейти в позицию между ними
            let xMiddleBetweenMarkers = marker1.xPosition + (marker2.xPosition - marker1.xPosition)/2
            let yMiddleBetweenMarkers = marker1.yPosition + (marker2.yPosition - marker1.yPosition)/2
            UIView.animate(withDuration: 0.6, animations: {
                self.parentVC.map.setContentOffset(CGPoint(x: xMiddleBetweenMarkers * self.parentVC.map.zoomScale - self.parentVC.map.frame.width/2,
                                                           y: yMiddleBetweenMarkers * self.parentVC.map.zoomScale - self.parentVC.map.frame.height/2), animated: false)
            }
        )}
    }
    
    
    // MARK: Завершение редактирования данных
    func endEditingData(){
        UIView.setAnimationsEnabled(true)
        self.startPlaceTextField.isUserInteractionEnabled = true
        self.finishPlaceTextField.isUserInteractionEnabled = true
        self.startPlaceTextField.endEditing(true)
        self.finishPlaceTextField.endEditing(true)
        self.leftMenuButton.isHidden = false
        
        self.tablePremiseView!.removeFromSuperview()
        self.backButton!.removeFromSuperview()
        self.tablePremiseView = nil
        self.backButton = nil
    }

    
    // MARK: Установка кнопки открытия бокового меню
    func setupLeftMenuButton(){
        
        self.leftMenuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                
                var listDisablers: [UIView] = [self!.parentVC.topBarView,
                                               self!.parentVC.map,
                                               self!.parentVC.storeySwitcherView]
                (self!.parentVC.bottomBarView != nil) ? listDisablers.append(self!.parentVC.bottomBarView!) : ()
                
                let userInfo: [String: [UIView]] = ["listDisablers": listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self!.parentVC.isMenuOpen.toggle()
            }).disposed(by: disposeBag)
    }
    
    deinit {
        print("Вызвался деструктор!")
    }
}

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
    var map: Map!
    var storeySwitcherView: StoreySwitcherView!
    var anotherStageButton: UIButton!
    
    var currentSelectedName: String!
    var currentSelectedPremiseId: Int!
    var changeMarkerStatus = false
    var bottomBarIsOpen = false
    var anotherStageButtonData: [(Int, Int, Int)]!
    
    var firstDraw = true
    var isEnabledTopBarInInit: Bool!
    var normalStartTopBarHeight: CGFloat!
    var currentStartTopBarHeight: CGFloat!
    var currentTopBarHeight = (UIApplication.shared.windows.first?.safeAreaInsets.top)!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.viewModel = NavigationViewModel(idMap: 3)
        
        NotificationCenter.default.addObserver(self, selector: #selector(openBottomBar), name: Notification.Name("OpenBottomBar"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(closeBottomBar), name: Notification.Name("CloseBottomBar"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(closeMarkerAndBottomBar), name: Notification.Name("CloseMarkerAndBottomBar"), object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(fillStartPlaceLabel), name: Notification.Name("FillStartPlace"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(fillFinishPlaceLabel), name: Notification.Name("FillFinishPlace"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillShow(_:)), name: UIResponder.keyboardWillShowNotification, object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeCorp), name: Notification.Name("ChangeCorp"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(changeStorey), name: Notification.Name("ChangeStorey"), object: nil)
        
        self.addTopBarView()
        self.addMap(idMap: 3)
        self.addStoreySwitcherView()
        self.setupSwapStoreyButtonAfterCreateWay()
    }
    
    
    // MARK: Функция добавления карты
    func addMap(idMap: Int){
        let yStart = (UIApplication.shared.windows.first?.safeAreaInsets.top)! + topBarView.frame.height
        self.map = Map(frame: CGRect(x: 0, y: yStart,
                                     width: self.view.frame.width, height: self.view.frame.height - yStart), idMap: idMap)
        self.map.setupView()
        if self.storeySwitcherView == nil{
            self.view.addSubview(self.map)
        } else{
            self.view.insertSubview(self.map, belowSubview: self.storeySwitcherView)
        }
    }
    
    
    // MARK: Функция открытия нижнего бара
    @objc func openBottomBar(_ notification: NSNotification){
        closeOldMarker(notification)
        
        // Загрузка информации на бар
        bottomBarView = Bundle.main.loadNibNamed("BottomBarView", owner: self, options: nil)?.first as? BottomBarNavigation
        let heightBottomBar = (bottomBarView?.frame.height)! + (self.currentStartTopBarHeight - self.normalStartTopBarHeight)
        bottomBarView?.makeShadow(width: Int(self.view.frame.width),
                                  heigth: Int(heightBottomBar))
        bottomBarView?.setupView(idPremise: notification.userInfo!["idPremise"] as! Int,
                                 heightBar: heightBottomBar,
                                 viewController: self)
        
        // Положение бара на странице
        self.bottomBarView?.frame = CGRect(x: 0, y: self.view.frame.height,
                                           width: self.view.frame.width, height: (bottomBarView?.frame.height)!)
        self.view.addSubview(bottomBarView!)
        
        // "Смена маркера" или "Бар открыт": нет анимации открытия
        // "Не смена маркера" или "Бар закрыт": есть анимация открытия
        if !self.changeMarkerStatus || !self.bottomBarIsOpen{
            
            let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.bottomBarView?.frame = self.bottomBarView?.frame
                    .offsetBy(dx: 0, dy: -heightBottomBar) as! CGRect
            }
            animator.startAnimation()
            
            // Изменить положение переключателя этажей
            let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                    .offsetBy(dx: 0, dy:  -heightBottomBar) as! CGRect
            }
            animatorSwitcherStorey.startAnimation(afterDelay: TimeInterval(0.3))
            
        } else {
            self.bottomBarView?.frame = self.bottomBarView?.frame
                .offsetBy(dx: 0, dy:  -heightBottomBar) as! CGRect
            self.changeMarkerStatus = false
        }
        self.bottomBarIsOpen = true
        self.currentSelectedName = bottomBarView?.namePremise
        self.currentSelectedPremiseId = notification.userInfo!["idPremise"] as! Int?
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
                    let heightBottomBar = (bottomBarView?.frame.height)! + (self.currentStartTopBarHeight - self.normalStartTopBarHeight)
                    let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                        self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                            .offsetBy(dx: 0, dy: heightBottomBar) as! CGRect
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
    
    
    // MARK: Функция закрытия маркера и нижнего бара при нажатии на экран
    @objc func closeMarkerAndBottomBar(_ notification: NSNotification){
        
        // Снять выделение маркера
        for view in self.map.mapScheme.subviews {
            if view is Marker {
                (view as! Marker).statusSelected = false
                (view as! Marker).paintingPriority = 0
            }
        }
        
        // Опустить нижнюю панель
        if self.bottomBarIsOpen{
            let heightBottomBar = (bottomBarView?.frame.height)! + (self.currentStartTopBarHeight - self.normalStartTopBarHeight)
            let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.bottomBarView?.frame = self.bottomBarView?.frame
                    .offsetBy(dx: 0, dy: heightBottomBar) as! CGRect
            }
            animator.startAnimation()
            animator.addCompletion{ _ in
                self.bottomBarIsOpen = false
                self.bottomBarView!.removeFromSuperview()
            }
            
            // Изменить положение переключателя этажей
            let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                    .offsetBy(dx: 0, dy: heightBottomBar) as! CGRect
            }
            animatorSwitcherStorey.startAnimation(afterDelay: TimeInterval(0.3))
        }
        
    }
    
        
    // MARK: Функция закрытия старого маркера
    func closeOldMarker(_ notification: NSNotification){
        
        for view in self.map.mapScheme.subviews{
            if let currentMarkerView = view as? Marker {
                let newPremise = viewModel.getPremiseById(withId: notification.userInfo!["idPremise"] as! Int)
                let newMarkerId = newPremise.id
                
                // Закрытие старого маркера
                if (currentMarkerView.statusSelected == true) && (currentMarkerView.idPremise == self.currentSelectedPremiseId)
                    && (newMarkerId != self.currentSelectedPremiseId){
                    self.changeMarkerStatus = true
                    currentMarkerView.closeMarker(sender: notification.userInfo!["tapRecognizer"])
                }
                // Удалить окно уже включенного маркера
                if (currentMarkerView.statusSelected == true) && (currentMarkerView.idPremise == self.currentSelectedPremiseId)
                    && (newMarkerId == self.currentSelectedPremiseId){
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
        let description = self.viewModel.getPremiseById(withId: self.currentSelectedPremiseId).description
        self.topBarView.startPlaceTextField.text = description
        self.topBarView.startPlacePremiseId = self.currentSelectedPremiseId
        closeBottomBarAfterChoosingPlace()
        
        self.anotherStageButton.isHidden = true
        self.storeySwitcherView.isHidden = false
        if self.topBarView.startPlaceTextField.text != "" && self.topBarView.finishPlaceTextField.text != ""{
            createWay()
        }
    }
    
    
    // MARK: Функция выбора пункта назначения
    @objc func fillFinishPlaceLabel(){
        let description = self.viewModel.getPremiseById(withId: self.currentSelectedPremiseId).description
        self.topBarView.finishPlaceTextField.text = description
        self.topBarView.finishPlacePremiseId = self.currentSelectedPremiseId
        closeBottomBarAfterChoosingPlace()
        
        self.anotherStageButton.isHidden = true
        self.storeySwitcherView.isHidden = false
        if self.topBarView.startPlaceTextField.text != "" && self.topBarView.finishPlaceTextField.text != ""{
            createWay()
        }
    }
    
    
    // MARK: Функция построения маршрута
    func createWay(){
        
        // Удаление старого пути перед рисованием нового
        if self.map.pathLayer != nil{
            self.map.pathLayer.removeFromSuperlayer()
            self.map.pathLayer.removeAllAnimations()
        }
        
        let startResult = self.viewModel.getIndexInStorageByPremiseId(idPremise: self.topBarView.startPlacePremiseId!)
        let finishResult = self.viewModel.getIndexInStorageByPremiseId(idPremise: self.topBarView.finishPlacePremiseId!)
        
        let inMapId = startResult.0
        let inDot = startResult.1
        
        let outMapId = finishResult.0
        let outDot = finishResult.1
        
        // Случай 1: этажи совпадают
        if inMapId == outMapId{
            let data: [String: Any] = ["storey": inMapId, "needsOpenNewMap": self.map.viewModel.idMap != inMapId]
            NotificationCenter.default.post(name: Notification.Name("ChangeStorey"), object: nil, userInfo: data)
            self.topBarView.cameraMovement(startPremiseId: self.topBarView.startPlacePremiseId!,
                                           finishPremiseId: self.topBarView.finishPlacePremiseId!,
                                           changeStorey: false)
            self.map.drawPathBetweenAudience(v1: inDot, v2: outDot)
            self.anotherStageButton.isHidden = true
            self.storeySwitcherView.isHidden = false
            self.storeySwitcherView.storeyNumberLabel.text! = String(inMapId)
        } else{
            // Случай 2: Пункты расположены на разных этажах
            let optimalWay = self.viewModel.getOptimalWayForPremiseFromDifferentStoreys(inPremise: startResult, outPremise: finishResult)
            // Данные: id-карты, пункты отправления и назначения
            self.anotherStageButtonData = [(Int, Int, Int)].init(arrayLiteral: (inMapId, optimalWay.0, optimalWay.1),
                                                                               (outMapId, optimalWay.2, optimalWay.3))
            
            let closure = {
                self.storeySwitcherView.storeyNumberLabel.text! = String(inMapId)
                // Построение пути на карте пункта отправления
                self.topBarView.cameraMovement(startPremiseId: self.viewModel.getIdPremiseByIdMapAndIdOnMap(inMapId, optimalWay.0),
                                               finishPremiseId: self.viewModel.getIdPremiseByIdMapAndIdOnMap(inMapId, optimalWay.1),
                                               changeStorey: false)
                self.map.drawPathBetweenAudience(v1: optimalWay.0, v2: optimalWay.1)
                
                // Кнопка для загрузки карты прибытия и построения пути
                self.anotherStageButton.setTitle("На \(outMapId) этаж", for: .normal)
                self.anotherStageButton.isHidden = false
                self.storeySwitcherView.isHidden = true
                }
            
            let data: [String: Any] = ["storey": inMapId, "closure": closure, "needsOpenNewMap": self.map.viewModel.idMap != inMapId]
            NotificationCenter.default.post(name: Notification.Name("ChangeStorey"), object: nil, userInfo: data)
        }
    }
    
    
    // MARK: Кнопка смены этажа, если маршрут включает несколько этажей
    func setupSwapStoreyButtonAfterCreateWay(){
        
        self.anotherStageButton = UIButton(frame: CGRect(x: self.view.frame.width - 120, y: self.view.frame.height - 60,
                                                         width: 110, height: 50))
        self.anotherStageButton.makeRounding()
        self.anotherStageButton.setTitle("На ... этаж", for: .normal)
        self.anotherStageButton.setTitleColor(.black, for: .normal)
        self.anotherStageButton.backgroundColor = .cancelInputPremiseColor
        self.anotherStageButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18.0)
        self.anotherStageButton.isHidden = true
        self.view.addSubview(self.anotherStageButton)
        
        self.anotherStageButton.rx.tap.bind{
            // Загрузка карты пункта назначения/отправления
            let data: [String: Any] = ["storey": (self.anotherStageButtonData.last?.0)!, "closure": {
                    
                self.storeySwitcherView.storeyNumberLabel.text! = String((self.anotherStageButtonData.last?.0)!)
                self.anotherStageButton.setTitle("На \((self.anotherStageButtonData.first?.0)!) этаж", for: .normal)
                
                // Построение пути на карте пункта назначения/отправления
                self.topBarView.cameraMovement(startPremiseId: self.viewModel.getIdPremiseByIdMapAndIdOnMap((self.anotherStageButtonData.last?.0)!,
                                                                                                            (self.anotherStageButtonData.last?.1)!),
                                               finishPremiseId: self.viewModel.getIdPremiseByIdMapAndIdOnMap((self.anotherStageButtonData.last?.0)!,
                                                                                                             (self.anotherStageButtonData.last?.2)!),
                                               changeStorey: true)
                self.map.drawPathBetweenAudience(v1: (self.anotherStageButtonData.last?.1)!,
                                                 v2: (self.anotherStageButtonData.last?.2)!)
                self.anotherStageButtonData.swapAt(0, 1)
                }, "needsOpenNewMap": true]
            
            NotificationCenter.default.post(name: Notification.Name("ChangeStorey"), object: nil, userInfo: data)
        }
    }
    
    
    // MARK: Функция закрытия нижнего бара после выбора пункта
    func closeBottomBarAfterChoosingPlace(){
        let heightBottomBar = (bottomBarView?.frame.height)! + (self.currentStartTopBarHeight - self.normalStartTopBarHeight)
        self.bottomBarIsOpen = false
        
        let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
            self.bottomBarView?.frame = self.bottomBarView?.frame
                .offsetBy(dx: 0, dy: heightBottomBar) as! CGRect
        }
        animator.startAnimation()
        animator.addCompletion{ _ in
            self.bottomBarView?.removeFromSuperview()
        }
        
        // Изменить положение переключателя этажей
        let animatorSwitcherStorey = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
            self.storeySwitcherView?.frame = self.storeySwitcherView?.frame
                .offsetBy(dx: 0, dy: heightBottomBar) as! CGRect
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
                        .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + headerHeight + 50)) as! CGRect
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
    
    
    // MARK: Функция смены этажа
    @objc func changeStorey(_ notification: NSNotification){
        
        if let storey = notification.userInfo!["storey"] as? Int{
            
            // Загрузить новый этаж по информации о текущем этаже
            if notification.userInfo!["needsOpenNewMap"] as? Bool == true{
                if self.map != nil{
                    self.map.removeFromSuperview()
                }
                self.viewModel = NavigationViewModel(idMap: storey)
                self.addMap(idMap: storey)
                self.map.layoutSubviews()
            }
            
            // Смена этажа с вариантами 1 или 2:
            // 1) Рисованием необходимого пути
            // 2) Фокусе на определенном маркере
            let closure = notification.userInfo!["closure"] as? ()->Void
            if let unwarpedClosure = closure{
                unwarpedClosure()
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
        
        let yStart = self.view.frame.height - 98
        self.storeySwitcherView?.frame = CGRect(x: 10, y: yStart,
                                           width: 42, height: 88)
        self.storeySwitcherView.makeRounding()
        self.view.addSubview(self.storeySwitcherView)
    }
    
    
    // MARK: Перерисовка объектов при включении режима модема, записи аудио и тд.
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        
        self.view.autoresizesSubviews = false
        var yStartTopBar: CGFloat = 0.0
        var yStartMap: CGFloat = 0.0
        var yStartSwitcher: CGFloat = 0.0
        var yStartAnotherStorey: CGFloat = 0.0
        
        var yStartTable: CGFloat = 0.0
        var tableHeight: CGFloat = 0.0
        
        var yStartBackButton: CGFloat = 0.0
        
        let firstDrawOnThisCall = self.firstDraw
        
        // При первой прорисовке запомнить, был ли запущен бар
        if self.firstDraw{
            
            self.normalStartTopBarHeight = self.view.frame.height - (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)!
            self.currentStartTopBarHeight = UIApplication.shared.windows.first?.safeAreaInsets.top
            
            self.isEnabledTopBarInInit = currentStartTopBarHeight != normalStartTopBarHeight
            self.firstDraw = false
        }
        
        if self.isEnabledTopBarInInit{
            yStartTopBar = 0
            yStartSwitcher = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - 98
            yStartMap = topBarView.frame.height
            yStartAnotherStorey = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - 60
            if self.topBarView.keyboardHeight != nil{
                tableHeight = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self.topBarView.keyboardHeight - self.topBarView.frame.height
                yStartTable = self.topBarView.frame.height
                yStartBackButton = (UIApplication.shared.windows.first?.safeAreaLayoutGuide.layoutFrame.height)! - self.topBarView.keyboardHeight - 50
            }
        } else {
            yStartTopBar = 0
            yStartSwitcher = self.view.frame.height - 98
            yStartAnotherStorey = self.view.frame.height - 60
            yStartMap = (UIApplication.shared.windows.first?.safeAreaInsets.top)! + topBarView.frame.height
            if self.topBarView.keyboardHeight != nil{
                tableHeight = self.view.frame.height - self.topBarView.keyboardHeight - (self.topBarView.frame.height + ((UIApplication.shared.windows.first?.safeAreaInsets.top)!))
                yStartTable = self.topBarView.frame.height + (self.topBarView.window?.safeAreaInsets.top)!
                yStartBackButton = self.view.frame.height - self.topBarView.keyboardHeight - 50
            }
        }
        
        // Если был изменен размер Safe area -> перерисовать объекты
        if ((UIApplication.shared.windows.first?.safeAreaInsets.top)! - self.currentTopBarHeight != 0) || firstDrawOnThisCall{
            self.topBarView?.frame = CGRect(x: 0, y: yStartTopBar,
                                            width: self.view.frame.width, height: (topBarView?.frame.height)!)
            self.storeySwitcherView?.frame = CGRect(x: 10, y: yStartSwitcher,
                                                    width: 42, height: 88)
            self.anotherStageButton.frame = CGRect(x: self.view.frame.width - 120, y: yStartAnotherStorey,
                                                     width: 110, height: 50)
            self.map.frame = CGRect(x: 0, y: yStartMap,
                                    width: self.view.frame.width, height: self.view.frame.height - yStartMap)
            if self.topBarView.backButton != nil{
                self.topBarView.backButton?.frame = CGRect(x: self.topBarView.center.x - 60, y: yStartBackButton,
                                                           width: 120, height: 40)
                self.topBarView.tablePremiseView?.frame = CGRect(x: 0, y: yStartTable,
                                                                 width: self.topBarView.frame.width, height: tableHeight)
                self.topBarView.tablePremiseView?.premiseTableViewHeightConstraint.constant = tableHeight
            }
        }
        
        self.currentTopBarHeight = (UIApplication.shared.windows.first?.safeAreaInsets.top)!
    }
}

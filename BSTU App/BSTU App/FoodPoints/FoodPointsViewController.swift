//
//  FoodPointsViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa

class FoodPointsViewController: UIViewController, UIGestureRecognizerDelegate, UITableViewDelegate{
    
    @IBOutlet weak var menuButton: UIImageView!
    
    @IBOutlet weak var dropdownContainerView: UIView!
    @IBOutlet weak var nameRoomDropdownButton: UILabel!
    @IBOutlet weak var dropdownImage: UIImageView!
    
    var roomDataBehavoirRelay: BehaviorRelay<[FoodRoom]>!
    @IBOutlet weak var tableRooms: UITableView!
    @IBOutlet weak var tableRoomsHeightConstraint: NSLayoutConstraint!
    
    var foodDataBehavoirRelay: BehaviorRelay<[FoodItem]>!
    @IBOutlet weak var tableFoods: UITableView!
    
    @IBOutlet weak var errorLoadingPicture: UIImageView!
    @IBOutlet weak var errorTextLabel: UILabel!
    
    var isMenuOpen = false
    var firstDraw = true
    let viewModel = FoodPointsViewModel()
    let disposeBag = DisposeBag()
    
    var loadingDialogBar: UIAlertController? = nil
    lazy var listDisablers: [UIView] = [
        self.menuButton, self.dropdownContainerView,
        self.tableRooms, self.tableFoods
    ]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupTableDisplay()
        setupLeftMenuButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        if self.firstDraw{
            self.loadingDialogBar = self.setupLoadingBar()
            setupTableRoomData()
            self.firstDraw = false
        }
    }
    
    
    // MARK: Установка отображения таблиц
    func setupTableDisplay(){
        
        for viewItem in [self.dropdownContainerView, self.tableRooms,
                         self.tableFoods,
                         self.errorLoadingPicture,
                         self.errorTextLabel] {
                            viewItem?.isHidden = true
        }
    }
    
    
    // MARK: Установка информации о помещениях в таблицу
    func setupTableRoomData(){
        
        self.tableRooms.backgroundColor = .foodPointsLightGrayColor
        self.tableRooms.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        
        self.viewModel.getFoodRooms(completion: { [weak self] rooms in
            
            for viewItem in [self!.dropdownContainerView, self!.tableRooms,
                             self!.tableFoods] {
                                viewItem?.isHidden = false
            }
            self?.tableRooms.isHidden = true
            self?.setupDropdownContainerDisplay()
            
            // Получение данных таблицей помещений
            self!.roomDataBehavoirRelay = BehaviorRelay<[FoodRoom]>(value: rooms)
            self!.roomDataBehavoirRelay.bind(to: self!.tableRooms.rx.items){
                [weak self] table, row, item in
                let cellTable = table.dequeueReusableCell(withIdentifier: "FoodRoomCellID", for: IndexPath.init(row: row, section: 0)) as! FoodRoomCell
                cellTable.configureCell(roomModel: item)
                return cellTable
            }.disposed(by: self!.disposeBag)
            
            // Открытие/Закрытие таблицы
            self!.dropdownContainerView.rx
                .tapGesture()
                .when(.recognized)
                .subscribe(onNext: { _ in
                    
                    // Таблица скрыта - бар закрыт
                    if self!.tableRooms.isHidden{
                        self!.dropdownImage.image = UIImage(named: "dropup")
                        self!.tableRoomsHeightConstraint.constant = 0
                        self!.view.layoutIfNeeded()
                        
                    // Таблица открыта - бар открыт
                    } else {
                        self!.dropdownImage.image = UIImage(named: "dropdown")
                        let calculatedHeightTable = CGFloat(44 * rooms.count) + 11
                        if calculatedHeightTable + 91 > (self?.view.frame.height)!{
                            var fitRoomsCount = rooms.count - 1
                            var currentCalculatedHeightTable = CGFloat(44 * fitRoomsCount) + 11
                            while currentCalculatedHeightTable + 91 > (self?.view.frame.height)!{
                                fitRoomsCount -= 1
                                currentCalculatedHeightTable = CGFloat(44 * fitRoomsCount) + 11
                            }
                            self!.tableRoomsHeightConstraint.constant = currentCalculatedHeightTable
                        } else {
                            self!.tableRoomsHeightConstraint.constant = calculatedHeightTable
                        }
                        self!.view.layoutIfNeeded()
                    }
                    
                    let isHiddenTableRooms = self!.tableRooms.isHidden
                    self!.tableRooms.isHidden = false
                    
                    // Анимация движения таблицы
                    UIView.animate(
                            withDuration: 0.4,
                            delay: 0,
                            usingSpringWithDamping: 1.0,
                            initialSpringVelocity: 1.0,
                            options: .curveEaseIn,
                            animations: {
                                var heightTable: CGFloat!
                                if isHiddenTableRooms{
                                    heightTable = CGFloat(44 * rooms.count) + 11
                                    if heightTable + 91 > (self?.view.frame.height)!{
                                        var fitRoomsCount = rooms.count - 1
                                        var currentCalculatedHeightTable = CGFloat(44 * fitRoomsCount) + 11
                                        while currentCalculatedHeightTable + 91 > (self?.view.frame.height)!{
                                            fitRoomsCount -= 1
                                            currentCalculatedHeightTable = CGFloat(44 * fitRoomsCount) + 11
                                        }
                                        heightTable = currentCalculatedHeightTable
                                    }
                                } else {
                                    heightTable = 0
                                }
                                self!.tableRoomsHeightConstraint.constant = heightTable
                                self!.view.layoutIfNeeded()
                              },
                              completion: { _ in
                                self!.tableRooms.isHidden = !isHiddenTableRooms
                        })
                }).disposed(by: self!.disposeBag)
            
            
            // Обработка нажатия на значение таблицы помещений
            self!.tableRooms.rx
                .modelSelected(FoodRoom.self)
                .subscribe(
                    onNext: {[weak self] selectedItem in
                        let foodRoomTitle = selectedItem.nameRoom
                        self!.dropdownImage.image = UIImage(named: "dropdown")
                        
                        if foodRoomTitle != self!.nameRoomDropdownButton.text{
                            // Получить новые данные
                        }
                        
                        self!.nameRoomDropdownButton.text = foodRoomTitle
                        UIView.animate(
                            withDuration: 0.4,
                            delay: 0,
                            usingSpringWithDamping: 1,
                            initialSpringVelocity: 1,
                            options: .curveEaseIn,
                            animations: {
                                self!.tableRoomsHeightConstraint.constant = 0
                                self!.view.layoutIfNeeded()
                        },
                            completion: { _ in
                                self!.tableRooms.isHidden = true
                                
                                let currentRoomData = self?.roomDataBehavoirRelay.value
                                for room in currentRoomData!{
                                    (room.nameRoom == selectedItem.nameRoom) ? (room.isSelected = true) : (room.isSelected = false)
                                }
                            
                                self!.roomDataBehavoirRelay.accept(currentRoomData!)
                                //self!.foodDataBehavoirRelay.accept(data)
                        })
                }).disposed(by: self!.disposeBag)
            self!.setupTableFoodData()
            
        }, errorClosure: { [weak self] in
            
            for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                viewItem?.isHidden = false
            }
            self!.loadingDialogBar!.dismiss(animated: true, completion: nil)
            self!.loadingDialogBar = nil
        })
        
    }
    
    
    // MARK: Установка информации о меню в таблицу
    func setupTableFoodData(){
        
        self.tableFoods.register(UINib(nibName: "FoodItemCell", bundle: nil),
                                   forCellReuseIdentifier: "FoodItemCellID")
        self.viewModel.getFoodMenuForRoom(idRoom: "1",
                                          completion: { [weak self] foods in
                                            
                                            // Получение данных таблицы еды
                                            self!.foodDataBehavoirRelay = BehaviorRelay<[FoodItem]>(value: foods)
                                            self!.foodDataBehavoirRelay.bind(to: self!.tableFoods.rx.items){
                                                [weak self] table, row, item in
                                                let cellTable = table.dequeueReusableCell(withIdentifier: "FoodItemCellID", for: IndexPath.init(row: row, section: 0)) as! FoodItemCell
                                                cellTable.layoutIfNeeded()
                                                cellTable.configureCell(foodItem: item)
                                                return cellTable
                                            }.disposed(by: self!.disposeBag)
                                            self!.loadingDialogBar!.dismiss(animated: true, completion: nil)
                                            self!.loadingDialogBar = nil
                                             
        },
                                          errorClosure: { [weak self] in
                                            for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                                                viewItem?.isHidden = false
                                                
                                            }
                                            self!.loadingDialogBar!.dismiss(animated: true, completion: nil)
                                            self!.loadingDialogBar = nil
        })
    }
    
    
    // MARK: Установка окна загрузки данных
    func setupLoadingBar()->UIAlertController{
        let dialogLoading = UIAlertController(title: "Загрузка",
                                              message: nil,
                                              preferredStyle: .alert)
        let activityIndicator = UIActivityIndicatorView(style: .gray)
        activityIndicator.translatesAutoresizingMaskIntoConstraints = false
        activityIndicator.isUserInteractionEnabled = false
        activityIndicator.startAnimating()

        dialogLoading.view.addSubview(activityIndicator)
        dialogLoading.view.heightAnchor.constraint(equalToConstant: 95).isActive = true

        activityIndicator.centerXAnchor.constraint(equalTo: dialogLoading.view.centerXAnchor, constant: 0).isActive = true
        activityIndicator.bottomAnchor.constraint(equalTo: dialogLoading.view.bottomAnchor, constant: -20).isActive = true
        self.present(dialogLoading, animated: true)
        
        return dialogLoading
    }
    
    
    // MARK: Настройка Header/Fotter для таблицы выбора помещения
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView(frame: CGRect(x: 0, y: 0, width: tableView.frame.size.width, height: 10))
        headerView.backgroundColor = .foodPointsLightGrayColor
        return headerView
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 10
    }
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let footerView = UIView(frame: CGRect(x: 0, y: 0, width: tableView.frame.size.width, height: 1))
        footerView.backgroundColor = .lightGray
        return footerView
    }

    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return 1
    }
    
    
    // MARK: Настройка отображения Dropdown - контейнера
    func setupDropdownContainerDisplay(){
        
        self.dropdownContainerView.makeRounding()
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.dropdownContainerView.bounds
        gradientLayer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor,
                                UIColor.thirdCourseBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.dropdownContainerView.layer.insertSublayer(gradientLayer, at: 0)
    }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupLeftMenuButton(){
        
       let tap = UITapGestureRecognizer(target: self, action: #selector(self.handleTap(_:)))
       self.view.addGestureRecognizer(tap)
       tap.delegate = self
        
       let edgePan = UIScreenEdgePanGestureRecognizer(target: self, action: #selector(self.screenEdgeSwiped))
       edgePan.edges = .left
       self.view.addGestureRecognizer(edgePan)
        
       self.menuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                let userInfo: [String: [UIView]] = ["listDisablers": self!.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self!.isMenuOpen.toggle()
        }).disposed(by: disposeBag)
        
        let leftSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        let rightSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        leftSwipe.direction = .left
        rightSwipe.direction = .right
        self.view.addGestureRecognizer(leftSwipe)
        self.view.addGestureRecognizer(rightSwipe)
    }
    
    
    // MARK: Обработка свайпов экрана
    @objc func handleSwipes(_ sender: UISwipeGestureRecognizer){
    
        switch sender.direction {
        case .left:
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: listDisablers)
            self.isMenuOpen = false
        case .right:
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: listDisablers)
            self.isMenuOpen = true
        default:
            return
        }
    }
    
    
    // MARK: Действия по открытию меню
    @objc func handleTap(_ sender: UITapGestureRecognizer){
        if self.isMenuOpen{
            let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
            NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
            self.isMenuOpen.toggle()
        }
    }
    
    
    // MARK: Отмена нажатия на экран при закрытом меню
    func gestureRecognizer(_ gestureRecognizer: UIGestureRecognizer, shouldReceive touch: UITouch) -> Bool {
        if self.isMenuOpen {
            return true
        }
        return false
    }
    
    
    // MARK: Действия по открытию меню из-за пределов экрана
    @objc func screenEdgeSwiped(_ recognizer: UIScreenEdgePanGestureRecognizer) {
        if recognizer.state == .recognized {
            if !self.isMenuOpen{
                let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self.isMenuOpen.toggle()
            }
        }
    }
    
    deinit {
        print("Вызов деструктора страницы Меню питания!")
    }
}

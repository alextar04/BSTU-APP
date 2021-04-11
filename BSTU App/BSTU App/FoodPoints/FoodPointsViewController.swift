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
import RxDataSources

class FoodPointsViewController: UIViewController, UIGestureRecognizerDelegate, UITableViewDelegate{
    
    @IBOutlet weak var menuButton: UIImageView!
    
    @IBOutlet weak var dropdownContainerView: UIView!
    @IBOutlet weak var nameRoomDropdownButton: UILabel!
    @IBOutlet weak var dropdownImage: UIImageView!
    
    var roomDataBehavoirRelay: BehaviorRelay<[FoodRoom]>!
    @IBOutlet weak var tableRooms: UITableView!
    @IBOutlet weak var tableRoomsHeightConstraint: NSLayoutConstraint!
    var gradientLayerTableRooms: CAGradientLayer!
    
    var foodDataBehavoirRelay: BehaviorRelay<[SectionOfFoodItems]>!
    @IBOutlet weak var tableFoods: UITableView!
    struct SectionOfFoodItems{
        var header: String
        var items: [FoodItem]
    }
    
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
        
        self.tableRooms.makeRoundingSpecificCorners(arrayCorners: [.layerMinXMaxYCorner,
                                                                   .layerMaxXMaxYCorner])
        self.tableRooms.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        self.tableRooms.layoutMargins = UIEdgeInsets.zero
        self.tableRooms.separatorInset = UIEdgeInsets.zero
        
        self.viewModel.getFoodRooms(completion: { [weak self] in
            
            let rooms = self!.viewModel.totalRooms
            for viewItem in [self!.dropdownContainerView, self!.tableRooms,
                             self!.tableFoods] {
                                viewItem?.isHidden = false
            }
            self?.tableRooms.isHidden = true
            self?.nameRoomDropdownButton.text = self?.viewModel.totalRooms.first?.nameRoom
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
                        self!.dropdownImage.image = UIImage(named: "blackDropup")
                        self!.tableRoomsHeightConstraint.constant = 0
                        self!.view.layoutIfNeeded()
                        
                    // Таблица открыта - бар открыт
                    } else {
                        self!.dropdownImage.image = UIImage(named: "blackDropdown")
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
                    self!.dropdownContainerView.isUserInteractionEnabled = false
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
                                self!.dropdownContainerView.isUserInteractionEnabled = true
                        })
                }).disposed(by: self!.disposeBag)
            
            
            // Обработка нажатия на значение таблицы помещений
            self!.tableRooms.rx
                .modelSelected(FoodRoom.self)
                .subscribe(
                    onNext: {[weak self] selectedItem in
                        let foodRoomTitle = selectedItem.nameRoom
                        self!.dropdownImage.image = UIImage(named: "blackDropdown")
                        
                        if foodRoomTitle != self!.nameRoomDropdownButton.text{
                            
                            for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                                 viewItem?.isHidden = true
                             }
                            
                            // Получить новые данные в таблицу
                            let selectedRoomNumber = selectedItem.numberRoom
                            let neededIndex = self?.viewModel.totalRooms.firstIndex(where: { room in
                                return room.numberRoom == selectedRoomNumber
                            })
                            
                            self?.foodDataBehavoirRelay.accept((self?.viewModel.totalMenus[neededIndex!])!)
                            if self?.viewModel.totalMenus[neededIndex!]?.count != 0{
                                let topIndex = IndexPath(row: 0, section: 0)
                                self!.tableFoods.scrollToRow(at: topIndex, at: .top, animated: false)
                            }

                            // Отобразить сообщение при пустом списке меню
                            if (self?.viewModel.totalMenus[neededIndex!])!.count == 0{
                                for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                                    viewItem?.isHidden = false
                                }
                            }
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
                        })
                }).disposed(by: self!.disposeBag)
            self!.setupTableFoodData()
            
        }, errorClosure: { [weak self] error in
            
            for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                viewItem?.isHidden = false
                if error == .networkError{
                    self?.errorTextLabel.text = "Ошибка подключения к интернету"
                }
            }
            
            self!.loadingDialogBar!.dismiss(animated: true, completion: nil)
            self!.loadingDialogBar = nil
        })
        
    }
    
    
    // MARK: Установка информации о меню в таблицу
    func setupTableFoodData(){
        
        self.tableFoods.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        
        self.tableFoods.register(UINib(nibName: "FoodItemCell", bundle: nil),
                                   forCellReuseIdentifier: "FoodItemCellID")
        self.viewModel.getFoodMenuForRooms( completion: { [weak self] in
                            
                                            // Конфигурация содержимого для ячеек таблицы
                                            let dataSource = RxTableViewSectionedReloadDataSource<SectionOfFoodItems>(configureCell: {
                                                [weak self] dataSource, table, index, item in
                                                let cell = table.dequeueReusableCell(withIdentifier: "FoodItemCellID", for: index) as! FoodItemCell
                                                cell.layoutIfNeeded()
                                                cell.configureCell(foodItem: item)
                                                return cell
                                            })
                                            
                                            // Связывание данных и таблицы
                                            self!.foodDataBehavoirRelay = BehaviorRelay<[SectionOfFoodItems]>(value: (self?.viewModel.totalMenus.first!)!)
                                            self!.foodDataBehavoirRelay
                                                .bind(to: self!.tableFoods.rx.items(dataSource: dataSource))
                                                .disposed(by: self!.disposeBag)
                                            
                                            self!.loadingDialogBar!.dismiss(animated: true, completion: nil)
                                            self!.loadingDialogBar = nil
            
                                            if (self!.viewModel.totalMenus.first!)!.count == 0{
                                                for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                                                    viewItem?.isHidden = false
                                                }
                                            }
        },
                                          errorClosure: { [weak self] error in
                                            for viewItem in [self!.errorLoadingPicture, self!.errorTextLabel] {
                                                viewItem?.isHidden = false
                                                if error == .networkError{
                                                    self?.errorTextLabel.text = "Ошибка подключения к интернету"
                                                }
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
    //       Настройка Header для таблицы блюд
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        if tableView == self.tableRooms{
            let headerView = UIView(frame: CGRect(x: 0, y: 0, width: tableView.frame.size.width, height: 10))
            
            headerView.backgroundColor = .clear
            let gradientLayer = CAGradientLayer()
            gradientLayer.frame = headerView.bounds
            gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor,
                                    UIColor.firstCourseBackgroundColorFinish.cgColor]
            gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
            gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
            
            if self.gradientLayerTableRooms == nil{
                self.gradientLayerTableRooms = gradientLayer
                headerView.layer.insertSublayer(self.gradientLayerTableRooms, at: 0)
            }
            
            headerView.layer.insertSublayer(gradientLayer, at: 0)
            
            return headerView
        }
        
        if tableView == self.tableFoods{
            let label = UILabel()
            label.backgroundColor = .white
            label.font = UIFont.systemFont(ofSize: 17, weight: .bold)
            label.text = self.foodDataBehavoirRelay.value[section].header
            return label
        }
        
        return nil
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        if tableView == self.tableRooms{
            return 10
        }
        return 30
    }
    
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        if tableView == self.tableRooms{
            let footerView = UIView(frame: CGRect(x: 0, y: 0, width: tableView.frame.size.width, height: 1))
            return footerView
        }
        return nil
    }

    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        if tableView == self.tableRooms{
            return 1
        }
        return 0
    }
    
    
    // MARK: Настройка отображения Dropdown - контейнера
    func setupDropdownContainerDisplay(){
        
        // Для iPhone SE уменьшить размер шрифта на кнопке
        if self.view.frame.width == 320{
            self.nameRoomDropdownButton.font = UIFont.systemFont(ofSize: 13)
        }
        self.dropdownContainerView.makeRounding()
        
        let gradientLayerContainer = CAGradientLayer()
        gradientLayerContainer.frame = self.dropdownContainerView.bounds
        gradientLayerContainer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor,
                                         UIColor.thirdCourseBackgroundColorFinish.cgColor]
        gradientLayerContainer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayerContainer.endPoint = CGPoint(x: 1, y: 0.5)
        self.dropdownContainerView.layer.insertSublayer(gradientLayerContainer, at: 0)
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


extension FoodPointsViewController.SectionOfFoodItems: SectionModelType{
    init(original: FoodPointsViewController.SectionOfFoodItems, items: [FoodItem]) {
        self = original
        self.items = items
    }
}

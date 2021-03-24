//
//  ListTeachersViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 11.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import RxDataSources
import UIKit


class ListTeachersViewController: UIViewController, UITableViewDelegate, UIGestureRecognizerDelegate{
    
    var isMenuOpen = false
    @IBOutlet weak var statusLoadingLabel: UILabel!
    @IBOutlet weak var reloadButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
        
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var tableTeachersView: UITableView!
    var searchGroupBar: UISearchBar!
    let viewModel = ListTeachersViewModel()
    let disposeBag = DisposeBag()
    var isShowAllTeachers = true
         
        
    // Вспомогательная структура для отображения данных в виде секции
    var data = [SectionOfTeachers]()
    var groupsSectionalData: BehaviorRelay<[SectionOfTeachers]>!
    struct SectionOfTeachers{
        var header: String
        var items: [Teacher]
    }

    lazy var listDisablers: [UIView] = [self.menuButton,
                                        self.tableTeachersView
    ]
    
        
    override func viewDidLoad() {
        self.tableTeachersView.isHidden = true
        self.reloadButton.isHidden = true
        self.setupSearchBar()
        self.setupReloadButton()
        self.setupMenuButton()
        
        self.tableTeachersView.register(UINib(nibName: "ListTeachersTableCell", bundle: nil), forCellReuseIdentifier: "ListTeachersTableCellID")
            
        viewModel.getTeachersList(completion: { [weak self] teachers in
                
            self!.statusLoadingLabel.isHidden = true
            self!.loadingWheel.isHidden = true
            self!.tableTeachersView.isHidden = false
                
            self!.setupTable(teachers)
            self!.connectTableAndSearchBar()
            }, errorClosure: { [weak self] _ in
                self!.statusLoadingLabel.text = "Ошибка загрузки данных"
                self!.loadingWheel.isHidden = true
                self!.reloadButton.isHidden = false
            })
            
            self.navigationController?.setNavigationBarHidden(true, animated: true)
            self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
        }
        
    
         // MARK: Установка таблицы с названиями групп
        func setupTable(_ listTeachers: [Teacher]){
            
            // Установка делегата для установки кастомной шапки секции
            self.tableTeachersView.rx
                .setDelegate(self)
                .disposed(by: self.disposeBag)
            
            self.groupsSectionalData = BehaviorRelay(value: [SectionOfTeachers]())
            let groupTeachersByNameFirstLetter = Dictionary(grouping: listTeachers){ teacher in
                return teacher.name.first
            }
            for group in groupTeachersByNameFirstLetter{
                self.data.append(SectionOfTeachers(header: "\(group.key!)", items: group.value))
            }
            
            // Конфигурация содержимого для ячеек таблицы
            let dataSource = RxTableViewSectionedReloadDataSource<SectionOfTeachers>(configureCell: {
                dataSource, table, index, item in
                let cell = table.dequeueReusableCell(withIdentifier: "ListTeachersTableCellID", for: index) as! ListTeachersTableCell
                cell.configureCell(name: item.name)
                return cell
            })
            
            // Связывание данных и таблицы
            self.groupsSectionalData
                .bind(to: tableTeachersView.rx.items(dataSource: dataSource))
                .disposed(by: disposeBag)
            
            self.tableTeachersView.rx
                 .modelSelected(Teacher.self)
                 .subscribe(onNext: { [weak self] selectedItem in
                    /*
                    let groupsSheduleController = UIStoryboard(name: "GroupSheduleViewController", bundle: nil)
                        .instantiateViewController(withIdentifier: "GroupSheduleViewControllerID") as! GroupSheduleViewController
                    groupsSheduleController.groupName = selectedItem.name
                    self.navigationController?.pushViewController(groupsSheduleController, animated: true)
                    */
                    print("Выбран: \(selectedItem.name!)")
                    print(selectedItem.link)
                    self!.searchGroupBar.endEditing(true)
                 }).disposed(by: disposeBag)
         }
        
        
        // MARK: Установка кнопки перезагрузки данных
        func setupReloadButton(){
            
            self.reloadButton.rx
                .tap
                .subscribe(onNext: { [weak self] _ in
                    self!.statusLoadingLabel.text = "Загрузка данных"
                    self!.loadingWheel.isHidden = false
                    self!.reloadButton.isHidden = true
                    
                    self!.viewModel.getTeachersList(completion: { teachers in
                        
                        self!.statusLoadingLabel.isHidden = true
                        self!.loadingWheel.isHidden = true
                        self!.tableTeachersView.isHidden = false
                        
                        self!.setupTable(teachers)
                        self!.connectTableAndSearchBar()
                        self!.searchGroupBar.isUserInteractionEnabled = true
                    }, errorClosure: { _ in 
                        self!.statusLoadingLabel.text = "Ошибка загрузки данных"
                        self!.loadingWheel.isHidden = true
                        self!.reloadButton.isHidden = false
                    })
                    
                }).disposed(by: disposeBag)
        }
        
        
        func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
            let label = UILabel()
            label.backgroundColor = .white
            label.font = UIFont.systemFont(ofSize: 17, weight: .bold)
            (self.isShowAllTeachers) ? (label.text = " \(self.data[section].header)") : (label.text = "Результаты")
            return label
        }
        
        
        // MARK: Настройка работы окна поиска
        func setupSearchBar(){
            
            let searchBar = UISearchBar(frame: CGRect(x: 0, y: 0, width: self.view.frame.size.width, height: 56))
            searchBar.searchBarStyle = .minimal
            searchBar.placeholder = "Поиск преподавателя"
            self.tableTeachersView.tableHeaderView = searchBar
            self.searchGroupBar = searchBar
        }
        
        
        // MARK: Соединение таблицы и окна поиска
        func connectTableAndSearchBar(){
            
            // Настройка отображения контента в таблице
            self.searchGroupBar
                .rx
                .text
                .subscribe(onNext: { [weak self] currentString in
                    if currentString == ""{
                        self!.isShowAllTeachers = true
                        self!.groupsSectionalData.accept(self!.data)
                    } else {
                        self!.isShowAllTeachers = false
                        var filteredData: SectionOfTeachers!
                        var filteredTeachers = [Teacher]()
                        _ = self!.data.map{ section in
                            filteredTeachers.append(contentsOf: section.items.filter { group in
                                return group.name.lowercased().prefix(currentString!.count) == currentString?.lowercased().prefix(currentString!.count)
                            })
                        }
                        filteredData = SectionOfTeachers(header: "Результаты", items: filteredTeachers)
                        self!.groupsSectionalData.accept([filteredData])
                    }
            }).disposed(by: disposeBag)
            
            // Настройка работы с клавиатурой
            self.tableTeachersView.keyboardDismissMode = .onDrag
        }
        
        
        // Настройка работы с клавиатурой
        override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
            view.endEditing(true)
        }
    
        
        // MARK: Установка кнопки открытия бокового меню
        func setupMenuButton(){
            
            let closeMenuTap = UITapGestureRecognizer(target: self, action: #selector(self.closeMenu(_:)))
            self.view.addGestureRecognizer(closeMenuTap)
            closeMenuTap.delegate = self
            
            self.menuButton.rx
                .tapGesture()
                .when(.recognized)
                .subscribe(onNext: { [weak self] _ in
                    let userInfo: [String: [UIView]] = ["listDisablers": self!.listDisablers]
                    NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                    self?.isMenuOpen.toggle()
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
                AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender,
                                                                             listDisablers: self.listDisablers)
                self.isMenuOpen = false
            case .right:
                AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender,
                                                                             listDisablers: self.listDisablers)
                self.isMenuOpen = true
            default:
                return
            }
        }
        
    
        // MARK: Отмена нажатия на экран при закрытом меню
        func gestureRecognizer(_ gestureRecognizer: UIGestureRecognizer, shouldReceive touch: UITouch) -> Bool {
            if self.isMenuOpen {
                return true
            }
            return false
        }
        
    
        // MARK: Закрытие меню
        @objc func closeMenu(_ sender: UITapGestureRecognizer){
            self.view.endEditing(true)
            
            if self.isMenuOpen{
                let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self.isMenuOpen.toggle()
            }
        }
    
        deinit {
            print("Вызван деструктор ListTeachersViewController")
        }
    }

    extension ListTeachersViewController.SectionOfTeachers : SectionModelType{
        init(original: ListTeachersViewController.SectionOfTeachers, items: [Teacher]) {
            self = original
            self.items = items
        }
    }

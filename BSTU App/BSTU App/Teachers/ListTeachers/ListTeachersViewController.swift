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


class ListTeachersViewController: UIViewController, UITableViewDelegate{
    
    var isMenuOpen = false
    var letter: String!
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var firstLetterLabel: UILabel!
    
    @IBOutlet weak var statusLoadingLabel: UILabel!
    @IBOutlet weak var horizotalyStatusLoadingLabelConstraint: NSLayoutConstraint!
    @IBOutlet weak var reloadButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
    
    @IBOutlet weak var errorLoadingImage: UIImageView!
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
    
        
    override func viewDidLoad() {
        
        self.firstLetterLabel.text = letter
        self.tableTeachersView.isHidden = true
        self.reloadButton.isHidden = true
        self.errorLoadingImage.isHidden = true
        self.setupSearchBar()
        self.setupReloadButton()
        self.setupBackButton()
        
        self.tableTeachersView.register(UINib(nibName: "ListTeachersTableCell", bundle: nil), forCellReuseIdentifier: "ListTeachersTableCellID")
            
        let intedFirstLetter = Unicode.Scalar(letter)!.value
        self.viewModel.getTeachersListByFirstLetter(firstLetter: intedFirstLetter,
                                                    completion: { [weak self] teachers in
                                                        
                                                        if teachers.count != 0{
                                                            self!.statusLoadingLabel.isHidden = true
                                                            self!.loadingWheel.isHidden = true
                                                            self!.tableTeachersView.isHidden = false
                                                            
                                                            self!.setupTable(teachers)
                                                            self!.connectTableAndSearchBar()
                                                        } else {
                                                            self!.statusLoadingLabel.text = "Преподаватели не найдены"
                                                            self!.horizotalyStatusLoadingLabelConstraint.constant = 40
                                                            self!.errorLoadingImage.isHidden = false
                                                            self!.loadingWheel.isHidden = true
                                                            self!.reloadButton.isHidden = true
                                                        }
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
                    
                    let intedFirstLetter = Unicode.Scalar(self!.letter)!.value
                    self!.viewModel.getTeachersListByFirstLetter(firstLetter: intedFirstLetter,
                        completion: { teachers in
                        
                            if teachers.count != 0{
                                self!.statusLoadingLabel.isHidden = true
                                self!.loadingWheel.isHidden = true
                                self!.tableTeachersView.isHidden = false
                                
                                self!.setupTable(teachers)
                                self!.connectTableAndSearchBar()
                            } else {
                                self!.statusLoadingLabel.text = "Преподаватели не найдены"
                                self!.horizotalyStatusLoadingLabelConstraint.constant = 40
                                self!.errorLoadingImage.isHidden = false
                                self!.loadingWheel.isHidden = true
                                self!.reloadButton.isHidden = true
                            }
                            
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
            label.text = "Результаты"
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
    
    
        // MARK: Установка кнопки перехода к предыдущему окну
        func setupBackButton(){
            
            self.backButton.rx
                .tapGesture()
                .when(.recognized)
                .subscribe(onNext: { [weak self] _ in
                    self?.navigationController?.popViewController(animated: true)
                }).disposed(by: disposeBag)
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

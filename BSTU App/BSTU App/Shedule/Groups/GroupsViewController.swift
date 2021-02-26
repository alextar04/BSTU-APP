//
//  GroupsViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 26.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import RxDataSources
import UIKit

class GroupsViewController: UIViewController, UITableViewDelegate{
    
    @IBOutlet weak var tableGroupsView: UITableView!
    var searchGroupBar: UISearchBar!
    let disposeBag = DisposeBag()
     
    
    // Вспомогательная структура для отображения данных в виде секции
    let coursesArray = ["1 курс", "2 курс", "3 курс", "4 курс", "5 курс"]
    let groupsArray = ["ПВ-11", "ПВ-12", "ПВ-21", "ПВ-22", "ПВ-31", "ПВ-41", "ВТ-41"]
    var groupsSectionalData = [SectionOfGroups]()
    struct SectionOfGroups{
        var header: String
        var items: [String]
    }
    
    override func viewDidLoad() {
        setupTable()
        setupSearchBar()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
     }
     
     
     // MARK: Установка таблицы с названиями институтов
     func setupTable(){
        
        // Установка делегата для установки кастомной шапки секции
        self.tableGroupsView.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        
        for course in coursesArray{
            self.groupsSectionalData.append(SectionOfGroups(header: course, items: groupsArray))
        }
        
        // Конфигурация содержимого для ячеек таблицы
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfGroups>(configureCell: {
            dataSource, table, index, item in
            let cell = table.dequeueReusableCell(withIdentifier: "GroupsViewCellID", for: index) as! GroupsViewCell
            cell.configureCell(name: item)
            return cell
        })
        
        // Связывание данных и таблицы
        Observable.just(groupsSectionalData)
            .bind(to: tableGroupsView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.tableGroupsView.rx
             .modelSelected(String.self)
             .subscribe(onNext: { selectedItem in
                 var result: String = ""
                 result = selectedItem
                 print(selectedItem)
                let groupsSheduleController = UIStoryboard(name: "GroupSheduleViewController", bundle: nil)
                    .instantiateViewController(withIdentifier: "GroupSheduleViewControllerID") as! GroupSheduleViewController
                self.navigationController?.pushViewController(groupsSheduleController, animated: true)
             }).disposed(by: disposeBag)
     }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let label = UILabel()
        label.backgroundColor = .white
        label.font = UIFont.systemFont(ofSize: 17, weight: .bold)
        label.text = " \(self.groupsSectionalData[section].header)"
        return label
    }
    
    
    // MARK: Настройка работы окна поиска
    func setupSearchBar(){
        
        let searchBar = UISearchBar(frame: CGRect(x: 0, y: 0, width: self.view.frame.size.width, height: 56))
        searchBar.searchBarStyle = .minimal
        searchBar.placeholder = "Поиск группы"
        self.tableGroupsView.tableHeaderView = searchBar
        self.searchGroupBar = searchBar
        
        self.searchGroupBar
            .rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                print("Начало редактирования")
            }).disposed(by: disposeBag)
    }
    
}

extension GroupsViewController.SectionOfGroups: SectionModelType{
    init(original: GroupsViewController.SectionOfGroups, items: [String]) {
        self = original
        self.items = items
    }
}

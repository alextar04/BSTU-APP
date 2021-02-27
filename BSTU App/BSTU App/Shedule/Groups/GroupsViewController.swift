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
    var isShowAllGroups = true
    let disposeBag = DisposeBag()
     
    
    // Вспомогательная структура для отображения данных в виде секции
    let coursesArray = ["1 курс", "2 курс", "3 курс", "4 курс", "5 курс"]
    let groupsArray = ["ПВ-11", "ПВ-12", "ПВ-21", "ПВ-22", "ПВ-31", "ПВ-41", "ВТ-41"]
    var data = [SectionOfGroups]()
    var groupsSectionalData: BehaviorRelay<[SectionOfGroups]>!
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
     
     
     // MARK: Установка таблицы с названиями групп
     func setupTable(){
        
        // Установка делегата для установки кастомной шапки секции
        self.tableGroupsView.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        
        self.groupsSectionalData = BehaviorRelay(value: [SectionOfGroups]())
        for course in coursesArray{
            self.data.append(SectionOfGroups(header: course, items: groupsArray))
        }
        
        // Конфигурация содержимого для ячеек таблицы
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfGroups>(configureCell: {
            dataSource, table, index, item in
            let cell = table.dequeueReusableCell(withIdentifier: "GroupsViewCellID", for: index) as! GroupsViewCell
            cell.configureCell(name: item)
            return cell
        })
        
        // Связывание данных и таблицы
        self.groupsSectionalData
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
                self.searchGroupBar.endEditing(true)
             }).disposed(by: disposeBag)
     }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let label = UILabel()
        label.backgroundColor = .white
        label.font = UIFont.systemFont(ofSize: 17, weight: .bold)
        (self.isShowAllGroups) ? (label.text = " \(self.data[section].header)") : (label.text = "Результаты")
        return label
    }
    
    
    // MARK: Настройка работы окна поиска
    func setupSearchBar(){
        
        let searchBar = UISearchBar(frame: CGRect(x: 0, y: 0, width: self.view.frame.size.width, height: 56))
        searchBar.searchBarStyle = .minimal
        searchBar.placeholder = "Поиск группы"
        self.tableGroupsView.tableHeaderView = searchBar
        self.searchGroupBar = searchBar
        
        // Настройка отображения контента в таблице
        self.searchGroupBar
            .rx
            .text
            .subscribe(onNext: { currentString in
                if currentString == ""{
                    self.isShowAllGroups = true
                    self.groupsSectionalData.accept(self.data)
                } else {
                    self.isShowAllGroups = false
                    var filteredData: SectionOfGroups!
                    var filteredGroupNames = [String]()
                    _ = self.data.map{ section in
                        filteredGroupNames.append(contentsOf: section.items.filter { groupName in
                            return groupName.lowercased().prefix(currentString!.count) == currentString?.lowercased().prefix(currentString!.count)
                        })
                    }
                    filteredData = SectionOfGroups(header: "Результаты", items: filteredGroupNames)
                    self.groupsSectionalData.accept([filteredData])
                }
        }).disposed(by: disposeBag)
        
        // Настройка работы с клавиатурой
        self.tableGroupsView.keyboardDismissMode = .onDrag
    }
    
    
    // Настройка работы с клавиатурой
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
}


extension GroupsViewController.SectionOfGroups: SectionModelType{
    init(original: GroupsViewController.SectionOfGroups, items: [String]) {
        self = original
        self.items = items
    }
}

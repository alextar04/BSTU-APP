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
    
    var institutionName: String!
    var link: URL!
    
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var tableGroupsView: UITableView!
    @IBOutlet weak var institutionNameLabel: UILabel!
    var searchGroupBar: UISearchBar!
    let viewModel = GroupsViewModel()
    let disposeBag = DisposeBag()
    var isShowAllGroups = true
     
    
    // Вспомогательная структура для отображения данных в виде секции
    var data = [SectionOfGroups]()
    var groupsSectionalData: BehaviorRelay<[SectionOfGroups]>!
    struct SectionOfGroups{
        var header: String
        var items: [Group]
    }

    
    override func viewDidLoad() {
        self.institutionNameLabel.text = institutionName
        setupBackButton()
        viewModel.getGroupsList(link: link, completion: { coursesGroups in
            
            let sortedCoursesGroups = coursesGroups.sorted { course1, course2 in
                return course1.numberCourse < course2.numberCourse
            }
            self.setupTable(sortedCoursesGroups)
            self.setupSearchBar()
        })
        
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
     }
     
     
    // MARK: Установка кнопки перехода к предыдущему окну
    func setupBackButton(){
        
        self.backButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.navigationController?.popViewController(animated: true)
            }).disposed(by: disposeBag)
    }
    
    
     // MARK: Установка таблицы с названиями групп
    func setupTable(_ listGroup: [GroupsViewModel.CourseGroups]){
        
        // Установка делегата для установки кастомной шапки секции
        self.tableGroupsView.rx
            .setDelegate(self)
            .disposed(by: self.disposeBag)
        
        self.groupsSectionalData = BehaviorRelay(value: [SectionOfGroups]())
        for course in listGroup{
            self.data.append(SectionOfGroups(header: "\(course.numberCourse!) курс", items: course.groups))
        }
        
        // Конфигурация содержимого для ячеек таблицы
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfGroups>(configureCell: {
            dataSource, table, index, item in
            let cell = table.dequeueReusableCell(withIdentifier: "GroupsViewCellID", for: index) as! GroupsViewCell
            cell.configureCell(name: item.name, courseNumber: item.numberCourse)
            return cell
        })
        
        // Связывание данных и таблицы
        self.groupsSectionalData
            .bind(to: tableGroupsView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.tableGroupsView.rx
             .modelSelected(Group.self)
             .subscribe(onNext: { selectedItem in

                let groupsSheduleController = UIStoryboard(name: "GroupSheduleViewController", bundle: nil)
                    .instantiateViewController(withIdentifier: "GroupSheduleViewControllerID") as! GroupSheduleViewController
                groupsSheduleController.groupName = selectedItem.name
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
                    var filteredGroup = [Group]()
                    _ = self.data.map{ section in
                        filteredGroup.append(contentsOf: section.items.filter { group in
                            return group.name.lowercased().prefix(currentString!.count) == currentString?.lowercased().prefix(currentString!.count)
                        })
                    }
                    filteredData = SectionOfGroups(header: "Результаты", items: filteredGroup)
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
    init(original: GroupsViewController.SectionOfGroups, items: [Group]) {
        self = original
        self.items = items
    }
}
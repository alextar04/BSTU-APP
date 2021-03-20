//
//  ExamsViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxDataSources

class ExamsViewController: UIViewController, UITableViewDelegate{
    
    @IBOutlet weak var backButton: UIImageView!
    weak var selectedCell: ExamsCell!
    var selectedCellIndex: IndexPath!
    var selectedCellHeight: Int!
    @IBOutlet weak var contentTableView: ContentTableView!
    
    var arrayNumberSemesters = [ExamsCell]()
    let disposeBag = DisposeBag()
    
    // Вспомогательная структура для отображения данных в виде секции
    var sectionedArrayNumberSemesters = [SectionOfNumberSemesters]()
    struct SectionOfNumberSemesters{
        var header: String
        var items: [ExamsModel]
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupBackButton()
        setupContent()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка контента
    func setupContent(){
        
        var sessionData = [ExamsModel]()
        for _ in 0...10{
            sessionData.append(
                ExamsModel(numberSemester: "1 сессия (весна 2017)", disciplines: [
                DisciplineExamModel(discipline: ("Математика", .differentialСredit, 5)),
                DisciplineExamModel(discipline: ("Информатика", .courseProject, 5)),
                DisciplineExamModel(discipline: ("Английский", .courseWork, 5)),
                DisciplineExamModel(discipline: ("Окружающий", .credit, 5)),
                DisciplineExamModel(discipline: ("Математика", .exam, 5))])
            )
        }
        
        
        for session in sessionData{
            self.sectionedArrayNumberSemesters.append(SectionOfNumberSemesters(header: session.numberSemester,
                                                                               items: [session]))
        }
        
        self.contentTableView.register(UINib(nibName: "ExamsCell", bundle: nil),
                                  forCellReuseIdentifier: "ExamsCellID")
        self.contentTableView.canCancelContentTouches = true
        
        // Конфигурация содержимого для ячеек таблицы
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfNumberSemesters>(configureCell: {
            [weak self] dataSource, table, index, item in
            let cell = table.dequeueReusableCell(withIdentifier: "ExamsCellID", for: index) as! ExamsCell
            cell.layoutIfNeeded()
            cell.parentVC = self
            cell.myIndex = index
            cell.configureCell(data: item)
            return cell
        })
        
        // Связывание данных и таблицы
        Observable.just(self.sectionedArrayNumberSemesters)
            .bind(to: contentTableView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.contentTableView.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
    }
    
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        if self.selectedCellIndex == indexPath {
            return CGFloat(self.selectedCellHeight!)
        }
        return 37
    }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView()
        headerView.backgroundColor = .clear
        return headerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 8.0
    }
    
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let footerView = UIView()
        footerView.backgroundColor = .clear
        return footerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return (section == tableView.numberOfSections - 1) ? 8.0 : 0
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
        print("Деструктор страницы Экзаменов")
    }
}


extension ExamsViewController.SectionOfNumberSemesters: SectionModelType{
    init(original: ExamsViewController.SectionOfNumberSemesters, items: [ExamsModel]) {
        self = original
        self.items = items
    }
}

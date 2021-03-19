//
//  AttestationViewController.swift
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

class AttestationViewController: UIViewController, UITableViewDelegate{
    
    @IBOutlet weak var backButton: UIImageView!
    weak var selectedCell: AttestationCell!
    var selectedCellIndex: IndexPath!
    var selectedCellHeight: Int!
    @IBOutlet weak var contentView: ContentTableView!
    
    var arrayRangeDates = [AttestationCell]()
    let disposeBag = DisposeBag()
    
    // Вспомогательная структура для отображения данных в виде секции
    var sectionedArrayRangeDates = [SectionOfDataRanges]()
    struct SectionOfDataRanges{
        var header: String
        var items: [AttestationModel]
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
        
        var attestationData = [AttestationModel]()
        for _ in 0...10{
            attestationData.append(AttestationModel(dataRange: "21.01.10 - 22.22.22",
                                                    disciplines: [DisciplineModel(discipline: ("Русский", 5)),
                                                                  DisciplineModel(discipline: ("Математика", 4)),
                                                                  DisciplineModel(discipline: ("Информатика", 2)),
                                                                  DisciplineModel(discipline: ("Английский", 3)),
                                                                  DisciplineModel(discipline: ("Окружающий", 3))
                                                                  ]))
        }
        
        
        for attestation in attestationData{
            self.sectionedArrayRangeDates.append(SectionOfDataRanges(header: attestation.dataRange!, items: [attestation]))
        }
        
        self.contentView.register(UINib(nibName: "AttestationCell", bundle: nil),
                                  forCellReuseIdentifier: "AttestationCellID")
        self.contentView.canCancelContentTouches = true
        
        // Конфигурация содержимого для ячеек таблицы
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfDataRanges>(configureCell: {
            [weak self] dataSource, table, index, item in
            let cell = table.dequeueReusableCell(withIdentifier: "AttestationCellID", for: index) as! AttestationCell
            cell.layoutIfNeeded()
            cell.parentVC = self
            cell.myIndex = index
            cell.configureCell(data: item)
            return cell
        })
        
        // Связывание данных и таблицы
        Observable.just(self.sectionedArrayRangeDates)
            .bind(to: contentView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.contentView.rx
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
        let view = UIView()
        view.backgroundColor = .clear
        return view
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 8.0
    }
    
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let view = UIView()
        view.backgroundColor = .clear
        return view
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
        print("Деструктор страницы Аттестации")
    }
}


class ContentTableView: UITableView {

    override func touchesShouldCancel(in view: UIView) -> Bool {
        if view.isKind(of: UIButton.self) {
          return true
        }

        return super.touchesShouldCancel(in: view)
    }
}


extension AttestationViewController.SectionOfDataRanges: SectionModelType{
    init(original: AttestationViewController.SectionOfDataRanges, items: [AttestationModel]) {
        self = original
        self.items = items
    }
}

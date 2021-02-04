//
//  UniversityCorp.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import RxDataSources
import UIKit

class UniversityCorpsView: UIView, UITableViewDelegate{
    
    @IBOutlet weak var corpsTable: UITableView!
    @IBOutlet weak var heightTable: NSLayoutConstraint!
    
    var corpsCount = 0
    let cellHeigth = 44
    let headerHeigth = 26
    var currentSelectedCorpsIndex = IndexPath(item: 0, section: 0)
    let disposeBag = DisposeBag()
    
    struct SectionOfCorps: SectionModelType{
        var header: String
        var items: [UniversityCorp]
        
        
        init(original: UniversityCorpsView.SectionOfCorps, items: [UniversityCorp]) {
            self = original
            self.items = items
        }
        
        init(header: String, items: [UniversityCorp]){
            self.header = header
            self.items = items
        }
    }
    
    func setupView(){
        
        let receivedData = [UniversityCorp(name: "Главный корпус"),
                            UniversityCorp(name: "Механический корпус")]
        self.corpsCount = receivedData.count
        let section = [SectionOfCorps(header: "Корпуса", items: receivedData)]
        
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfCorps>(configureCell: { dataSource, table, index, item in
            table.register(UINib(nibName: "UniversityCorpCellTable", bundle: nil), forCellReuseIdentifier: "UniversityCell")
            let cell = table.dequeueReusableCell(withIdentifier: "UniversityCell", for: index) as! UniversityCorpCellTable
            cell.nameCorpLabel.text = item.name
            cell.selectImageStatus.isHidden = (index.item != self.currentSelectedCorpsIndex.item) ? true : false
            
            let selectedCellView = UIView()
            selectedCellView.backgroundColor = .white
            cell.selectedBackgroundView = selectedCellView
            self.heightTable.constant = CGFloat(self.cellHeigth) * CGFloat(receivedData.count) + CGFloat(self.headerHeigth)
            return cell
        })
        
        Observable.just(section)
            .bind(to: corpsTable.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.corpsTable.rx
            .itemSelected
            .subscribe(onNext: { selectedRowIndex in
                
                let oldSelectedCell = self.corpsTable.cellForRow(at: self.currentSelectedCorpsIndex) as! UniversityCorpCellTable
                oldSelectedCell.selectImageStatus.isHidden = true
                
                let newSelectedCell = self.corpsTable.cellForRow(at: selectedRowIndex) as! UniversityCorpCellTable
                newSelectedCell.selectImageStatus.isHidden = false
                self.currentSelectedCorpsIndex = selectedRowIndex
                
                let userInfo: [String: Any] = ["nameCorp": newSelectedCell.nameCorpLabel.text]
                NotificationCenter.default.post(name: Notification.Name("ChangeCorp"), object: nil, userInfo: userInfo)
            }
        ).disposed(by: disposeBag)
        
        
        self.corpsTable.isScrollEnabled = false
        self.corpsTable.makeRounding()

        self.makeCorpShadow(width: 300, heigth: Int(cellHeigth * receivedData.count + headerHeigth))
        _ = self.corpsTable.rx.setDelegate(self).disposed(by: disposeBag)
    }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let label = UILabel()
        label.setBoldText(placeholderText: "Корпуса")
        return label
    }
}

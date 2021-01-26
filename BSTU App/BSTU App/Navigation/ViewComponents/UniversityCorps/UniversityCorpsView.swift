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
        let section = [SectionOfCorps(header: "Корпуса", items: receivedData)]
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfCorps>(configureCell: { dataSource, table, index, item in
            table.register(UINib(nibName: "UniversityCorpCellTable", bundle: nil), forCellReuseIdentifier: "UniversityCell")
            let cell = table.dequeueReusableCell(withIdentifier: "UniversityCell", for: index) as! UniversityCorpCellTable
            cell.nameCorpLabel.text = item.name
            cell.selectImageStatus.isHidden = (index.item != 0) ? true : false
            self.heightTable.constant = CGFloat(cell.frame.size.height * CGFloat(receivedData.count)) + 26
            return cell
        })
        
        Observable.just(section)
            .bind(to: corpsTable.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.corpsTable.isScrollEnabled = false
        self.corpsTable.makeRounding()
        self.makeShadow(width: 300, heigth: Int(self.heightTable.constant - 60))
        _ = self.corpsTable.rx.setDelegate(self)
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let label = UILabel()
        label.setBoldText(placeholderText: "Корпуса")
        return label
    }
}

class UniversityCorp{
    var name: String!
    init(name: String) {
        self.name = name
    }
}

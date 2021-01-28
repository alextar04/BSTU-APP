//
//  SearchPremiseView.swift
//  BSTU App
//
//  Created by Alexey Taran on 28.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import RxDataSources
import UIKit

class SearchPremiseView: UIView{
    
    @IBOutlet weak var premiseTableView: UITableView!
    @IBOutlet weak var premiseTableViewHeightConstraint: NSLayoutConstraint!
    let disposeBag = DisposeBag()
    
    struct SectionOfPremise: SectionModelType{
        var header: String
        var items: [Premise]
        
        init(original: SearchPremiseView.SectionOfPremise, items: [Premise]) {
            self = original
            self.items = items
        }
        
        init(header: String, items: [Premise]){
            self.header = header
            self.items = items
        }
    }
    
    func setupView(height: CGFloat){
        
        let receivedData = [Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "153a"),
                Premise(type: TypePremise(type: "Гардероб", image: "wardrobe"), name: "Гардероб"),
                Premise(type: TypePremise(type: "Буфет", image: "buffet"), name: "Столовая"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "182"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "Преподавательская"),
                Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "Туалет"),
        ]
        let section = [SectionOfPremise(header: "Кабинеты", items: receivedData)]
        
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfPremise>(configureCell: { dataSource, table, index, item in
            table.register(UINib(nibName: "SearchPremiseCellTable", bundle: nil), forCellReuseIdentifier: "SearchPremiseCellTable")
            let cell = table.dequeueReusableCell(withIdentifier: "SearchPremiseCellTable", for: index) as! SearchPremiseCellTable
            cell.namePremiseLabel.text = item.namePremise
            cell.typePremiseLabel.text = item.typePremise.nameTypePremise
            
            cell.storeyLabel.text = "1 этаж"
            cell.storeyLabel.makeRounding()
            cell.storeyLabel.layer.borderWidth = 3
            cell.storeyLabel.layer.borderColor = UIColor.lightGray.cgColor
            cell.storeyLabel.backgroundColor = .clear
            
            cell.typePremiseImage.image = UIImage(named: item.typePremise.nameImagePremise!)
            cell.typePremiseImage.makeRoundingImage()
            
            return cell
        })
        
        Observable.just(section)
            .bind(to: premiseTableView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        self.premiseTableView.rx
            .itemSelected
            .subscribe(onNext: { selectedRowIndex in
                let selectedCell = self.premiseTableView.cellForRow(at: selectedRowIndex) as! SearchPremiseCellTable
                let userInfo: [String: Any] = ["namePremise": selectedCell.namePremiseLabel.text]
                NotificationCenter.default.post(name: Notification.Name("ChangePremiseLabel"), object: nil, userInfo: userInfo)
            }
        ).disposed(by: disposeBag)
        
        self.premiseTableViewHeightConstraint.constant = height
    }
}

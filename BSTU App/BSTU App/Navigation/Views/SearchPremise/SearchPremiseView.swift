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
    var sections = BehaviorRelay(value: [SearchPremiseView.SectionOfPremise]())
    let disposeBag = DisposeBag()
    
    struct SectionOfPremise: SectionModelType{
        var header: String
        var items: [PremiseDB]
        
        init(original: SearchPremiseView.SectionOfPremise, items: [PremiseDB]) {
            self = original
            self.items = items
        }
        
        init(header: String, items: [PremiseDB]){
            self.header = header
            self.items = items
        }
    }
    
    func setupView(height: CGFloat, parentController: NavigationViewController){
        
        let dataSource = RxTableViewSectionedReloadDataSource<SectionOfPremise>(configureCell: { _, table, index, item in
            table.register(UINib(nibName: "SearchPremiseCellTable", bundle: nil), forCellReuseIdentifier: "SearchPremiseCellTable")
            let cell = table.dequeueReusableCell(withIdentifier: "SearchPremiseCellTable", for: index) as! SearchPremiseCellTable
            let typePremise = parentController.viewModel.getTypePremiseById(id: item.idTypePremise)
            cell.premiseId = item.id
            cell.namePremiseLabel.text = item.description
            cell.typePremiseLabel.text = typePremise.name
            
            cell.storeyLabel.text = String("\(parentController.map.viewModel.getMapById(id: item.idMap).storey!) этаж")
            cell.storeyLabel.makeRounding()
            cell.storeyLabel.layer.borderWidth = 3
            cell.storeyLabel.layer.borderColor = UIColor.lightGray.cgColor
            cell.storeyLabel.backgroundColor = .clear
            
            cell.typePremiseImage.image = UIImage(data: typePremise.picture)
            cell.typePremiseImage.makeRoundingImage()
            
            return cell
        })
        
        self.sections
            .asObservable()
            .bind(to: premiseTableView.rx.items(dataSource: dataSource))
            .disposed(by: disposeBag)
        
        
        self.premiseTableView.rx
            .itemSelected
            .subscribe(onNext: { selectedRowIndex in
                let selectedCell = self.premiseTableView.cellForRow(at: selectedRowIndex) as! SearchPremiseCellTable
                let userInfo: [String: Any] = ["idPremise": selectedCell.premiseId]
                NotificationCenter.default.post(name: Notification.Name("ChangePremiseLabel"), object: nil, userInfo: userInfo)
            }
        ).disposed(by: disposeBag)
        
        self.premiseTableViewHeightConstraint.constant = height
    }
}

//
//  InstitutionsViewController.swift
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

class InstitutionsViewController: UIViewController{
    
    @IBOutlet weak var institutionsTable: UITableView!
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        setupTable()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка таблицы с названиями институтов
    func setupTable(){
        
        let data = Observable.just(["АИ", "КВТ", "ИЭИТУС", "ИЗО", "ИМ", "УПК", "ХТИ"])
        data.bind(to: self.institutionsTable.rx.items){ (tableView, row, element) in
            let cell = self.institutionsTable.dequeueReusableCell(withIdentifier: "InstitutionCell") as! InstitutionsTableCell
            cell.configureCell(name: element)
            return cell
            }.disposed(by: disposeBag)
        
        self.institutionsTable.rx
            .modelSelected(String.self)
            .subscribe(onNext: { selectedItem in
                var result: String = ""
                result = selectedItem
                print(selectedItem)
                
                let groupsController = UIStoryboard(name: "GroupsScreen", bundle: nil)
                    .instantiateViewController(withIdentifier: "GroupsScreenID") as! GroupsViewController
                self.navigationController?.pushViewController(groupsController, animated: true)
            }).disposed(by: disposeBag)
    }
}

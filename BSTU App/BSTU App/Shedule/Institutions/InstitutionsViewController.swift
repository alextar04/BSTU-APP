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
    let viewModel = InstitutionViewModel()
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        
        setupTable()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка таблицы с названиями институтов
    func setupTable(){
        
        viewModel.getInstitutionList(completion: { institutions in
            let data = Observable.just(institutions)
            data.bind(to: self.institutionsTable.rx.items){ (tableView, row, element) in
                let cell = self.institutionsTable.dequeueReusableCell(withIdentifier: "InstitutionCell") as! InstitutionsTableCell
                cell.configureCell(name: element.name, url: element.link)
                return cell
            }.disposed(by: self.disposeBag)
            
            self.institutionsTable.rx
                .modelSelected(Institution.self)
                .subscribe(onNext: { selectedItem in
                    
                    let groupsController = UIStoryboard(name: "GroupsScreen", bundle: nil)
                        .instantiateViewController(withIdentifier: "GroupsScreenID") as! GroupsViewController
                    groupsController.institutionName = selectedItem.name
                    groupsController.link = selectedItem.link
                    self.navigationController?.pushViewController(groupsController, animated: true)
                }).disposed(by: self.disposeBag)
        })
    }
}

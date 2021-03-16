//
//  MenuViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 07.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxDataSources

class MenuViewController: UIViewController{
    
    @IBOutlet weak var menuTableView: UITableView!
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTable()
    }
    
    
    // MARK: Установка отображения контента таблицы
    func setupTable(){
        
        self.view.backgroundColor = UIColor(patternImage: UIImage(named: "background")!)
        let chapters: [ChapterType] = [.schedule,
                                       .navigation,
                                       .teachers,
                                       .cabinet]
        
        let data = Observable.just(chapters)
        data.bind(to: self.menuTableView.rx.items){ (tableView, row, element) in
            let cell = self.menuTableView.dequeueReusableCell(withIdentifier: "MenuTableCellID") as! MenuTableCell
            cell.configureCell(chapterType: element)
            return cell
        }.disposed(by: self.disposeBag)
            
        self.menuTableView.rx
            .modelSelected(ChapterType.self)
            .subscribe(onNext: { selectedItem in
                
                let userInfo: [String: ChapterType] = ["selectedItem": selectedItem]
                NotificationCenter.default.post(name: Notification.Name("ChangeChapter"), object: nil, userInfo: userInfo)
                
            }).disposed(by: self.disposeBag)
        }
    
    }
    

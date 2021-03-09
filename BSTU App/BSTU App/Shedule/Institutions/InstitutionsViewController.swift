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
    
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var statusLoadingLabel: UILabel!
    @IBOutlet weak var reloadButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
    
    @IBOutlet weak var institutionsTable: UITableView!
    let viewModel = InstitutionViewModel()
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        
        setupTable()
        setupReloadButton()
        setupLeftMenuButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка таблицы с названиями институтов
    func setupTable(){
        
        self.institutionsTable.isHidden = true
        self.reloadButton.isHidden = true
        
        viewModel.getInstitutionList(completion: { institutions in
            
            self.statusLoadingLabel.isHidden = true
            self.loadingWheel.isHidden = true
            self.institutionsTable.isHidden = false
            
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
        }, errorClosure: {
            self.statusLoadingLabel.text = "Ошибка загрузки данных"
            self.loadingWheel.isHidden = true
            self.reloadButton.isHidden = false
        })
    }
    
    
    // MARK: Установка кнопки перезагрузки данных
    func setupReloadButton(){
        
        self.reloadButton.rx
            .tap
            .subscribe(onNext: { _ in
                self.statusLoadingLabel.text = "Загрузка данных"
                self.loadingWheel.isHidden = false
                self.reloadButton.isHidden = true
                self.setupTable()
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupLeftMenuButton(){
        
        self.menuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil)
            }).disposed(by: disposeBag)
        
        let leftSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        let rightSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        leftSwipe.direction = .left
        rightSwipe.direction = .right
        self.view.addGestureRecognizer(leftSwipe)
        self.view.addGestureRecognizer(rightSwipe)
    }
    
    
    // MARK: Обработка свайпов экрана
    @objc func handleSwipes(_ sender: UISwipeGestureRecognizer){
        
        switch sender.direction {
        case .left:
            print("Влево")
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: [institutionsTable])
        case .right:
            print("Вправо")
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: [institutionsTable])
        default:
            return
        }
    }
    
}

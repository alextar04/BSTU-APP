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

class InstitutionsViewController: UIViewController, UIGestureRecognizerDelegate{
    
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var statusLoadingLabel: UILabel!
    @IBOutlet weak var reloadButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
    
    @IBOutlet weak var institutionsTable: UITableView!
    let viewModel = InstitutionViewModel()
    
    var isMenuOpen = false
    let disposeBag = DisposeBag()
    
    lazy var listDisablers: [UIView] = [
        self.menuButton, self.institutionsTable
    ]
    
    override func viewDidLoad() {
        
        setupTable()
        setupLeftMenuButton()
        setupReloadButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка таблицы с названиями институтов
    func setupTable(){
        
        self.institutionsTable.isHidden = true
        self.reloadButton.isHidden = true
        
        viewModel.getInstitutionList(completion: { [weak self] institutions in
            
            self!.statusLoadingLabel.isHidden = true
            self!.loadingWheel.isHidden = true
            self!.institutionsTable.isHidden = false
            
            let data = Observable.just(institutions)
            data.bind(to: self!.institutionsTable.rx.items){ (tableView, row, element) in
                let cell = self!.institutionsTable.dequeueReusableCell(withIdentifier: "InstitutionCell") as! InstitutionsTableCell
                cell.configureCell(name: element.name, url: element.link)
                return cell
            }.disposed(by: self!.disposeBag)
            
            self!.institutionsTable.rx
                .modelSelected(Institution.self)
                .subscribe(onNext: { [weak self] selectedItem in
                    
                    let groupsController = UIStoryboard(name: "GroupsScreen", bundle: nil)
                        .instantiateViewController(withIdentifier: "GroupsScreenID") as! GroupsViewController
                    groupsController.institutionName = selectedItem.name
                    groupsController.link = selectedItem.link
                    self!.navigationController?.pushViewController(groupsController, animated: true)
                }).disposed(by: self!.disposeBag)
            
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
            .subscribe(onNext: { [weak self] _ in
                self!.statusLoadingLabel.text = "Загрузка данных"
                self!.loadingWheel.isHidden = false
                self!.reloadButton.isHidden = true
                self!.setupTable()
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupLeftMenuButton(){
        
       let tap = UITapGestureRecognizer(target: self, action: #selector(self.handleTap(_:)))
       self.view.addGestureRecognizer(tap)
       tap.delegate = self
        
       let edgePan = UIScreenEdgePanGestureRecognizer(target: self, action: #selector(self.screenEdgeSwiped))
       edgePan.edges = .left
       self.view.addGestureRecognizer(edgePan)
        
        self.menuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                let userInfo: [String: [UIView]] = ["listDisablers": self!.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self!.isMenuOpen.toggle()
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
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: listDisablers)
            self.isMenuOpen = false
        case .right:
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender, listDisablers: listDisablers)
            self.isMenuOpen = true
        default:
            return
        }
    }
    
    
    // MARK: Действия по открытию меню
    @objc func handleTap(_ sender: UITapGestureRecognizer){
        if self.isMenuOpen{
            let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
            NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
            self.isMenuOpen.toggle()
        }
    }
    

    // MARK: Отмена нажатия на экран при закрытом меню
    func gestureRecognizer(_ gestureRecognizer: UIGestureRecognizer, shouldReceive touch: UITouch) -> Bool {
        if self.isMenuOpen {
            return true
        }
        return false
    }
    
    
    // MARK: Действия по открытию меню из-за пределов экрана
    @objc func screenEdgeSwiped(_ recognizer: UIScreenEdgePanGestureRecognizer) {
        if recognizer.state == .recognized {
            if !self.isMenuOpen{
                let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self.isMenuOpen.toggle()
            }
        }
    }
    
    deinit {
        print("Вызов деструктора страницы институтов!")
    }
}

//
//  PersonalCabinetMainPageViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 15.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import UIKit


class PersonalCabinetMainPageViewController: UIViewController{
    
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var exitButton: UIImageView!
    
    var isMenuOpen = false
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupExitButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }
    
    
    func setupMenuButton(){
        self.menuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                let userInfo: [String: [UIView]] = ["listDisablers": []]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self!.isMenuOpen.toggle()
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Настройка работы кнопки выхода из системы
    func setupExitButton(){
        
        self.exitButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                print("Выход из системы")
        }).disposed(by: disposeBag)
    }
    
    /*
     Функционал:
     Успеваемость: http://cabinet.bstu.ru/api/1.0/progress?dataId=102973 (id - студента)
     Аттестация: http://cabinet.bstu.ru/api/1.0/certification?dataId=102973 (id-студента)
     Расписание: Адреса есть в расписании
     Выход: http://cabinet.bstu.ru/auth/logout
     */
}

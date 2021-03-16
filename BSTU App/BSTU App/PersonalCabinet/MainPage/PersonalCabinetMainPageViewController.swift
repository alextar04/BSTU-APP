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
    
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupExitButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }
    
    
    func setupMenuButton(){
        
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

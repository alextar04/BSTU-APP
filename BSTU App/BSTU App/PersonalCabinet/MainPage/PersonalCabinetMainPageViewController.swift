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
    let viewModel = PersonalCabinetMainPageViewModel()
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupMenuButton()
        self.setupExitButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }
    
    
    // MARK: Авторизация уже имеющегося в базе пользователя
    func makeAutorization(){
        
        let defaults = UserDefaults.standard
        let login = defaults.string(forKey: "login")
        let password = defaults.string(forKey: "password")
        
        viewModel.autorizate(login: login!, password: password!,
                             completion: {
                                print("Подгрузились из кэша!")
        },
                             errorCallback: { [weak self] typeError in
                                var message: String!
                                switch typeError{
                                case .networkError:
                                    message = "Ошибка подключения к Интернету"
                                case .wrongDataError:
                                    message = "Неверный логин или пароль. Попробуйте ещё раз"
                                }
                                                   
                                let dialogMessage = UIAlertController(title: "Вход в систему",
                                                                    message: message,
                                                                    preferredStyle: .alert)
                                let okButton = UIAlertAction(title: "OK", style: .default, handler: { _ in
                                    AppDelegate.appDelegate.rootViewController.successAccountChangeChapter(newPageType: .login)
                                })
                                dialogMessage.addAction(okButton)
                                self!.present(dialogMessage, animated: true, completion: nil)
        })
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
                let dialogExit = UIAlertController(title: "Выход из системы",
                                                      message: nil,
                                                      preferredStyle: .alert)
                let activityIndicator = UIActivityIndicatorView(style: .gray)
                activityIndicator.translatesAutoresizingMaskIntoConstraints = false
                activityIndicator.isUserInteractionEnabled = false
                activityIndicator.startAnimating()

                dialogExit.view.addSubview(activityIndicator)
                dialogExit.view.heightAnchor.constraint(equalToConstant: 95).isActive = true

                activityIndicator.centerXAnchor.constraint(equalTo: dialogExit.view.centerXAnchor, constant: 0).isActive = true
                activityIndicator.bottomAnchor.constraint(equalTo: dialogExit.view.bottomAnchor, constant: -20).isActive = true
                self!.present(dialogExit, animated: true)
                
                self!.viewModel.logout(
                    completion: {
                        dialogExit.dismiss(animated: true, completion: nil)
                    AppDelegate.appDelegate
                        .rootViewController
                        .successAccountChangeChapter(newPageType: .login)
                        
                },
                    errorCallback: { [weak self] _ in
                        dialogExit.dismiss(animated: true, completion: nil)
                        let message = "Ошибка выхода из системы. Повторите попытку."
                        let dialogMessage = UIAlertController(title: "Выход из системы",
                                                              message: message,
                                                              preferredStyle: .alert)
                        let okButton = UIAlertAction(title: "OK", style: .default, handler: nil)
                        dialogMessage.addAction(okButton)
                        self!.present(dialogMessage, animated: true, completion: nil)
                })
        }).disposed(by: disposeBag)
    }
    
    
    deinit{
        print("Вызван деструктор главной страницы кабинета")
    }
    
    /*
     Функционал:
     Успеваемость: http://cabinet.bstu.ru/api/1.0/progress?dataId=102973 (id - студента)
     Аттестация: http://cabinet.bstu.ru/api/1.0/certification?dataId=102973 (id-студента)
     Расписание: Адреса есть в расписании
     Выход: http://cabinet.bstu.ru/auth/logout
     */
}

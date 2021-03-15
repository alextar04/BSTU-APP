//
//  SignInViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 13.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import RxGesture
import UIKit

class SigninViewController: UIViewController{
    
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var loginField: UITextField!
    @IBOutlet weak var passwordField: UITextField!
    
    @IBOutlet weak var signinButton: UIButton!
    @IBOutlet weak var registrationButton: UIButton!
    @IBOutlet weak var forgetPasswordButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
    
    @IBOutlet weak var shadowFeedbackView: UIView!
    @IBOutlet weak var roundedFeedbackView: UIView!
    @IBOutlet weak var feedbackButton: UIButton!
    
    var isMenuOpen = false
    let disposeBag = DisposeBag()
    
    lazy var listDisablers: [UIView] = [self.menuButton,
                                        self.loginField,
                                        self.passwordField,
                                        self.signinButton,
                                        self.registrationButton,
                                        self.forgetPasswordButton,
                                        self.feedbackButton
    ]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupMenuButton()
        setupSigninSettings()
        setupRegistrationButton()
        setupForgetPasswordButton()
        setupFeedbackButton()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }
    
    
    // MARK: Установка компонентов для входа в систему
    func setupSigninSettings(){
        self.signinButton.layoutIfNeeded()
        self.signinButton.makeSigninButtonStyle()
        self.signinButton.makeRoundingButton()
        
        self.view.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self!.view.endEditing(true)
                
                if self!.isMenuOpen{
                    let userInfo: [String: [UIView]] = ["listDisablers": self!.listDisablers]
                    NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                    self?.isMenuOpen.toggle()
                }
                
            }).disposed(by: disposeBag)
        
        self.signinButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                print("Вход в систему!")
                
                /*
                 http://cabinet.bstu.ru/auth/login
                 POST: email, password
                 */
                
                self!.view.endEditing(true)
                self?.loadingWheel.isHidden = false
                self?.signinButton.isHidden = true
                
                let dialogMessage = UIAlertController(title: "Вход в систему",
                                                      message: "Неверный логин или пароль. Попробуйте ещё раз.",
                                                      preferredStyle: .alert)
                let okButton = UIAlertAction(title: "OK", style: .default, handler: { (action) -> Void in
                    print("Ok button tapped")
                })
                dialogMessage.addAction(okButton)
                self!.present(dialogMessage, animated: true, completion: nil)
                
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки регистрации
    func setupRegistrationButton(){
        self.registrationButton.rx
        .tapGesture()
        .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            self!.view.endEditing(true)
            UIApplication.shared.open(URL(string: "http://cabinet.bstu.ru/auth/register")!)
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки "Забыли пароль"
    func setupForgetPasswordButton(){
        self.forgetPasswordButton.rx
        .tapGesture()
        .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            UIApplication.shared.open(URL(string: "http://cabinet.bstu.ru/auth/restore")!)
            self!.view.endEditing(true)
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки "Обратная связь"
    func setupFeedbackButton(){
        self.roundedFeedbackView.layoutIfNeeded()
        self.roundedFeedbackView.makeSigninFeedbackViewStyle()
        self.roundedFeedbackView.makeRounding()
        
        self.feedbackButton.rx
        .tapGesture()
        .when(.recognized)
        .subscribe(onNext: { [weak self] _ in
            UIApplication.shared.open(URL(string: "http://support.bstu.ru/")!)
            self!.view.endEditing(true)
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupMenuButton(){
        
        self.menuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                let userInfo: [String: [UIView]] = ["listDisablers": self!.listDisablers]
                NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
                self?.isMenuOpen.toggle()
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
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender,
                                                                         listDisablers: self.listDisablers)
            self.isMenuOpen = false
        case .right:
            AppDelegate.appDelegate.rootViewController.currentViewMoving(recognizer: sender,
                                                                         listDisablers: self.listDisablers)
            self.isMenuOpen = true
        default:
            return
        }
    }
    
    deinit {
        print("Вызов деструктора Окна входа в ЛК")
    }
}

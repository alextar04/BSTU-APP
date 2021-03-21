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


class PersonalCabinetMainPageViewController: UIViewController, UIGestureRecognizerDelegate{
    
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var headerName: UILabel!
    @IBOutlet weak var exitButton: UIImageView!
    @IBOutlet weak var scrollView: UIScrollView!
    
    @IBOutlet weak var educationalInformationView: UIView!
    @IBOutlet weak var instituteName: UILabel!
    @IBOutlet weak var groupName: UILabel!
    @IBOutlet weak var numberRecordBookValue: UILabel!
    @IBOutlet weak var numberRecordBookLabel: UILabel!
    @IBOutlet weak var numberRecordBookWidthConstraint: NSLayoutConstraint!
    @IBOutlet weak var typePerson: UILabel!
    @IBOutlet weak var educationForm: UILabel!
    @IBOutlet weak var educationType: UILabel!
    
    @IBOutlet weak var containerPersonalInformationView: UIView!
    @IBOutlet weak var containerPersonalInformationViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var personalInformationView: UIView!
    @IBOutlet weak var personalInformationViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var togglerPersonalInformation: UIButton!
    @IBOutlet weak var togglerImage: UIImageView!
    @IBOutlet weak var birthday: UILabel!
    @IBOutlet weak var gender: UILabel!
    @IBOutlet weak var citizenship: UILabel!
    @IBOutlet weak var telephone: UILabel!
    @IBOutlet weak var email: UILabel!
    @IBOutlet weak var snils: UILabel!
    var personalInformationViewIsOpen = false
    
    @IBOutlet weak var chaptersTableHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var chaptersTable: UITableView!
    
    var isMenuOpen = false
    var personalCabinetData: PersonalCabinetMainPageModel? = nil
    let viewModel = PersonalCabinetMainPageViewModel()
    let disposeBag = DisposeBag()
    
    lazy var listDisablers: [UIView] = [
        self.menuButton, self.headerName, self.exitButton,
        self.educationalInformationView, self.containerPersonalInformationView,
        self.chaptersTable
    ]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setupEducationalInformationDisplay()
        self.setupPersonalInformationDisplay()
        
        if personalCabinetData != nil{
            self.setupEducationalInformation(model: personalCabinetData!)
            self.setupPersonalInformation(model: personalCabinetData!)
        }
        
        self.setupChaptersTable()
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
                             completion: { [weak self] model in
                                
                                print("Подгрузились из кэша!")
                                self!.personalCabinetData = model
                                self!.setupEducationalInformation(model: self!.personalCabinetData!)
                                self!.setupPersonalInformation(model: self!.personalCabinetData!)
        },
                             errorCallback: { [weak self] typeError in
                                var message: String!
                                switch typeError{
                                case .networkError:
                                    message = "Ошибка подключения к Интернету"
                                case .serverError:
                                    message = "Ошибка сервера"
                                case .wrongDataError:
                                    message = "Неверный логин или пароль. Попробуйте ещё раз"
                                }
                                                   
                                let dialogMessage = UIAlertController(title: "Вход в систему",
                                                                    message: message,
                                                                    preferredStyle: .alert)
                                let okButton = UIAlertAction(title: "OK", style: .default, handler: { _ in
                                    if typeError == .wrongDataError{
                                        AppDelegate.appDelegate.rootViewController.successAccountChangeChapter(newPageType: .login,
                                                                                                               personalCabinetData: nil)
                                    }
                                })
                                dialogMessage.addAction(okButton)
                                self!.present(dialogMessage, animated: true, completion: nil)
        })
    }
    
    
    // MARK: Настройка отображения раздела информации об образовательном процессе
    func setupEducationalInformationDisplay(){
        
        self.educationalInformationView.frame = CGRect(x: 16, y: 0,
                                                        width: self.view.frame.width - 32,
                                                        height: self.educationalInformationView.frame.height)
        self.educationalInformationView.layoutIfNeeded()
        self.educationalInformationView.makeRounding()
        self.educationalInformationView.addViewBlueGradientStyle()
    }
    
    
    // MARK: Настройка информации раздела информации об образовательном процессе
    func setupEducationalInformation(model: PersonalCabinetMainPageModel){
        
        self.instituteName.text = model.instituteName
        self.groupName.text = model.groupName
        self.numberRecordBookValue.text = model.numberRecordBookValue
        if numberRecordBookValue.isTruncated(){
            self.numberRecordBookLabel.text = "Номер ЗК: "
            self.numberRecordBookWidthConstraint.constant = 96
        } else {
            self.numberRecordBookWidthConstraint.constant = 212
        }
        self.typePerson.text = model.typePerson
        self.educationForm.text = model.educationForm
        self.educationType.text = model.educationType
    }
    
    
    // MARK: Настройка отображения раздела личной информации
    func setupPersonalInformationDisplay(){
        
        self.containerPersonalInformationView.frame = CGRect(x: 16, y: 0,
                                                        width: self.view.frame.width - 32,
                                                        height: containerPersonalInformationViewHeightConstraint.constant)
        self.containerPersonalInformationView.layoutIfNeeded()
        
        self.containerPersonalInformationView.makeRounding()
        self.containerPersonalInformationView.addViewBlueGradientStyle()
        self.personalInformationView.addViewBlueGradientStyle()
        
        self.containerPersonalInformationViewHeightConstraint.constant = 31
        self.personalInformationViewHeightConstraint.constant = 0
        
        let dropInDropOutClosure = { [weak self] in
            
            var newValueContainerHeight: CGFloat!
            var newValueHeight: CGFloat!
            if self!.personalInformationViewIsOpen{
                newValueContainerHeight = 31
                newValueHeight = 0
            } else{
                newValueContainerHeight = 214
                newValueHeight = 183
            }
            
            UIView.animate(
                withDuration: 0.4,
                delay: 0,
                usingSpringWithDamping: 1,
                initialSpringVelocity: 1,
            options: .curveEaseIn,
            animations: {
              self!.containerPersonalInformationViewHeightConstraint.constant = newValueContainerHeight
              self!.personalInformationViewHeightConstraint.constant = newValueHeight
                
              (!self!.personalInformationViewIsOpen) ?
                (self!.togglerImage.image = UIImage(named: "dropup")) : (self!.togglerImage.image = UIImage(named: "dropdown"))
                
              self!.view.layoutIfNeeded()
            }, completion: { [weak self] _ in
                self!.personalInformationViewIsOpen.toggle()
            })
        }
        
        self.togglerPersonalInformation.rx
            .tap
            .subscribe(onNext: { [weak self] _ in
                dropInDropOutClosure()
            }).disposed(by: disposeBag)
        
        togglerImage.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                dropInDropOutClosure()
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Настройка информации раздела личной информации
    func setupPersonalInformation(model: PersonalCabinetMainPageModel){
        
        self.headerName.text = model.headerName
        self.birthday.text = model.birthday
        self.gender.text = model.gender
        self.citizenship.text = model.citizenship
        self.telephone.text = model.telephone
        self.email.text = model.email
        self.snils.text = model.snils
    }
    
    
    // MARK: Настройка таблицы с разделами
    func setupChaptersTable(){
        
        self.chaptersTable.register(UINib(nibName: "PersonalCabinetChapterCard", bundle: nil), forCellReuseIdentifier: "PersonalCabinetChapterCardID")
        
        // Высота таблицы = количество разделов * высота одной ячейки
        let chapters: [TypePersonalCabinetChapter] = [.attestation,
                                                      .exams,
                                                      .schedule]
        self.chaptersTableHeightConstraint.constant = CGFloat(chapters.count * 80)
        
        Observable.just(chapters).bind(to: self.chaptersTable.rx.items){
            [weak self] (tableView, row, element) in
            let cell = self!.chaptersTable.dequeueReusableCell(withIdentifier: "PersonalCabinetChapterCardID") as! PersonalCabinetChapterCard
            cell.frame = CGRect(x: 0, y: 0,
                                width: self!.chaptersTable.frame.width, height: 80)
            cell.layoutIfNeeded()
            cell.configureCell(typePersonalCabinetChapter: element)
            return cell
        }.disposed(by: self.disposeBag)
        
        self.chaptersTable.rx
            .modelSelected(TypePersonalCabinetChapter.self)
            .subscribe(onNext: { selectedItem in
                switch selectedItem{
                case .attestation:
                    let attestationController = UIStoryboard(name: "AttestationViewController", bundle: nil)
                        .instantiateViewController(withIdentifier: "AttestationViewControllerID") as! AttestationViewController
                    self.navigationController?.pushViewController(attestationController, animated: true)
                case .exams:
                    let examController = UIStoryboard(name: "ExamsViewController", bundle: nil)
                        .instantiateViewController(withIdentifier: "ExamsViewControllerID") as! ExamsViewController
                    self.navigationController?.pushViewController(examController, animated: true)
                case .schedule:
                    let groupsSheduleController = UIStoryboard(name: "GroupSheduleViewController", bundle: nil)
                        .instantiateViewController(withIdentifier: "GroupSheduleViewControllerID") as! GroupSheduleViewController
                    groupsSheduleController.groupName = self.groupName.text
                    self.navigationController?.pushViewController(groupsSheduleController, animated: true)
                }
            }).disposed(by: self.disposeBag)
    }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupMenuButton(){
        
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
                        .successAccountChangeChapter(newPageType: .login,
                                                     personalCabinetData: nil)
                },
                    errorCallback: { [weak self] _ in
                            let message = "Ошибка выхода из системы. Повторите попытку."
                            let dialogMessage = UIAlertController(title: "Выход из системы",
                                                                  message: message,
                                                                  preferredStyle: .alert)
                            let okButton = UIAlertAction(title: "OK", style: .default, handler: nil)
                            dialogMessage.addAction(okButton)
                            dialogExit.dismiss(animated: true, completion: {
                                self!.present(dialogMessage, animated: true, completion: nil)
                            })
                    }
                )
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

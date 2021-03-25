//
//  ListTeachersFirstLettersViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift


class ListTeachersFirstLettersViewController: UIViewController, UIGestureRecognizerDelegate, UICollectionViewDelegate{
    
    var isMenuOpen = false
    @IBOutlet weak var menuButton: UIImageView!
    @IBOutlet weak var statusLoadingLabel: UILabel!
    @IBOutlet weak var reloadButton: UIButton!
    @IBOutlet weak var loadingWheel: UIActivityIndicatorView!
    
    @IBOutlet weak var collectionFirstLetters: UICollectionView!
    
    let viewModel = ListTeachersFirstLettersViewModel()
    let disposeBag = DisposeBag()
    lazy var listDisablers: [UIView] = [self.menuButton,
                                        self.collectionFirstLetters
    ]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.collectionFirstLetters.isHidden = true
        self.reloadButton.isHidden = true
        self.setupReloadButton()
        self.setupMenuButton()
        
        self.viewModel.getFirstLetters(
            completion: { [weak self] letters in
                self!.statusLoadingLabel.isHidden = true
                self!.loadingWheel.isHidden = true
                self!.collectionFirstLetters.isHidden = false
                                                        
                self!.setupFirstLetterCollection(letters)
                                    
            }, errorClosure: { [weak self] _ in
                self!.statusLoadingLabel.text = "Ошибка загрузки данных"
                self!.loadingWheel.isHidden = true
                self!.reloadButton.isHidden = false
        })
            
            self.navigationController?.setNavigationBarHidden(true, animated: true)
            self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка кнопки перезагрузки данных
    func setupReloadButton(){
        
        self.reloadButton.rx
            .tap
            .subscribe(onNext: { [weak self] _ in
                self!.statusLoadingLabel.text = "Загрузка данных"
                self!.loadingWheel.isHidden = false
                self!.reloadButton.isHidden = true
                
                self!.viewModel.getFirstLetters(
                    completion: { [weak self] letters in
                        self!.statusLoadingLabel.isHidden = true
                        self!.loadingWheel.isHidden = true
                        self!.collectionFirstLetters.isHidden = false
                                                                
                        self!.setupFirstLetterCollection(letters)
                                            
                    }, errorClosure: { [weak self] _ in
                        self!.statusLoadingLabel.text = "Ошибка загрузки данных"
                        self!.loadingWheel.isHidden = true
                        self!.reloadButton.isHidden = false
                })
                
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка таблицы с первыми буквами преподавателей
    func setupFirstLetterCollection(_ listLetters: [String]){
        
        Observable.just(listLetters).bind(to: self.collectionFirstLetters.rx.items){
            collection, row, item in
            let cell = collection.dequeueReusableCell(withReuseIdentifier: "TeacherFirstLetterCell", for: IndexPath.init(row: row, section: 0)) as! TeacherFirstLetterCell
            
            cell.layoutIfNeeded()
            cell.configureCell(name: item)
            return cell
        }.disposed(by: disposeBag)
        
        
        self.collectionFirstLetters.rx.modelSelected(String.self).subscribe(
                onNext: {selectedItem in
                    
                    let teachersController = UIStoryboard(name: "ListTeachers", bundle: nil)
                        .instantiateViewController(withIdentifier: "ListTeachersID") as! ListTeachersViewController
                    teachersController.letter = selectedItem
                    self.navigationController?.pushViewController(teachersController, animated: true)
                    
        }).disposed(by: disposeBag)
     }
    
    
    // MARK: Установка кнопки открытия бокового меню
    func setupMenuButton(){
        
        let closeMenuTap = UITapGestureRecognizer(target: self, action: #selector(self.closeMenu(_:)))
        self.view.addGestureRecognizer(closeMenuTap)
        closeMenuTap.delegate = self
        
        let edgePan = UIScreenEdgePanGestureRecognizer(target: self, action: #selector(self.screenEdgeSwiped))
        edgePan.edges = .left
        self.view.addGestureRecognizer(edgePan)
        
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
    
    
    // MARK: Закрытие меню
    @objc func closeMenu(_ sender: UITapGestureRecognizer){
        self.view.endEditing(true)

        if self.isMenuOpen{
            let userInfo: [String: [UIView]] = ["listDisablers": self.listDisablers]
            NotificationCenter.default.post(name: Notification.Name("SwitchLeftMenu"), object: nil, userInfo: userInfo)
            self.isMenuOpen.toggle()
        }
    }
    
    deinit {
        print("Вызван деструктор Список первых букв преподавателей")
    }
    
}

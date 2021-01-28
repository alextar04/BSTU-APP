//
//  TopBarNavigation.swift
//  MapSection
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxGesture

class TopBarNavigation: UIView{
    
    @IBOutlet weak var nameCorpLabel: UILabel!
    @IBOutlet weak var chooseCorpButton: UIImageView!
    var chooseCorpButtonIsActive: Bool = false
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    
    var universityCorpView: UniversityCorpsView!
    var chooseCorpBackground: UIView!
    
    var tablePremiseView: SearchPremiseView? = nil
    var backButton: UIButton? = nil
    var navigationControllerHeight: CGFloat!
    var keyboardHeight: CGFloat!
    
    let disposeBag = DisposeBag()
    
    
    func setupView(navigationControllerHeight: CGFloat){
        
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        NotificationCenter.default.addObserver(self, selector: #selector(changePremiseLabel), name: Notification.Name("ChangePremiseLabel"), object: nil)
        
        self.chooseCorpButton.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                
                var delay = 0.0
                if self.tablePremiseView != nil{
                    self.endEditingData()
                    delay = 0.3
                }
                
                // Экран под окном выбора корпуса
                self.setGrayScreenUnderCorpChoosenView(delay: delay)
                    
                if self.universityCorpView == nil{
                    self.universityCorpView = Bundle.main.loadNibNamed("UniversityCorpsView", owner: self, options: nil)?.first as? UniversityCorpsView
                    self.universityCorpView?.setupView()
                }
                
                let cellHeight = self.universityCorpView.cellHeigth
                let headerHeight = self.universityCorpView.headerHeigth
                let countCells = self.universityCorpView.corpsCount
                let parentVC = self.parentViewController
                self.universityCorpView?.frame = CGRect(x: (Double((parentVC?.view.frame.size.width)!) / 2) - 150,
                                                       y: Double((parentVC?.view.frame.size.height)!),
                                                       width: 300,
                                                       height: Double(cellHeight * countCells) + Double(headerHeight))
                
                parentVC!.view.addSubview(self.universityCorpView!)
                    
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self.universityCorpView?.frame = self.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: -CGFloat((cellHeight * countCells) + headerHeight + 20)) as! CGRect
                    }
                animator.startAnimation(afterDelay: TimeInterval(delay))
                
        }).disposed(by: disposeBag)
        
        self.navigationControllerHeight = navigationControllerHeight
        customizationSelectionFormPlaceTap()
    }
    
    
    // MARK: Экран под окном выбора корпуса
    func setGrayScreenUnderCorpChoosenView(delay: Double){
        let parentVC = self.parentViewController
        self.chooseCorpBackground = UIView()
        chooseCorpBackground.frame = CGRect(x: 0, y: 0,
                                            width: Double((parentVC?.view.frame.width)!),
                                            height: Double((parentVC?.view.frame.height)!))
        chooseCorpBackground.backgroundColor = .clear
        parentVC!.view.addSubview(chooseCorpBackground)
        
        UIView.animate(withDuration: 0.3, delay: delay, animations: {
            self.chooseCorpBackground.backgroundColor = .corpBackgroundGrayColor
        })
        
        chooseCorpBackground.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                let cellHeight = self.universityCorpView.cellHeigth
                let headerHeight = self.universityCorpView.headerHeigth
                let countCells = self.universityCorpView.corpsCount
                let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                    self.universityCorpView?.frame = self.universityCorpView?.frame
                        .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + headerHeight + 30)) as! CGRect
                }
                animator.startAnimation()
                
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self.chooseCorpBackground.backgroundColor = .clear
                },
                               completion: { _ in
                                self.chooseCorpBackground.removeFromSuperview()
                })
            })
            .disposed(by: disposeBag)
    }
    
    
    // MARK: Закрытие экрана под окном выбора корпуса
    func closeGrayScreenUnderCorpChoosenView(){
        UIView.animate(withDuration: 0.3,
                       animations: {
                        self.chooseCorpBackground.backgroundColor = .clear
        },
                       completion: { _ in
                        self.chooseCorpBackground.removeFromSuperview()
        })
    }
    
    
    // MARK: Обработка нажатия на форму выбора кабинета
    func customizationSelectionFormPlaceTap(){
        [self.startPlaceTextField, self.finishPlaceTextField].map{
            $0?.rx.tapGesture()
                .when(.recognized)
                .subscribe(onNext: { _ in
                    
                    if self.startPlaceTextField.text == "Откуда"{
                        self.startPlaceTextField.text = ""
                    }
                    
                    if self.finishPlaceTextField.text == "Куда"{
                        self.finishPlaceTextField.text = ""
                    }
                    
                    let timeForBindings = self.tablePremiseView == nil
                    
                    if self.tablePremiseView == nil{
                        self.tablePremiseView = Bundle.main.loadNibNamed("SearchPremiseView", owner: self, options: nil)?.first as? SearchPremiseView
                        let tableHeight = self.navigationControllerHeight - self.keyboardHeight - (self.frame.height + (self.window?.safeAreaInsets.top)!)
                        self.tablePremiseView?.setupView(height: tableHeight)
                        self.tablePremiseView?.frame = CGRect(x: 0, y: self.frame.height + (self.window?.safeAreaInsets.top)!,
                                                          width: self.frame.width,
                                                          height: tableHeight)
                        self.parentViewController?.view.addSubview(self.tablePremiseView!)
                    }
                    
                    // Кнопка "Назад"
                    if self.backButton == nil{
                        self.backButton = UIButton()
                        self.backButton!.makeCancelPremiseInputtingView()
                        
                        self.backButton!.frame = CGRect(x: self.center.x - 60, y: self.navigationControllerHeight - self.keyboardHeight - 50,
                                                  width: 120, height: 40)
                        self.parentViewController?.view.addSubview(self.backButton!)
                    }
                    
                    if timeForBindings{
                        self.backButton!.rx.tap.bind{
                            self.endEditingData()
                        }.disposed(by: self.disposeBag)
                    }
                }).disposed(by: disposeBag)
            }
        }
    
    
    // MARK: Изменение точки отправления/назначения
    @objc func changePremiseLabel(_ notification: NSNotification){
        let labelText = notification.userInfo!["namePremise"] as? String
        self.startPlaceTextField.isEditing ? (self.startPlaceTextField.text = labelText) : (self.finishPlaceTextField.text = labelText)
        endEditingData()
        
        // Камера!!!
    }
    
    
    // MARK: Завершение редактирования данных
    func endEditingData(){
        self.startPlaceTextField.endEditing(true)
        self.finishPlaceTextField.endEditing(true)
        
        self.tablePremiseView!.removeFromSuperview()
        self.backButton!.removeFromSuperview()
        self.tablePremiseView = nil
        self.backButton = nil
    }
    
    }

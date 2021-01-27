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
    let disposeBag = DisposeBag()
    
    func setupView(){
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        
        self.chooseCorpButton.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                    
                // Экран под окном выбора корпуса
                self.setGrayScreenUnderCorpChoosenView()
                    
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
                animator.startAnimation()
                
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: Экран под окном выбора корпуса
    func setGrayScreenUnderCorpChoosenView(){
        let parentVC = self.parentViewController
        self.chooseCorpBackground = UIView()
        chooseCorpBackground.frame = CGRect(x: 0, y: 0,
                                            width: Double((parentVC?.view.frame.width)!),
                                            height: Double((parentVC?.view.frame.height)!))
        chooseCorpBackground.backgroundColor = .clear
        parentVC!.view.addSubview(chooseCorpBackground)
        
        UIView.animate(withDuration: 0.3) {
            self.chooseCorpBackground.backgroundColor = .corpBackgroundGrayColor
        }
        
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
    
}

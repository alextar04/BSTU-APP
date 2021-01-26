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
    
    @IBOutlet weak var nameHousingLabel: UILabel!
    @IBOutlet weak var chooseCorpButton: UIImageView!
    var chooseCorpButtonIsActive: Bool = false
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    
    var universityCorpView: UniversityCorpsView!
    let disposeBag = DisposeBag()
    
    func setupView(){
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        
        self.chooseCorpButton.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                if !self.chooseCorpButtonIsActive{
                    self.universityCorpView = Bundle.main.loadNibNamed("UniversityCorpsView", owner: self, options: nil)?.first as? UniversityCorpsView
                    let parentVC = self.parentViewController
                    let cellHeight: Int = 44
                    let countCells: Int = 2
                    self.universityCorpView?.frame = CGRect(x: (Double((parentVC?.view.frame.size.width)!) / 2) - 150,
                                                       y: Double((parentVC?.view.frame.size.height)!),
                                                       width: 300,
                                                       height: Double(cellHeight * countCells) + 26)
                    self.universityCorpView?.setupView()
                    self.parentViewController?.view.addSubview(self.universityCorpView!)
                    
                    let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                        self.universityCorpView?.frame = self.universityCorpView?.frame
                            .offsetBy(dx: 0, dy: -CGFloat((cellHeight * countCells) + 46)) as! CGRect
                    }
                    animator.startAnimation()
                    self.chooseCorpButtonIsActive = true
                } else {
                    let cellHeight: Int = 44
                    let countCells: Int = 2
                    let animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
                        self.universityCorpView?.frame = self.universityCorpView?.frame
                            .offsetBy(dx: 0, dy: CGFloat((cellHeight * countCells) + 56)) as! CGRect
                    }
                    animator.startAnimation()
                    animator.addCompletion({ _ in
                        let subviews = self.parentViewController?.view.subviews
                        for view in subviews!{
                            if view is UniversityCorpsView{
                                view.removeFromSuperview()
                            }
                        }
                    })
                    self.chooseCorpButtonIsActive = false
                }
                
        }).disposed(by: disposeBag)
    }
    
    
}

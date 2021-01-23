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
    @IBOutlet weak var chooseCorp: UIImageView!
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    
    let disposeBag = DisposeBag()
    
    func setupView(){
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
        
        self.chooseCorp.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                print("Тапнулся")
                //let universityCorpView = Bundle.main.loadNibNamed("UniversityCorps", owner: self, options: nil)?.first as? UniversityCorp
        }).disposed(by: disposeBag)
    }
    
    
}

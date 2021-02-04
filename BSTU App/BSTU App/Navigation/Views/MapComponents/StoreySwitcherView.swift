//
//  StoreySwitcher.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa

class StoreySwitcherView: UIView{
    
    @IBOutlet weak var storeyUpButton: UIImageView!
    @IBOutlet weak var storeyNumberLabel: UILabel!
    @IBOutlet weak var storeyDownButton: UIImageView!
    var noMoreUp = false
    var noMoreDown = false
    
    let disposeBag = DisposeBag()
    
    func setupView(rangeStorey: ClosedRange<Int>){
    
        self.storeyNumberLabel.text = "1"
        
        self.storeyUpButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                var currentValue = Int(self.storeyNumberLabel.text!)
                if self.noMoreUp{
                    self.storeyUpButton.image = UIImage(named: "storeyUpNoMore")
                } else {
                    currentValue! += 1
                    self.storeyNumberLabel.text = String(currentValue!)
                    if (currentValue! + 1) > rangeStorey.max()!{
                        self.storeyUpButton.image = UIImage(named: "storeyUpNoMore")
                        self.noMoreUp = true
                    } else {
                        self.storeyDownButton.image = UIImage(named: "storeyDown")
                        self.noMoreDown = false
                        self.storeyUpButton.image = UIImage(named: "storeyUp")
                        self.noMoreUp = false
                    }
                }
            }).disposed(by: disposeBag)
        
        self.storeyDownButton.rx
        .tapGesture()
        .when(.recognized)
        .subscribe(onNext: { _ in
            var currentValue = Int(self.storeyNumberLabel.text!)
            if self.noMoreDown{
                self.storeyDownButton.image = UIImage(named: "storeyDownNoMore")
            } else {
                currentValue! -= 1
                self.storeyNumberLabel.text = String(currentValue!)
                if (currentValue! - 1) < rangeStorey.min()!{
                    self.storeyDownButton.image = UIImage(named: "storeyDownNoMore")
                    self.noMoreDown = true
                } else {
                    self.storeyDownButton.image = UIImage(named: "storeyDown")
                    self.noMoreDown = false
                    self.storeyUpButton.image = UIImage(named: "storeyUp")
                    self.noMoreUp = false
                }
            }
        }).disposed(by: disposeBag)
        
    }
    
}

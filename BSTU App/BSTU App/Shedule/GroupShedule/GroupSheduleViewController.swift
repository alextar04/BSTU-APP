//
//  GroupSheduleViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxGesture

class GroupSheduleViewController: UIViewController{
    
    @IBOutlet weak var currentDayOfWeek: UILabel!
    
    @IBOutlet weak var parityOfWeek: UILabel!
    @IBOutlet weak var parityDropdownButton: UIImageView!
    
    @IBOutlet weak var dateStackView: UIStackView!
    @IBOutlet weak var sheduleTable: UIScrollView!
    
    var dateSegmentedControl: DateSegmentedControl!
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setSettingsForDateSegmentedControl()
        setSheduleTableContent()
        setSettingsChangeDate()
    }
    
    
    // MARK: Настройки для панели дат
    func setSettingsForDateSegmentedControl(){
        self.dateSegmentedControl = DateSegmentedControl()
        dateSegmentedControl.setupView(stackView: self.dateStackView)
    }
    
    
    // MARK: Установка контента в таблицу
    func setSheduleTableContent(){
        
        // Загрузка карточки
        var cardHeight: CGFloat!
        for index in 0...5{
            let subjectCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
            cardHeight = (subjectCard?.frame.height)!
            var yStart: CGFloat = 8
            index != 0 ? (yStart = 8 + (8 + cardHeight) * CGFloat(index)) : (yStart = 8)
            subjectCard!.frame = CGRect(x: 10, y: yStart,
                                        width: self.sheduleTable.frame.width - 20,
                                        height: cardHeight)
            subjectCard!.setupView()
            self.sheduleTable.addSubview(subjectCard!)
        }
        
        sheduleTable.autoresizesSubviews = false
        sheduleTable.contentSize = CGSize(width: self.view.frame.width, height: 8 + (cardHeight + 8) * 6)
    }
    
    
    // MARK: Настройки свайпов смены даты
    func setSettingsChangeDate(){
        
        sheduleTable
            .rx
            .anyGesture(.swipe(direction: .left))
            .when(.recognized)
            .subscribe(onNext: { gesture in
                self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView, direction: .left)
            }).disposed(by: disposeBag)
        
        
        sheduleTable
        .rx
            .anyGesture(.swipe(direction: .right))
        .when(.recognized)
        .subscribe(onNext: { gesture in
            self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView, direction: .right)
        }).disposed(by: disposeBag)
    }
    
    
}

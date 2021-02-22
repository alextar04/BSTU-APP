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
    var currentPage: UIView!
    var currentSelectedIndex: Int!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setSettingsForDateSegmentedControl()
        setSettingsSheduleTable()
    }
    
    
    // MARK: Настройки для панели дат
    func setSettingsForDateSegmentedControl(){
        self.dateSegmentedControl = DateSegmentedControl()
        dateSegmentedControl.setupView(stackView: self.dateStackView)
    }
    
    
    // MARK: Установка настроек отображения контента в таблице
    func setSettingsSheduleTable(){
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeDay), name: Notification.Name("ChangeDay"), object: nil)
        
        let templateCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        let cardHeight = (templateCard?.frame.height)!
        let offsetBetweenCards: CGFloat = 8
        
        self.currentPage = createViewForSheduleTable(number: "0",
                                                     frame: CGRect(x: 0, y: 0,
                                                                   width: self.sheduleTable.frame.width,
                                                                   height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6))
        self.currentSelectedIndex = 0
        self.sheduleTable.addSubview(self.currentPage)
        sheduleTable.autoresizesSubviews = false
        sheduleTable.contentSize = CGSize(width: self.view.frame.width, height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6)
    }
    
    
    // MARK: Создание вида для таблицы расписаний
    func createViewForSheduleTable(number: String, frame: CGRect)->UIView{
        
        let outputView = UIView(frame: frame)
        
        // Получение параметров карточки
        let templateCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        let cardHeight = (templateCard?.frame.height)!
        let offsetBetweenCards: CGFloat = 8
        
        // Загрузка карточек
        for index in 0...5{
            let subjectCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
            var yStart: CGFloat = 8
            index != 0 ? (yStart = offsetBetweenCards + (offsetBetweenCards + cardHeight) * CGFloat(index)) : (yStart = offsetBetweenCards)
            subjectCard!.frame = CGRect(x: 10, y: yStart,
                                            width: self.sheduleTable.frame.width - 20,
                                            height: cardHeight)
            subjectCard!.setupView()
            subjectCard?.typeLesson.text! += number
            outputView.addSubview(subjectCard!)
        }
            
        let leftSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        let rightSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
        leftSwipe.direction = .left
        rightSwipe.direction = .right
        outputView.addGestureRecognizer(leftSwipe)
        outputView.addGestureRecognizer(rightSwipe)
        
        return outputView
    }
    
    
    // MARK: Обработка свайпов при выборе новой даты
    @objc func handleSwipes(_ sender: UISwipeGestureRecognizer)
    {
        // Загрузка правого окна
        if sender.direction == .left
        {
           let currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
           let maxIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.numberOfSegments-1
           if currentSelectedIndex + 1 <= maxIndex{
                self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView, direction: .increment)
                self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
                loadViewFromRightSide()
           }
        }

        // Загрузка левого окна
        if sender.direction == .right
        {
           let currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
           if currentSelectedIndex > 0{
                self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView,  direction: .decrement)
                self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
                loadViewFromLeftSide()
           }
        }
    }
    
    
    // MARK: Открытие представления с левой стороны
    func loadViewFromLeftSide(){
        
        let templateCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        let cardHeight = (templateCard?.frame.height)!
        let offsetBetweenCards: CGFloat = 8
        
        // Анимация: Текущее расписание перемещается вправо
        // На его месте появляется новое
        let preventPage = createViewForSheduleTable(number: String(Int.random(in: 0...10)),
                                                    frame: CGRect(x: -self.sheduleTable.frame.width, y: 0,
                                                                width: self.sheduleTable.frame.width,
                                                                height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6))
        self.sheduleTable.addSubview(preventPage)
            
        let animatorSwitcherTableSheduleContent = UIViewPropertyAnimator(duration: 0.4, dampingRatio: 10.0){
            self.currentPage.isUserInteractionEnabled = false
            preventPage.isUserInteractionEnabled = false
            self.currentPage?.frame = self.currentPage?.frame
                .offsetBy(dx: self.view.frame.width, dy: 0) as! CGRect
            preventPage.frame = preventPage.frame
                .offsetBy(dx: self.view.frame.width, dy: 0) as! CGRect
        }
        
        self.sheduleTable.contentOffset = CGPoint(x: 0, y: 0)
        animatorSwitcherTableSheduleContent.startAnimation()
        animatorSwitcherTableSheduleContent.addCompletion{ _ in
            self.currentPage.removeFromSuperview()
            self.currentPage = preventPage
            self.currentPage.isUserInteractionEnabled = true
        }
    }
    
    
    // MARK: Открытие представления с правой стороны
    func loadViewFromRightSide(){
        
        let templateCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        let cardHeight = (templateCard?.frame.height)!
        let offsetBetweenCards: CGFloat = 8
        
        // Анимация: Текущее расписание перемещается влево
        // На его месте появляется новое
        let nextPage = createViewForSheduleTable(number: String(Int.random(in: 0...10)),
                                                 frame: CGRect(x: self.sheduleTable.frame.width, y: 0,
                                                               width: self.sheduleTable.frame.width,
                                                               height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6))
        self.sheduleTable.addSubview(nextPage)
        
        let animatorSwitcherTableSheduleContent = UIViewPropertyAnimator(duration: 0.4, dampingRatio: 10.0){
            self.currentPage.isUserInteractionEnabled = false
            nextPage.isUserInteractionEnabled = false
            self.currentPage?.frame = self.currentPage?.frame
                .offsetBy(dx: -self.view.frame.width, dy: 0) as! CGRect
            nextPage.frame = nextPage.frame
                .offsetBy(dx: -self.view.frame.width, dy: 0) as! CGRect
        }
        
        self.sheduleTable.contentOffset = CGPoint(x: 0, y: 0)
        animatorSwitcherTableSheduleContent.startAnimation()
        animatorSwitcherTableSheduleContent.addCompletion{ _ in
            self.currentPage.removeFromSuperview()
            self.currentPage = nextPage
            self.currentPage.isUserInteractionEnabled = true
        }
    }
    
    
    @objc func changeDay(_ notification: NSNotification) {
        
        if let dayIndex = notification.userInfo!["dayIndex"] as? Int{
            
            if dayIndex < self.currentSelectedIndex{
                loadViewFromLeftSide()
            }
            if dayIndex > self.currentSelectedIndex{
                loadViewFromRightSide()
            }
            self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
        }
    }
}

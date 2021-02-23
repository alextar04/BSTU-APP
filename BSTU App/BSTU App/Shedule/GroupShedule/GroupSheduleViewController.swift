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
import RxDataSources


class GroupSheduleViewController: UIViewController{
    
    @IBOutlet weak var currentDayOfWeek: UILabel!
    
    @IBOutlet weak var parityOfWeek: UIButton!
    //@IBOutlet weak var parityOfWeek: UILabel!
    @IBOutlet weak var tableTypeWeek: UITableView!
    @IBOutlet weak var shadowTableTypeWeek: UIView!
    @IBOutlet weak var parityDropdownButton: UIImageView!
    
    @IBOutlet weak var dateStackView: UIStackView!
    var dateSegmentedControl: DateSegmentedControl!
    var currentPage: UIView!
    var currentSelectedIndex: Int!
    
    
    @IBOutlet weak var sheduleTable: UIScrollView!
    lazy var templateCard: GroupSheduleCard = {
        let card = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        return card!
    }()
    lazy var cardHeight = templateCard.frame.height
    lazy var offsetBetweenCards: CGFloat = 14
    
    let disposeBag = DisposeBag()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setSettingsForDateSegmentedControl()
        setSettingsSheduleTable()
        setSettingsWeekType()
    }
    
    
    // MARK: Настройки для панели дат
    func setSettingsForDateSegmentedControl(){
        self.dateSegmentedControl = DateSegmentedControl()
        dateSegmentedControl.setupView(stackView: self.dateStackView)
    }
    
    
    // MARK: Настройки окна типа недели
    func setSettingsWeekType(){
        
        // Заполнение таблицы данными
        let data: [TypeWeek] = [TypeWeek("Числитель", true),
                                TypeWeek("Знаменатель", false)]
        let dataBehaviorRelay = BehaviorRelay<[TypeWeek]>(value: data)
        dataBehaviorRelay.bind(to: self.tableTypeWeek.rx.items){
            table, row, item in
            let cellTable = table.dequeueReusableCell(withIdentifier: "typeWeekCell", for: IndexPath.init(row: row, section: 0)) as! TypeWeekCell
            
            cellTable.nameTypeWeek.text = item.name
            cellTable.selectionTypeWeekStatus.isHidden = !item.status
            return cellTable
        }.disposed(by: disposeBag)
        
        
        // Открытие/Закрытие таблицы
        self.parityOfWeek.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.parityOfWeek.setTitleColor(.darkGray, for: .normal)
                
                // Таблица скрыта - бар закрыт
                if self.tableTypeWeek.isHidden{
                    self.parityDropdownButton.image = UIImage(named: "dropup")
                    self.tableTypeWeek.frame = CGRect(x: 0, y: self.tableTypeWeek.frame.minY,
                                                      width: self.tableTypeWeek.frame.width, height: 0)
                    self.shadowTableTypeWeek.frame = CGRect(x: 0, y: self.shadowTableTypeWeek.frame.minY,
                                                      width: self.shadowTableTypeWeek.frame.width, height: 0)
                    
                // Таблица открыта - бар открыт
                } else {
                    self.parityDropdownButton.image = UIImage(named: "dropdown")
                    self.tableTypeWeek.frame = CGRect(x: 0, y: self.tableTypeWeek.frame.minY,
                                                      width: self.tableTypeWeek.frame.width, height: 88)
                    self.shadowTableTypeWeek.frame = CGRect(x: 0, y: self.shadowTableTypeWeek.frame.minY,
                                                      width: self.shadowTableTypeWeek.frame.width, height: 89)
                }
                let isHiddenTableTypeWeek = self.tableTypeWeek.isHidden
                self.tableTypeWeek.isHidden = false
                self.shadowTableTypeWeek.isHidden = false
                
                
                // Анимация движения таблицы
                UIView.animate(
                        withDuration: 0.4,
                        delay: 0,
                        usingSpringWithDamping: 1,
                        initialSpringVelocity: 1,
                        options: .curveEaseInOut,
                        animations: {
                            var heightTable: CGFloat!
                            var heightShadow: CGFloat!
                            if isHiddenTableTypeWeek{
                                heightTable = 88
                                heightShadow = 89
                            } else {
                                heightTable = 0
                                heightShadow = 0
                            }
                            self.tableTypeWeek.frame = CGRect(x: self.tableTypeWeek.frame.minX, y: self.tableTypeWeek.frame.minY,
                                                                       width: self.tableTypeWeek.frame.width, height: heightTable)
                            self.shadowTableTypeWeek.frame = CGRect(x: self.shadowTableTypeWeek.frame.minX, y: self.shadowTableTypeWeek.frame.minY,
                                                              width: self.shadowTableTypeWeek.frame.width, height: heightShadow)
                            self.tableTypeWeek.layoutIfNeeded()
                            self.shadowTableTypeWeek.layoutIfNeeded()
                          },
                          completion: { _ in
                            self.tableTypeWeek.isHidden = !isHiddenTableTypeWeek
                            self.shadowTableTypeWeek.isHidden = self.tableTypeWeek.isHidden
                    })
                })
                .disposed(by: disposeBag)
        
        
        // Обработка нажатия на тип недели
        self.tableTypeWeek.rx
            .modelSelected(TypeWeek.self)
            .subscribe(
                onNext: {selectedItem in
                    self.parityDropdownButton.image = UIImage(named: "dropdown")
                    self.parityOfWeek.titleLabel?.text = selectedItem.name
                    self.parityOfWeek.setTitle(selectedItem.name, for: .normal)
                    self.view.layoutIfNeeded()
                
                UIView.animate(
                      withDuration: 0.4,
                      delay: 0,
                      usingSpringWithDamping: 1,
                      initialSpringVelocity: 1,
                      options: .curveEaseInOut,
                      animations: {
                        self.tableTypeWeek.frame = CGRect(x: self.tableTypeWeek.frame.minX, y: self.tableTypeWeek.frame.minY,
                                                          width: self.tableTypeWeek.frame.width, height: 0)
                        self.shadowTableTypeWeek.frame = CGRect(x: self.shadowTableTypeWeek.frame.minX, y: self.shadowTableTypeWeek.frame.minY,
                                                          width: self.shadowTableTypeWeek.frame.width, height: 0)
                        self.tableTypeWeek.layoutIfNeeded()
                        self.shadowTableTypeWeek.layoutIfNeeded()
                      },
                      completion: { _ in
                        self.tableTypeWeek.isHidden = true
                        self.shadowTableTypeWeek.isHidden = true
                        selectedItem.status = false
                        
                        _ = data.map{ typeWeek in
                            typeWeek.status = false
                        }
                        
                        let index = data.firstIndex(where: { dataItem in
                            return dataItem.name == selectedItem.name
                        })
                        data[index!].status = true
                        dataBehaviorRelay.accept(data)
                })
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка настроек отображения контента в таблице
    func setSettingsSheduleTable(){
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeDay), name: Notification.Name("ChangeDay"), object: nil)
        
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
        
        // Загрузка карточек
        for index in 0...5{
            let subjectCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
            var yStart: CGFloat = 14
            index != 0 ? (yStart = offsetBetweenCards + (offsetBetweenCards + cardHeight) * CGFloat(index)) : (yStart = offsetBetweenCards)
            subjectCard!.frame = CGRect(x: 10, y: yStart,
                                            width: self.sheduleTable.frame.width - 20,
                                            height: cardHeight)
            
            let typeLessons: [TypeLesson] = [.laboratory, .lection, .practice]
            subjectCard!.setupView(typeLesson: typeLessons.randomElement()!)
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
        
        // Анимация: Текущее расписание перемещается вправо
        // На его месте появляется новое
        let preventPage = createViewForSheduleTable(number: String(Int.random(in: 0...10)),
                                                    frame: CGRect(x: -self.sheduleTable.frame.width, y: 0,
                                                                width: self.sheduleTable.frame.width,
                                                                height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6))
        self.sheduleTable.addSubview(preventPage)
            
        let animatorSwitcherTableSheduleContent = UIViewPropertyAnimator(duration: 0.4, dampingRatio: 10.0){
            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.isUserInteractionEnabled = false
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
            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.isUserInteractionEnabled = true
        }
    }
    
    
    // MARK: Открытие представления с правой стороны
    func loadViewFromRightSide(){
        
        // Анимация: Текущее расписание перемещается влево
        // На его месте появляется новое
        let nextPage = createViewForSheduleTable(number: String(Int.random(in: 0...10)),
                                                 frame: CGRect(x: self.sheduleTable.frame.width, y: 0,
                                                               width: self.sheduleTable.frame.width,
                                                               height: offsetBetweenCards + (cardHeight + offsetBetweenCards) * 6))
        self.sheduleTable.addSubview(nextPage)
        
        let animatorSwitcherTableSheduleContent = UIViewPropertyAnimator(duration: 0.4, dampingRatio: 10.0){
            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.isUserInteractionEnabled = false
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
            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.isUserInteractionEnabled = true
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

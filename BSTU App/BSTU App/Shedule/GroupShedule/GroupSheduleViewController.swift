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
    
    var groupName: String!
    @IBOutlet weak var groupNameLabel: UILabel!
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var currentDayOfWeek: UILabel!
    
    @IBOutlet weak var parityOfWeek: UIButton!
    @IBOutlet weak var tableTypeWeek: UITableView!
    @IBOutlet weak var shadowTableTypeWeek: UIView!
    @IBOutlet weak var parityDropdownButton: UIImageView!
    
    @IBOutlet weak var dateStackView: UIStackView!
    var dateSegmentedControl: DateSegmentedControl!
    var currentServerTypeWeek: String!
    var numberOfCalendarDates: ([Int], [Int])!
    var currentPage: UIView!
    var currentSelectedIndex: Int!
    var currentDay: Int!
    
    
    @IBOutlet weak var sheduleTable: UIScrollView!
    lazy var templateCard: GroupSheduleCard = {
        let card = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
        return card!
    }()
    lazy var cardHeight = templateCard.frame.height
    lazy var offsetBetweenCards: CGFloat = 14
    
    
    var additionalStatusBar: UIView  = {
        let statusBarView = UIView(frame: UIApplication.shared.statusBarFrame)
        statusBarView.backgroundColor = .examBackgroundColor
        return statusBarView
    }()
    @IBOutlet weak var examMenuButton: UIButton!
    @IBOutlet weak var examMainView: UIView!
    @IBOutlet weak var examContainerView: UIView!
    @IBOutlet weak var examHeaderView: UIView!
    @IBOutlet weak var examCloseButton: UIImageView!
    @IBOutlet weak var examContentView: UIScrollView!
    
    let viewModel = GroupSheduleViewModel()
    let disposeBag = DisposeBag()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationController?.setNavigationBarHidden(true, animated: false)
        self.groupNameLabel.text = groupName
        setupBackButton()
        setSettingsCurrentDayOfWeek()
        setSettingsNumbersOfWeeks()
        setSettingsSheduleTable()
        setSettingsWeekType()
        //setSettingsExamViews()
    }
    
    
    // MARK: Установка кнопки перехода к предыдущему окну
    func setupBackButton(){
        
        self.backButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.navigationController?.popViewController(animated: true)
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Настройка отображения текущего дня
    func setSettingsCurrentDayOfWeek(){
        NotificationCenter.default.addObserver(self, selector: #selector(changeDayText), name: Notification.Name("ChangeDayText"), object: nil)
        let result = viewModel.getCurrentDayOfWeek()
        
        self.currentDayOfWeek.text = result.1
        self.currentDay = result.0
    }
    
    
    // MARK: Получение чисел для недель числителя и знаменателя
    func setSettingsNumbersOfWeeks(){
        self.numberOfCalendarDates = viewModel.getNumbersOfCalendarDates()
        
        self.dateSegmentedControl = DateSegmentedControl()
        dateSegmentedControl.numbersData = self.numberOfCalendarDates.0
        dateSegmentedControl.todayNumber = self.currentDay
        dateSegmentedControl.setupView(stackView: self.dateStackView)
    }
    
    
    // MARK: Настройки окна типа недели
    func setSettingsWeekType(){
        
        // Заполнение таблицы данными
        var data = [TypeWeek]()
        self.currentServerTypeWeek = self.viewModel.getCurrentWeekType()
        self.parityOfWeek.setTitle(currentServerTypeWeek, for: [.normal])
        let typeWeekName = ["Числитель", "Знаменатель"]
        
        for weekName in typeWeekName{
            var status: Bool!
            (weekName == currentServerTypeWeek) ? (status = true) : (status = false)
            data.append(TypeWeek(weekName, status))
        }
        
        let dataBehaviorRelay = BehaviorRelay<[TypeWeek]>(value: data)
        dataBehaviorRelay.bind(to: self.tableTypeWeek.rx.items){
            table, row, item in
            let cellTable = table.dequeueReusableCell(withIdentifier: "typeWeekCell", for: IndexPath.init(row: row, section: 0)) as! TypeWeekCell
            
            var additionalText = ""
            (self.currentServerTypeWeek == item.name) ? (additionalText += ": Текущая неделя") : (additionalText = "")
            cellTable.nameTypeWeek.text = item.name + additionalText
            cellTable.selectionTypeWeekStatus.isHidden = !item.status
            return cellTable
        }.disposed(by: disposeBag)
    
        // Каждую секунду определять день недели
        var timer = Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true){ _ in
            self.currentServerTypeWeek = self.viewModel.getCurrentWeekType()
            dataBehaviorRelay.accept(data)
        }
        
        // Открытие/Закрытие таблицы
        self.parityOfWeek.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.parityOfWeek.setTitleColor(.darkGray, for: .normal)
                self.currentServerTypeWeek = self.viewModel.getCurrentWeekType()
                dataBehaviorRelay.accept(data)
                
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
                        usingSpringWithDamping: 1.0,
                        initialSpringVelocity: 1.0,
                        options: .curveEaseInOut,
                        animations: {
                            // Остановка таймера счетчика дня недели
                            timer.invalidate()
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
                            
                            // Переинициализация таймера обновления дня недели
                            timer = Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true){ _ in
                                self.currentServerTypeWeek = self.viewModel.getCurrentWeekType()
                                dataBehaviorRelay.accept(data)
                            }
                    })
                })
                .disposed(by: disposeBag)
        
        
        // Обработка нажатия на тип недели
        self.tableTypeWeek.rx
            .modelSelected(TypeWeek.self)
            .subscribe(
                onNext: {selectedItem in
                    let weekTypeTitle = String((selectedItem.name.split(separator: ":").first)!)
                    self.parityDropdownButton.image = UIImage(named: "dropdown")
                    
                    if weekTypeTitle != self.parityOfWeek.titleLabel?.text{
                        self.loadViewFromRightSide()
                    }
                    
                    UIView.performWithoutAnimation {
                        self.parityOfWeek.setTitle(weekTypeTitle, for: [.normal])
                        self.parityOfWeek.layoutIfNeeded()
                        
                        switch weekTypeTitle{
                        case self.currentServerTypeWeek:
                            self.numberOfCalendarDates = self.viewModel.getNumbersOfCalendarDates()
                            self.dateSegmentedControl.numbersData = self.numberOfCalendarDates.0
                            self.dateSegmentedControl.todayNumber = self.numberOfCalendarDates.0.first
                            let result = self.viewModel.getCurrentDayOfWeek()
                            self.currentDayOfWeek.text = result.1
                            self.currentDay = result.0

                            self.dateSegmentedControl.changeContent()
                            let index = self.dateSegmentedControl.numbersData.firstIndex(of: self.currentDay)!
                            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex = index
                            self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView, index: index, direction: nil)
                            self.currentDayOfWeek.text = self.viewModel.getNameOfDayByIndex(index: index)
                        default:
                            self.numberOfCalendarDates = self.viewModel.getNumbersOfCalendarDates()
                            self.dateSegmentedControl.numbersData = self.numberOfCalendarDates.1
                            self.dateSegmentedControl.todayNumber = self.numberOfCalendarDates.1.first
                            let result = self.viewModel.getCurrentDayOfWeek()
                            self.currentDayOfWeek.text = result.1
                            self.currentDay = result.0

                            self.dateSegmentedControl.changeContent()
                            self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex = 0
                            self.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self.dateStackView, index: 0, direction: nil)
                            self.currentDayOfWeek.text = self.viewModel.getNameOfDayByIndex(index: 0)
                        }
                    }
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
    
    
    // MARK: Установка настроек для представления экзаменов
    func setSettingsExamViews(){
        self.examMainView.isHidden = true
        examMainView.backgroundColor = .examBackgroundColor
        self.examContainerView.isHidden = true
        self.examContainerView.makeRounding()
        
        self.additionalStatusBar.isHidden = true
        self.view.addSubview(self.additionalStatusBar)
        
        let examView = createViewForSheduleTable(data: self.viewModel.resultDaysCurrentWeek[self.currentSelectedIndex],
                                                 frame: CGRect(x: 0, y: 0,
                                                                    width: self.examContentView.frame.width,
                                                                    height: .zero),
                                                 typeCard: .exam)
        self.examContentView.addSubview(examView)
        self.examContentView.autoresizesSubviews = false
        
        self.examMenuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.examMainView.isHidden = false
                self.examMainView.alpha = 0
                self.examContainerView.isHidden = false
                self.examContainerView.alpha = 0
                self.additionalStatusBar.isHidden = false
                self.additionalStatusBar.alpha = 0
                
                let examView = self.createViewForSheduleTable(data: self.viewModel.resultDaysCurrentWeek[self.currentSelectedIndex],
                                                         frame: CGRect(x: 0, y: 0,
                                                                       width: self.examContentView.frame.width,
                                                                       height: .zero),
                                                         typeCard: .exam)
                self.examContentView.subviews.forEach({ $0.removeFromSuperview() })
                self.examContentView.addSubview(examView)
                self.examContentView.contentOffset = CGPoint(x: 0, y: 0)
                
                UIView.animate(withDuration: 0.3) {
                    self.examMainView.alpha = 1
                    self.examContainerView.alpha = 1
                    self.additionalStatusBar.alpha = 1
                }
            }).disposed(by: disposeBag)
        
        self.examMainView.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.examMainView.alpha = 1
                self.additionalStatusBar.alpha = 1
                self.examContainerView.alpha = 1
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self.examMainView.alpha = 0
                                self.additionalStatusBar.alpha = 0
                                self.examContainerView.alpha = 0
                },
                               completion: { _ in
                                    self.examMainView.isHidden = true
                                    self.additionalStatusBar.isHidden = true
                                    self.examContainerView.isHidden = true
                })
            }).disposed(by: disposeBag)
        
        self.examCloseButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { _ in
                self.examMainView.alpha = 1
                self.additionalStatusBar.alpha = 1
                self.examContainerView.alpha = 1
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self.examMainView.alpha = 0
                                self.additionalStatusBar.alpha = 0
                                self.examContainerView.alpha = 0
                                
                },
                               completion: { _ in
                                self.examMainView.isHidden = true
                                self.additionalStatusBar.isHidden = true
                                self.examContainerView.isHidden = true
                })
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка настроек отображения контента в таблице
    func setSettingsSheduleTable(){
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeDay),
                                               name: Notification.Name("ChangeDay"),
                                               object: nil)
        
        self.viewModel.getSheduleForGroup(groupName: "ИТ-41", completion: {
            self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
            self.currentPage = self.createViewForSheduleTable(data: self.viewModel.resultDaysCurrentWeek[self.currentSelectedIndex],
                                                         frame: CGRect(x: 0, y: 0,
                                                                       width: self.sheduleTable.frame.width,
                                                                       height: .zero),
                                                         typeCard: .lesson)
            self.sheduleTable.addSubview(self.currentPage)
            self.sheduleTable.autoresizesSubviews = false
        })
    }
    
    
    // MARK: Создание вида для таблицы расписаний
    func createViewForSheduleTable(data: [GroupSheduleModel], frame: CGRect, typeCard: TypeCard)->UIView{
        
        var outputView: UIView!
        
        // Случай: есть занятия
        if data.count != 0{
            var updatedFrame = frame
            updatedFrame.size.height = offsetBetweenCards + (cardHeight + offsetBetweenCards) * CGFloat(data.count)
            outputView = UIView(frame: updatedFrame)
            
            for (index, dayShedule) in data.enumerated(){

                // Загрузка карточек
                let subjectCard = Bundle.main.loadNibNamed("GroupSheduleCard", owner: self, options: nil)?.first as? GroupSheduleCard
                var yStart: CGFloat = 14
                index != 0 ? (yStart = offsetBetweenCards + (offsetBetweenCards + cardHeight) * CGFloat(index)) : (yStart = offsetBetweenCards)
                    
                switch typeCard {
                case .lesson:
                    subjectCard!.frame = CGRect(x: 10, y: yStart,
                                                width: self.sheduleTable.frame.width - 20,
                                                height: cardHeight)
                    subjectCard!.setupView(activity: dayShedule)
                    self.sheduleTable.isScrollEnabled = true
                case .exam:
                    subjectCard!.frame = CGRect(x: 10, y: yStart,
                                                width: self.examContentView.frame.width - 20,
                                                height: cardHeight)
                    subjectCard?.nameSubject.font = UIFont.boldSystemFont(ofSize: 14.0)
                    let typeExam: [TypeActivity] = [.consultation, .examination]
                    subjectCard!.setupData(activity: dayShedule)
                    self.examContentView.isScrollEnabled = true
                }
                    outputView.addSubview(subjectCard!)
            }
        }
        
        // Случай: нет занятий
        if data.count == 0{
            let emptyView = Bundle.main.loadNibNamed("EmptySheduleView", owner: self, options: nil)?.first as? EmptySheduleView
            switch typeCard {
            case .lesson:
                var updatedFrame = frame
                updatedFrame.size.height = self.sheduleTable.frame.height
                outputView = UIView(frame: updatedFrame)
                
                emptyView!.frame = CGRect(x: 0, y: 0,
                                                width: self.sheduleTable.frame.width,
                                                height: self.sheduleTable.frame.height)
                let typeLessons: [TypeActivity] = [.laboratory, .lection, .practice]
                emptyView!.setupView(typeActivity: typeLessons.randomElement()!)
                self.sheduleTable.isScrollEnabled = false
            case .exam:
                var updatedFrame = frame
                updatedFrame.size.height = self.examContentView.frame.height
                outputView = UIView(frame: updatedFrame)
                
                emptyView!.frame = CGRect(x: 0, y: 0,
                                                width: self.examContentView.frame.width,
                                                height: self.examContentView.frame.height)
                let typeExam: [TypeActivity] = [.consultation, .examination]
                emptyView!.setupView(typeActivity: typeExam.randomElement()!)
                self.examContentView.isScrollEnabled = false
            }
            outputView.addSubview(emptyView!)
        }
        
        switch typeCard {
        case .lesson:
            self.sheduleTable.contentSize = CGSize(width: self.view.frame.width, height: outputView.frame.height)
        case .exam:
            self.examContentView.contentSize = CGSize(width: self.examContentView.frame.width, height: outputView.frame.height)
        }
        
        if typeCard == .lesson{
            let leftSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
            let rightSwipe = UISwipeGestureRecognizer(target: self, action: #selector(handleSwipes(_:)))
            leftSwipe.direction = .left
            rightSwipe.direction = .right
            outputView.addGestureRecognizer(leftSwipe)
            outputView.addGestureRecognizer(rightSwipe)
        }
        
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
        let preventPage = createViewForSheduleTable(data: self.viewModel.resultDaysCurrentWeek[self.currentSelectedIndex],
                                                    frame: CGRect(x: -self.sheduleTable.frame.width, y: 0,
                                                                width: self.sheduleTable.frame.width,
                                                                height: .zero),
                                                    typeCard: .lesson)
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
        let nextPage = createViewForSheduleTable(data: self.viewModel.resultDaysCurrentWeek[self.currentSelectedIndex],
                                                 frame: CGRect(x: self.sheduleTable.frame.width, y: 0,
                                                               width: self.sheduleTable.frame.width,
                                                               height: .zero),
                                                 typeCard: .lesson)
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
                self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
                loadViewFromLeftSide()
            }
            if dayIndex > self.currentSelectedIndex{
                self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
                loadViewFromRightSide()
            }
        }
    }
    
    
    @objc func changeDayText(_ notification: NSNotification) {
        if let dayIndex = notification.userInfo!["dayIndex"] as? Int{
            self.currentDayOfWeek.text = self.viewModel.getNameOfDayByIndex(index: dayIndex)
        }
    }
    
}

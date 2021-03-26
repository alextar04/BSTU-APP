//
//  TeacherScheduleViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 25.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxGesture
import RxDataSources


class TeacherScheduleViewController: UIViewController{
    
    var teacherName: String!
    var teacherLink: URL!
    var dialogLoading: UIAlertController!
    var dialogLoadingIsNeeded = true
    @IBOutlet weak var teacherNameLabel: UILabel!
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var currentDayOfWeek: UILabel!
    
    @IBOutlet weak var parityOfWeek: UIButton!
    @IBOutlet weak var tableTypeWeek: UITableView!
    @IBOutlet weak var tableTypeWeekConstraint: NSLayoutConstraint!
    @IBOutlet weak var shadowTableTypeWeek: UIView!
    @IBOutlet weak var shadowTableTypeWeekConstraint: NSLayoutConstraint!
    @IBOutlet weak var parityDropdownButton: UIImageView!
    
    @IBOutlet weak var correspondenceSheduleLabel: UILabel!
    @IBOutlet weak var dateStackView: UIStackView!
    var dateSegmentedControl: DateSegmentedControl!
    var currentServerTypeWeek: String!
    var currentSheduleContainer: [[TeacherScheduleModel]]!
    var numberOfCalendarDates: ([Int], [Int])!
    var currentPage: UIView!
    var currentSelectedIndex: Int!
    var currentDay: Int!
    
    
    @IBOutlet weak var sheduleTable: UIScrollView!
    var isNeedCardSwipe = true
    lazy var templateCard: TeacherScheduleCard = {
        let card = Bundle.main.loadNibNamed("TeacherScheduleCard", owner: self, options: nil)?.first as? TeacherScheduleCard
        return card!
    }()
    lazy var cardHeight = templateCard.frame.height
    lazy var cardLiteHeight: CGFloat = 120
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
    
    let viewModel = TeacherScheduleViewModel()
    let disposeBag = DisposeBag()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationController?.setNavigationBarHidden(true, animated: false)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
        
        self.teacherNameLabel.text = viewModel.getShortTeacherRecord(teacher: self.teacherName)
        setupBackButton()
        setSettingsCurrentDayOfWeek()
        setSettingsNumbersOfWeeks()
        setSettingsSheduleTable()
        setSettingsExamViews()
    }
    
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        if self.dialogLoadingIsNeeded{
            self.dialogLoading = UIAlertController(title: "Загрузка",
                                                  message: nil,
                                                  preferredStyle: .alert)
            let activityIndicator = UIActivityIndicatorView(style: .gray)
            activityIndicator.translatesAutoresizingMaskIntoConstraints = false
            activityIndicator.isUserInteractionEnabled = false
            activityIndicator.startAnimating()

            self.dialogLoading.view.addSubview(activityIndicator)
            self.dialogLoading.view.heightAnchor.constraint(equalToConstant: 95).isActive = true

            activityIndicator.centerXAnchor.constraint(equalTo: self.dialogLoading.view.centerXAnchor, constant: 0).isActive = true
            activityIndicator.bottomAnchor.constraint(equalTo: self.dialogLoading.view.bottomAnchor, constant: -20).isActive = true
            self.present(self.dialogLoading, animated: true)
        }
    }
    
    
    // MARK: Установка кнопки перехода к предыдущему окну
    func setupBackButton(){
        
        self.backButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self?.navigationController?.popViewController(animated: true)
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
            [weak self] table, row, item in
            let cellTable = table.dequeueReusableCell(withIdentifier: "typeWeekCell", for: IndexPath.init(row: row, section: 0)) as! TypeWeekCell
            
            var additionalText = ""
            (self!.currentServerTypeWeek == item.name) ? (additionalText += ": Текущая неделя") : (additionalText = "")
            cellTable.nameTypeWeek.text = item.name + additionalText
            cellTable.selectionTypeWeekStatus.isHidden = !item.status
            return cellTable
        }.disposed(by: disposeBag)
    
        
        // Открытие/Закрытие таблицы
        self.tableTypeWeekConstraint.constant = 0
        self.shadowTableTypeWeekConstraint.constant = 0
        self.view.layoutIfNeeded()
        self.parityOfWeek.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self!.parityOfWeek.setTitleColor(.darkGray, for: .normal)
                self!.currentServerTypeWeek = self!.viewModel.getCurrentWeekType()
                dataBehaviorRelay.accept(data)
                
                // Таблица скрыта - бар закрыт
                if self!.tableTypeWeek.isHidden{
                    self!.parityDropdownButton.image = UIImage(named: "dropup")
                    self!.tableTypeWeekConstraint.constant = 0
                    self!.shadowTableTypeWeekConstraint.constant = 0
                    self!.view.layoutIfNeeded()
                    
                // Таблица открыта - бар открыт
                } else {
                    self!.parityDropdownButton.image = UIImage(named: "dropdown")
                    self!.tableTypeWeekConstraint.constant = 88
                    self!.shadowTableTypeWeekConstraint.constant = 89
                    self!.view.layoutIfNeeded()
                }
                let isHiddenTableTypeWeek = self!.tableTypeWeek.isHidden
                self!.tableTypeWeek.isHidden = false
                self!.shadowTableTypeWeek.isHidden = false
        
                // Анимация движения таблицы
                UIView.animate(
                        withDuration: 0.4,
                        delay: 0,
                        usingSpringWithDamping: 1.0,
                        initialSpringVelocity: 1.0,
                        options: .curveEaseIn,
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
                            self!.tableTypeWeekConstraint.constant = heightTable
                            self!.shadowTableTypeWeekConstraint.constant = heightShadow
                            self!.view.layoutIfNeeded()
                          },
                          completion: { _ in
                            self!.tableTypeWeek.isHidden = !isHiddenTableTypeWeek
                            self!.shadowTableTypeWeek.isHidden = self!.tableTypeWeek.isHidden
                    })
                })
                .disposed(by: disposeBag)
        
        
        // Обработка нажатия на тип недели
        self.tableTypeWeek.rx
            .modelSelected(TypeWeek.self)
            .subscribe(
                onNext: {[weak self] selectedItem in
                    let weekTypeTitle = String((selectedItem.name.split(separator: ":").first)!)
                    self!.parityDropdownButton.image = UIImage(named: "dropdown")
                    
                    if weekTypeTitle != self!.parityOfWeek.titleLabel?.text{
                        (self!.currentServerTypeWeek == weekTypeTitle) ?
                            (self!.currentSheduleContainer = self!.viewModel.resultDaysCurrentWeek) :
                            (self!.currentSheduleContainer = self!.viewModel.resultDaysNextWeek)
                    }
                    
                    UIView.performWithoutAnimation {
                        self!.parityOfWeek.setTitle(weekTypeTitle, for: [.normal])
                        self!.parityOfWeek.layoutIfNeeded()
                        
                        switch weekTypeTitle{
                        case self!.currentServerTypeWeek:
                            self!.numberOfCalendarDates = self!.viewModel.getNumbersOfCalendarDates()
                            self!.dateSegmentedControl.numbersData = self!.numberOfCalendarDates.0
                            self!.dateSegmentedControl.todayNumber = self!.numberOfCalendarDates.0.first
                            let result = self!.viewModel.getCurrentDayOfWeek()
                            self!.currentDayOfWeek.text = result.1
                            self!.currentDay = result.0

                            self!.dateSegmentedControl.changeContent()
                            let index = self!.dateSegmentedControl.numbersData.firstIndex(of: self!.currentDay)!
                            self!.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex = index
                            self!.currentSelectedIndex = index
                            self!.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self!.dateStackView, index: index, direction: nil)
                            self!.currentDayOfWeek.text = self!.viewModel.getNameOfDayByIndex(index: index)
                        default:
                            self!.numberOfCalendarDates = self!.viewModel.getNumbersOfCalendarDates()
                            self!.dateSegmentedControl.numbersData = self!.numberOfCalendarDates.1
                            self!.dateSegmentedControl.todayNumber = self!.numberOfCalendarDates.1.first
                            let result = self!.viewModel.getCurrentDayOfWeek()
                            self!.currentDayOfWeek.text = result.1
                            self!.currentDay = result.0

                            self!.dateSegmentedControl.changeContent()
                            self!.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex = 0
                            self!.currentSelectedIndex = 0
                            self!.dateSegmentedControl.changeSegmentedControlLinePosition(stackView: self!.dateStackView, index: 0, direction: nil)
                            self!.currentDayOfWeek.text = self!.viewModel.getNameOfDayByIndex(index: 0)
                        }
                    }
                    
                    self!.loadViewFromRightSide()
                    self!.view.layoutIfNeeded()
                    
                    
                    UIView.animate(
                      withDuration: 0.4,
                      delay: 0,
                      usingSpringWithDamping: 1,
                      initialSpringVelocity: 1,
                      options: .curveEaseIn,
                      animations: {
                        self!.tableTypeWeekConstraint.constant = 0
                        self!.shadowTableTypeWeekConstraint.constant = 0
                        self!.view.layoutIfNeeded()
                      },
                      completion: { _ in
                        self!.tableTypeWeek.isHidden = true
                        self!.shadowTableTypeWeek.isHidden = true
                        
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
        
        let examView = createViewForSheduleTable(data: self.viewModel.resultExams,
                                                 frame: CGRect(x: 0, y: 0,
                                                                    width: self.examContentView.frame.width,
                                                                    height: .zero),
                                                 typeCard: .exam)
        self.examContentView.addSubview(examView)
        self.examContentView.autoresizesSubviews = false
        
        self.examMenuButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self!.examMainView.isHidden = false
                self!.examMainView.alpha = 0
                self!.examContainerView.isHidden = false
                self!.examContainerView.alpha = 0
                self!.additionalStatusBar.isHidden = false
                self!.additionalStatusBar.alpha = 0
                
                let examView = self!.createViewForSheduleTable(data: self!.viewModel.resultExams,
                                                         frame: CGRect(x: 0, y: 0,
                                                                       width: self!.examContentView.frame.width,
                                                                       height: .zero),
                                                         typeCard: .exam)
                self!.examContentView.subviews.forEach({ $0.removeFromSuperview() })
                self!.examContentView.addSubview(examView)
                self!.examContentView.contentOffset = CGPoint(x: 0, y: 0)
                
                UIView.animate(withDuration: 0.3) {
                    self!.examMainView.alpha = 1
                    self!.examContainerView.alpha = 1
                    self!.additionalStatusBar.alpha = 1
                }
            }).disposed(by: disposeBag)
        
        self.examMainView.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self!.examMainView.alpha = 1
                self!.additionalStatusBar.alpha = 1
                self!.examContainerView.alpha = 1
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self!.examMainView.alpha = 0
                                self!.additionalStatusBar.alpha = 0
                                self!.examContainerView.alpha = 0
                },
                               completion: { _ in
                                    self!.examMainView.isHidden = true
                                    self!.additionalStatusBar.isHidden = true
                                    self!.examContainerView.isHidden = true
                })
            }).disposed(by: disposeBag)
        
        self.examCloseButton.rx
            .tapGesture()
            .when(.recognized)
            .subscribe(onNext: { [weak self] _ in
                self!.examMainView.alpha = 1
                self!.additionalStatusBar.alpha = 1
                self!.examContainerView.alpha = 1
                UIView.animate(withDuration: 0.3,
                               animations: {
                                self!.examMainView.alpha = 0
                                self!.additionalStatusBar.alpha = 0
                                self!.examContainerView.alpha = 0
                                
                },
                               completion: { _ in
                                self!.examMainView.isHidden = true
                                self!.additionalStatusBar.isHidden = true
                                self!.examContainerView.isHidden = true
                })
            }).disposed(by: disposeBag)
    }
    
    
    // MARK: Установка настроек отображения контента в таблице
    func setSettingsSheduleTable(){
        
        NotificationCenter.default.addObserver(self, selector: #selector(changeDay),
                                               name: Notification.Name("ChangeDay"),
                                               object: nil)
        
        self.viewModel.getSheduleForTeacher(teacherName: self.teacherName,
                                            teacherLink: self.teacherLink,
                                          completion: {
            // Расписание успешно загружно
            self.setSettingsWeekType()
            self.currentSheduleContainer = self.viewModel.resultDaysCurrentWeek
            
            self.dateStackView.isHidden = false
            self.examMenuButton.isHidden = false
            self.parityOfWeek.isHidden = false
            self.parityDropdownButton.isHidden = false
                
            self.currentSelectedIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.selectedSegmentIndex
            self.currentPage = self.createViewForSheduleTable(data: self.currentSheduleContainer[self.currentSelectedIndex],
                                                            frame: CGRect(x: 0, y: 0,
                                                                        width: self.sheduleTable.frame.width,
                                                                        height: .zero),
                                                            typeCard: .lesson)
            self.dialogLoadingIsNeeded = false
            if self.dialogLoading != nil{
                self.dialogLoading.dismiss(animated: true, completion: nil)
            }
                                            
            self.sheduleTable.addSubview(self.currentPage)
            self.sheduleTable.autoresizesSubviews = false
                                            
            self.dialogLoadingIsNeeded = false
            if self.dialogLoading != nil{
                self.dialogLoading.dismiss(animated: true, completion: nil)
            }
        }, errorClosure: {
            // Ошибка загрузки расписания
            let emptyView = Bundle.main.loadNibNamed("EmptySheduleView", owner: self, options: nil)?.first as? EmptySheduleView
            emptyView!.frame = CGRect(x: 0, y: 0,
                                            width: self.sheduleTable.frame.width,
                                            height: self.sheduleTable.frame.height)
            self.sheduleTable.addSubview(emptyView!)
            
            emptyView!.setupView(typeActivity: .lection)
            emptyView?.picture.image = UIImage(named: "errorLoading")
            emptyView?.descriptionLabel.text = "Ошибка загрузки расписания."
            
            self.sheduleTable.isScrollEnabled = false
            self.examMenuButton.isEnabled = false
            
            self.sheduleTable.isUserInteractionEnabled = false
            self.dateStackView.isUserInteractionEnabled = false
            self.examMenuButton.isUserInteractionEnabled = false
            self.parityOfWeek.isUserInteractionEnabled = false
            
            self.dialogLoadingIsNeeded = false
            if self.dialogLoading != nil{
                self.dialogLoading.dismiss(animated: true, completion: nil)
            }
        })
    }
    
    
    // MARK: Создание вида для таблицы расписаний
    func createViewForSheduleTable(data: [TeacherScheduleModel], frame: CGRect, typeCard: TypeCard)->UIView{
        
        var outputView: UIView!
        
        // Случай: есть занятия
        if data.count != 0{

            // Определение размеров таблицы
            var updatedFrame = frame
            let countPairWithGroups = data.filter{ activity in
                return activity.groups.count != 0
            }.count
            updatedFrame.size.height = offsetBetweenCards
                + (cardHeight + offsetBetweenCards) * CGFloat(countPairWithGroups)
                + (cardLiteHeight + offsetBetweenCards) * CGFloat(data.count - countPairWithGroups)
            outputView = UIView(frame: updatedFrame)
            
            var currentTableHeight: CGFloat!
            for (index, dayShedule) in data.enumerated(){

                // Загрузка карточек
                let subjectCard = Bundle.main.loadNibNamed("TeacherScheduleCard", owner: self, options: nil)?.first as? TeacherScheduleCard
                index != 0 ? () : (currentTableHeight = self.offsetBetweenCards)
                
                let yStart: CGFloat!
                index != 0 ? (yStart = currentTableHeight + offsetBetweenCards) : (yStart = currentTableHeight)
                    
                switch typeCard {
                case .lesson:
                    if dayShedule.groups.count != 0{
                        subjectCard!.frame = CGRect(x: 10, y: yStart,
                                                    width: self.sheduleTable.frame.width - 20,
                                                    height: cardHeight)
                        index != 0 ? (currentTableHeight += self.cardHeight + offsetBetweenCards) : (currentTableHeight += self.cardHeight)
                    } else {
                        subjectCard!.frame = CGRect(x: 10, y: yStart,
                                                    width: self.sheduleTable.frame.width - 20,
                                                    height: cardLiteHeight)
                        index != 0 ? (currentTableHeight += self.cardLiteHeight + offsetBetweenCards) : (currentTableHeight += self.cardLiteHeight)
                        
                        subjectCard?.contentViewHeightConstraint.constant = cardLiteHeight
                        subjectCard?.groupNames.isHidden = true
                    }
                    
                    subjectCard!.setupView(activity: dayShedule)
                    self.sheduleTable.isScrollEnabled = true
                case .exam:
                    subjectCard!.frame = CGRect(x: 10, y: yStart,
                                                width: self.examContentView.frame.width - 20,
                                                height: cardHeight)
                    index != 0 ? (currentTableHeight += self.cardHeight + offsetBetweenCards) : (currentTableHeight += self.cardHeight)
                    
                    subjectCard?.nameSubject.font = UIFont.boldSystemFont(ofSize: 14.0)
                    subjectCard!.setupView(activity: dayShedule)
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
        
        if typeCard == .lesson && self.isNeedCardSwipe{
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
           let maxIndex = self.dateSegmentedControl.numbersOfCalendarSegmentedControl.numberOfSegments - 1
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
        let preventPage = createViewForSheduleTable(data: self.currentSheduleContainer[self.currentSelectedIndex],
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
        let nextPage = createViewForSheduleTable(data: self.currentSheduleContainer[self.currentSelectedIndex],
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
    
    deinit {
        print("Вызов деструктора страницы расписания для преподавателя!")
    }
    
}


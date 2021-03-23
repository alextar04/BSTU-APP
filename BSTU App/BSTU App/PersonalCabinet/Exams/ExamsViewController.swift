//
//  ExamsViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxDataSources

class ExamsViewController: UIViewController, UITableViewDelegate{
    
    var idUser: Int!
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var contentTableView: ContentTableView!
    
    var arrayNumberSemesters = [ExamsCell]()
    let viewModel = ExamsViewModel()
    let disposeBag = DisposeBag()
    
    // Вспомогательная структура для отображения данных в виде секции
    var sectionedArrayNumberSemesters = [SectionOfNumberSemesters]()
    struct SectionOfNumberSemesters{
        var header: String
        var items: [ExamsModel]
    }
    
    @IBOutlet weak var errorImage: UIImageView!
    @IBOutlet weak var errorText: UILabel!
    
    var viewControllerWasPainted = false
    var selectedCellsParametrs = [SelectedCellParametrs]()
    
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        if !viewControllerWasPainted{
            setupBackButton()
            setupContent()
            self.navigationController?.setNavigationBarHidden(true, animated: true)
            self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
            self.viewControllerWasPainted = true
        }
    }
    
    
    // MARK: Установка контента
    func setupContent(){
        
        self.contentTableView.rx
            .setDelegate(self)
            .disposed(by: disposeBag)
        
        let dialogLoading = UIAlertController(title: "Загрузка",
                                              message: nil,
                                              preferredStyle: .alert)
        let activityIndicator = UIActivityIndicatorView(style: .gray)
        activityIndicator.translatesAutoresizingMaskIntoConstraints = false
        activityIndicator.isUserInteractionEnabled = false
        activityIndicator.startAnimating()

        dialogLoading.view.addSubview(activityIndicator)
        dialogLoading.view.heightAnchor.constraint(equalToConstant: 95).isActive = true

        activityIndicator.centerXAnchor.constraint(equalTo: dialogLoading.view.centerXAnchor, constant: 0).isActive = true
        activityIndicator.bottomAnchor.constraint(equalTo: dialogLoading.view.bottomAnchor, constant: -20).isActive = true
        self.present(dialogLoading, animated: true)
        
        viewModel.getUserExamsInfo(idUser: self.idUser,
                                   completion: { [weak self] sessionData in
                                    
                                    self!.contentTableView.register(UINib(nibName: "ExamsCell", bundle: nil),
                                                              forCellReuseIdentifier: "ExamsCellID")
                                    self!.contentTableView.canCancelContentTouches = true
                                    
                                    for session in sessionData{
                                        self!.sectionedArrayNumberSemesters.append(SectionOfNumberSemesters(header: session.numberSemester,
                                                                                                           items: [session]))
                                    }
                                    
                                    // Конфигурация содержимого для ячеек таблицы
                                    let dataSource = RxTableViewSectionedReloadDataSource<SectionOfNumberSemesters>(configureCell: {
                                        [weak self] dataSource, table, index, item in
                                        let cell = table.dequeueReusableCell(withIdentifier: "ExamsCellID", for: index) as! ExamsCell
                                        cell.layoutIfNeeded()
                                        cell.parentVC = self
                                        cell.myIndex = index
                                        cell.configureCell(data: item)
                                        return cell
                                    })
                                    
                                    // Связывание данных и таблицы
                                    Observable.just(self!.sectionedArrayNumberSemesters)
                                        .bind(to: self!.contentTableView.rx.items(dataSource: dataSource))
                                        .disposed(by: self!.disposeBag)
                                    
                                    dialogLoading.dismiss(animated: true, completion: nil)
                                    
            }, errorCallback: { [weak self] typeError in
                self!.errorImage.isHidden = false
                self!.errorText.isHidden = false
                self!.contentTableView.isHidden = true
                dialogLoading.dismiss(animated: true, completion: nil)
        })
    }
    
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        for selectedCell in self.selectedCellsParametrs{
            if selectedCell.selectedCellIndex == indexPath.section{
                return CGFloat(selectedCell.selectedCellHeight)
            }
        }
        return 37
    }
    
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView()
        headerView.backgroundColor = .clear
        return headerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 8.0
    }
    
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let footerView = UIView()
        footerView.backgroundColor = .clear
        return footerView
    }
    
    
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return (section == tableView.numberOfSections - 1) ? 8.0 : 0
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
    
    deinit {
        print("Деструктор страницы Экзаменов")
    }
}


extension ExamsViewController.SectionOfNumberSemesters: SectionModelType{
    init(original: ExamsViewController.SectionOfNumberSemesters, items: [ExamsModel]) {
        self = original
        self.items = items
    }
}

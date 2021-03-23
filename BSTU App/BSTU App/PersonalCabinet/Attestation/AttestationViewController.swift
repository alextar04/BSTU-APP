//
//  AttestationViewController.swift
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

class AttestationViewController: UIViewController, UITableViewDelegate{
    
    var idUser: Int!
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var contentView: ContentTableView!
    weak var selectedCell: AttestationCell!
    var selectedCellIndex: IndexPath!
    var selectedCellHeight: Int!
    
    // Вспомогательная структура для отображения данных в виде секции
    var sectionedArrayRangeDates = [SectionOfDataRanges]()
    struct SectionOfDataRanges{
        var header: String
        var items: [AttestationModel]
    }
    
    var arrayRangeDates = [AttestationCell]()
    let viewModel = AttestationViewModel()
    let disposeBag = DisposeBag()
    
    @IBOutlet weak var errorImage: UIImageView!
    @IBOutlet weak var errorText: UILabel!
    
    var selectedCellsParametrs = [SelectedCellParametrs]()
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        setupBackButton()
        setupContent()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка контента
    func setupContent(){
        
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
        
        viewModel.getUserAttestationInfo(idUser: self.idUser,
                                         completion: { [weak self] attestationData in
            
                                            for attestation in attestationData{
                                                self!.sectionedArrayRangeDates.append(SectionOfDataRanges(header: attestation.dataRange!, items: [attestation]))
                                            }
                                            
                                            self!.contentView.register(UINib(nibName: "AttestationCell", bundle: nil),
                                                                      forCellReuseIdentifier: "AttestationCellID")
                                            self!.contentView.canCancelContentTouches = true
                                            
                                            // Конфигурация содержимого для ячеек таблицы
                                            let dataSource = RxTableViewSectionedReloadDataSource<SectionOfDataRanges>(configureCell: {
                                                [weak self] dataSource, table, index, item in
                                                let cell = table.dequeueReusableCell(withIdentifier: "AttestationCellID", for: index) as! AttestationCell
                                                cell.layoutIfNeeded()
                                                cell.parentVC = self
                                                cell.myIndex = index
                                                cell.configureCell(data: item)
                                                return cell
                                            })
                                            
                                            // Связывание данных и таблицы
                                            Observable.just(self!.sectionedArrayRangeDates)
                                                .bind(to: self!.contentView.rx.items(dataSource: dataSource))
                                                .disposed(by: self!.disposeBag)
                                            
                                            dialogLoading.dismiss(animated: true, completion: nil)
        },
                                         errorCallback: { [weak self] typeError in
                                            self!.errorImage.isHidden = false
                                            self!.errorText.isHidden = false
                                            self!.contentView.isHidden = true
                                            dialogLoading.dismiss(animated: true, completion: nil)
            })
        
        self.contentView.rx
            .setDelegate(self)
            .disposed(by: self.disposeBag)
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
        let view = UIView()
        view.backgroundColor = .clear
        return view
    }
    
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 8.0
    }
    
    
    func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let view = UIView()
        view.backgroundColor = .clear
        return view
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
        print("Деструктор страницы Аттестации")
    }
}


class ContentTableView: UITableView {

    override func touchesShouldCancel(in view: UIView) -> Bool {
        if view.isKind(of: UIButton.self) {
          return true
        }

        return super.touchesShouldCancel(in: view)
    }
}


extension AttestationViewController.SectionOfDataRanges: SectionModelType{
    init(original: AttestationViewController.SectionOfDataRanges, items: [AttestationModel]) {
        self = original
        self.items = items
    }
}

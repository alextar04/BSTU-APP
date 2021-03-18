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

class AttestationViewController: UIViewController{
    
    @IBOutlet weak var backButton: UIImageView!
    @IBOutlet weak var contentView: UIScrollView!
    
    let offsetBetweenRecords: CGFloat = 8.0
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupBackButton()
        setupContent()
        self.navigationController?.setNavigationBarHidden(true, animated: true)
        self.navigationController?.interactivePopGestureRecognizer?.delegate = nil
    }
    
    
    // MARK: Установка контента
    func setupContent(){
        
        let attestationData: [AttestationModel] = [AttestationModel(dataRange: "21.01.10 - 22.22.22",
                                                                    disciplines: ["Русский": 5,
                                                                                  "Математика": 3,
                                                                                  "Окружающий мир": 4])/*,
                                                   AttestationModel(dataRange: "21.01.10 - 22.22.22",
                                                                    disciplines: ["Русский": 5,
                                                                                      "Математика": 3,
                                                                                      "Окружающий мир": 4]),
                                                   AttestationModel(dataRange: "21.01.10 - 22.22.22",
                                                                    disciplines: ["Русский": 5,
                                                                                  "Математика": 3,
                                                                                  "Окружающий мир": 4]),
                                                   AttestationModel(dataRange: "21.01.10 - 22.22.22",
                                                                    disciplines: ["Русский": 5,
                                                                                  "Математика": 3,
                                                                                  "Окружающий мир": 4])*/]
        var currentTableHeight = offsetBetweenRecords
        for (index, oneAttestationData) in attestationData.enumerated(){
            let yStart: CGFloat!
            index != 0 ? (yStart = currentTableHeight + offsetBetweenRecords) : (yStart = currentTableHeight)
            
            let oneAttestationView = UINib(nibName: "AttestationCell", bundle: nil)
                .instantiate(withOwner: self, options: nil)
                .first as? AttestationCell
            
            oneAttestationView!.frame = CGRect(x: 10, y: yStart,
                                        width: self.contentView.frame.width - 20,
                                        height: (oneAttestationView?.frame.height)!)
            oneAttestationView?.headerContainerView.frame = CGRect(x: 0, y: 0,
                                                                   width: self.contentView.frame.width - 20,
                                                                   height: (oneAttestationView?.headerContainerView.frame.height)!)
            
            oneAttestationView?.configureCell(data: oneAttestationData)
            
            oneAttestationView?.containerViewHeightConstraint.constant = 37
            oneAttestationView?.headerViewHeightConstraint.constant = 37
            oneAttestationView?.tableMarksHeightConstraiant.constant = 0
            
            index != 0 ? (currentTableHeight += (oneAttestationView?.headerViewHeightConstraint.constant)! + offsetBetweenRecords) : (currentTableHeight += (oneAttestationView?.headerViewHeightConstraint.constant)!)
            contentView.addSubview(oneAttestationView!)
        }
        
        self.contentView.contentSize = CGSize(width: self.view.frame.width,
                                               height: 1000)
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

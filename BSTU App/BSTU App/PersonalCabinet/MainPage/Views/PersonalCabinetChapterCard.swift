//
//  PersonalCabinetChapterCard.swift
//  BSTU App
//
//  Created by Alexey Taran on 17.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit


class PersonalCabinetChapterCard: UITableViewCell{
    
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundedView: UIView!
    
    @IBOutlet weak var picture: UIImageView!
    @IBOutlet weak var nameChapter: UILabel!
    @IBOutlet weak var descriptionChapter: UILabel!
    
    @IBOutlet weak var nameChapterTopConstraint: NSLayoutConstraint!
    var installedGradientLayer: CAGradientLayer!
    
    
    func configureCell(typePersonalCabinetChapter: TypePersonalCabinetChapter){
        
        self.shadowView.personalCabinetCardMakeShadow(width: Int(self.shadowView.frame.width),
                                                      heigth: Int(self.shadowView.frame.height))
        self.roundedView.makeRounding()
        self.makeGradient()
        
        switch typePersonalCabinetChapter {
        case .attestation:
            self.nameChapter.text = "Аттестация"
            self.descriptionChapter.text = "Оценки в семестре"
            self.picture.image = UIImage(named: "attestations")
            
        case .exams:
            self.nameChapter.text = "Успеваемость"
            self.descriptionChapter.text = "Результаты сессии"
            self.picture.image = UIImage(named: "exams")
            
        case .schedule:
            self.nameChapter.text = "Расписание"
            self.descriptionChapter.text = "Календарь занятий"
            self.picture.image = UIImage(named: "schedule")
        
        }
        
        if self.descriptionChapter.isTruncated(){
            self.descriptionChapter.isHidden = true
            nameChapterTopConstraint.constant = 20
        }
    }
    
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundedView.bounds
        gradientLayer.colors = [UIColor.thirdCourseBackgroundColorStart.cgColor,
                                UIColor.thirdCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer != nil{
            self.installedGradientLayer.removeFromSuperlayer()
        }
        self.installedGradientLayer = gradientLayer
        self.roundedView.layer.insertSublayer(self.installedGradientLayer, at: 0)
    }
    
}

enum TypePersonalCabinetChapter: String{
    case exams = "Экзамены"
    case attestation = "Аттестация"
    case schedule = "Расписание"
}

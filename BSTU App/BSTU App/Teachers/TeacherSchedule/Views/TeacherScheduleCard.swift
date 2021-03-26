//
//  TeacherScheduleCard.swift
//  BSTU App
//
//  Created by Alexey Taran on 25.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Foundation
import UIKit

class TeacherScheduleCard: UIView{
    
    @IBOutlet weak var contentView: UIView!
    @IBOutlet weak var contentViewHeightConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var nameSubject: UILabel!
    @IBOutlet weak var nameSubjectTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var nameSubjectHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var nameSubjectBottomConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var typeActivity: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var audienceLabel: UILabel!
    @IBOutlet weak var audienceTopConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var groupNames: UILabel!
    @IBOutlet weak var groupNamesTopConstraint: NSLayoutConstraint!
    
    
    func setupView(activity: TeacherScheduleModel){
        
        self.setupData(activity: activity)
        self.contentView.makeRounding()
        self.makeGradient(typeActivity: activity.typeActivity)
        self.updateStyleTypeLesson(typeActivity: activity.typeActivity)
        self.updateStyleNameSubject(typeActivity: activity.typeActivity)
        
        self.sheduleMakeShadow(width: Int(self.frame.width), heigth: Int(self.frame.height))
    }
    
    
    // MARK: Установка информации в ячейку
    func setupData(activity: TeacherScheduleModel){
        
        self.nameSubject.text = activity.nameSubject
        if self.nameSubject.isTruncated(){
            nameSubjectTopConstraint.constant = 16
            nameSubjectHeightConstraint.constant = 50
            nameSubjectBottomConstraint.constant = 8
            audienceTopConstraint.constant = 22
            groupNamesTopConstraint.constant = 13
            nameSubject.numberOfLines = 2
        } else {
            nameSubjectTopConstraint.constant = 31
            nameSubjectHeightConstraint.constant = 20
            nameSubjectBottomConstraint.constant = 8
            audienceTopConstraint.constant = 8
            groupNamesTopConstraint.constant = 20
            nameSubject.numberOfLines = 1
        }
        
        if let timeStart = activity.timeStart{
            if let timeFinish = activity.timeEnd{
                self.timeLabel.text = "\(timeStart) - \(timeFinish)"
            } else {
                self.timeLabel.text = "\(timeStart)"
            }
        } else {
            self.timeLabel.text = ""
        }
        
        self.audienceLabel.text = activity.audiences.joined(separator: ", ")
        self.groupNames.text = activity.groups.first!
    }
    
    
    // Градиент для карточки
    func makeGradient(typeActivity: TypeActivity){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        switch typeActivity {
        case .lection:
            gradientLayer.colors = [UIColor.lectionsBackgroundColorStart.cgColor, UIColor.lectionsBackgroundColorFinish.cgColor]
        case .laboratory:
            gradientLayer.colors = [UIColor.laboratoryBackgroundColorStart.cgColor, UIColor.laboratoryBackgroundColorFinish.cgColor]
        case .practice:
            gradientLayer.colors = [UIColor.practiceBackgroundColorStart.cgColor, UIColor.practiceBackgroundColorFinish.cgColor]
        case .test:
            gradientLayer.colors = [UIColor.examinationBackgroundColorStart.cgColor, UIColor.examinationBackgroundColorFinish.cgColor]
        case .consultation:
            gradientLayer.colors = [UIColor.consultationBackgroundColorStart.cgColor, UIColor.consultationBackgroundColorFinish.cgColor]
        case .examination:
            gradientLayer.colors = [UIColor.examinationBackgroundColorStart.cgColor, UIColor.examinationBackgroundColorFinish.cgColor]
        }
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.contentView.layer.insertSublayer(gradientLayer, at: 0)
    }
    
    
    // Установка стиля label типа урока
    func updateStyleTypeLesson(typeActivity: TypeActivity){
        self.typeActivity.makeRounding()
        self.typeActivity.font = UIFont.boldSystemFont(ofSize: 11.0)
        self.typeActivity.textColor = .white
        
        switch typeActivity {
        case .lection:
            self.typeActivity.backgroundColor = .lectionsSubjectColor
            self.typeActivity.text = "Лекция"
        case .laboratory:
            self.typeActivity.backgroundColor = .practiceSubjectColor
            self.typeActivity.text = "Лабораторная"
            if self.typeActivity.isTruncated(){
                self.typeActivity.text = "Лаб"
            }
        case .practice:
            self.typeActivity.backgroundColor = .laboratorySubjectColor
            self.typeActivity.text = "Практика"
        case .test:
            self.typeActivity.backgroundColor = .examinationSubjectColor
            self.typeActivity.text = "Зачет"
        case .consultation:
            self.typeActivity.backgroundColor = .consultationSubjectColor
            self.typeActivity.text = "Консультация"
            if self.typeActivity.isTruncated(){
                self.typeActivity.text = "К"
            }
        case .examination:
            self.typeActivity.backgroundColor = .examinationSubjectColor
            self.typeActivity.text = "Экзамен"
            if self.typeActivity.isTruncated(){
                self.typeActivity.text = "Э"
            }
        }
    }
    
    
    // Установка стиля label названия предмета
    func updateStyleNameSubject(typeActivity: TypeActivity){
        
        switch typeActivity {
        case .lection:
            self.nameSubject.textColor = .lectionsSubjectColor
        case .laboratory:
            self.nameSubject.textColor = .practiceSubjectColor
        case .practice:
            self.nameSubject.textColor = .laboratorySubjectColor
        case .test:
            self.nameSubject.textColor = .examinationSubjectColor
        case .consultation:
            self.nameSubject.textColor = .consultationSubjectColor
        case .examination:
            self.nameSubject.textColor = .examinationSubjectColor
        }
    }
    
}

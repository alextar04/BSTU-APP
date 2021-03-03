//
//  GroupSheduleCard.swift
//  BSTU App
//
//  Created by Alexey Taran on 21.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class GroupSheduleCard: UIView{
    
    @IBOutlet weak var contentView: UIView!
    
    @IBOutlet weak var nameSubject: UILabel!
    @IBOutlet weak var typeActivity: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var audienceLabel: UILabel!
    
    @IBOutlet weak var photoTeacher: UIImageView!
    @IBOutlet weak var nameAndPatronymicTeacher: UILabel!
    @IBOutlet weak var surnameTeacher: UILabel!
    
    func setupView(typeActivity: TypeActivity){
        
        self.contentView.makeRounding()
        self.makeGradient(typeActivity: typeActivity)
        self.updateStyleTypeLesson(typeActivity: typeActivity)
        self.updateStyleNameSubject(typeActivity: typeActivity)
        self.updateTeacherData()
        
        self.sheduleMakeShadow(width: Int(self.frame.width), heigth: Int(self.frame.height))
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
            self.typeActivity.text = "Практика"
        case .practice:
            self.typeActivity.backgroundColor = .laboratorySubjectColor
            self.typeActivity.text = "Лабораторная"
        case .consultation:
            self.typeActivity.backgroundColor = .consultationSubjectColor
            self.typeActivity.text = "Консультация"
        case .examination:
            self.typeActivity.backgroundColor = .examinationSubjectColor
            self.typeActivity.text = "Экзамен"
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
        case .consultation:
            self.nameSubject.textColor = .consultationSubjectColor
        case .examination:
            self.nameSubject.textColor = .examinationSubjectColor
        }
    }
    
    
    // Установка информации о преподавателе
    func updateTeacherData(){
        self.photoTeacher.image = UIImage(named: "someImage")
        self.photoTeacher.sheduleMakeRoundingImage()
    }
    
}

enum TypeCard{
    case lesson
    case exam
}

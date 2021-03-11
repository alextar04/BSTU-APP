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
    @IBOutlet weak var contentViewHeightConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var nameSubject: UILabel!
    @IBOutlet weak var nameSubjectTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var nameSubjectHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var nameSubjectBottomConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var typeActivity: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var audienceLabel: UILabel!
    @IBOutlet weak var audienceTopConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var photoTeacher: UIImageView!
    @IBOutlet weak var photoTeacherTopConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var nameAndPatronymicTeacher: UILabel!
    @IBOutlet weak var nameAndPatronymicTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var surnameTeacher: UILabel!
    
    func setupView(activity: GroupSheduleModel){
        
        self.setupData(activity: activity)
        self.contentView.makeRounding()
        self.makeGradient(typeActivity: activity.typeActivity)
        self.updateStyleTypeLesson(typeActivity: activity.typeActivity)
        self.updateStyleNameSubject(typeActivity: activity.typeActivity)
        
        self.sheduleMakeShadow(width: Int(self.frame.width), heigth: Int(self.frame.height))
    }
    
    
    // MARK: Установка информации в ячейку
    func setupData(activity: GroupSheduleModel){
        
        self.nameSubject.text = activity.nameSubject
        if self.nameSubject.isTruncated(){
            nameSubjectTopConstraint.constant = 16
            nameSubjectHeightConstraint.constant = 50
            nameSubjectBottomConstraint.constant = 8
            audienceTopConstraint.constant = 22
            photoTeacherTopConstraint.constant = 11
            nameAndPatronymicTopConstraint.constant = 17
            nameSubject.numberOfLines = 2
        } else {
            nameSubjectTopConstraint.constant = 31
            nameSubjectHeightConstraint.constant = 20
            nameSubjectBottomConstraint.constant = 8
            audienceTopConstraint.constant = 8
            photoTeacherTopConstraint.constant = 18
            nameAndPatronymicTopConstraint.constant = 24
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
        
        if activity.teachers.count == 1{
            let teacherParts = activity.teachers.first?.split(separator: " ").map{
                return String($0)
            }
            if teacherParts != nil{
                if teacherParts?.count == 3{
                    self.nameAndPatronymicTeacher.text = "\(teacherParts![1]) \(teacherParts![2])"
                    self.surnameTeacher.text = "\(teacherParts![0])"
                } else{
                    self.nameAndPatronymicTeacher.text = activity.teachers.first
                    self.surnameTeacher.text = ""
                }
            }
        }
        
        if activity.teachers.count > 1{
            
            self.nameAndPatronymicTeacher.text = self.getShortTeacherRecord(teacher: activity.teachers.first!)
            self.surnameTeacher.text = activity.teachers[1..<activity.teachers.count].map{ (teacher: String)->String in
                return self.getShortTeacherRecord(teacher: teacher)
            }.joined(separator: ", ")
        }
        
        self.photoTeacher.image = UIImage(named: "baseTeacher")
        //self.photoTeacher.sheduleMakeRoundingImage()
    }
    
    
    // Получение сокращенной записи для идентификации преподавателя
    func getShortTeacherRecord(teacher: String)->String{
        
        // Выделение инициалов преподавателя
        let teacherParts = teacher.split(separator: " ").map{
            return String($0)
        }
        // Сокращенные инициалы (без фамилии)
        let notSurnamePart = teacherParts[1..<teacherParts.count].map{ names in
            return ("\(names.first!).")
        }.joined(separator: " ")
        
        return "\(teacherParts.first!) \(notSurnamePart)"
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

enum TypeCard{
    case lesson
    case exam
}

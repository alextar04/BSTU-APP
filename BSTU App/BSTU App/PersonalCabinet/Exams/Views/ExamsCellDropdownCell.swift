//
//  ExamCellDropdownCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 18.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class ExamsCellDropdownCell: UITableViewCell{
    
    @IBOutlet weak var disciplineView: UIView!
    @IBOutlet weak var disciplineName: UILabel!
    @IBOutlet weak var disciplineType: UILabel!
    @IBOutlet weak var disciplineMark: UILabel!
    var installedGradientLayer: CAGradientLayer!
    
    
    func configureCell(pairDisciplineMark: (String, TypeExam, String)){
        
        self.disciplineName.text = pairDisciplineMark.0
        self.disciplineType.text = pairDisciplineMark.1.rawValue
        self.disciplineMark.text = pairDisciplineMark.2
        self.makeGradient()
    }
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.disciplineView.bounds
        gradientLayer.colors = [UIColor.firstCourseBackgroundColorStart.cgColor,
                                UIColor.firstCourseBackgroundColorFinish.cgColor]
        
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer == nil{
            self.installedGradientLayer = gradientLayer
            self.disciplineView.layer.insertSublayer(self.installedGradientLayer, at: 0)
        }
    }
}

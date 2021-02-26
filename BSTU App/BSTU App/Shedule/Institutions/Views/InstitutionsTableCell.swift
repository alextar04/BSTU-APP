//
//  InstitutionsTableCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 26.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class InstitutionsTableCell: UITableViewCell{
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundingView: UIView!
    @IBOutlet weak var nameLabel: UILabel!
    
    func configureCell(name: String){
        self.shadowView.instituteMakeShadow(width: Int(self.roundingView.frame.width), heigth: Int(self.roundingView.frame.height))
        self.roundingView.makeRounding()
        self.makeGradient()
        self.nameLabel.text = name
    }
    
    // Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundingView.bounds
        gradientLayer.colors = [UIColor.institutionBackgroundColorStart.cgColor, UIColor.institutionBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        self.roundingView.layer.insertSublayer(gradientLayer, at: 0)
    }
}

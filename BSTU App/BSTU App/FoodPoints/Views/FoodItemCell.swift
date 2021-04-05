//
//  FoodItemCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit


class FoodItemCell: UITableViewCell{
    @IBOutlet weak var shadowView: UIView!
    @IBOutlet weak var roundedView: UIView!
    
    @IBOutlet weak var nameFood: UILabel!
    @IBOutlet weak var nameFoodHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var nameFoodTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var weightFood: UILabel!
    @IBOutlet weak var weightFoodTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var energyFoodTopConstraint: NSLayoutConstraint!
    @IBOutlet weak var energyValueFood: UILabel!
    @IBOutlet weak var costFood: UILabel!
    
    var installedGradientLayer: CAGradientLayer!
    
    
    // MARK: Конфигурация ячейки
    func configureCell(foodItem: FoodItem){
        self.shadowView.instituteMakeShadow(width: Int(self.roundedView.frame.width),
                                            heigth: Int(self.roundedView.frame.height))
        self.roundedView.makeRounding()
        self.makeGradient()
        
        self.nameFood.numberOfLines = 1
        self.nameFood.text = foodItem.nameFood
        if self.nameFood.isTruncated(){
            self.nameFoodTopConstraint.constant = 17
            self.nameFoodHeightConstraint.constant = 49
            self.weightFoodTopConstraint.constant = 8
            self.energyFoodTopConstraint.constant = 8
            self.nameFood.numberOfLines = 2
        } else {
            self.nameFoodTopConstraint.constant = 22
            self.nameFoodHeightConstraint.constant = 30
            self.weightFoodTopConstraint.constant = 8
            self.energyFoodTopConstraint.constant = 14
            self.nameFood.numberOfLines = 1
        }
        self.weightFood.text = foodItem.weightFood
        self.energyValueFood.text = foodItem.energyValueFood
        self.costFood.text = foodItem.costFood
    }
    
    
    // MARK: Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.roundedView.bounds
        gradientLayer.colors = [UIColor.institutionBackgroundColorStart.cgColor,
                                UIColor.institutionBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer == nil{
            self.installedGradientLayer = gradientLayer
            self.roundedView.layer.insertSublayer(self.installedGradientLayer, at: 0)
        }
    }
}
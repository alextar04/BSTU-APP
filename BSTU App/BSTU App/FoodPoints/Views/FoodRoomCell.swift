//
//  FoodRoomCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class FoodRoomCell: UITableViewCell{
    
    @IBOutlet weak var nameRoom: UILabel!
    @IBOutlet weak var selectionImage: UIImageView!
    var installedGradientLayer: CAGradientLayer!
    
    func configureCell(roomModel: FoodRoom){
        
        self.makeGradient()
        self.layoutMargins = UIEdgeInsets.zero
        self.nameRoom.text = roomModel.nameRoom
        // Для iPhone SE уменьшить размер шрифта написанного текста
        if self.frame.width == 304{
            self.nameRoom.font = UIFont.systemFont(ofSize: 12)
        }
        self.selectionImage.isHidden = !roomModel.isSelected
    }
    
    
    // MARK: Градиент для фона ячейки таблицы
    func makeGradient(){
        let gradientLayer = CAGradientLayer()
        gradientLayer.frame = self.bounds
        gradientLayer.colors = [UIColor.institutionBackgroundColorStart.cgColor,
                                UIColor.institutionBackgroundColorFinish.cgColor]
        gradientLayer.startPoint = CGPoint(x: 0, y: 0.5)
        gradientLayer.endPoint = CGPoint(x: 1, y: 0.5)
        
        if self.installedGradientLayer == nil{
            self.installedGradientLayer = gradientLayer
            self.layer.insertSublayer(self.installedGradientLayer, at: 0)
        }
    }
}

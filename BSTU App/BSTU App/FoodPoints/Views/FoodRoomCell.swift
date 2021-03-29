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
    
    func configureCell(roomModel: FoodRoom){
        
        self.backgroundColor = .foodPointsLightGrayColor
        self.nameRoom.text = roomModel.nameRoom
        self.selectionImage.isHidden = !roomModel.isSelected
    }
}

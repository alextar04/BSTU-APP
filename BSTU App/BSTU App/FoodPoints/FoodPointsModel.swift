//
//  FoodPointsModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class FoodItem{
    
    var nameFood: String!
    var weightFood: String!
    var energyValueFood: String!
    var costFood: String!
    
    init(nameFood: String, weightFood: String,
         energyValueFood: String, costFood: String) {
        
        self.nameFood = nameFood
        self.weightFood = weightFood
        self.energyValueFood = energyValueFood
        self.costFood = costFood
    }
}


class FoodRoom{
    
    var numberRoom: String!
    var nameRoom: String!
    var isSelected: Bool!
    
    init(numberRoom: String, nameRoom: String) {
        self.numberRoom = numberRoom
        self.nameRoom = nameRoom
        self.isSelected = false
    }
}

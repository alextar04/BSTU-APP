//
//  FoodPointsViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire
import SwiftSoup

class FoodPointsViewModel{
    
    // MARK: Получение всех точек питания университета
    func getFoodRooms(completion: @escaping ([FoodRoom])->Void, errorClosure: @escaping ()->Void) -> Void{
        
        var result = [FoodRoom]()
        for i in 0...11{
            result.append(FoodRoom(nameRoom: "Кафе профессорско-преподавательское"))
        }
        result.first?.isSelected = true
        
        completion(result)
    }
    
    
    // MARK: Получение меню для точки питания
    // Входные параметры: ID-точки питания
    func getFoodMenuForRoom(idRoom: String,
                            completion: @escaping ([FoodPointsViewController.SectionOfFoodItems])->Void, errorClosure: @escaping ()->Void) -> Void{
        
        var result = [FoodItem]()
        for _ in 0...9{
            result.append(FoodItem(nameFood: "Суп картофельный с горохом и копченостями",
                                   weightFood: "300/15 грамм",
                                   energyValueFood: "130 Ккал",
                                   costFood: "45 ₽"))
        }
        completion([FoodPointsViewController.SectionOfFoodItems(header: "Арабская кухня", items: result),
                    FoodPointsViewController.SectionOfFoodItems(header: "Китайская кухня", items: result),
                    FoodPointsViewController.SectionOfFoodItems(header: "Индийская кухня", items: result)])
    }
}

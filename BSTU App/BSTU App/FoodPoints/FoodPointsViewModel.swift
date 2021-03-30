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
    
    var totalRooms = [FoodRoom]()
    var totalMenus = [[FoodPointsViewController.SectionOfFoodItems]?]()
    
    
    // MARK: Получение всех точек питания университета
    func getFoodRooms(completion: @escaping ()->Void,
                      errorClosure: @escaping (TypeError)->Void) -> Void{

        let url = "http://menu.bstu.ru/"
        AF.request(url).responseString{ [weak self] html in
            
            do {
                let document = try SwiftSoup.parse(html.result.get())
                if try document.title() != "Пункты питания БГТУ им. Шухова"{
                    errorClosure(.serverError)
                    return
                }
                
                let pointsContainer = try document.getElementById("points_add")?.getElementsByTag("option")
                var result = [FoodRoom]()
                for point in pointsContainer!{
                    let numberPoint = try point.attr("value")
                    if numberPoint == ""{
                        continue
                    }
                    let namePoint = try point.text().capitalizingFirstLetter()
                    result.append(FoodRoom(numberRoom: numberPoint, nameRoom: namePoint))
                }
                
                result.first?.isSelected = true
                self!.totalRooms = result
                completion()
                
                } catch{
                    errorClosure(.networkError)
            }
        }
    }
    
    
    // MARK: Получение меню для точек питания
    // Входные параметры: [Точка питания]
    func getFoodMenuForRooms(completion: @escaping ()->Void,
                             errorClosure: @escaping (TypeError)->Void) -> Void{
        
        var pointsViewed = 0
        self.totalMenus = [[FoodPointsViewController.SectionOfFoodItems]?].init(repeating: nil,
                                                                                count: self.totalRooms.count)
        for (index, foodRoom) in self.totalRooms.enumerated(){
            
            let url = "http://menu.bstu.ru/"
            let headers: HTTPHeaders = [
                "Content-Type": "application/x-www-form-urlencoded"
            ]
            let parameters = [
                "point": foodRoom.numberRoom
            ]
            
            AF.request(url, method: .post, parameters: parameters, headers: headers)
                .responseString{ [weak self] html in
                    
                    do{
                        let document = try SwiftSoup.parse(html.result.get())
                        var isEmpty = false
                        
                        if try document.title() != "Пункты питания БГТУ им. Шухова"{
                            isEmpty = true
                        }
                        
                        let table = try document.getElementById("empty_menu")?.getElementsByClass("table").first()
                        if table == nil{
                            isEmpty = true
                        }
                        
                        var resultOnePlace = [FoodPointsViewController.SectionOfFoodItems]()
                        var buffer = FoodPointsViewController.SectionOfFoodItems(header: "", items: [FoodItem]())
                        
                        if !isEmpty{
                            let tableRows = try table?.getElementsByTag("tr")
                            for row in tableRows!{
                                let tableValues = try row.getElementsByTag("td")
                                let name = try tableValues[0].text()
                                let weight = try tableValues[1].text()
                                let energyValue = try tableValues[2].text()
                                let cost = try tableValues[3].text()
                                
                                if name == "Наименование"{
                                    continue
                                }
                                
                                if name != "" && weight == "" && energyValue == "" && cost == ""{
                                    if buffer.header != ""{
                                        resultOnePlace.append(buffer)
                                        buffer.header = ""
                                        buffer.items.removeAll()
                                    }
                                    buffer.header = name.lowercased().capitalizingFirstLetter()
                                    continue
                                } else {
                                    buffer.items.append(FoodItem(nameFood: name,
                                                                 weightFood: "\(weight) грамм",
                                                                 energyValueFood: "\(energyValue) Ккал",
                                                                 costFood: "\(cost) ₽"))
                                }
                            }
                        }
                        
                        self!.totalMenus[index] = resultOnePlace
                        pointsViewed += 1
                        if pointsViewed == self!.totalRooms.count{
                            completion()
                        }
                    
                    } catch {
                        errorClosure(.networkError)
                    }
            }
        }
    }
}

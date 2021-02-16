//
//  NavigationViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 29.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class NavigationViewModel{
    
    lazy var premiseList = [PremiseDB]()
    lazy var premisesTypesList = [TypePremiseDB]()
    
    init(idMap: Int) {
        getPremises(idMap: idMap)
        getTypesPremises()
    }
    
    
    // MARK: Получение списка помещений
    func getPremises(idMap: Int){

        let mapper = PremiseMapper()
        let acceptedData = mapper.getPremiseList(idMap: idMap)
        self.premiseList.removeAll()
        
        for row in acceptedData{
            let premise = PremiseDB()
            premise.id = row[mapper.idQuery]
            premise.idMap = row[mapper.idMapQuery]
            premise.idTypePremise = row[mapper.idTypePremiseQuery]
            premise.name = row[mapper.nameQuery]
            premise.description = row[mapper.descriptionQuery]
            
            self.premiseList.append(premise)
        }
    }
    
    
    // MARK: Получение списка типов помещений
    func getTypesPremises(){

        let mapper = TypePremiseMapper()
        let acceptedData = mapper.getTypePremiseList()
        self.premisesTypesList.removeAll()
        
        for row in acceptedData{
            let typePremise = TypePremiseDB()
            typePremise.id = row[mapper.idQuery]
            typePremise.name = row[mapper.nameQuery]
            typePremise.picture = row[mapper.pictureQuery]
            
            self.premisesTypesList.append(typePremise)
        }
    }
    
    
    // MARK: Получение помещения по id
    func getPremiseById(withId: Int)->PremiseDB{
        
        let mapper = PremiseMapper()
        let acceptedData = mapper.getPremiseById(withId: withId).first!
        
        let premise = PremiseDB()
        premise.id = acceptedData[mapper.idQuery]
        premise.idMap = acceptedData[mapper.idMapQuery]
        premise.idTypePremise = acceptedData[mapper.idTypePremiseQuery]
        premise.name = acceptedData[mapper.nameQuery]
        premise.description = acceptedData[mapper.descriptionQuery]
        
        return premise
    }
    
    
    // MARK: Получение типа помещения с заданным id
    func getTypePremiseById(id: Int)->TypePremiseDB{
        return self.premisesTypesList.filter{
            $0.id == id
        }.first!
    }
    
    
    // MARK: Загрузка помещений, имеющих заданный префикс
    func loadArrayPremise(prefix: String)->[PremiseDB]?{
    
        if prefix == ""{
            return Array(self.premiseList.prefix(10))
        }
        
        let result = try? premiseList.filter{ premise in
            premise.description.lowercased().hasPrefix(prefix.lowercased())
        }
        return result
    }
    
}


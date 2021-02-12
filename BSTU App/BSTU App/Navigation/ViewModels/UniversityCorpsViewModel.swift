//
//  UniversityCorpsViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 12.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation

class UniversityCorpViewModel{
    
    lazy var corpsList = [CorpDB]()
    
    init() {
        getCorps()
    }
    
    // MARK: Получение списка корпусов
    func getCorps(){
        let mapper = CorpMapper()
        let acceptedData = mapper.getCorpList()
        
        for row in acceptedData{
            let corp = CorpDB()
            corp.id = row[CorpDB.idQuery]
            corp.name = row[CorpDB.nameQuery]
            
            corpsList.append(corp)
        }
    }
    
}

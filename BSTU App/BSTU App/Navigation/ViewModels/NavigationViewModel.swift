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
    var allResults = [
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "122"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "124"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "125"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "120"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "119"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "118"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "117"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "116"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "115"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "114"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "113"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "111"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "109"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "108"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "107"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "106"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "105"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "104"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "101"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "138"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "128"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "131"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "Вход"),
            Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "WC"),
            Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "WC"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "Лифт"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "137"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "136а"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "136"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "135"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "134"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "133"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "132"),
            Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "132а"),
    ]
    
    
    // MARK: Загрузка помещений, имеющих заданный префикс
    func loadArrayPremise(prefix: String)->[Premise]?{
        
        if prefix == ""{
            return self.allResults
        }
        
        let result = try? allResults.filter{ premise in
            premise.namePremise.lowercased().hasPrefix(prefix.lowercased())
        }
        return result
    }
    
}


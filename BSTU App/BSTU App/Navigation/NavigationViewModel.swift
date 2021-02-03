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
    
    var allResults = [Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "153a"),
            Premise(type: TypePremise(type: "Гардероб", image: "wardrobe"), name: "Гардероб1"),
            Premise(type: TypePremise(type: "Гардероб", image: "wardrobe"), name: "Гардероб2"),
            Premise(type: TypePremise(type: "Гардероб", image: "wardrobe"), name: "Гардероб3"),
            Premise(type: TypePremise(type: "Буфет", image: "buffet"), name: "Столовая"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "182"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "183"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "184"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "185"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "186"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "187"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "188"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "189"),
            Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "Преподавательская"),
            Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "Туалет1"),
            Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "Туалет2"),
            Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "Туалет3"),
    ]
    
    // MARK: Загрузка помещений, имеющих заданный префикс
    func loadArrayPremise(prefix: String)->[Premise]?{
        let result = try? allResults.filter{ premise in
            premise.namePremise.hasPrefix(prefix)
        }
        return result
    }
}


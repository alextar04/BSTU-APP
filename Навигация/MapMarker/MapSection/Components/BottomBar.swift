//
//  BottomBar.swift
//  MapMarker
//
//  Created by Alexey Taran on 21.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class BottomBar: UIView{
    
    var namePremise: String!
    
    @IBOutlet weak var typePremiseLabel: UILabel!
    @IBOutlet weak var namePremiseLabel: UILabel!
    @IBOutlet weak var imagePremiseView: UIImageView!
    
    @IBOutlet weak var departureButton: UIButton!
    @IBOutlet weak var destinationButton: UIButton!
    
    
    required init?(coder: NSCoder) {
           super.init(coder: coder)
    }
       
    override public init(frame: CGRect) {
           super.init(frame: frame)
    }
       
    func setupView() {
        let premise = Premise(name: namePremise)
           
        self.typePremiseLabel.text = premise.typePremise.nameTypePremise
        self.namePremiseLabel.text = premise.namePremise
        
        self.imagePremiseView.image = UIImage(named: premise.typePremise.nameImagePremise!)
        self.imagePremiseView.makeRoundingImage()
        
        self.departureButton.makeRoundingButton()
        self.destinationButton.makeRoundingButton()
        // Добавить через RxSwift нажатия на кнопки

    }
}


// Класс "Помещение" (model-бд)
class Premise {
    var namePremise: String!
    var typePremise: TypePremise!
    
    init(name: String) {
        self.typePremise = TypePremise.getPremises().first
        self.namePremise = "\(name) \(self.typePremise.nameTypePremise!)"
    }
}


// Класс "Тип помещения" (model-бд)
class TypePremise {
    var nameTypePremise: String? = nil
    var nameImagePremise: String? = nil
    
    init(type: String, image: String) {
        self.nameTypePremise = type
        self.nameImagePremise = image
    }
    
    static func getPremises()->[TypePremise]{
        return [TypePremise(type: "Кабинет", image: "cabinet"),
                TypePremise(type: "Гардероб", image: "wardrobe"),
                TypePremise(type: "Буфет", image: "buffet"),
                TypePremise(type: "Туалет", image: "wcimage")
        ]
    }
    
    /*
    enum PremisesType {
        case Cabinet
        case Wardrobe
        case Buffet
        case WC
    }
    
    enum PremisesImage {
        case CabinetImage
        case WardrobeImage
        case BuffetImage
        case WCImage
    }
    */
}

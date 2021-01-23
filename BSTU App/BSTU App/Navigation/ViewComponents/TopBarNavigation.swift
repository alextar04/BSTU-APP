//
//  TopBarNavigation.swift
//  MapSection
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class TopBarNavigation: UIView{
    
    @IBOutlet weak var nameHousingLabel: UILabel!
    @IBOutlet weak var chooseHousing: UIImageView!
    
    @IBOutlet weak var startPlaceTextField: UITextField!
    @IBOutlet weak var finishPlaceTextField: UITextField!
    
    func setupView(){
        self.startPlaceTextField.setPlaceholderBoldFont(placeholderText: "Откуда")
        self.finishPlaceTextField.setPlaceholderBoldFont(placeholderText: "Куда")
    }
    
    
}

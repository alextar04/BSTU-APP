//
//  SearchPremiseCellTable.swift
//  BSTU App
//
//  Created by Alexey Taran on 28.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class SearchPremiseCellTable: UITableViewCell{
    
    @IBOutlet weak var typePremiseLabel: UILabel!
    @IBOutlet weak var typePremiseImage: UIImageView!
    @IBOutlet weak var namePremiseLabel: UILabel!
    @IBOutlet weak var storeyLabel: UILabel!
    var premiseId: Int!
}

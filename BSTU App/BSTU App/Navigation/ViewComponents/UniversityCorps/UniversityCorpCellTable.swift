//
//  UniversityCorpsCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class UniversityCorpCellTable: UITableViewCell{
    @IBOutlet weak var nameCorpLabel: UILabel!
    @IBOutlet weak var selectImageStatus: UIImageView!
}

class UniversityCorp{
    var name: String!
    init(name: String) {
        self.name = name
    }
}

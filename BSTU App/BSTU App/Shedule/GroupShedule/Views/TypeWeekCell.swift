//
//  TypeWeakCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 23.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class TypeWeekCell: UITableViewCell{
    
    @IBOutlet weak var nameTypeWeek: UILabel!
    @IBOutlet weak var selectionTypeWeekStatus: UIImageView!
}


class TypeWeek{
    var name: String!
    var status: Bool!
    
    init(_ name: String, _ status: Bool) {
        self.name = name
        self.status = status
    }
}

//
//  MenuTableCell.swift
//  BSTU App
//
//  Created by Alexey Taran on 08.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class MenuTableCell: UITableViewCell{
    
    @IBOutlet weak var chapterName: UILabel!
    @IBOutlet weak var chapterIcon: UIImageView!
    
    func configureCell(chapterType: ChapterType){
        
        switch chapterType{
        case .schedule:
            self.chapterName.text = "Расписание"
            self.chapterIcon.image = UIImage(named: "scheduleIcon")
        case .navigation:
            self.chapterName.text = "Навигация"
            self.chapterIcon.image = UIImage(named: "navigationIcon")
        }
    }
}


enum ChapterType: String{
    case schedule = "Расписание"
    case navigation = "Навигация"
}

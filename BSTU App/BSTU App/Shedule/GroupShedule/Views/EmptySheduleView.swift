//
//  EmptySheduleView.swift
//  BSTU App
//
//  Created by Alexey Taran on 25.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class EmptySheduleView: UIView{
    
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var picture: UIImageView!
    
    func setupView(typeActivity: TypeActivity){
        if typeActivity == .consultation || typeActivity == .examination{
            self.descriptionLabel.text = "Расписание экзаменов отсутствует."
            self.descriptionLabel.numberOfLines = 2
            self.picture.image = UIImage(named: "emptyExam")
        } else {
            self.descriptionLabel.text = "В этот день не будет пар! Хорошая возможность провести время с пользой."
            self.descriptionLabel.numberOfLines = 3
            self.picture.image = UIImage(named: "books")
        }
    }
}

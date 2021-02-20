//
//  GroupSheduleViewController.swift
//  BSTU App
//
//  Created by Alexey Taran on 20.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit

class GroupSheduleViewController: UIViewController{
    
    @IBOutlet weak var currentDayOfWeek: UILabel!
    
    @IBOutlet weak var parityDropdownButton: UIImageView!
    @IBOutlet weak var parityOfWeek: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setSettingsForDateSegmentedControl()
    }
    
    // MARK: Настройки для панели дат
    func setSettingsForDateSegmentedControl(){
        
    }
    
}

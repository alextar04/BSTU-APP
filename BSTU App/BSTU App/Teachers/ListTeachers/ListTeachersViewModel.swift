//
//  ListTeachersViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 11.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import Alamofire


class ListTeachersViewModel{
    
    func getTeachersList(completion: @escaping (([Teacher])->Void),
                         errorClosure: @escaping ()->Void){
        completion([Teacher("Иванов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Петров", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Сидоров", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Могов", try! "http://info.bstu.ru/index.php/".asURL()),
                    Teacher("Погов", try! "http://info.bstu.ru/index.php/".asURL())
        ])
    }
}

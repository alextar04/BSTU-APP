//
//  ListTeachersFirstLettersViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 24.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation


class ListTeachersFirstLettersViewModel{
    
    // MARK: Получение первых символов фамилий
    func getFirstLetters(completion: @escaping (([String])->Void),
                         errorClosure: @escaping (TypeError)->Void)->Void{
        
        let string = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ"
        var result = [String]()
        for letter in string{
            result.append(String(letter))
        }
        
        completion(result)
    }
    
}

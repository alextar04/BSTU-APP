//
//  AttestationViewModel.swift
//  BSTU App
//
//  Created by Alexey Taran on 22.03.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import SwiftyJSON
import Alamofire

class AttestationViewModel{
    
    // MARK: Получение данных об аттестации пользователя
    // Входной параметр: id пользователя
    func getUserAttestationInfo(idUser: Int,
                                completion: @escaping ([AttestationModel])->Void,
                                errorCallback: @escaping (TypeError)->Void) -> Void{
        
        let url = "http://cabinet.bstu.ru/api/1.0/certification?dataId=\(idUser)"
            .addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)
        AF.request(url!, method: .get).validate()
            .responseJSON{ response in
                
                switch response.result{
                case .success(let value):
                
                    let resultJson = JSON(value)
                    let allAttestations = resultJson["progress"].array
                    var resultAttestations = [AttestationModel]()
                    
                    guard let unwarpedAllAttestations = allAttestations else {
                        errorCallback(.serverError)
                        return
                    }
                    
                    for attestation in unwarpedAllAttestations{
                        let dataRange = attestation["period"].string
                        var disciplinesResult = [DisciplineAttestationModel]()
                        
                        for discipline in attestation["subjects"].array!{
                            disciplinesResult.append(DisciplineAttestationModel(discipline: (discipline["subjectname"].string!,
                                                                                             discipline["mark"].int!)))
                        }
                        
                        resultAttestations.append(AttestationModel(dataRange: dataRange!,
                                                                   disciplines: disciplinesResult))
                    }
                    completion(resultAttestations)
                    
                case .failure(_):
                    errorCallback(.networkError)
                }
        }
    }
}

//
//  BottomBar.swift
//  MapMarker
//
//  Created by Alexey Taran on 21.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import RxGesture

class BottomBarNavigation: UIView{
    
    var namePremise: String!
    
    @IBOutlet weak var typePremiseLabel: UILabel!
    @IBOutlet weak var namePremiseLabel: UILabel!
    @IBOutlet weak var imagePremiseView: UIImageView!
    
    @IBOutlet weak var departureButton: UIButton!
    @IBOutlet weak var destinationButton: UIButton!

    var maxHeightBar: CGFloat!
    var animator: UIViewPropertyAnimator!
    let disposeBag = DisposeBag()
    
    required init?(coder: NSCoder) {
           super.init(coder: coder)
    }
       
    override public init(frame: CGRect) {
           super.init(frame: frame)
    }
    
    func getHeightBar(heightBottomBar: CGFloat){
        self.maxHeightBar = heightBottomBar
    }
    
    func initAnimationObject(){
        self.animator = UIViewPropertyAnimator(duration: 0.3, dampingRatio: 12.0){
            self.frame = self.frame.offsetBy(dx: 0, dy: self.maxHeightBar)
        }
    }
    
    func setupView(namePremise: String, heightBar: CGFloat) {
        
        self.maxHeightBar = heightBar
        self.namePremise = namePremise
        
        let premise = PremiseViewModel(name: namePremise)
           
        self.typePremiseLabel.text = premise.typePremise.nameTypePremise
        self.namePremiseLabel.text = premise.namePremise
        
        self.imagePremiseView.image = UIImage(named: premise.typePremise.nameImagePremise!)
        self.imagePremiseView.makeRoundingImage()
        
        _ = [self.departureButton, self.destinationButton].map{
            $0?.makeRoundingButton()
        }
        
        self.departureButton.rx.tap.bind{
            NotificationCenter.default.post(name: Notification.Name("FillStartPlace"), object: nil)
        }.disposed(by: disposeBag)
        
        self.destinationButton.rx.tap.bind{
            NotificationCenter.default.post(name: Notification.Name("FillFinishPlace"), object: nil)
        }.disposed(by: disposeBag)
 
        self.rx.panGesture()
            .when(.began, .changed, .ended)
            .subscribe(onNext: { recognizer in
                self.bottomBarMoving(recognizer: recognizer)
        }).disposed(by: disposeBag)
        
        initAnimationObject()
    }
    
    
    @objc func bottomBarMoving(recognizer: UIPanGestureRecognizer) {
        switch recognizer.state {
        case .began:
            startMovingAnimation()
        case .changed:
            updateMovingAnimation(recognizer: recognizer)
        case .ended:
            endAnimation()
        default:
            ()
        }
    }
    
    func startMovingAnimation(){
        self.animator.pauseAnimation()
    }
    
    func updateMovingAnimation(recognizer: UIPanGestureRecognizer) {
        let translation = recognizer.translation(in: self)
        let fractionComplete = translation.y / self.maxHeightBar
        self.animator.fractionComplete = fractionComplete
    }
    
    func endAnimation() {
        if animator.fractionComplete > 0.2{
            animator.continueAnimation(withTimingParameters: nil, durationFactor: 0)
            animator.addCompletion{ _ in
                let userInfo: [String: Any] = ["staySelected": true]
                NotificationCenter.default.post(name: Notification.Name("CloseBottomBar"), object: nil, userInfo: userInfo)
            }
        } else {
            animator.isReversed = true
            animator.continueAnimation(withTimingParameters: nil, durationFactor: 0)
        }
        initAnimationObject()
    }
    
}


class PremiseViewModel {
    var namePremise: String!
    var typePremise: TypePremise!
    
    init(name: String) {
        self.typePremise = Premise.getPremises().first{ premise in
            premise.namePremise == name
        }?.typePremise
        self.namePremise = "\(name) \(self.typePremise.nameTypePremise!)"
    }
}


// Класс "Помещение" (model-бд)
class Premise {
    var namePremise: String!
    var typePremise: TypePremise!
    
    init(type: TypePremise!, name: String) {
        self.typePremise = type
        self.namePremise = name
    }
    
    static func getPremises()->[Premise]{
        return [
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "122"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "124"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "125"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "120"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "119"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "118"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "117"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "116"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "115"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "114"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "113"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "111"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "109"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "108"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "107"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "106"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "105"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "104"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "101"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "138"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "128"),
                Premise(type: TypePremise(type: "Кабинет", image: "cabinet"), name: "131"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "Вход"),
                Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "WC"),
                Premise(type: TypePremise(type: "Туалет", image: "wc"), name: "WC"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "Лифт"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "137"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "136а"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "136"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "135"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "134"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "133"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "132"),
                Premise(type: TypePremise(type: "Кабинет", image: "wc"), name: "132а"),
        ]
    }
}


// Класс "Тип помещения" (model-бд)
class TypePremise {
    var nameTypePremise: String? = nil
    var nameImagePremise: String? = nil
    
    init(type: String, image: String) {
        self.nameTypePremise = type
        self.nameImagePremise = image
    }
    
    static func getPremises()->[TypePremise]{
        return [TypePremise(type: "Кабинет", image: "cabinet"),
                TypePremise(type: "Гардероб", image: "wardrobe"),
                TypePremise(type: "Буфет", image: "buffet"),
                TypePremise(type: "Туалет", image: "wc")
        ]
    }
    
    /*
    enum PremisesType {
        case Cabinet
        case Wardrobe
        case Buffet
        case WC
    }
    
    enum PremisesImage {
        case CabinetImage
        case WardrobeImage
        case BuffetImage
        case WCImage
    }
    */
}

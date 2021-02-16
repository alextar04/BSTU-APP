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
    
    func setupView(idPremise: Int, heightBar: CGFloat, viewController: NavigationViewController) {
        
        self.maxHeightBar = heightBar
        
        let premise = viewController.viewModel.getPremiseById(withId: idPremise)
        let typePremise = viewController.viewModel.getTypePremiseById(id: premise.idTypePremise)
        self.namePremise = premise.name
           
        self.typePremiseLabel.text = typePremise.name
        self.namePremiseLabel.text = premise.description
        
        self.imagePremiseView.image = UIImage(data: typePremise.picture)
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

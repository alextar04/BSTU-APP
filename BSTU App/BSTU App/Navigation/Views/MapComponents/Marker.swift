//
//  Marker.swift
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


class Marker: UIView{
    
    var text = String()
    var idPremise: Int!
    var xPosition: CGFloat = 0.0
    var yPosition: CGFloat = 0.0
    
    var mapScale: CGFloat = 1.0
    
    var containerView = UIView()
    var labelView = UILabel()
    var pointerView = UIImageView()
    var paintingPriority = 0
    let disposeBag = DisposeBag()
    
    var statusSelected: Bool = false{
        didSet{
            removeAllSubviews()
            setupViews()
        }
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    override public init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    init(position: (Int, Int), text: String, idPremise: Int) {
        super.init(frame: CGRect())
        self.text = text
        self.idPremise = idPremise
        self.xPosition = CGFloat(position.0)
        self.yPosition = CGFloat(position.1)
        
        setupViews()
        setupTapContainerView()
    }
    
    
    func removeAllSubviews(){
        for view in self.subviews{
            view.removeFromSuperview()
        }
        for view in self.containerView.subviews{
            view.removeFromSuperview()
        }
    }
    
    func setLabelStyle(backgroundColor: UIColor, textColor: UIColor, tintColor: UIColor){
        self.labelView.backgroundColor = backgroundColor
        self.labelView.textColor = textColor
        self.labelView.text = self.text
        self.labelView.font = UIFont.boldSystemFont(ofSize: 18.0)
        self.labelView.textAlignment = .center
        
        let imagePointerView = UIImageView(image: UIImage(named: "marker_pointer"))
        let templateImage = imagePointerView.image?.withRenderingMode(.alwaysTemplate)
        imagePointerView.image = templateImage
        imagePointerView.tintColor = tintColor
        imagePointerView.contentMode = .scaleAspectFit
        self.pointerView = imagePointerView
    }
    
    
    func setupViews(){
        self.statusSelected ? setLabelStyle(backgroundColor: .blue, textColor: .white, tintColor: .blue) :
                              setLabelStyle(backgroundColor: .white, textColor: .black, tintColor: .white)
        
        self.labelView.makeRounding()
        
        let labelWidth = Int(self.labelView.intrinsicContentSize.width) + 15
        let labelHeight = 30
        self.labelView.frame = CGRect(x: 0, y: 0,
                                      width: labelWidth, height: labelHeight)
        
        let pointerWidth = 30
        let pointerHeight = 40
        let startPointerYPosition = labelHeight/2 - 3
        self.pointerView.frame = CGRect(x: labelWidth/2 - pointerWidth/2, y: startPointerYPosition,
                                        width: pointerWidth, height: pointerHeight)
        
        self.makeShadow(width: labelWidth,
                                 heigth: startPointerYPosition + pointerHeight)
        containerView.addSubview(self.labelView)
        containerView.addSubview(self.pointerView)
        self.addSubview(containerView)
        
        if (self.frame == CGRect(x: 0, y: 0, width: 0, height: 0)){
            self.frame = CGRect(x: Int(xPosition), y: Int(yPosition),
                            width: labelWidth, height: startPointerYPosition + pointerHeight)
        }
    }
     
    
    func setupTapContainerView() {
        self.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { sender in
                self.markerTapped(sender: sender)
        }).disposed(by: disposeBag)
    }
    
    
    @objc func markerTapped(sender: UITapGestureRecognizer){
        self.statusSelected = true
        self.paintingPriority = 1
        
        UIView.animate(withDuration: 0.2,
            animations: {
                self.transform = CGAffineTransform(scaleX: 0.9 * self.mapScale, y: 0.9 * self.mapScale)
            },
            completion: { _ in
                UIView.animate(withDuration: 0.2) {
                    self.transform = CGAffineTransform(scaleX: self.mapScale, y: self.mapScale)
                }
        })
        
        // Действия по открытию нижнего бара с информацией
        let userInfo: [String: Any] = ["idPremise": self.idPremise,
                                       "tapRecognizer": sender]
        NotificationCenter.default.post(name: Notification.Name("OpenBottomBar"), object: nil, userInfo: userInfo)
    }
    
    
    func closeMarker(sender: Any){
        self.statusSelected = false
        self.paintingPriority = 0
        
        var userInfo = [String: Any]()

        userInfo = ["idPremise": self.idPremise,
                    "tapRecognizer": sender]

        NotificationCenter.default.post(name: Notification.Name("CloseBottomBar"), object: nil, userInfo: userInfo)
    }
}
    

//
//  Marker.swift
//  MapMarker
//
//  Created by Alexey Taran on 21.01.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import UIKit



class Marker: UIView{
    
    var text = String()
    var xPosition: Int = 0
    var yPosition: Int = 0
    
    var containerView = UIView()
    var labelView = UILabel()
    var pointerView = UIImageView()
    
    var statusSelected: Bool = false{
        didSet{
            removeAllSubviews()
            setupViews()
            setupContainerView()
        }
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    override public init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    init(position: (Int, Int), text: String) {
        super.init(frame: CGRect())
        self.text = text
        self.xPosition = position.0
        self.yPosition = position.1
        
        setupViews()
        setupContainerView()
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
    }
     
        
    func setupContainerView() {
        
        let labelWidth = Int(self.labelView.intrinsicContentSize.width) + 15
        let labelHeight = 30
        self.labelView.frame = CGRect(x: 0, y: 0,
                                      width: labelWidth, height: labelHeight)
        
        let pointerWidth = 30
        let pointerHeight = 40
        let startPointerYPosition = labelHeight/2 - 3
        self.pointerView.frame = CGRect(x: labelWidth/2 - pointerWidth/2, y: startPointerYPosition,
                                        width: pointerWidth, height: pointerHeight)
        
        
        containerView.makeShadow(width: labelWidth,
                                 heigth: startPointerYPosition + pointerHeight)
        containerView.addSubview(self.labelView)
        containerView.addSubview(self.pointerView)
        self.addSubview(containerView)
        self.frame = CGRect(x: xPosition, y: yPosition,
                            width: labelWidth, height: startPointerYPosition + pointerHeight)
        
        
        let tapMarkerRecognizer = UITapGestureRecognizer(target: self, action: #selector(markerTapped(sender:)))
        self.addGestureRecognizer(tapMarkerRecognizer)
    }
    
    @objc func markerTapped(sender: UITapGestureRecognizer){
        self.statusSelected = !self.statusSelected
        
        UIView.animate(withDuration: 0.2,
            animations: {
                self.transform = CGAffineTransform(scaleX: 0.9, y: 0.9)
            },
            completion: { _ in
                UIView.animate(withDuration: 0.2) {
                    self.transform = CGAffineTransform.identity
                }
        })
        
        // Действия по открытию нижнего бара с информацией
        
        if self.statusSelected{
            //print("Открылся нижний бар: \((sender.view as! Marker).text)")
            NotificationCenter.default.post(name: Notification.Name("OpenBottomBar"), object: nil)
        } else {
            //print("Закрылся нижний бар: \((sender.view as! Marker).text)")
            NotificationCenter.default.post(name: Notification.Name("CloseBottomBar"), object: nil)
        }
    }
}

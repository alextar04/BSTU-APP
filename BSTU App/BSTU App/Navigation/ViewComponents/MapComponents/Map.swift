//
//  Map.swift
//  BSTU App
//
//  Created by Alexey Taran on 01.02.2021.
//  Copyright © 2021 Alexey Taran. All rights reserved.
//

import Foundation
import RxSwift
import RxCocoa
import UIKit

class Map: UIScrollView, UIScrollViewDelegate{
    
    var mapScheme: UIImageView!
    let disposeBag = DisposeBag()
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.showsHorizontalScrollIndicator = false
        self.showsVerticalScrollIndicator = false
        self.decelerationRate = .fast
        //self.zoom(to: CGRect(x: 200, y: 200, width: 200, height: 200), animated: true)
        self.bouncesZoom = false
        
        self.mapScheme = UIImageView(image: UIImage(named: "someStage"))
        self.addSubview(self.mapScheme)
        
        let someView = Marker(position: (50, 150), text: "153a")
        let someView1 = Marker(position: (200, 150), text: "Столовая")
        let someView2 = Marker(position: (100, 200), text: "Гардероб")
        self.addSubview(someView)
        self.addSubview(someView1)
        self.addSubview(someView2)
    }
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    func setupView(){
        self.delegate = self
        setCurrentScale()
        
        self.rx.didZoom.subscribe(onNext: {
            self.setCenterMapScheme()
            }).disposed(by: disposeBag)
        
    }
    
    
    // MARK: При изменении размеров карты вызывается перерисовка
    override func layoutSubviews() {
        super.layoutSubviews()
        setCenterMapScheme()
    }
    
    
    // MARK: Функция установки значения зума
    func setCurrentScale(){
        let boundsSize = self.bounds.size
        let mapSchemeSize = self.mapScheme.bounds.size
        
        let xScale = boundsSize.width / mapSchemeSize.width
        let yScale = boundsSize.height / mapSchemeSize.height
        let minScale = min(xScale, yScale)
        
        var maxScale: CGFloat = 1.0
        if minScale < 0.1{
            maxScale = 0.3
        }
        if minScale >= 0.1 && minScale < 0.5{
            maxScale = 1.2
        }
        if minScale >= 0.5{
            maxScale = max(1.2, minScale)
        }
        
        self.minimumZoomScale = minScale
        self.maximumZoomScale = maxScale
    }
    
    
    // MARK: Функция центровки изображения карты про уменьшении масштаба
    func setCenterMapScheme(){
        let boundsSize = self.bounds.size
        var frameToCenter = self.mapScheme.frame ?? CGRect.zero
        
        if frameToCenter.size.width < boundsSize.width{
            frameToCenter.origin.x = (boundsSize.width - frameToCenter.size.width) / 2
        } else {
            frameToCenter.origin.x = 0
        }
        
        if frameToCenter.size.height < boundsSize.height{
            frameToCenter.origin.y = (boundsSize.height - frameToCenter.size.height) / 2
        } else {
            frameToCenter.origin.y = 0
        }
        
        self.mapScheme.frame = frameToCenter
    }
    
    
    // MARK: - UIScrollViewDelegate
    func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return self.mapScheme
    }
    
}

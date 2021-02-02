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
    var markers: [Marker]!
    let disposeBag = DisposeBag()
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.showsHorizontalScrollIndicator = false
        self.showsVerticalScrollIndicator = false
        self.decelerationRate = .fast
        self.bouncesZoom = false
        //self.zoom(to: CGRect(x: 200, y: 200, width: 200, height: 200), animated: true)
        
        self.mapScheme = UIImageView(image: UIImage(named: "someStage"))
        self.mapScheme.isUserInteractionEnabled = true
        self.addSubview(self.mapScheme)
        
        let someView = Marker(position: (200, 200), text: "153a")
        let someView1 = Marker(position: (300, 300), text: "Столовая")
        let someView2 = Marker(position: (400, 400), text: "Гардероб")
        let someView3 = Marker(position: (500, 500), text: "Преподавательская")
        let someView4 = Marker(position: (600, 650), text: "182")
        let someView5 = Marker(position: (700, 800), text: "Туалет")
        
        self.markers = [someView, someView1, someView2, someView3, someView4, someView5]
        _ = markers.map{ marker in
            self.mapScheme.addSubview(marker)
        }
    }
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    func setupView(){
        self.delegate = self
        setCurrentScale()
        
        self.rx.didZoom.subscribe(onNext: {
            for marker in self.markers{
                marker.transform = CGAffineTransform(scaleX: 1.0/self.zoomScale, y: 1.0/self.zoomScale)
                marker.xPosition = marker.frame.minX
                marker.yPosition = marker.frame.minY
                marker.mapScale = 1.0/self.zoomScale
            }
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

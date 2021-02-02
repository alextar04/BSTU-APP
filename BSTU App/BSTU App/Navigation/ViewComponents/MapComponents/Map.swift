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
        
        self.mapScheme = UIImageView(image: UIImage(named: "someStage"))
        self.mapScheme.isUserInteractionEnabled = true
        self.addSubview(self.mapScheme)
        self.contentSize = CGSize(width: mapScheme.frame.width, height: mapScheme.frame.height)
        
        // Стартовая позиция камеры
        self.contentOffset = CGPoint(x: 400, y: 400)
        let someView = Marker(position: (200, 200), text: "153a")
        let someView1 = Marker(position: (300, 300), text: "Столовая")
        let someView2 = Marker(position: (400, 400), text: "Гардероб")
        let someView3 = Marker(position: (500, 500), text: "Преподавательская")
        let someView4 = Marker(position: (600, 650), text: "182")
        let someView5 = Marker(position: (700, 800), text: "Туалет")
        
        self.markers = [someView, someView1, someView2, someView3, someView4, someView5]
        for marker in markers{
            self.mapScheme.addSubview(marker)
        }
    }
    
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
    func setupView(){
        self.delegate = self
        setCurrentScale()
        
        // Пересчет координат при зуме
        self.rx.didZoom.subscribe(onNext: {
            for marker in self.markers{
                marker.transform = CGAffineTransform(scaleX: 1.0/self.zoomScale, y: 1.0/self.zoomScale)
                marker.mapScale = 1.0/self.zoomScale
            }
                self.setCenterMapScheme()
            }).disposed(by: disposeBag)
        
        // Закрытие маркеров при нажатии на экран
        self.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { sender in
                let userInfo: [String: Any] = ["tapRecognizer": sender]
                NotificationCenter.default.post(name: Notification.Name("CloseMarkerAndBottomBar"), object: nil, userInfo: userInfo)
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
        
        if (frameToCenter.size.width < boundsSize.width){
            frameToCenter.origin.x = (boundsSize.width - frameToCenter.size.width) / 2
            
            let absX = abs(frameToCenter.origin.x)
            if absX > 0 && absX < 1{
                frameToCenter.origin.x = 0
            }
            
        } else {
            frameToCenter.origin.x = 0
        }
        
        if (frameToCenter.size.height < boundsSize.height){
            frameToCenter.origin.y = (boundsSize.height - frameToCenter.size.height) / 2
            
            let absY = abs(frameToCenter.origin.y)
            if absY > 0 && absY < 1{
                frameToCenter.origin.y = 0
            }
             
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

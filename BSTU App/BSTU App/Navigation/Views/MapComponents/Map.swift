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
    var pathLayer: CAShapeLayer!
    
    var firstDraw = true
    var zoomLastDraw: CGFloat = 0.0
    var paintedMarkersInZoom = [Marker]()
    
    let disposeBag = DisposeBag()
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.showsHorizontalScrollIndicator = false
        self.showsVerticalScrollIndicator = false
        self.decelerationRate = .fast
        self.bouncesZoom = false
        
        self.mapScheme = UIImageView(image: UIImage(named: "someMap3"))
        self.mapScheme.isUserInteractionEnabled = true
        self.addSubview(self.mapScheme)
        self.contentSize = CGSize(width: mapScheme.frame.width, height: mapScheme.frame.height)
        
        // Стартовая позиция камеры
        self.contentOffset = CGPoint(x: 800, y: 900)
        let views = [Marker(position: (60 * 2 + 300, 270 * 2 + 300), text: "153a"),
                     Marker(position: (300 * 2 + 300, 300 * 2 + 300), text: "Столовая"),
                     Marker(position: (400 * 2 + 300, 400 * 2 + 300), text: "Гардероб1"),
                     Marker(position: (475 * 2 + 300, 400 * 2 + 300), text: "Гардероб2"),
                     Marker(position: (560 * 2 + 300, 1200), text: "Гардероб3"),
                     Marker(position: (1460, 400 * 2 + 300), text: "Преподавательская"),
                     Marker(position: (430 * 2 + 300, 550 * 2 + 300), text: "182"),
                     Marker(position: (475 * 2 + 300, 550 * 2 + 300), text: "183"),
                     Marker(position: (520 * 2 + 300, 550 * 2 + 300), text: "184"),
                     Marker(position: (560 * 2 + 300, 550 * 2 + 300), text: "185"),
                     Marker(position: (700 * 2 + 300, 30 * 2 + 300), text: "Туалет1"),
                     Marker(position: (700 * 2 + 300, 100 * 2 + 300), text: "Туалет2"),
                     Marker(position: (700 * 2 + 300, 150 * 2 + 300), text: "186"),
                     Marker(position: (700 * 2 + 300, 200 * 2 + 300), text: "187"),
                     Marker(position: (700 * 2 + 300, 250 * 2 + 300), text: "188"),
                     Marker(position: (700 * 2 + 300, 280 * 2 + 300), text: "189"),
                     Marker(position: (700 * 2 + 300, 330 * 2 + 300), text: "Туалет3"),
        ]
        
        self.markers = views
        for marker in markers{
            self.mapScheme.addSubview(marker)
        }
        
        drawPathBetweenAudience(v1: 1, v2: 14)
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
        self.mapScheme.rx.tapGesture()
            .when(.recognized)
            .subscribe(onNext: { sender in
                
                let touchPoint = sender.location(in: self)
                
                var isButton = false
                var existSelectedMarker = false
                
                for marker in self.markers{
                    if (marker.frame.minX * self.zoomScale) <= touchPoint.x && (marker.frame.maxX * self.zoomScale) >= touchPoint.x
                        && (marker.frame.minY * self.zoomScale) <= touchPoint.y && (marker.frame.maxY * self.zoomScale) >= touchPoint.y{
                        if !marker.isHidden{
                            isButton = true
                        }
                    }
                    if marker.statusSelected{
                        existSelectedMarker = true
                    }
                    
                    if isButton && existSelectedMarker{
                        break
                    }
                }
                
                if !isButton && existSelectedMarker{
                    let userInfo: [String: Any] = ["tapRecognizer": sender]
                    NotificationCenter.default.post(name: Notification.Name("CloseMarkerAndBottomBar"), object: nil, userInfo: userInfo)
                }
        }).disposed(by: disposeBag)
    }
    
    
    // MARK: При изменении размеров карты вызывается перерисовка
    override func layoutSubviews() {
        super.layoutSubviews()
        if self.firstDraw{
            self.zoomScale = 0.3
            firstDraw = false
        }

        setCenterMapScheme()
        markerPainting()
    }

    
    // MARK: Функция установки значения зума
    func setCurrentScale(){
        let minScale: CGFloat = 0.3
        let maxScale: CGFloat = 1.0
        
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
    
    
    // MARK: Отображение маркеров с изменением масштаба
    func markerPainting(){
        let deltaZoom = self.zoomScale - self.zoomLastDraw
        
        if deltaZoom > 0{
            // Увеличение зума
            // Сортировка неотрисованных маркеров в порядке убывания длин
            var sortedMarkers = self.markers!.filter{ !self.paintedMarkersInZoom.contains($0) }
            sortedMarkers = sortedMarkers.sorted(by: { marker1, marker2 in
                return marker1.frame.width > marker2.frame.width
            })
            
            // Отобразить маркеры, исключая перекрытий
            for marker in sortedMarkers{
                var statusHidden = false
                for paintedMarker in self.paintedMarkersInZoom{
                    if marker.frame.intersects(paintedMarker.frame){
                        statusHidden = true
                        break
                    }
                }
                
                if !statusHidden{
                    UIView.animate(withDuration: 0.3, delay: 0, options: .curveEaseOut,
                      animations: {
                        marker.alpha = 1
                        marker.isHidden = false
                    })
                    paintedMarkersInZoom.append(marker)
                } else {
                    marker.alpha = 0
                    marker.isHidden = true
                }
            }
        }
        
        if deltaZoom < 0 {
            // Уменьшение зума
            // Сортировка отрисованных маркеров в порядке убывания длин
            var sortedMarkers = self.paintedMarkersInZoom.sorted(by: { marker1, marker2 in
                return marker1.frame.width > marker2.frame.width
            })
            
            // Убрать нарисованные маркеры, исключая перекрытий
            for marker1 in sortedMarkers{
                var statusHidden = false
                for marker2 in self.paintedMarkersInZoom{
                    if marker1 == marker2{
                        break
                    }
                    if marker1.frame.intersects(marker2.frame){
                        statusHidden = true
                        break
                    }
                }
                
                if !statusHidden{
                    UIView.animate(withDuration: 0.3, delay: 0, options: .curveEaseOut,
                      animations: {
                        marker1.alpha = 1
                        marker1.isHidden = false
                    })
                } else {
                    marker1.alpha = 0
                    marker1.isHidden = true
                    self.paintedMarkersInZoom = self.paintedMarkersInZoom.filter{ $0 != marker1}
                }
            }
        }
        
        self.zoomLastDraw = self.zoomScale
    }
    
    
    // MARK: Отображение пути между кабинетами на карте
    func drawPathBetweenAudience(v1: Int, v2: Int){
        
        let temp = Path()
        temp.searchShortestWays()
        let pathVertex = temp.getPath(vertex1Index: v1, vertex2Index: v2)
        
        let path = UIBezierPath()
        for (index, vertex) in pathVertex.enumerated(){
            if index == 0{
                path.move(to: temp.dotsPositions[vertex].toAudience!)
                path.addLine(to: temp.dotsPositions[vertex].coordinates)
            } else if index == pathVertex.count - 1{
                path.addLine(to: temp.dotsPositions[vertex].coordinates)
                path.addLine(to: temp.dotsPositions[vertex].toAudience!)
            } else {
                path.addLine(to: temp.dotsPositions[vertex].coordinates)
            }
            
        }
        /*
        path.move(to: CGPoint(x: 700, y: 1000))
        path.addLine(to: CGPoint(x: 800, y: 1000))
        path.addLine(to: CGPoint(x: 800, y: 1100))
        path.addLine(to: CGPoint(x: 900, y: 1100))
        path.addLine(to: CGPoint(x: 1200, y: 1100))
        */
        

        self.pathLayer = CAShapeLayer()
        self.pathLayer.path = path.cgPath
        self.pathLayer.strokeEnd = 0
        self.pathLayer.lineWidth = 14
        self.pathLayer.opacity = 0.7
        self.pathLayer.lineCap = .round
        self.pathLayer.strokeColor = UIColor.orangePathColor.cgColor
        self.pathLayer.fillColor = UIColor.clear.cgColor
        self.mapScheme.layer.insertSublayer(self.pathLayer, at: 0)
        // Удаление перед рисованием нового пути!!
        //self.pathLayer.removeFromSuperlayer()
        //self.pathLayer.removeAllAnimations()
        
        
        let animation = CABasicAnimation(keyPath: "strokeEnd")
        animation.toValue = 1
        animation.speed = 0.2
        animation.fillMode = .forwards
        animation.isRemovedOnCompletion = false
        
        self.pathLayer.add(animation, forKey: "line")
    }
    
    
    // MARK: - UIScrollViewDelegate
    func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return self.mapScheme
    }
    
}

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
    var viewModel: MapViewModel!
    
    var firstDraw = true
    var zoomLastDraw: CGFloat = 0.0
    var paintedMarkersInZoom = [Marker]()
    
    let disposeBag = DisposeBag()
    
    
    init(frame: CGRect, idMap: Int) {
        super.init(frame: frame)
        
        self.backgroundColor = .white
        self.showsHorizontalScrollIndicator = false
        self.showsVerticalScrollIndicator = false
        self.decelerationRate = .fast
        self.bouncesZoom = false
        
        self.viewModel = MapViewModel(idMap: idMap)
        
        self.mapScheme = self.viewModel.mapScheme
        self.mapScheme.isUserInteractionEnabled = true
        self.addSubview(self.mapScheme)
        self.contentSize = CGSize(width: mapScheme.frame.width, height: mapScheme.frame.height)
        
        // Стартовая позиция камеры
        UIView.animate(withDuration: 0.6, animations: {
        self.setContentOffset(CGPoint(x: 1000,
                                      y: 1000), animated: false)
        })
        
        self.markers = self.viewModel.markerList
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
            // Сортировка отрисованных маркеров в порядке убывания длин и приоритетов отрисовки
            var sortedMarkers = self.paintedMarkersInZoom.sorted(by: { marker1, marker2 in
                if marker1.paintingPriority > marker2.paintingPriority{
                    return true
                }
                
                if marker1.paintingPriority < marker2.paintingPriority{
                    return false
                }
                
                return marker1.frame.width > marker2.frame.width
            })
            
            // Убрать нарисованные маркеры, исключая перекрытий
            for marker1 in sortedMarkers{
                var statusHidden = false
                for marker2 in self.paintedMarkersInZoom.sorted(by: { marker1, marker2 in
                    if marker1.paintingPriority > marker2.paintingPriority{
                        return true
                    }
                    
                    if marker1.paintingPriority < marker2.paintingPriority{
                        return false
                    }
                    
                    return marker1.frame.width > marker2.frame.width
                }){

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

        let shortestPathVertexs = self.viewModel.getPath(vertex1Index: v1, vertex2Index: v2)
        
        let path = UIBezierPath()
        for (index, vertex) in shortestPathVertexs.enumerated(){
            if index == 0{
                path.move(to: CGPoint(x: viewModel.dotsPositions[vertex].audienceX!, y: viewModel.dotsPositions[vertex].audienceY!))
                path.addLine(to: CGPoint(x: viewModel.dotsPositions[vertex].x, y: viewModel.dotsPositions[vertex].y))
            } else if index == shortestPathVertexs.count - 1{
                path.addLine(to: CGPoint(x: viewModel.dotsPositions[vertex].x, y: viewModel.dotsPositions[vertex].y))
                path.addLine(to: CGPoint(x: viewModel.dotsPositions[vertex].audienceX!, y: viewModel.dotsPositions[vertex].audienceY!))
            } else {
                path.addLine(to: CGPoint(x: viewModel.dotsPositions[vertex].x, y: viewModel.dotsPositions[vertex].y))
            }
        }

        self.pathLayer = CAShapeLayer()
        self.pathLayer.path = path.cgPath
        self.pathLayer.strokeEnd = 0
        self.pathLayer.lineWidth = 14
        self.pathLayer.opacity = 0.7
        self.pathLayer.lineCap = .round
        self.pathLayer.strokeColor = UIColor.orangePathColor.cgColor
        self.pathLayer.fillColor = UIColor.clear.cgColor
        self.mapScheme.layer.insertSublayer(self.pathLayer, at: 0)
        
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

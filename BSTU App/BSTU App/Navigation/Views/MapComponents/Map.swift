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
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        self.showsHorizontalScrollIndicator = false
        self.showsVerticalScrollIndicator = false
        self.decelerationRate = .fast
        self.bouncesZoom = false
        
        self.viewModel = MapViewModel(idMap: 1)
        
        self.mapScheme = self.viewModel.mapScheme//UIImageView(image: UIImage(named: "guk_1_result"))
        self.mapScheme.isUserInteractionEnabled = true
        self.addSubview(self.mapScheme)
        self.contentSize = CGSize(width: mapScheme.frame.width, height: mapScheme.frame.height)
        
        // Стартовая позиция камеры
        UIView.animate(withDuration: 0.6, animations: {
        self.setContentOffset(CGPoint(x: 1000,
                                      y: 1000), animated: false)
        })
        
        /*
        let views = [Marker(position: (490, 900), text: "122"),
                     Marker(position: (700, 900), text: "124"),
                     Marker(position: (975, 900), text: "125"),
                     Marker(position: (450, 1158), text: "120"),
                     Marker(position: (767, 1158), text: "119"),
                     Marker(position: (790, 1573), text: "118"),
                     Marker(position: (767, 1884), text: "117"),
                     Marker(position: (975, 1900), text: "116"),
                     Marker(position: (1100, 1792), text: "115"),
                     Marker(position: (1100, 1594), text: "114"),
                     Marker(position: (1100, 1490), text: "113"),
                     Marker(position: (1050, 1370), text: "WC"),
                     Marker(position: (1140, 1370), text: "WC"),
                     Marker(position: (1220, 1370), text: "111"),
                     Marker(position: (1450, 1370), text: "109"),
                     Marker(position: (1615, 1370), text: "108"),
                     Marker(position: (1685, 1370), text: "107"),
                     Marker(position: (1770, 1370), text: "106"),
                     Marker(position: (1720, 1570), text: "105"),
                     Marker(position: (1720, 1700), text: "104"),
                     Marker(position: (1720, 1942), text: "101"),
                     Marker(position: (2100, 1375), text: "138"),
                     Marker(position: (1335, 1120), text: "128"),
                     Marker(position: (1500, 1120), text: "131"),
                     Marker(position: (1980, 957), text: "Вход"),
                     Marker(position: (1980, 811), text: "137"),
                     Marker(position: (1980, 539), text: "136а"),
                     Marker(position: (1980, 392), text: "136"),
                     Marker(position: (1720, 340), text: "135"),
                     Marker(position: (1720, 450), text: "134"),
                     Marker(position: (1720, 620), text: "133"),
                     Marker(position: (1720, 811), text: "132"),
                     Marker(position: (1720, 935), text: "132а"),
                     Marker(position: (1650, 1050), text: "Лифт"),
        ]*/
        
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
                return marker1.frame.width > marker2.frame.width
            })
            
            // Убрать нарисованные маркеры, исключая перекрытий
            for marker1 in sortedMarkers{
                var statusHidden = false
                for marker2 in self.paintedMarkersInZoom.sorted(by: { marker1, marker2 in
                    if marker1.paintingPriority > marker2.paintingPriority{
                        return true
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
    
    /*
    // MARK: Получение маркера с заданным именем
    func getMarkerWith(name: String)->Marker{
        return self.markers.filter{ $0.text == name }.first!
    }*/

    
    // MARK: - UIScrollViewDelegate
    func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return self.mapScheme
    }
    
}

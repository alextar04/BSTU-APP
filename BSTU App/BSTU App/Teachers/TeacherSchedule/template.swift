import Alamofire
import SwiftSoup

// MARK: Получение расписания для группы
    // Входные параметры: id-группы
    func templateGetSheduleForGroup(idGroup: Int){
        
        let link = "http://info.bstu.ru/schedule.php?gid=\(idGroup)"
        AF.request(link).responseString{ html in
            
            do{
                let document = try SwiftSoup.parse(html.result.get())
                let listLessons = try document.getElementsByClass("schedule_std")
                
                // Список занятий по дням
                var listLessonByDaysNumerator = [[String]].init(repeating: [], count: 6)
                var listLessonByDaysDenomentor = [[String]].init(repeating: [], count: 6)
                for (index, lesson) in listLessons.enumerated(){
                    
                    var lessonParsed: Bool = false
                    for cellType in [TypeLesson.schedule_half,
                                     TypeLesson.schedule_hq,
                                     TypeLesson.schedule_quarter,
                                     TypeLesson.schedule_std]{
                        if !lessonParsed{
                            switch cellType {
                            // Обработка ячеек с занятиями числитель/знаменатель
                            case .schedule_half:
                                let notPermanentLesson = try lesson.getElementsByClass("schedule_half")
                                if notPermanentLesson.count != 0{
                                    listLessonByDaysNumerator[index % 6].append(try notPermanentLesson.first()?.text() as! String)
                                    listLessonByDaysDenomentor[index % 6].append(try notPermanentLesson.last()?.text() as! String)
                                    lessonParsed = true
                                    break
                                }
                            // Обработка ячеек с постоянными занятиями по полупаре
                            case .schedule_hq:
                                let notPermanentLesson = try lesson.getElementsByClass("schedule_hq")
                                if notPermanentLesson.count != 0{
                                    for item in notPermanentLesson{
                                        listLessonByDaysNumerator[index % 6].append(try item.text() as! String)
                                        listLessonByDaysDenomentor[index % 6].append(try item.text() as! String)
                                    }
                                    lessonParsed = true
                                    break
                                }
                            // Обработка ячеек с с занятиями числитель/знаменатель по полупаре
                            case .schedule_quarter:
                                let notPermanentLesson = try lesson.getElementsByClass("schedule_quarter")
                                if notPermanentLesson.count != 0{
                                    
                                    listLessonByDaysNumerator[index % 6].append(try notPermanentLesson[0].text() as! String)
                                    listLessonByDaysNumerator[index % 6].append(try notPermanentLesson[1].text() as! String)
                                    
                                    listLessonByDaysDenomentor[index % 6].append(try notPermanentLesson[2].text() as! String)
                                    listLessonByDaysDenomentor[index % 6].append(try notPermanentLesson[3].text() as! String)
                                    
                                    lessonParsed = true
                                    break
                                }
                            // Обработка ячеек с постоянными занятиями
                            case .schedule_std:
                                listLessonByDaysNumerator[index % 6].append(try lesson.text() as! String)
                                listLessonByDaysDenomentor[index % 6].append(try lesson.text() as! String)
                                lessonParsed = true
                                break
                            }
                        }
                    }
                }
                
                
                for day in listLessonByDaysNumerator{
                    print("Новый день")
                    for lesson in day{
                        print(lesson)
                    }
                    print("***")
                }
                
            } catch {
              fatalError()
            }
        }
    }
    
    
    enum TypeLesson{
        case schedule_std
        case schedule_half
        case schedule_hq
        case schedule_quarter
    }

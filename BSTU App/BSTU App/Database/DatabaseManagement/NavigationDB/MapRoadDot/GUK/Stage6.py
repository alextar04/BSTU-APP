import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=246, idMap=6, idOnMap=0, idPremise=209, x=440, y=1035, audienceX=440, audienceY=1064),
    MapRoadDot(id=247, idMap=6, idOnMap=1, idPremise=205, x=534, y=1035, audienceX=534, audienceY=1000),
    MapRoadDot(id=248, idMap=6, idOnMap=2, idPremise=206, x=535, y=1035, audienceX=535, audienceY=1000),
    MapRoadDot(id=249, idMap=6, idOnMap=3, idPremise=210, x=593, y=1035, audienceX=593, audienceY=1064),
    MapRoadDot(id=250, idMap=6, idOnMap=4, idPremise=207, x=818, y=1035, audienceX=818, audienceY=1000),
    MapRoadDot(id=251, idMap=6, idOnMap=5, idPremise=211, x=825, y=1035, audienceX=825, audienceY=1064),
    MapRoadDot(id=252, idMap=6, idOnMap=6, x=995, y=1035),
    MapRoadDot(id=253, idMap=6, idOnMap=7, idPremise=208, x=998, y=1035, audienceX=998, audienceY=1000),
    # Нижний кордиор лев. (8 индекс)
    MapRoadDot(id=254, idMap=6, idOnMap=8, idPremise=239, x=995, y=1135, audienceX=1029, audienceY=1135), #Вход 2
    MapRoadDot(id=255, idMap=6, idOnMap=9, x=995, y=1268),
    MapRoadDot(id=256, idMap=6, idOnMap=10, idPremise=212, x=995, y=1483, audienceX=957, audienceY=1483),#612а
    MapRoadDot(id=257, idMap=6, idOnMap=11, idPremise=217, x=995, y=1495, audienceX=1030, audienceY=1495), #608
    MapRoadDot(id=258, idMap=6, idOnMap=12, idPremise=216, x=995, y=1556, audienceX=1030, audienceY=1556), #609
    MapRoadDot(id=259, idMap=6, idOnMap=13, idPremise=213, x=995, y=1671, audienceX=957, audienceY=1671), #612
    MapRoadDot(id=260, idMap=6, idOnMap=14, idPremise=215, x=995, y=1810, audienceX=1030, audienceY=1810), #610
    MapRoadDot(id=261, idMap=6, idOnMap=15, idPremise=214, x=995, y=1812, audienceX=957, audienceY=1812), #611
    # Горизонтальный коридор (16 индекс)
    MapRoadDot(id=262, idMap=6, idOnMap=16, idPremise=235, x=1070, y=1268, audienceX=1070, audienceY=1315),  # Туалет М
    MapRoadDot(id=263, idMap=6, idOnMap=17, idPremise=236, x=1118, y=1268, audienceX=1118, audienceY=1315),  # Туалет Ж
    MapRoadDot(id=264, idMap=6, idOnMap=18, idPremise=218, x=1251, y=1268, audienceX=1251, audienceY=1315),  # 606
    MapRoadDot(id=265, idMap=6, idOnMap=19, idPremise=224, x=1252, y=1268, audienceX=1252, audienceY=1225),  # 620
    MapRoadDot(id=266, idMap=6, idOnMap=20, idPremise=219, x=1333, y=1268, audienceX=1333, audienceY=1315),  # 605
    MapRoadDot(id=267, idMap=6, idOnMap=21, idPremise=225, x=1344, y=1268, audienceX=1344, audienceY=1225),  # 621
    MapRoadDot(id=268, idMap=6, idOnMap=22, idPremise=226, x=1508, y=1268, audienceX=1508, audienceY=1225),  # 622
    MapRoadDot(id=269, idMap=6, idOnMap=23, idPremise=220, x=1566, y=1268, audienceX=1566, audienceY=1315),  # 604
    MapRoadDot(id=270, idMap=6, idOnMap=24, idPremise=221, x=1700, y=1268, audienceX=1700, audienceY=1315),  # 603
    MapRoadDot(id=271, idMap=6, idOnMap=25, idPremise=222, x=1865, y=1268, audienceX=1865, audienceY=1315),  # 602
    MapRoadDot(id=272, idMap=6, idOnMap=26, x=1870, y=1268),
    MapRoadDot(id=273, idMap=6, idOnMap=27, idPremise=223, x=1929, y=1268, audienceX=1929, audienceY=1315),  # 601
    # Доп. точки (28 индекс)
    MapRoadDot(id=274, idMap=6, idOnMap=28, idPremise=237, x=1700, y=1162, audienceX=1700, audienceY=1162), # Лифт
    MapRoadDot(id=275, idMap=6, idOnMap=29, x=1870, y=1162),
    # Точки прямо от входа. (30 индекс)
    MapRoadDot(id=276, idMap=6, idOnMap=30, idPremise=238, x=1969, y=1090, audienceX=1969, audienceY=1090), # Вход 1
    MapRoadDot(id=277, idMap=6, idOnMap=31, x=1969, y=1162),
    MapRoadDot(id=278, idMap=6, idOnMap=32, x=1969, y=1268),
    # Точки прямо от входа. (33 индекс)
    MapRoadDot(id=279, idMap=6, idOnMap=33, idPremise=227, x=1870, y=971, audienceX=1832, audienceY=971),  # 623
    MapRoadDot(id=280, idMap=6, idOnMap=34, idPremise=228, x=1870, y=849, audienceX=1832, audienceY=849),  # 624
    MapRoadDot(id=281, idMap=6, idOnMap=35, idPremise=234, x=1870, y=794, audienceX=1908, audienceY=794),  # 629
    MapRoadDot(id=282, idMap=6, idOnMap=36, idPremise=229, x=1870, y=713, audienceX=1832, audienceY=713),  # 625
    MapRoadDot(id=283, idMap=6, idOnMap=37, idPremise=233, x=1870, y=639, audienceX=1908, audienceY=639),  # 628
    MapRoadDot(id=284, idMap=6, idOnMap=38, idPremise=230, x=1870, y=576, audienceX=1832, audienceY=576),  # 626
    MapRoadDot(id=285, idMap=6, idOnMap=39, idPremise=232, x=1870, y=573, audienceX=1908, audienceY=573),  # 627
    MapRoadDot(id=286, idMap=6, idOnMap=40, idPremise=231, x=1870, y=500, audienceX=1870, audienceY=500),  # 627а
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 6)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
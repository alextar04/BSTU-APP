import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=287, idMap=0, idOnMap=0, idPremise=243, x=411, y=1035, audienceX=411, audienceY=1074), #013a
    MapRoadDot(id=288, idMap=0, idOnMap=1, idPremise=240, x=415, y=1035, audienceX=415, audienceY=1008), #014
    MapRoadDot(id=289, idMap=0, idOnMap=2, idPremise=244, x=460, y=1035, audienceX=460, audienceY=1074),  #013
    MapRoadDot(id=290, idMap=0, idOnMap=3, idPremise=245, x=607, y=1035, audienceX=607, audienceY=1074), #012
    MapRoadDot(id=291, idMap=0, idOnMap=4, idPremise=241, x=651, y=1035, audienceX=651, audienceY=1008), #014а
    MapRoadDot(id=292, idMap=0, idOnMap=5, idPremise=242, x=771, y=1035, audienceX=771, audienceY=1008), #015
    MapRoadDot(id=293, idMap=0, idOnMap=6, x=966, y=1035),
    # Нижний кордиор лев. (7 индекс)
    MapRoadDot(id=294, idMap=0, idOnMap=7, idPremise=0, x=966, y=1145, audienceX=1041, audienceY=1145),  # Выход 2
    MapRoadDot(id=295, idMap=0, idOnMap=8, x=997, y=1145),
    MapRoadDot(id=296, idMap=0, idOnMap=9, idPremise=0, x=997, y=1508, audienceX=967, audienceY=1508), #006
    MapRoadDot(id=297, idMap=0, idOnMap=10, idPremise=0, x=997, y=1508, audienceX=1032, audienceY=1508),  #007
    MapRoadDot(id=298, idMap=0, idOnMap=11, idPremise=0, x=997, y=1751, audienceX=1032, audienceY=1751),  #008
    MapRoadDot(id=299, idMap=0, idOnMap=12, idPremise=0, x=997, y=1913, audienceX=967, audienceY=1913),  #009
    # Горизонтальный кордиор (13 индекс)
    MapRoadDot(id=300, idMap=0, idOnMap=13, idPremise=0, x=1070, y=1268, audienceX=1070, audienceY=1315),  # Туалет М
    MapRoadDot(id=301, idMap=0, idOnMap=14, idPremise=0, x=1370, y=1268, audienceX=575, audienceY=1230),  # 021
    MapRoadDot(id=302, idMap=0, idOnMap=15, idPremise=0, x=1492, y=1268, audienceX=1492, audienceY=1315),  # 003
    MapRoadDot(id=303, idMap=0, idOnMap=16, x=1700, y=1268),
    MapRoadDot(id=304, idMap=0, idOnMap=17, x=1870, y=1268),
    MapRoadDot(id=305, idMap=0, idOnMap=18, idPremise=0, x=1946, y=1268, audienceX=1946, audienceY=1315),  # 001
    # Доп. точки (19 индекс)
    MapRoadDot(id=306, idMap=0, idOnMap=19, idPremise=237, x=1700, y=1162, audienceX=1700, audienceY=1162),  # Лифт
    MapRoadDot(id=307, idMap=0, idOnMap=20, x=1870, y=1162),
    # Точки прямо от входа. (21 индекс)
    MapRoadDot(id=308, idMap=0, idOnMap=21, idPremise=238, x=1969, y=1090, audienceX=1969, audienceY=1090),  # Вход 1
    MapRoadDot(id=309, idMap=0, idOnMap=22, x=1969, y=1162),
    MapRoadDot(id=310, idMap=0, idOnMap=23, x=1969, y=1268),
    # Правый верхний коридор (24 индекс)
    MapRoadDot(id=311, idMap=0, idOnMap=24, idPremise=0, x=1870, y=966, audienceX=1832, audienceY=966),  # 022
    MapRoadDot(id=312, idMap=0, idOnMap=25, idPremise=0, x=1870, y=875, audienceX=1908, audienceY=875),  # 024
    MapRoadDot(id=313, idMap=0, idOnMap=26, idPremise=0, x=1870, y=714, audienceX=1832, audienceY=714),  # 026
    MapRoadDot(id=314, idMap=0, idOnMap=27, idPremise=0, x=1870, y=701, audienceX=1908, audienceY=701),  # 027
    # Верхние лекционные аудитории (28 индекс)
    MapRoadDot(id=315, idMap=0, idOnMap=28, x=1870, y=420),
    MapRoadDot(id=316, idMap=0, idOnMap=29, idPremise=0, x=2077, y=420, audienceX=2077, audienceY=420),  # 030
    MapRoadDot(id=317, idMap=0, idOnMap=30, idPremise=0, x=1934, y=420, audienceX=575, audienceY=1008),  # 031
    MapRoadDot(id=318, idMap=0, idOnMap=31, idPremise=0, x=1650, y=420, audienceX=575, audienceY=1008),  # 032
    MapRoadDot(id=319, idMap=0, idOnMap=32, idPremise=0, x=1532, y=420, audienceX=575, audienceY=1008),  # 033
    MapRoadDot(id=320, idMap=0, idOnMap=33, idPremise=0, x=1266, y=420, audienceX=575, audienceY=1008),  # 034
    # Верхний левый коридор (34 индекс)
    MapRoadDot(id=321, idMap=0, idOnMap=34, x=966, y=420),
    MapRoadDot(id=322, idMap=0, idOnMap=35, idPremise=0, x=966, y=529, audienceX=1039, audienceY=529),  # 013
    MapRoadDot(id=323, idMap=0, idOnMap=36, idPremise=0, x=966, y=609, audienceX=1039, audienceY=609),  # 016
    MapRoadDot(id=324, idMap=0, idOnMap=37, idPremise=0, x=966, y=686, audienceX=1039, audienceY=686),  # 017
    MapRoadDot(id=325, idMap=0, idOnMap=38, idPremise=0, x=966, y=778, audienceX=1039, audienceY=778),  # 018
    MapRoadDot(id=326, idMap=0, idOnMap=39, idPremise=0, x=966, y=856, audienceX=1039, audienceY=856),  # 019
    MapRoadDot(id=327, idMap=0, idOnMap=40, idPremise=0, x=966, y=925, audienceX=1039, audienceY=925),  # 020
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 0)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=287, idMap=0, idOnMap=0, idPremise=243, x=411, y=1050, audienceX=411, audienceY=1085), #013a
    MapRoadDot(id=288, idMap=0, idOnMap=1, idPremise=240, x=535, y=1050, audienceX=535, audienceY=1010), #014
    MapRoadDot(id=289, idMap=0, idOnMap=2, idPremise=244, x=641, y=1050, audienceX=641, audienceY=1085),  #013
    MapRoadDot(id=290, idMap=0, idOnMap=3, idPremise=241, x=685, y=1050, audienceX=685, audienceY=1010), #014а
    MapRoadDot(id=291, idMap=0, idOnMap=4, idPremise=245, x=782, y=1050, audienceX=782, audienceY=1085),  # 012
    MapRoadDot(id=292, idMap=0, idOnMap=5, idPremise=242, x=802, y=1050, audienceX=802, audienceY=1010), #015
    MapRoadDot(id=293, idMap=0, idOnMap=6, x=966, y=1050),
    # Нижний кордиор лев. (7 индекс)
    MapRoadDot(id=295, idMap=0, idOnMap=7, x=966, y=1145),
    MapRoadDot(id=294, idMap=0, idOnMap=8, idPremise=253, x=997, y=1145, audienceX=1041, audienceY=1145),  # Выход 2
    MapRoadDot(id=296, idMap=0, idOnMap=9, idPremise=246, x=997, y=1508, audienceX=967, audienceY=1508), #006
    MapRoadDot(id=297, idMap=0, idOnMap=10, idPremise=249, x=997, y=1508, audienceX=1032, audienceY=1508),  #007
    MapRoadDot(id=298, idMap=0, idOnMap=11, idPremise=248, x=997, y=1751, audienceX=1032, audienceY=1751),  #008
    MapRoadDot(id=299, idMap=0, idOnMap=12, idPremise=247, x=997, y=1913, audienceX=967, audienceY=1913),  #009
    # Горизонтальный кордиор (13 индекс)
    MapRoadDot(id=300, idMap=0, idOnMap=13, idPremise=250, x=1070, y=1268, audienceX=1070, audienceY=1315),  # Туалет М
    MapRoadDot(id=301, idMap=0, idOnMap=14, idPremise=254, x=1400, y=1268, audienceX=1400, audienceY=1230),  # 021
    MapRoadDot(id=302, idMap=0, idOnMap=15, idPremise=251, x=1553, y=1268, audienceX=1553, audienceY=1315),  # 003
    MapRoadDot(id=303, idMap=0, idOnMap=16, x=1700, y=1268),
    MapRoadDot(id=304, idMap=0, idOnMap=17, x=1870, y=1268),
    MapRoadDot(id=305, idMap=0, idOnMap=18, idPremise=252, x=1962, y=1268, audienceX=1962, audienceY=1315),  # 001
    # Доп. точки (19 индекс)
    MapRoadDot(id=306, idMap=0, idOnMap=19, idPremise=255, x=1700, y=1162, audienceX=1700, audienceY=1162),  # Лифт
    MapRoadDot(id=307, idMap=0, idOnMap=20, x=1870, y=1162),
    # Точки прямо от входа. (21 индекс)
    MapRoadDot(id=308, idMap=0, idOnMap=21, idPremise=271, x=1969, y=1090, audienceX=1969, audienceY=1090),  # Вход 1
    MapRoadDot(id=309, idMap=0, idOnMap=22, x=1969, y=1162),
    MapRoadDot(id=310, idMap=0, idOnMap=23, x=1969, y=1268),
    # Правый верхний коридор (24 индекс)
    MapRoadDot(id=311, idMap=0, idOnMap=24, idPremise=256, x=1870, y=966, audienceX=1832, audienceY=966),  # 022
    MapRoadDot(id=312, idMap=0, idOnMap=25, idPremise=257, x=1870, y=798, audienceX=1913, audienceY=798),  # 024
    MapRoadDot(id=313, idMap=0, idOnMap=26, idPremise=258, x=1870, y=714, audienceX=1832, audienceY=714),  # 026
    MapRoadDot(id=314, idMap=0, idOnMap=27, idPremise=259, x=1870, y=701, audienceX=1913, audienceY=701),  # 027
    # Верхние лекционные аудитории (28 индекс)
    MapRoadDot(id=315, idMap=0, idOnMap=28, x=1870, y=420),
    MapRoadDot(id=316, idMap=0, idOnMap=29, idPremise=260, x=2077, y=420, audienceX=2077, audienceY=420),  # 030
    MapRoadDot(id=317, idMap=0, idOnMap=30, idPremise=261, x=1934, y=420, audienceX=1934, audienceY=385),  # 031
    MapRoadDot(id=318, idMap=0, idOnMap=31, idPremise=262, x=1650, y=420, audienceX=1650, audienceY=385),  # 032
    MapRoadDot(id=319, idMap=0, idOnMap=32, idPremise=263, x=1532, y=420, audienceX=1532, audienceY=385),  # 033
    MapRoadDot(id=320, idMap=0, idOnMap=33, idPremise=264, x=1266, y=420, audienceX=1266, audienceY=385),  # 034
    # Верхний левый коридор (34 индекс)
    MapRoadDot(id=321, idMap=0, idOnMap=34, x=966, y=420),
    MapRoadDot(id=322, idMap=0, idOnMap=35, idPremise=265, x=966, y=529, audienceX=1039, audienceY=529),  # 013
    MapRoadDot(id=323, idMap=0, idOnMap=36, idPremise=266, x=966, y=609, audienceX=1039, audienceY=609),  # 016
    MapRoadDot(id=324, idMap=0, idOnMap=37, idPremise=267, x=966, y=686, audienceX=1039, audienceY=686),  # 017
    MapRoadDot(id=325, idMap=0, idOnMap=38, idPremise=268, x=966, y=778, audienceX=1039, audienceY=778),  # 018
    MapRoadDot(id=326, idMap=0, idOnMap=39, idPremise=269, x=966, y=856, audienceX=1039, audienceY=856),  # 019
    MapRoadDot(id=327, idMap=0, idOnMap=40, idPremise=270, x=966, y=925, audienceX=1039, audienceY=925),  # 020
    # Дополнительная точка
    MapRoadDot(id=328, idMap=0, idOnMap=41, x=997, y=1268),
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
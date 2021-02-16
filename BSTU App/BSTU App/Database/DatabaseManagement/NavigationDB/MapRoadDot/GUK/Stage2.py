import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=42, idMap=2, idOnMap=0, idPremise=38, x=644, y=1035, audienceX=644, audienceY=1074),
    MapRoadDot(id=43, idMap=2, idOnMap=1, idPremise=36, x=812, y=1035, audienceX=812, audienceY=1008),
    MapRoadDot(id=44, idMap=2, idOnMap=2, idPremise=37, x=986, y=1035, audienceX=986, audienceY=1008),
    MapRoadDot(id=45, idMap=2, idOnMap=3, x=995, y=1035),
    MapRoadDot(id=46, idMap=2, idOnMap=4, idPremise=63, x=995, y=1145, audienceX=1041, audienceY=1145),
    MapRoadDot(id=47, idMap=2, idOnMap=5, x=995, y=1268),
    # Нижний коридор лев.(6 индекс)
    MapRoadDot(id=48, idMap=2, idOnMap=6, idPremise=39, x=995, y=1507, audienceX=1034, audienceY=1507),
    MapRoadDot(id=49, idMap=2, idOnMap=7, idPremise=41, x=995, y=1692, audienceX=969, audienceY=1692),
    MapRoadDot(id=50, idMap=2, idOnMap=8, idPremise=40, x=995, y=1752, audienceX=1034, audienceY=1752),
    # Горизонтальный коридор (9 индекс)
    MapRoadDot(id=51, idMap=2, idOnMap=9, idPremise=58, x=1065, y=1268, audienceX=1065, audienceY=1313),
    MapRoadDot(id=52, idMap=2, idOnMap=10, idPremise=59, x=1131, y=1268, audienceX=1131, audienceY=1313),
    MapRoadDot(id=53, idMap=2, idOnMap=11, idPremise=42, x=1274, y=1268, audienceX=1274, audienceY=1225),
    MapRoadDot(id=54, idMap=2, idOnMap=12, idPremise=43, x=1403, y=1268, audienceX=1403, audienceY=1225),
    MapRoadDot(id=55, idMap=2, idOnMap=13, idPremise=44, x=1519, y=1268, audienceX=1519, audienceY=1225),
    MapRoadDot(id=56, idMap=2, idOnMap=14, idPremise=46, x=1527, y=1268, audienceX=1527, audienceY=1313),
    MapRoadDot(id=57, idMap=2, idOnMap=15, idPremise=45, x=1542, y=1268, audienceX=1542, audienceY=1313),
    MapRoadDot(id=58, idMap=2, idOnMap=16, idPremise=47, x=1654, y=1268, audienceX=1654, audienceY=1313),
    # Доп. точки (17 индекс)
    MapRoadDot(id=59, idMap=2, idOnMap=17, x=1700, y=1268),
    MapRoadDot(id=60, idMap=2, idOnMap=18, x=1892, y=1268),
    MapRoadDot(id=61, idMap=2, idOnMap=19, idPremise=60, x=1700, y=1162, audienceX=1700, audienceY=1162),
    MapRoadDot(id=62, idMap=2, idOnMap=20, x=1892, y=1162),
    # Точки прямо от входа. (21 индекс)
    MapRoadDot(id=63, idMap=2, idOnMap=21, idPremise=62, x=1969, y=1090, audienceX=1969, audienceY=1090),
    MapRoadDot(id=64, idMap=2, idOnMap=22, x=1969, y=1162),
    MapRoadDot(id=65, idMap=2, idOnMap=23, x=1969, y=1268),
    # Верхний коридор прав. (24 индекс)
    MapRoadDot(id=66, idMap=2, idOnMap=24, idPremise=52, x=1892, y=966, audienceX=1835, audienceY=966),
    MapRoadDot(id=67, idMap=2, idOnMap=25, idPremise=53, x=1892, y=806, audienceX=1913, audienceY=806),
    MapRoadDot(id=68, idMap=2, idOnMap=26, idPremise=55, x=1892, y=572, audienceX=1913, audienceY=572),
    MapRoadDot(id=69, idMap=2, idOnMap=27, idPremise=54, x=1892, y=506, audienceX=1835, audienceY=506),
    MapRoadDot(id=70, idMap=2, idOnMap=28, idPremise=56, x=1892, y=494, audienceX=1913, audienceY=494),
    MapRoadDot(id=71, idMap=2, idOnMap=29, idPremise=57, x=1892, y=419, audienceX=1872, audienceY=389),
    # Нижний коридор прав. (30 индекс)
    MapRoadDot(id=72, idMap=2, idOnMap=30, idPremise=48, x=1892, y=1393, audienceX=1835, audienceY=1393),
    MapRoadDot(id=73, idMap=2, idOnMap=31, idPremise=51, x=1892, y=1464, audienceX=1920, audienceY=1464),
    MapRoadDot(id=74, idMap=2, idOnMap=32, idPremise=49, x=1892, y=1650, audienceX=1835, audienceY=1650),
    MapRoadDot(id=75, idMap=2, idOnMap=33, idPremise=50, x=1892, y=1915, audienceX=1835, audienceY=1915),
    MapRoadDot(id=76, idMap=2, idOnMap=34, idPremise=61, x=1892, y=2019, audienceX=1892, audienceY=2020),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 2)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
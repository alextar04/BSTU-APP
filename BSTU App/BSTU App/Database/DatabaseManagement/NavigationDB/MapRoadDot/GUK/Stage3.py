import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=77, idMap=3, idOnMap=0, idPremise=64, x=418, y=1035, audienceX=418, audienceY=1035),
    MapRoadDot(id=78, idMap=3, idOnMap=1, idPremise=68, x=440, y=1035, audienceX=440, audienceY=1074),
    MapRoadDot(id=79, idMap=3, idOnMap=2, idPremise=65, x=512, y=1035, audienceX=512, audienceY=1000),
    MapRoadDot(id=80, idMap=3, idOnMap=3, idPremise=69, x=524, y=1035, audienceX=524, audienceY=1074),
    MapRoadDot(id=81, idMap=3, idOnMap=4, idPremise=70, x=771, y=1035, audienceX=771, audienceY=1074),
    MapRoadDot(id=82, idMap=3, idOnMap=5, idPremise=66, x=786, y=1035, audienceX=786, audienceY=1000),
    MapRoadDot(id=83, idMap=3, idOnMap=6, idPremise=67, x=963, y=1035, audienceX=963, audienceY=1000),
    MapRoadDot(id=84, idMap=3, idOnMap=7, x=995, y=1035),
    # Нижний коридор лев.(8 индекс)
    MapRoadDot(id=85, idMap=3, idOnMap=8, idPremise=99, x=995, y=1131, audienceX=1026, audienceY=1131),
    MapRoadDot(id=86, idMap=3, idOnMap=9, x=995, y=1268),
    MapRoadDot(id=87, idMap=3, idOnMap=10, idPremise=71, x=995, y=1283, audienceX=969, audienceY=1283),
    MapRoadDot(id=88, idMap=3, idOnMap=11, idPremise=72, x=995, y=1518, audienceX=969, audienceY=1518),
    MapRoadDot(id=89, idMap=3, idOnMap=12, idPremise=76, x=995, y=1526, audienceX=1034, audienceY=1526),
    MapRoadDot(id=90, idMap=3, idOnMap=13, idPremise=73, x=995, y=1640, audienceX=969, audienceY=1640),
    MapRoadDot(id=91, idMap=3, idOnMap=14, idPremise=75, x=995, y=1660, audienceX=1034, audienceY=1660),
    MapRoadDot(id=92, idMap=3, idOnMap=15, idPremise=74, x=995, y=1810, audienceX=969, audienceY=1810),
    # Горизонтальный коридор (16 индекс)
    MapRoadDot(id=93, idMap=3, idOnMap=16, idPremise=95, x=1064, y=1268, audienceX=1064, audienceY=1313),
    MapRoadDot(id=94, idMap=3, idOnMap=17, idPremise=96, x=1112, y=1268, audienceX=1112, audienceY=1313),
    MapRoadDot(id=95, idMap=3, idOnMap=18, idPremise=84, x=1226, y=1268, audienceX=1226, audienceY=1225),
    MapRoadDot(id=96, idMap=3, idOnMap=19, idPremise=77, x=1237, y=1268, audienceX=1237, audienceY=1313),
    MapRoadDot(id=97, idMap=3, idOnMap=20, idPremise=78, x=1319, y=1268, audienceX=1319, audienceY=1313),
    MapRoadDot(id=98, idMap=3, idOnMap=21, idPremise=85, x=1525, y=1268, audienceX=1525, audienceY=1225),
    MapRoadDot(id=99, idMap=3, idOnMap=22, idPremise=79, x=1542, y=1268, audienceX=1542, audienceY=1313),
    MapRoadDot(id=100, idMap=3, idOnMap=23, idPremise=80, x=1550, y=1268, audienceX=1550, audienceY=1313),
    MapRoadDot(id=101, idMap=3, idOnMap=24, idPremise=81, x=1628, y=1268, audienceX=1628, audienceY=1313),
    MapRoadDot(id=102, idMap=3, idOnMap=25, x=1700, y=1268),
    MapRoadDot(id=103, idMap=3, idOnMap=26, idPremise=82, x=1740, y=1268, audienceX=1740, audienceY=1313),
    MapRoadDot(id=104, idMap=3, idOnMap=27, x=1870, y=1268),
    MapRoadDot(id=105, idMap=3, idOnMap=28, idPremise=83, x=1959, y=1268, audienceX=1959, audienceY=1313),
    # Доп. точки (29 индекс)
    MapRoadDot(id=106, idMap=3, idOnMap=29, idPremise=97, x=1700, y=1162, audienceX=1700, audienceY=1162),
    MapRoadDot(id=107, idMap=3, idOnMap=30, x=1870, y=1162),
    # Точки прямо от входа. (31 индекс)
    MapRoadDot(id=108, idMap=3, idOnMap=31, idPremise=98, x=1969, y=1090, audienceX=1969, audienceY=1090),
    MapRoadDot(id=109, idMap=3, idOnMap=32, x=1969, y=1162),
    MapRoadDot(id=110, idMap=3, idOnMap=33, x=1969, y=1268),
    # Верхний коридор прав. (34 индекс)
    MapRoadDot(id=111, idMap=3, idOnMap=34, idPremise=86, x=1870, y=962, audienceX=1835, audienceY=962),
    MapRoadDot(id=112, idMap=3, idOnMap=35, idPremise=87, x=1870, y=893, audienceX=1835, audienceY=893),
    MapRoadDot(id=113, idMap=3, idOnMap=36, idPremise=94, x=1870, y=886, audienceX=1913, audienceY=886),
    MapRoadDot(id=114, idMap=3, idOnMap=37, idPremise=93, x=1870, y=812, audienceX=1913, audienceY=812),
    MapRoadDot(id=115, idMap=3, idOnMap=38, idPremise=88, x=1870, y=802, audienceX=1835, audienceY=802),
    MapRoadDot(id=116, idMap=3, idOnMap=39, idPremise=89, x=1870, y=798, audienceX=1835, audienceY=798),
    MapRoadDot(id=117, idMap=3, idOnMap=40, idPremise=90, x=1870, y=588, audienceX=1835, audienceY=588),
    MapRoadDot(id=118, idMap=3, idOnMap=41, idPremise=92, x=1870, y=508, audienceX=1913, audienceY=508),
    MapRoadDot(id=119, idMap=3, idOnMap=42, idPremise=91, x=1870, y=484, audienceX=1870, audienceY=484),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 3)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
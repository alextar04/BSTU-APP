import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=120, idMap=4, idOnMap=0, idPremise=100, x=454, y=1035, audienceX=437, audienceY=1035),
    MapRoadDot(id=121, idMap=4, idOnMap=1, idPremise=104, x=464, y=1035, audienceX=464, audienceY=1088),
    MapRoadDot(id=122, idMap=4, idOnMap=2, idPremise=101, x=520, y=1035, audienceX=520, audienceY=1000),
    MapRoadDot(id=123, idMap=4, idOnMap=3, idPremise=105, x=774, y=1035, audienceX=774, audienceY=1088),
    MapRoadDot(id=124, idMap=4, idOnMap=4, idPremise=102, x=785, y=1035, audienceX=785, audienceY=1000),
    MapRoadDot(id=125, idMap=4, idOnMap=5, idPremise=103, x=961, y=1035, audienceX=961, audienceY=1000),
    MapRoadDot(id=126, idMap=4, idOnMap=6, x=995, y=1035),
    # Нижний коридор лев.(7 индекс)
    MapRoadDot(id=127, idMap=4, idOnMap=7, idPremise=136, x=995, y=1176, audienceX=1026, audienceY=1176),
    MapRoadDot(id=128, idMap=4, idOnMap=8, x=995, y=1268),
    MapRoadDot(id=129, idMap=4, idOnMap=9, idPremise=106, x=995, y=1341, audienceX=969, audienceY=1341),
    MapRoadDot(id=130, idMap=4, idOnMap=10, idPremise=107, x=995, y=1419, audienceX=969, audienceY=1419),
    MapRoadDot(id=131, idMap=4, idOnMap=11, idPremise=108, x=995, y=1484, audienceX=969, audienceY=1484),
    MapRoadDot(id=132, idMap=4, idOnMap=12, idPremise=114, x=995, y=1520, audienceX=1034, audienceY=1520),
    MapRoadDot(id=133, idMap=4, idOnMap=13, idPremise=113, x=995, y=1661, audienceX=1034, audienceY=1661),
    MapRoadDot(id=134, idMap=4, idOnMap=14, idPremise=109, x=995, y=1684, audienceX=969, audienceY=1684),
    MapRoadDot(id=135, idMap=4, idOnMap=15, idPremise=112, x=995, y=1819, audienceX=1034, audienceY=1819),
    MapRoadDot(id=136, idMap=4, idOnMap=16, idPremise=110, x=995, y=1961, audienceX=969, audienceY=1961),
    MapRoadDot(id=137, idMap=4, idOnMap=17, idPremise=111, x=995, y=1972, audienceX=1034, audienceY=1972),
    # Горизонтальный коридор (18 индекс)
    MapRoadDot(id=138, idMap=4, idOnMap=18, idPremise=132, x=1064, y=1268, audienceX=1064, audienceY=1313),
    MapRoadDot(id=139, idMap=4, idOnMap=19, idPremise=133, x=1130, y=1268, audienceX=1130, audienceY=1313),
    MapRoadDot(id=141, idMap=4, idOnMap=20, idPremise=115, x=1237, y=1268, audienceX=1237, audienceY=1313),
    MapRoadDot(id=142, idMap=4, idOnMap=21, idPremise=122, x=1294, y=1268, audienceX=1294, audienceY=1225),
    MapRoadDot(id=143, idMap=4, idOnMap=22, idPremise=116, x=1301, y=1268, audienceX=1301, audienceY=1313),
    MapRoadDot(id=144, idMap=4, idOnMap=23, idPremise=123, x=1529, y=1268, audienceX=1529, audienceY=1225),
    MapRoadDot(id=145, idMap=4, idOnMap=24, idPremise=117, x=1555, y=1268, audienceX=1555, audienceY=1313),
    MapRoadDot(id=146, idMap=4, idOnMap=25, idPremise=118, x=1619, y=1268, audienceX=1619, audienceY=1313),
    MapRoadDot(id=147, idMap=4, idOnMap=26, idPremise=119, x=1620, y=1268, audienceX=1620, audienceY=1313),
    MapRoadDot(id=148, idMap=4, idOnMap=27, x=1700, y=1268),
    MapRoadDot(id=149, idMap=4, idOnMap=28, idPremise=120, x=1782, y=1268, audienceX=1782, audienceY=1313),
    MapRoadDot(id=150, idMap=4, idOnMap=29, x=1870, y=1268),
    MapRoadDot(id=151, idMap=4, idOnMap=30, idPremise=121, x=1944, y=1268, audienceX=1944, audienceY=1313),
    # Доп. точки (31 индекс)
    MapRoadDot(id=152, idMap=4, idOnMap=31, idPremise=134, x=1700, y=1162, audienceX=1700, audienceY=1162),
    MapRoadDot(id=153, idMap=4, idOnMap=32, x=1870, y=1162),
    # Точки прямо от входа. (33 индекс)
    MapRoadDot(id=154, idMap=4, idOnMap=33, idPremise=135, x=1969, y=1090, audienceX=1969, audienceY=1090),
    MapRoadDot(id=155, idMap=4, idOnMap=34, x=1969, y=1162),
    MapRoadDot(id=156, idMap=4, idOnMap=35, x=1969, y=1268),
    # Верхний коридор прав. (36 индекс)
    MapRoadDot(id=157, idMap=4, idOnMap=36, idPremise=124, x=1870, y=966, audienceX=1835, audienceY=966),
    MapRoadDot(id=158, idMap=4, idOnMap=37, idPremise=131, x=1870, y=883, audienceX=1913, audienceY=883),
    MapRoadDot(id=159, idMap=4, idOnMap=38, idPremise=125, x=1870, y=808, audienceX=1835, audienceY=808),
    MapRoadDot(id=160, idMap=4, idOnMap=39, idPremise=126, x=1870, y=626, audienceX=1835, audienceY=626),
    MapRoadDot(id=161, idMap=4, idOnMap=40, idPremise=130, x=1870, y=580, audienceX=1913, audienceY=580),
    MapRoadDot(id=162, idMap=4, idOnMap=41, idPremise=127, x=1870, y=452, audienceX=1835, audienceY=452),
    MapRoadDot(id=163, idMap=4, idOnMap=42, idPremise=129, x=1870, y=417, audienceX=1913, audienceY=417),
    MapRoadDot(id=164, idMap=4, idOnMap=43, idPremise=128, x=1870, y=319, audienceX=1870, audienceY=319),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 4)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
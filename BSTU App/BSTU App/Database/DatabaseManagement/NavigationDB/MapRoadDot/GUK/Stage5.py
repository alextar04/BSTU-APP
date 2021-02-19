import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=164, idMap=5, idOnMap=0, idPremise=137, x=480, y=1035, audienceX=480, audienceY=1035),
    MapRoadDot(id=165, idMap=5, idOnMap=1, idPremise=141, x=534, y=1035, audienceX=534, audienceY=1064),
    MapRoadDot(id=166, idMap=5, idOnMap=2, idPremise=138, x=540, y=1035, audienceX=540, audienceY=1000),
    MapRoadDot(id=167, idMap=5, idOnMap=3, idPremise=142, x=608, y=1035, audienceX=608, audienceY=1064),
    MapRoadDot(id=168, idMap=5, idOnMap=4, idPremise=143, x=705, y=1035, audienceX=705, audienceY=1064),
    MapRoadDot(id=169, idMap=5, idOnMap=5, idPremise=139, x=843, y=1035, audienceX=843, audienceY=1000),
    MapRoadDot(id=171, idMap=5, idOnMap=6, x=995, y=1035),
    MapRoadDot(id=170, idMap=5, idOnMap=7, idPremise=140, x=1011, y=1035, audienceX=1011, audienceY=1000),
    # Нижний коридор лев.(8 индекс)
    MapRoadDot(id=172, idMap=5, idOnMap=8, idPremise=170, x=995, y=1130, audienceX=1026, audienceY=1130),
    MapRoadDot(id=173, idMap=5, idOnMap=9, idPremise=144, x=995, y=1230, audienceX=969, audienceY=1230),
    MapRoadDot(id=174, idMap=5, idOnMap=10, x=995, y=1268),
    MapRoadDot(id=175, idMap=5, idOnMap=11, idPremise=145, x=995, y=1318, audienceX=969, audienceY=1318),
    MapRoadDot(id=176, idMap=5, idOnMap=12, idPremise=146, x=995, y=1480, audienceX=969, audienceY=1480),
    MapRoadDot(id=177, idMap=5, idOnMap=13, idPremise=150, x=995, y=1494, audienceX=1034, audienceY=1494),
    MapRoadDot(id=178, idMap=5, idOnMap=14, idPremise=149, x=995, y=1569, audienceX=1034, audienceY=1569),
    MapRoadDot(id=179, idMap=5, idOnMap=15, idPremise=148, x=995, y=1802, audienceX=1034, audienceY=1802),
    MapRoadDot(id=180, idMap=5, idOnMap=16, idPremise=147, x=995, y=1945, audienceX=969, audienceY=1945),
    # Горизонтальный коридор (17 индекс)
    MapRoadDot(id=181, idMap=5, idOnMap=17, idPremise=151, x=1266, y=1268, audienceX=1266, audienceY=1313),
    MapRoadDot(id=182, idMap=5, idOnMap=18, idPremise=157, x=1311, y=1268, audienceX=1311, audienceY=1225),
    MapRoadDot(id=183, idMap=5, idOnMap=19, idPremise=152, x=1332, y=1268, audienceX=1332, audienceY=1313),
    MapRoadDot(id=184, idMap=5, idOnMap=20, idPremise=158, x=1538, y=1268, audienceX=1538, audienceY=1225),
    MapRoadDot(id=185, idMap=5, idOnMap=21, idPremise=153, x=1555, y=1268, audienceX=1555, audienceY=1313),
    MapRoadDot(id=186, idMap=5, idOnMap=22, idPremise=154, x=1652, y=1268, audienceX=1652, audienceY=1313),
    MapRoadDot(id=187, idMap=5, idOnMap=23, x=1700, y=1268),
    MapRoadDot(id=188, idMap=5, idOnMap=24, idPremise=155, x=1804, y=1268, audienceX=1804, audienceY=1313),
    MapRoadDot(id=189, idMap=5, idOnMap=25, x=1880, y=1268),
    MapRoadDot(id=190, idMap=5, idOnMap=26, idPremise=156, x=1893, y=1268, audienceX=1893, audienceY=1313),
    # Доп. точки (27 индекс)
    MapRoadDot(id=191, idMap=5, idOnMap=27, idPremise=168, x=1700, y=1162, audienceX=1700, audienceY=1162),
    MapRoadDot(id=192, idMap=5, idOnMap=28, x=1880, y=1162),
    # Точки прямо от входа. (29 индекс)
    MapRoadDot(id=193, idMap=5, idOnMap=29, idPremise=169, x=1969, y=1090, audienceX=1969, audienceY=1090),
    MapRoadDot(id=194, idMap=5, idOnMap=30, x=1969, y=1162),
    MapRoadDot(id=195, idMap=5, idOnMap=31, x=1969, y=1268),
    # Верхний коридор прав. (32 индекс)
    MapRoadDot(id=196, idMap=5, idOnMap=32, idPremise=159, x=1880, y=961, audienceX=1835, audienceY=961),
    MapRoadDot(id=197, idMap=5, idOnMap=33, idPremise=165, x=1880, y=877, audienceX=1913, audienceY=877),
    MapRoadDot(id=198, idMap=5, idOnMap=34, idPremise=160, x=1880, y=814, audienceX=1835, audienceY=814),
    MapRoadDot(id=199, idMap=5, idOnMap=35, idPremise=164, x=1880, y=807, audienceX=1913, audienceY=807),
    MapRoadDot(id=200, idMap=5, idOnMap=36, idPremise=161, x=1880, y=605, audienceX=1835, audienceY=605),
    MapRoadDot(id=201, idMap=5, idOnMap=37, idPremise=163, x=1880, y=580, audienceX=1913, audienceY=580),
    MapRoadDot(id=202, idMap=5, idOnMap=38, idPremise=162, x=1880, y=412, audienceX=1880, audienceY=412),
    # 2 туалета (39 индекс)
    MapRoadDot(id=203, idMap=5, idOnMap=39, idPremise=166, x=1064, y=1268, audienceX=1064, audienceY=1313),
    MapRoadDot(id=204, idMap=5, idOnMap=40, idPremise=167, x=1130, y=1268, audienceX=1130, audienceY=1313),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 5)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
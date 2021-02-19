import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=205, idMap=7, idOnMap=0, idPremise=171, x=416, y=1035, audienceX=416, audienceY=1035),
    MapRoadDot(id=206, idMap=7, idOnMap=1, idPremise=172, x=449, y=1035, audienceX=449, audienceY=1064),
    MapRoadDot(id=207, idMap=7, idOnMap=2, idPremise=173, x=590, y=1035, audienceX=590, audienceY=1064),
    MapRoadDot(id=208, idMap=7, idOnMap=3, idPremise=174, x=592, y=1035, audienceX=592, audienceY=1064),
    MapRoadDot(id=209, idMap=7, idOnMap=4, idPremise=176, x=821, y=1035, audienceX=821, audienceY=1000),
    MapRoadDot(id=210, idMap=7, idOnMap=5, idPremise=175, x=824, y=1035, audienceX=824, audienceY=1064),
    MapRoadDot(id=211, idMap=7, idOnMap=6, x=995, y=1035),
    MapRoadDot(id=212, idMap=7, idOnMap=7, idPremise=177, x=1003, y=1035, audienceX=1003, audienceY=1000),
    # Нижний коридор лев.(8 индекс)
    MapRoadDot(id=213, idMap=7, idOnMap=8, idPremise=204, x=995, y=1130, audienceX=1026, audienceY=1130),
    MapRoadDot(id=214, idMap=7, idOnMap=9, x=995, y=1268),
    MapRoadDot(id=215, idMap=7, idOnMap=10, idPremise=178, x=995, y=1336, audienceX=969, audienceY=1336),
    MapRoadDot(id=216, idMap=7, idOnMap=11, idPremise=179, x=995, y=1483, audienceX=969, audienceY=1483),
    MapRoadDot(id=217, idMap=7, idOnMap=12, idPremise=184, x=995, y=1498, audienceX=1034, audienceY=1498),
    MapRoadDot(id=218, idMap=7, idOnMap=13, idPremise=183, x=995, y=1558, audienceX=1034, audienceY=1558),
    MapRoadDot(id=219, idMap=7, idOnMap=14, idPremise=180, x=995, y=1814, audienceX=969, audienceY=1814),
    MapRoadDot(id=220, idMap=7, idOnMap=15, idPremise=182, x=995, y=1816, audienceX=1034, audienceY=1816),
    MapRoadDot(id=221, idMap=7, idOnMap=16, idPremise=181, x=995, y=1934, audienceX=995, audienceY=1934),
    # Горизонтальный коридор (17 индекс)
    MapRoadDot(id=222, idMap=7, idOnMap=17, idPremise=200, x=1070, y=1268, audienceX=1070, audienceY=1313),
    MapRoadDot(id=223, idMap=7, idOnMap=18, idPremise=201, x=1122, y=1268, audienceX=1122, audienceY=1313),
    MapRoadDot(id=224, idMap=7, idOnMap=19, idPremise=185, x=1254, y=1268, audienceX=1254, audienceY=1313),
    MapRoadDot(id=225, idMap=7, idOnMap=20, idPremise=186, x=1335, y=1268, audienceX=1335, audienceY=1313),
    MapRoadDot(id=226, idMap=7, idOnMap=21, idPremise=191, x=1349, y=1268, audienceX=1349, audienceY=1225),
    MapRoadDot(id=227, idMap=7, idOnMap=22, idPremise=192, x=1511, y=1268, audienceX=1511, audienceY=1225),
    MapRoadDot(id=228, idMap=7, idOnMap=23, idPremise=187, x=1573, y=1268, audienceX=1573, audienceY=1313),
    MapRoadDot(id=229, idMap=7, idOnMap=24, idPremise=188, x=1696, y=1268, audienceX=1696, audienceY=1313),
    MapRoadDot(id=230, idMap=7, idOnMap=25, x=1700, y=1268),
    MapRoadDot(id=231, idMap=7, idOnMap=26, idPremise=189, x=1870, y=1268, audienceX=1870, audienceY=1313),
    MapRoadDot(id=232, idMap=7, idOnMap=27, x=1870, y=1268),
    MapRoadDot(id=233, idMap=7, idOnMap=28, idPremise=190, x=1934, y=1268, audienceX=1934, audienceY=1313),
    # Доп. точки (29 индекс)
    MapRoadDot(id=234, idMap=7, idOnMap=29, idPremise=202, x=1700, y=1162, audienceX=1700, audienceY=1162),
    MapRoadDot(id=235, idMap=7, idOnMap=30, x=1870, y=1162),
    # Точки прямо от входа. (31 индекс)
    MapRoadDot(id=236, idMap=7, idOnMap=31, idPremise=203, x=1969, y=1090, audienceX=1969, audienceY=1090),
    MapRoadDot(id=237, idMap=7, idOnMap=32, x=1969, y=1162),
    MapRoadDot(id=238, idMap=7, idOnMap=33, x=1969, y=1268),
    # Верхний коридор прав. (34 индекс)
    MapRoadDot(id=239, idMap=7, idOnMap=34, idPremise=193, x=1870, y=974, audienceX=1835, audienceY=974),
    MapRoadDot(id=240, idMap=7, idOnMap=35, idPremise=194, x=1870, y=847, audienceX=1835, audienceY=847),
    MapRoadDot(id=241, idMap=7, idOnMap=36, idPremise=199, x=1870, y=796, audienceX=1913, audienceY=796),
    MapRoadDot(id=242, idMap=7, idOnMap=37, idPremise=195, x=1870, y=578, audienceX=1835, audienceY=578),
    MapRoadDot(id=243, idMap=7, idOnMap=38, idPremise=197, x=1870, y=578, audienceX=1913, audienceY=578),
    MapRoadDot(id=244, idMap=7, idOnMap=39, idPremise=198, x=1870, y=578, audienceX=1913, audienceY=578),
    MapRoadDot(id=245, idMap=7, idOnMap=40, idPremise=196, x=1870, y=503, audienceX=1870, audienceY=503),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 7)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
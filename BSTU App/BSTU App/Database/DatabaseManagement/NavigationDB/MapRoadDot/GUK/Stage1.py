import os
from peewee import *
from NavigationDB.MapRoadDot.MapRoadDotDB import MapRoadDot

roadDotsArray = [
    MapRoadDot(id=0, idMap=1, idOnMap=0, idPremise=0, x=575, y=1035, audienceX=575, audienceY=1008),
    MapRoadDot(id=1, idMap=1, idOnMap=1, idPremise=3, x=580, y=1035, audienceX=580, audienceY=1074),
    MapRoadDot(id=2, idMap=1, idOnMap=2, idPremise=4, x=819, y=1035, audienceX=819, audienceY=1074),
    MapRoadDot(id=3, idMap=1, idOnMap=3, idPremise=1, x=825, y=1035, audienceX=825, audienceY=1008),
    MapRoadDot(id=4, idMap=1, idOnMap=4, idPremise=2, x=958, y=1035, audienceX=958, audienceY=1008),
    MapRoadDot(id=5, idMap=1, idOnMap=5, x=989, y=1035),
    MapRoadDot(id=6, idMap=1, idOnMap=6, x=989, y=1268),
    # Нижний коридор лев.(7 индекс)
    MapRoadDot(id=7, idMap=1, idOnMap=7, idPremise=10, x=989, y=1509, audienceX=1032, audienceY=1509),
    MapRoadDot(id=8, idMap=1, idOnMap=8, idPremise=5, x=989, y=1592, audienceX=954, audienceY=1592),
    MapRoadDot(id=9, idMap=1, idOnMap=9, idPremise=9, x=989, y=1631, audienceX=1032, audienceY=1631),
    MapRoadDot(id=10, idMap=1, idOnMap=10, idPremise=8, x=989, y=1754, audienceX=1032, audienceY=1754),
    MapRoadDot(id=11, idMap=1, idOnMap=11, idPremise=6, x=989, y=1800, audienceX=954, audienceY=1800),
    MapRoadDot(id=12, idMap=1, idOnMap=12, idPremise=7, x=989, y=1840, audienceX=989, audienceY=1850),
    # Горизонтальный коридор.(13 индекс)
    MapRoadDot(id=13, idMap=1, idOnMap=13, idPremise=23, x=1049, y=1268, audienceX=1049, audienceY=1313),
    MapRoadDot(id=14, idMap=1, idOnMap=14, idPremise=24, x=1114, y=1268, audienceX=1114, audienceY=1313),
    MapRoadDot(id=15, idMap=1, idOnMap=15, idPremise=11, x=1230, y=1268, audienceX=1230, audienceY=1313),
    MapRoadDot(id=16, idMap=1, idOnMap=16, idPremise=20, x=1263, y=1268, audienceX=1263, audienceY=1225),
    MapRoadDot(id=17, idMap=1, idOnMap=17, idPremise=21, x=1525, y=1268, audienceX=1525, audienceY=1225),
    MapRoadDot(id=18, idMap=1, idOnMap=18, idPremise=12, x=1562, y=1268, audienceX=1562, audienceY=1313),
    MapRoadDot(id=19, idMap=1, idOnMap=19, idPremise=13, x=1637, y=1268, audienceX=1637, audienceY=1313),
    MapRoadDot(id=20, idMap=1, idOnMap=20, idPremise=14, x=1712, y=1268, audienceX=1712, audienceY=1313),
    MapRoadDot(id=21, idMap=1, idOnMap=21, idPremise=25, x=1713, y=1132, audienceX=1713, audienceY=1132),
    MapRoadDot(id=22, idMap=1, idOnMap=22, x=1892, y=1268),
    # Верхний коридор прав. (23 индекс)
    MapRoadDot(id=23, idMap=1, idOnMap=23, x=1892, y=1132),
    MapRoadDot(id=24, idMap=1, idOnMap=24, idPremise=33, x=1892, y=959, audienceX=1835, audienceY=959),
    MapRoadDot(id=25, idMap=1, idOnMap=25, idPremise=26, x=1892, y=856, audienceX=1913, audienceY=856),
    MapRoadDot(id=26, idMap=1, idOnMap=26, idPremise=32, x=1892, y=836, audienceX=1835, audienceY=836),
    MapRoadDot(id=27, idMap=1, idOnMap=27, idPremise=31, x=1892, y=601, audienceX=1835, audienceY=601),
    MapRoadDot(id=28, idMap=1, idOnMap=28, idPremise=27, x=1892, y=575, audienceX=1913, audienceY=575),
    MapRoadDot(id=29, idMap=1, idOnMap=29, idPremise=30, x=1892, y=450, audienceX=1835, audienceY=450),
    MapRoadDot(id=30, idMap=1, idOnMap=30, idPremise=28, x=1892, y=416, audienceX=1913, audienceY=416),
    MapRoadDot(id=31, idMap=1, idOnMap=31, idPremise=29, x=1892, y=358, audienceX=1835, audienceY=358),
    # Нижний коридор прав. (32 индекс)
    MapRoadDot(id=32, idMap=1, idOnMap=32, idPremise=19, x=1892, y=1379, audienceX=1946, audienceY=1379),
    MapRoadDot(id=33, idMap=1, idOnMap=33, idPremise=15, x=1892, y=1408, audienceX=1835, audienceY=1408),
    MapRoadDot(id=34, idMap=1, idOnMap=34, idPremise=16, x=1892, y=1641, audienceX=1835, audienceY=1641),
    MapRoadDot(id=35, idMap=1, idOnMap=35, idPremise=17, x=1892, y=1722, audienceX=1835, audienceY=1722),
    MapRoadDot(id=36, idMap=1, idOnMap=36, idPremise=18, x=1892, y=1946, audienceX=1835, audienceY=1946),
    # Точки прямо от входа. (37 индекс)
    MapRoadDot(id=37, idMap=1, idOnMap=37, idPremise=22, x=1980, y=1085, audienceX=1980, audienceY=1085),
    MapRoadDot(id=38, idMap=1, idOnMap=38, x=1980, y=1132),
    MapRoadDot(id=39, idMap=1, idOnMap=39, x=1980, y=1268),
    # 2 входа - Вход 2 и Главный вход (40 индекс)
    MapRoadDot(id=40, idMap=1, idOnMap=40, idPremise=34, x=989, y=1128, audienceX=1025, audienceY=1128),
    MapRoadDot(id=41, idMap=1, idOnMap=41, idPremise=35, x=1892, y=1966, audienceX=1892, audienceY=1970),
    ]


def MapRoadDotAdd():
    for dot in roadDotsArray:
        dot.create(id=dot.id, idMap=dot.idMap, idOnMap=dot.idOnMap, idPremise=dot.idPremise, x=dot.x, y=dot.y,
                   audienceX=dot.audienceX, audienceY=dot.audienceY)


def MopRoadDotRemove():
    query = MapRoadDot.delete().where(MapRoadDot.idMap == 1)
    query.execute()

os.chdir('../../..')
MopRoadDotRemove()
MapRoadDotAdd()
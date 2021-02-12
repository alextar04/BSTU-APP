import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    '''
    # Помощь для генерации маркеров
    for id, val in enumerate([(490, 900), (700, 900), (450, 1158), (767, 1158), (790, 1573), (767, 1884), (975, 1900), (1100, 1792), (1100, 1594), (1100, 1490), (1050, 1370),
    (1220, 1370), (1140, 1370), (1220, 1370), (1450, 1370), (1615, 1370), (1685, 1370), (1770, 1370), (1720, 1570), (1720, 1700), (1720, 1942), (2100, 1375),
    (1335, 1120), (1500, 1120), (1980, 957), (1980, 811), (1980, 539), (1980, 392), (1720, 340), (1720, 450), (1720, 620), (1720, 811), (1720, 935), (1650, 1050)]):
        print("Marker.create(id={}, idMap=0, idOnMap=0, idPremise=0, x={}, y={})".format(id, val[0], val[1]))
    '''

    Marker.create(id=0, idMap=0, idOnMap=0, idPremise=0, x=490, y=900)
    Marker.create(id=1, idMap=0, idOnMap=0, idPremise=1, x=700, y=900)
    Marker.create(id=2, idMap=0, idOnMap=0, idPremise=2, x=975, y=900)
    Marker.create(id=3, idMap=0, idOnMap=0, idPremise=3, x=450, y=1158)
    Marker.create(id=4, idMap=0, idOnMap=0, idPremise=4, x=767, y=1158)
    Marker.create(id=5, idMap=0, idOnMap=0, idPremise=5, x=790, y=1573)
    Marker.create(id=6, idMap=0, idOnMap=0, idPremise=6, x=767, y=1884)
    Marker.create(id=7, idMap=0, idOnMap=0, idPremise=7, x=975, y=1900)
    Marker.create(id=8, idMap=0, idOnMap=0, idPremise=8, x=1100, y=1792)
    Marker.create(id=9, idMap=0, idOnMap=0, idPremise=9, x=1100, y=1594)
    Marker.create(id=10, idMap=0, idOnMap=0, idPremise=10, x=1100, y=1490)
    Marker.create(id=11, idMap=0, idOnMap=0, idPremise=23, x=1050, y=1370)
    Marker.create(id=12, idMap=0, idOnMap=0, idPremise=11, x=1220, y=1370)
    Marker.create(id=13, idMap=0, idOnMap=0, idPremise=24, x=1140, y=1370)
    Marker.create(id=15, idMap=0, idOnMap=0, idPremise=12, x=1450, y=1370)
    Marker.create(id=16, idMap=0, idOnMap=0, idPremise=13, x=1615, y=1370)
    Marker.create(id=17, idMap=0, idOnMap=0, idPremise=14, x=1685, y=1370)
    Marker.create(id=18, idMap=0, idOnMap=0, idPremise=15, x=1770, y=1370)
    Marker.create(id=19, idMap=0, idOnMap=0, idPremise=16, x=1720, y=1570)
    Marker.create(id=20, idMap=0, idOnMap=0, idPremise=17, x=1720, y=1700)
    Marker.create(id=21, idMap=0, idOnMap=0, idPremise=18, x=1720, y=1942)
    Marker.create(id=22, idMap=0, idOnMap=0, idPremise=19, x=2100, y=1375)
    Marker.create(id=23, idMap=0, idOnMap=0, idPremise=20, x=1335, y=1120)
    Marker.create(id=24, idMap=0, idOnMap=0, idPremise=21, x=1500, y=1120)
    Marker.create(id=25, idMap=0, idOnMap=0, idPremise=22, x=1980, y=957)
    Marker.create(id=26, idMap=0, idOnMap=0, idPremise=26, x=1980, y=811)
    Marker.create(id=27, idMap=0, idOnMap=0, idPremise=27, x=1980, y=539)
    Marker.create(id=28, idMap=0, idOnMap=0, idPremise=28, x=1980, y=392)
    Marker.create(id=29, idMap=0, idOnMap=0, idPremise=29, x=1720, y=340)
    Marker.create(id=30, idMap=0, idOnMap=0, idPremise=30, x=1720, y=450)
    Marker.create(id=31, idMap=0, idOnMap=0, idPremise=31, x=1720, y=620)
    Marker.create(id=32, idMap=0, idOnMap=0, idPremise=32, x=1720, y=811)
    Marker.create(id=33, idMap=0, idOnMap=0, idPremise=33, x=1720, y=935)
    Marker.create(id=34, idMap=0, idOnMap=0, idPremise=25, x=1650, y=1050)
    # 2 доп. входа


def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 0)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

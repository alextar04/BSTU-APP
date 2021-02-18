import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=100, idMap=4, idPremise=100, x=350, y=1022)#415
    Marker.create(id=101, idMap=4, idPremise=104, x=400, y=1158)#414а
    Marker.create(id=102, idMap=4, idPremise=101, x=467, y=900)#416
    Marker.create(id=103, idMap=4, idPremise=102, x=739, y=900)#417
    Marker.create(id=104, idMap=4, idPremise=105, x=704, y=1158)#414
    Marker.create(id=105, idMap=4, idPremise=103, x=913, y=900)#418

    Marker.create(id=106, idMap=4, idPremise=106, x=879, y=1325)#413в
    Marker.create(id=107, idMap=4, idPremise=107, x=879, y=1409)#413б
    Marker.create(id=108, idMap=4, idPremise=108, x=793, y=1510)#413
    Marker.create(id=109, idMap=4, idPremise=109, x=793, y=1673)#412а
    Marker.create(id=110, idMap=4, idPremise=110, x=793, y=1915)#412
    Marker.create(id=111, idMap=4, idPremise=111, x=1090, y=1966)#411а
    Marker.create(id=112, idMap=4, idPremise=112, x=1090, y=1826)#411
    Marker.create(id=113, idMap=4, idPremise=113, x=1090, y=1616)#410
    Marker.create(id=114, idMap=4, idPremise=114, x=1090, y=1496)#409

    Marker.create(id=115, idMap=4, idPremise=115, x=1205, y=1368)#407
    Marker.create(id=116, idMap=4, idPremise=116, x=1282, y=1368)#406
    Marker.create(id=117, idMap=4, idPremise=117, x=1485, y=1368)#405
    Marker.create(id=118, idMap=4, idPremise=118, x=1598, y=1368)#404
    Marker.create(id=119, idMap=4, idPremise=119, x=1671, y=1368)#403
    Marker.create(id=120, idMap=4, idPremise=120, x=1755, y=1368)#402
    Marker.create(id=121, idMap=4, idPremise=121, x=1971, y=1368)#401
    Marker.create(id=122, idMap=4, idPremise=122, x=1272, y=1107)#421
    Marker.create(id=123, idMap=4, idPremise=123, x=1498, y=1107)#422

    Marker.create(id=124, idMap=4, idPremise=124, x=1719, y=946)#425а
    Marker.create(id=125, idMap=4, idPremise=125, x=1719, y=763)#425
    Marker.create(id=126, idMap=4, idPremise=126, x=1719, y=601)#426
    Marker.create(id=127, idMap=4, idPremise=127, x=1719, y=452)#427
    Marker.create(id=128, idMap=4, idPremise=128, x=1851, y=312)#428
    Marker.create(id=129, idMap=4, idPremise=129, x=1965, y=398)#429а
    Marker.create(id=130, idMap=4, idPremise=130, x=1965, y=536)#429
    Marker.create(id=131, idMap=4, idPremise=131, x=1965, y=811)#430

    Marker.create(id=132, idMap=4, idPremise=132, x=1050, y=1370)#Туалет М
    Marker.create(id=133, idMap=4, idPremise=133, x=1140, y=1370)#Туалет Ж
    Marker.create(id=134, idMap=4, idPremise=135, x=1975, y=990)#Вход1
    Marker.create(id=135, idMap=4, idPremise=136, x=1082, y=1107)#Вход2
    Marker.create(id=136, idMap=4, idPremise=134, x=1680, y=1107)#Лифт


def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 4)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

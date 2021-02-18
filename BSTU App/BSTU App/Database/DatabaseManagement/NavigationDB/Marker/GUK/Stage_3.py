import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=64, idMap=3, idPremise=64, x=330, y=1007)#317a
    Marker.create(id=65, idMap=3, idPremise=65, x=478, y=900)#320
    Marker.create(id=66, idMap=3, idPremise=66, x=755, y=900)#319
    Marker.create(id=67, idMap=3, idPremise=67, x=905, y=900)#321
    Marker.create(id=68, idMap=3, idPremise=68, x=348, y=1158)#318
    Marker.create(id=69, idMap=3, idPremise=69, x=491, y=1158)#317
    Marker.create(id=70, idMap=3, idPremise=70, x=687, y=1158)#316

    Marker.create(id=71, idMap=3, idPremise=71, x=879, y=1351)#314a
    Marker.create(id=72, idMap=3, idPremise=72, x=793, y=1507)#314
    Marker.create(id=73, idMap=3, idPremise=73, x=793, y=1625)#313
    Marker.create(id=74, idMap=3, idPremise=74, x=793, y=1837)#312
    Marker.create(id=75, idMap=3, idPremise=75, x=1090, y=1643)#311
    Marker.create(id=76, idMap=3, idPremise=76, x=1090, y=1515)#310

    Marker.create(id=77, idMap=3, idPremise=84, x=1200, y=1107)#322
    Marker.create(id=78, idMap=3, idPremise=85, x=1469, y=1107)#324

    Marker.create(id=79, idMap=3, idPremise=77, x=1213, y=1368)#307a
    Marker.create(id=80, idMap=3, idPremise=78, x=1285, y=1368)#307
    Marker.create(id=81, idMap=3, idPremise=79, x=1380, y=1368)#306
    Marker.create(id=82, idMap=3, idPremise=80, x=1478, y=1368)#305
    Marker.create(id=83, idMap=3, idPremise=81, x=1604, y=1368)#304
    Marker.create(id=84, idMap=3, idPremise=82, x=1710, y=1368)#303
    Marker.create(id=85, idMap=3, idPremise=83, x=1930, y=1368)#301

    Marker.create(id=86, idMap=3, idPremise=86, x=1719, y=937)#325
    Marker.create(id=87, idMap=3, idPremise=87, x=1719, y=865)#326
    Marker.create(id=88, idMap=3, idPremise=88, x=1719, y=798)#327
    Marker.create(id=89, idMap=3, idPremise=89, x=1719, y=713)#327a
    Marker.create(id=90, idMap=3, idPremise=90, x=1719, y=572)#328
    Marker.create(id=91, idMap=3, idPremise=91, x=1851, y=380)#329a
    Marker.create(id=92, idMap=3, idPremise=92, x=1965, y=475)#331
    Marker.create(id=93, idMap=3, idPremise=93, x=1965, y=792)#335
    Marker.create(id=94, idMap=3, idPremise=94, x=1965, y=872)#336

    Marker.create(id=95, idMap=3, idPremise=95, x=1050, y=1370)#Туалет М
    Marker.create(id=96, idMap=3, idPremise=96, x=1140, y=1370)#Туалет Ж
    Marker.create(id=97, idMap=3, idPremise=98, x=1975, y=990)#Вход1
    Marker.create(id=98, idMap=3, idPremise=99, x=1082, y=1107)#Вход2
    Marker.create(id=99, idMap=3, idPremise=97, x=1680, y=1107)#Лифт

def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 3)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

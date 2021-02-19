import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=137, idMap=5, idPremise=137, x=360, y=1005)#515а
    Marker.create(id=138, idMap=5, idPremise=141, x=482, y=1158)#515
    Marker.create(id=139, idMap=5, idPremise=142, x=592, y=1158)#514
    Marker.create(id=140, idMap=5, idPremise=143, x=686, y=1158)#513
    Marker.create(id=141, idMap=5, idPremise=138, x=467, y=900)#517
    Marker.create(id=142, idMap=5, idPremise=139, x=757, y=900)#519
    Marker.create(id=143, idMap=5, idPremise=140, x=941, y=900)#520

    Marker.create(id=144, idMap=5, idPremise=144, x=879, y=1230)#512б
    Marker.create(id=145, idMap=5, idPremise=145, x=879, y=1315)#512а
    Marker.create(id=146, idMap=5, idPremise=146, x=793, y=1532)#512
    Marker.create(id=147, idMap=5, idPremise=147, x=793, y=1875)#511
    Marker.create(id=148, idMap=5, idPremise=150, x=1090, y=1480)#508
    Marker.create(id=149, idMap=5, idPremise=149, x=1090, y=1565)#509
    Marker.create(id=150, idMap=5, idPremise=148, x=1090, y=1810)#510

    Marker.create(id=151, idMap=5, idPremise=151, x=1238, y=1368)#506
    Marker.create(id=152, idMap=5, idPremise=152, x=1297, y=1368)#505а
    Marker.create(id=153, idMap=5, idPremise=153, x=1492, y=1368)#504а
    Marker.create(id=154, idMap=5, idPremise=154, x=1607, y=1368)#504
    Marker.create(id=155, idMap=5, idPremise=155, x=1773, y=1368)#502
    Marker.create(id=156, idMap=5, idPremise=156, x=1950, y=1368)#501
    Marker.create(id=157, idMap=5, idPremise=157, x=1351, y=1107)#523
    Marker.create(id=158, idMap=5, idPremise=158, x=1517, y=1107)#524

    Marker.create(id=159, idMap=5, idPremise=159, x=1719, y=937)#525
    Marker.create(id=160, idMap=5, idPremise=160, x=1719, y=834)#526
    Marker.create(id=161, idMap=5, idPremise=161, x=1719, y=590)#528
    Marker.create(id=162, idMap=5, idPremise=162, x=1851, y=326)#528а
    Marker.create(id=163, idMap=5, idPremise=163, x=1965, y=524)#529
    Marker.create(id=164, idMap=5, idPremise=164, x=1965, y=757)#530
    Marker.create(id=165, idMap=5, idPremise=165, x=1965, y=858)#531

    Marker.create(id=166, idMap=5, idPremise=166, x=1050, y=1370)#Туалет М
    Marker.create(id=167, idMap=5, idPremise=167, x=1140, y=1370)#Туалет Ж
    Marker.create(id=168, idMap=5, idPremise=169, x=1975, y=990)#Вход1
    Marker.create(id=169, idMap=5, idPremise=170, x=1082, y=1107)#Вход2
    Marker.create(id=170, idMap=5, idPremise=168, x=1680, y=1107)#Лифт


def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 5)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

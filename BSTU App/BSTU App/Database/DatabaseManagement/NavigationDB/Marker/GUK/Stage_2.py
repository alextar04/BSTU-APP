import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=36, idMap=2, idPremise=36, x=780, y=900)#221
    Marker.create(id=37, idMap=2, idPremise=37, x=964, y=900)#226
    Marker.create(id=38, idMap=2, idPremise=38, x=614, y=1158)#218
    Marker.create(id=39, idMap=2, idPremise=41, x=793, y=1872)#214
    Marker.create(id=40, idMap=2, idPremise=40, x=1090, y=1720)#210
    Marker.create(id=41, idMap=2, idPremise=39, x=1090, y=1492)#209
    Marker.create(id=42, idMap=2, idPremise=42, x=1238, y=1107)#227
    Marker.create(id=43, idMap=2, idPremise=43, x=1367, y=1107)#228
    Marker.create(id=44, idMap=2, idPremise=44, x=1498, y=1107)#229
    Marker.create(id=45, idMap=2, idPremise=46, x=1399, y=1368)#205
    Marker.create(id=46, idMap=2, idPremise=45, x=1497, y=1368)#204
    Marker.create(id=47, idMap=2, idPremise=47, x=1627, y=1368)#203
    Marker.create(id=48, idMap=2, idPremise=48, x=1748, y=1368)#202
    Marker.create(id=49, idMap=2, idPremise=51, x=2047, y=1368)#242
    Marker.create(id=50, idMap=2, idPremise=49, x=1719, y=1629)#201
    Marker.create(id=51, idMap=2, idPremise=50, x=1719, y=1865)#201a
    Marker.create(id=52, idMap=2, idPremise=52, x=1719, y=930)#230
    Marker.create(id=53, idMap=2, idPremise=54, x=1719, y=555)#233
    Marker.create(id=54, idMap=2, idPremise=57, x=1851, y=326)#235
    Marker.create(id=55, idMap=2, idPremise=56, x=1965, y=472)#236
    Marker.create(id=56, idMap=2, idPremise=55, x=1965, y=555)#237
    Marker.create(id=57, idMap=2, idPremise=53, x=1965, y=780)#239
    Marker.create(id=58, idMap=2, idPremise=62, x=1975, y=990)#Вход1
    Marker.create(id=59, idMap=2, idPremise=63, x=1082, y=1107)#Вход2
    Marker.create(id=60, idMap=2, idPremise=61, x=1860, y=2015)#Главный вход
    Marker.create(id=61, idMap=2, idPremise=60, x=1680, y=1107)#Лифт
    Marker.create(id=62, idMap=2, idPremise=58, x=1050, y=1370)#Туалет М
    Marker.create(id=63, idMap=2, idPremise=59, x=1140, y=1370)#Туалет Ж

def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 2)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

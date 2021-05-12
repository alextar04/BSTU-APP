import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():

    Marker.create(id=240, idMap=0, idPremise=240, x=521, y=900) #014
    Marker.create(id=241, idMap=0, idPremise=241, x=652, y=900) #014a
    Marker.create(id=242, idMap=0, idPremise=242, x=771, y=900) #015
    Marker.create(id=243, idMap=0, idPremise=243, x=396, y=1135) #013a
    Marker.create(id=244, idMap=0, idPremise=244, x=607, y=1135) #013
    Marker.create(id=245, idMap=0, idPremise=245, x=773, y=1135) #012

    Marker.create(id=246, idMap=0, idPremise=253, x=1082, y=1107) #Вход 2
    Marker.create(id=247, idMap=0, idPremise=246, x=778, y=1476) #006
    Marker.create(id=248, idMap=0, idPremise=247, x=778, y=1846) #009

    Marker.create(id=249, idMap=0, idPremise=248, x=1100, y=1823) #008
    Marker.create(id=250, idMap=0, idPremise=249, x=1100, y=1600) #007
    Marker.create(id=251, idMap=0, idPremise=250, x=1050, y=1370) #Туалет М

    Marker.create(id=252, idMap=0, idPremise=251, x=1501, y=1368) #003
    Marker.create(id=253, idMap=0, idPremise=254, x=1378, y=1107) #021
    Marker.create(id=254, idMap=0, idPremise=252, x=1940, y=1368) #001

    Marker.create(id=255, idMap=0, idPremise=256, x=1719, y=939) #022
    Marker.create(id=256, idMap=0, idPremise=258, x=1719, y=660) #026
    Marker.create(id=257, idMap=0, idPremise=257, x=1965, y=786) #024
    Marker.create(id=258, idMap=0, idPremise=259, x=1965, y=660) #027

    Marker.create(id=259, idMap=0, idPremise=260, x=2098, y=404) #030
    Marker.create(id=260, idMap=0, idPremise=261, x=1918, y=263) #031
    Marker.create(id=261, idMap=0, idPremise=262, x=1650, y=263) #032
    Marker.create(id=262, idMap=0, idPremise=263, x=1413, y=263) #033
    Marker.create(id=263, idMap=0, idPremise=264, x=1172, y=263) #034

    Marker.create(id=264, idMap=0, idPremise=265, x=1085, y=517) #013
    Marker.create(id=265, idMap=0, idPremise=266, x=1085, y=597) #016
    Marker.create(id=266, idMap=0, idPremise=267, x=1085, y=675) #017
    Marker.create(id=267, idMap=0, idPremise=268, x=1085, y=752) #018
    Marker.create(id=268, idMap=0, idPremise=269, x=1085, y=841) #019
    Marker.create(id=269, idMap=0, idPremise=270, x=1085, y=916) #020

    Marker.create(id=270, idMap=0, idPremise=271, x=1975, y=990)  #Вход1
    Marker.create(id=271, idMap=0, idPremise=255, x=1680, y=1107) #Лифт

def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 0)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

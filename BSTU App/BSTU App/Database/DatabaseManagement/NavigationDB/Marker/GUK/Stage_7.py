import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=171, idMap=7, idPremise=171, x=336, y=1016)#716а
    Marker.create(id=172, idMap=7, idPremise=172, x=405, y=1158)#716
    Marker.create(id=173, idMap=7, idPremise=173, x=593, y=1158)#715
    Marker.create(id=174, idMap=7, idPremise=174, x=687, y=1158)#715а
    Marker.create(id=175, idMap=7, idPremise=175, x=800, y=1158)#714
    Marker.create(id=176, idMap=7, idPremise=176, x=726, y=900)#718
    Marker.create(id=177, idMap=7, idPremise=177, x=942, y=900)#719

    Marker.create(id=178, idMap=7, idPremise=178, x=879, y=1327)#713а
    Marker.create(id=179, idMap=7, idPremise=179, x=793, y=1494)#713
    Marker.create(id=180, idMap=7, idPremise=180, x=793, y=1861)#712
    Marker.create(id=181, idMap=7, idPremise=181, x=971, y=1933)#711а
    Marker.create(id=182, idMap=7, idPremise=182, x=1090, y=1844)#711
    Marker.create(id=183, idMap=7, idPremise=183, x=1090, y=1597)#710
    Marker.create(id=184, idMap=7, idPremise=184, x=1090, y=1460)#709

    Marker.create(id=185, idMap=7, idPremise=185, x=1215, y=1368)#707
    Marker.create(id=186, idMap=7, idPremise=186, x=1366, y=1368)#706
    Marker.create(id=187, idMap=7, idPremise=187, x=1532, y=1368)#705
    Marker.create(id=188, idMap=7, idPremise=188, x=1677, y=1368)#703
    Marker.create(id=189, idMap=7, idPremise=189, x=1839, y=1368)#702
    Marker.create(id=190, idMap=7, idPremise=190, x=1990, y=1368)#701
    Marker.create(id=191, idMap=7, idPremise=191, x=1295, y=1107)#720
    Marker.create(id=192, idMap=7, idPremise=192, x=1500, y=1107)#721

    Marker.create(id=193, idMap=7, idPremise=193, x=1719, y=943)#722
    Marker.create(id=194, idMap=7, idPremise=194, x=1719, y=812)#723
    Marker.create(id=195, idMap=7, idPremise=195, x=1719, y=544)#724
    Marker.create(id=196, idMap=7, idPremise=196, x=1851, y=406)#724а
    Marker.create(id=197, idMap=7, idPremise=197, x=1965, y=450)#725
    Marker.create(id=198, idMap=7, idPremise=198, x=1965, y=550)#725а
    Marker.create(id=199, idMap=7, idPremise=199, x=1965, y=830)#726

    Marker.create(id=200, idMap=7, idPremise=200, x=1050, y=1370)#Туалет М
    Marker.create(id=201, idMap=7, idPremise=201, x=1140, y=1370)#Туалет Ж
    Marker.create(id=202, idMap=7, idPremise=203, x=1975, y=990)#Вход1
    Marker.create(id=203, idMap=7, idPremise=204, x=1082, y=1107)#Вход2
    Marker.create(id=204, idMap=7, idPremise=202, x=1680, y=1107)#Лифт



def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 7)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

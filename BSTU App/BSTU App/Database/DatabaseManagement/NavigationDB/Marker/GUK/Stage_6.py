import os
from peewee import *
from NavigationDB.Marker.MarkerDB import Marker

def MarkerAdd():
    Marker.create(id=205, idMap=6, idPremise=205, x=428, y=887) #616
    Marker.create(id=206, idMap=6, idPremise=206, x=549, y=887) #616б
    Marker.create(id=207, idMap=6, idPremise=207, x=749, y=887) #617
    Marker.create(id=208, idMap=6, idPremise=208, x=973, y=887) #618/2

    Marker.create(id=209, idMap=6, idPremise=209, x=392, y=1160) #615
    Marker.create(id=210, idMap=6, idPremise=210, x=637, y=1160) #614
    Marker.create(id=211, idMap=6, idPremise=211, x=805, y=1160) #613

    Marker.create(id=212, idMap=6, idPremise=212, x=777, y=1477) #612а
    Marker.create(id=213, idMap=6, idPremise=213, x=777, y=1670) #612
    Marker.create(id=214, idMap=6, idPremise=214, x=777, y=1850) #611

    Marker.create(id=215, idMap=6, idPremise=217, x=1087, y=1476) #608
    Marker.create(id=216, idMap=6, idPremise=216, x=1087, y=1602) #609
    Marker.create(id=217, idMap=6, idPremise=215, x=1087, y=1843) #610

    Marker.create(id=218, idMap=6, idPremise=218, x=1213, y=1368) #606
    Marker.create(id=219, idMap=6, idPremise=219, x=1306, y=1368) #605
    Marker.create(id=220, idMap=6, idPremise=220, x=1545, y=1368) #604
    Marker.create(id=221, idMap=6, idPremise=221, x=1668, y=1368) #603
    Marker.create(id=222, idMap=6, idPremise=222, x=1845, y=1368) #602
    Marker.create(id=223, idMap=6, idPremise=223, x=1979, y=1368) #601

    Marker.create(id=224, idMap=6, idPremise=224, x=1227, y=1107) #620
    Marker.create(id=225, idMap=6, idPremise=225, x=1350, y=1107) #621
    Marker.create(id=226, idMap=6, idPremise=226, x=1483, y=1107) #622

    Marker.create(id=227, idMap=6, idPremise=227, x=1719, y=951) #623
    Marker.create(id=228, idMap=6, idPremise=228, x=1719, y=824) #624
    Marker.create(id=229, idMap=6, idPremise=229, x=1719, y=708) #625
    Marker.create(id=230, idMap=6, idPremise=230, x=1719, y=560) #626

    Marker.create(id=231, idMap=6, idPremise=232, x=1965, y=490) #627
    Marker.create(id=232, idMap=6, idPremise=233, x=1965, y=684) #628
    Marker.create(id=233, idMap=6, idPremise=234, x=1965, y=824) #629

    Marker.create(id=234, idMap=6, idPremise=231, x=1851, y=396) #627а

    Marker.create(id=235, idMap=6, idPremise=235, x=1050, y=1370) #Туалет М
    Marker.create(id=236, idMap=6, idPremise=236, x=1140, y=1370) #Туалет Ж
    Marker.create(id=237, idMap=6, idPremise=238, x=1975, y=990)  #Вход1
    Marker.create(id=238, idMap=6, idPremise=239, x=1082, y=1107) #Вход2
    Marker.create(id=239, idMap=6, idPremise=237, x=1680, y=1107) #Лифт





def MarkerRemove():
    query = Marker.delete().where(Marker.idMap == 6)
    query.execute()

os.chdir('../../..')
MarkerRemove()
MarkerAdd()

import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    '''
    # Помощь для генерации помещений
    for id, val in enumerate([137, "136a", 136, 135, 134, 133, 132, "132a"]):
        print("Premise.create(id={}, idTypePremise=0, name=\"{}\", description=\"Кабинет {}\")".format(25+id, val, val))
    '''
    Premise.create(id=0, idMap=1, idTypePremise=0, name="122", description="ГУК 122")
    Premise.create(id=1, idMap=1, idTypePremise=0, name="124", description="ГУК 124")
    Premise.create(id=2, idMap=1, idTypePremise=0, name="125", description="ГУК 125")
    Premise.create(id=3, idMap=1, idTypePremise=0, name="120", description="ГУК 120")
    Premise.create(id=4, idMap=1, idTypePremise=0, name="119", description="ГУК 119")
    Premise.create(id=5, idMap=1, idTypePremise=0, name="118", description="ГУК 118")
    Premise.create(id=6, idMap=1, idTypePremise=0, name="117", description="ГУК 117")
    Premise.create(id=7, idMap=1, idTypePremise=0, name="116", description="ГУК 116")
    Premise.create(id=8, idMap=1, idTypePremise=0, name="115", description="ГУК 115")
    Premise.create(id=9, idMap=1, idTypePremise=0, name="114", description="ГУК 114")
    Premise.create(id=10, idMap=1, idTypePremise=0, name="113", description="ГУК 113")
    Premise.create(id=11, idMap=1, idTypePremise=0, name="111", description="ГУК 111")
    Premise.create(id=12, idMap=1, idTypePremise=0, name="109", description="ГУК 109")
    Premise.create(id=13, idMap=1, idTypePremise=0, name="108", description="ГУК 108")
    Premise.create(id=14, idMap=1, idTypePremise=0, name="107", description="ГУК 107")
    Premise.create(id=15, idMap=1, idTypePremise=0, name="106", description="ГУК 106")
    Premise.create(id=16, idMap=1, idTypePremise=0, name="105", description="ГУК 105")
    Premise.create(id=17, idMap=1, idTypePremise=0, name="104", description="ГУК 104")
    Premise.create(id=18, idMap=1, idTypePremise=0, name="101", description="ГУК 101")
    Premise.create(id=19, idMap=1, idTypePremise=0, name="138", description="ГУК 138")
    Premise.create(id=20, idMap=1, idTypePremise=0, name="128", description="ГУК 128")
    Premise.create(id=21, idMap=1, idTypePremise=0, name="131", description="ГУК 131")
    Premise.create(id=22, idMap=1, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=23, idMap=1, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=24, idMap=1, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=25, idMap=1, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=26, idMap=1, idTypePremise=0, name="137", description="ГУК 137")
    Premise.create(id=27, idMap=1, idTypePremise=0, name="136a", description="ГУК 136a")
    Premise.create(id=28, idMap=1, idTypePremise=0, name="136", description="ГУК 136")
    Premise.create(id=29, idMap=1, idTypePremise=0, name="135", description="ГУК 135")
    Premise.create(id=30, idMap=1, idTypePremise=0, name="134", description="ГУК 134")
    Premise.create(id=31, idMap=1, idTypePremise=0, name="133", description="ГУК 133")
    Premise.create(id=32, idMap=1, idTypePremise=0, name="132", description="ГУК 132")
    Premise.create(id=33, idMap=1, idTypePremise=0, name="132a", description="ГУК 132a")
    Premise.create(id=34, idMap=1, idTypePremise=4, name="Вход", description="Вход 2")
    Premise.create(id=35, idMap=1, idTypePremise=4, name="Вход", description="Главный вход")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 1)
    query.execute()

os.chdir('../..')
PremiseRemove()
PremiseAdd()
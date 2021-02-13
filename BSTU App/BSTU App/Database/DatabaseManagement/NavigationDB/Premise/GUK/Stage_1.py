import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    '''
    # Помощь для генерации помещений
    for id, val in enumerate([137, "136a", 136, 135, 134, 133, 132, "132a"]):
        print("Premise.create(id={}, idTypePremise=0, name=\"{}\", description=\"Кабинет {}\")".format(25+id, val, val))
    '''
    Premise.create(id=0, idMap=0, idTypePremise=0, name="122", description="ГК 122")
    Premise.create(id=1, idMap=0, idTypePremise=0, name="124", description="ГК 124")
    Premise.create(id=2, idMap=0, idTypePremise=0, name="125", description="ГК 125")
    Premise.create(id=3, idMap=0, idTypePremise=0, name="120", description="ГК 120")
    Premise.create(id=4, idMap=0, idTypePremise=0, name="119", description="ГК 119")
    Premise.create(id=5, idMap=0, idTypePremise=0, name="118", description="ГК 118")
    Premise.create(id=6, idMap=0, idTypePremise=0, name="117", description="ГК 117")
    Premise.create(id=7, idMap=0, idTypePremise=0, name="116", description="ГК 116")
    Premise.create(id=8, idMap=0, idTypePremise=0, name="115", description="ГК 115")
    Premise.create(id=9, idMap=0, idTypePremise=0, name="114", description="ГК 114")
    Premise.create(id=10, idMap=0, idTypePremise=0, name="113", description="ГК 113")
    Premise.create(id=11, idMap=0, idTypePremise=0, name="111", description="ГК 111")
    Premise.create(id=12, idMap=0, idTypePremise=0, name="109", description="ГК 109")
    Premise.create(id=13, idMap=0, idTypePremise=0, name="108", description="ГК 108")
    Premise.create(id=14, idMap=0, idTypePremise=0, name="107", description="ГК 107")
    Premise.create(id=15, idMap=0, idTypePremise=0, name="106", description="ГК 106")
    Premise.create(id=16, idMap=0, idTypePremise=0, name="105", description="ГК 105")
    Premise.create(id=17, idMap=0, idTypePremise=0, name="104", description="ГК 104")
    Premise.create(id=18, idMap=0, idTypePremise=0, name="101", description="ГК 101")
    Premise.create(id=19, idMap=0, idTypePremise=0, name="138", description="ГК 138")
    Premise.create(id=20, idMap=0, idTypePremise=0, name="128", description="ГК 128")
    Premise.create(id=21, idMap=0, idTypePremise=0, name="131", description="ГК 131")
    Premise.create(id=22, idMap=0, idTypePremise=4, name="Вход", description="Главный вход")
    Premise.create(id=23, idMap=0, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=24, idMap=0, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=25, idMap=0, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=26, idMap=0, idTypePremise=0, name="137", description="ГК 137")
    Premise.create(id=27, idMap=0, idTypePremise=0, name="136a", description="ГК 136a")
    Premise.create(id=28, idMap=0, idTypePremise=0, name="136", description="ГК 136")
    Premise.create(id=29, idMap=0, idTypePremise=0, name="135", description="ГК 135")
    Premise.create(id=30, idMap=0, idTypePremise=0, name="134", description="ГК 134")
    Premise.create(id=31, idMap=0, idTypePremise=0, name="133", description="ГК 133")
    Premise.create(id=32, idMap=0, idTypePremise=0, name="132", description="ГК 132")
    Premise.create(id=33, idMap=0, idTypePremise=0, name="132a", description="ГК 132a")
    Premise.create(id=34, idMap=0, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=35, idMap=0, idTypePremise=4, name="Вход", description="Вход 2")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 0)
    query.execute()

os.chdir('../..')
PremiseRemove()
PremiseAdd()
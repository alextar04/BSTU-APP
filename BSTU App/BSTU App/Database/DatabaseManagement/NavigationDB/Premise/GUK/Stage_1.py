import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    '''
    # Помощь для генерации помещений
    for id, val in enumerate([137, "136a", 136, 135, 134, 133, 132, "132a"]):
        print("Premise.create(id={}, idTypePremise=0, name=\"{}\", description=\"Кабинет {}\")".format(25+id, val, val))
    '''
    Premise.create(id=0, idMap=0, idTypePremise=0, name="122", description="Кабинет 122")
    Premise.create(id=1, idMap=0, idTypePremise=0, name="124", description="Кабинет 124")
    Premise.create(id=2, idMap=0, idTypePremise=0, name="125", description="Кабинет 125")
    Premise.create(id=3, idMap=0, idTypePremise=0, name="120", description="Кабинет 120")
    Premise.create(id=4, idMap=0, idTypePremise=0, name="119", description="Кабинет 119")
    Premise.create(id=5, idMap=0, idTypePremise=0, name="118", description="Кабинет 118")
    Premise.create(id=6, idMap=0, idTypePremise=0, name="117", description="Кабинет 117")
    Premise.create(id=7, idMap=0, idTypePremise=0, name="116", description="Кабинет 116")
    Premise.create(id=8, idMap=0, idTypePremise=0, name="115", description="Кабинет 115")
    Premise.create(id=9, idMap=0, idTypePremise=0, name="114", description="Кабинет 114")
    Premise.create(id=10, idMap=0, idTypePremise=0, name="113", description="Кабинет 113")
    Premise.create(id=11, idMap=0, idTypePremise=0, name="111", description="Кабинет 111")
    Premise.create(id=12, idMap=0, idTypePremise=0, name="109", description="Кабинет 109")
    Premise.create(id=13, idMap=0, idTypePremise=0, name="108", description="Кабинет 108")
    Premise.create(id=14, idMap=0, idTypePremise=0, name="107", description="Кабинет 107")
    Premise.create(id=15, idMap=0, idTypePremise=0, name="106", description="Кабинет 106")
    Premise.create(id=16, idMap=0, idTypePremise=0, name="105", description="Кабинет 105")
    Premise.create(id=17, idMap=0, idTypePremise=0, name="104", description="Кабинет 104")
    Premise.create(id=18, idMap=0, idTypePremise=0, name="101", description="Кабинет 101")
    Premise.create(id=19, idMap=0, idTypePremise=0, name="138", description="Кабинет 138")
    Premise.create(id=20, idMap=0, idTypePremise=0, name="128", description="Кабинет 128")
    Premise.create(id=21, idMap=0, idTypePremise=0, name="128", description="Кабинет 131")
    Premise.create(id=22, idMap=0, idTypePremise=4, name="Вход", description="Главный вход")
    Premise.create(id=23, idMap=0, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=24, idMap=0, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=25, idMap=0, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=26, idMap=0, idTypePremise=0, name="137", description="Кабинет 137")
    Premise.create(id=27, idMap=0, idTypePremise=0, name="136a", description="Кабинет 136a")
    Premise.create(id=28, idMap=0, idTypePremise=0, name="136", description="Кабинет 136")
    Premise.create(id=29, idMap=0, idTypePremise=0, name="135", description="Кабинет 135")
    Premise.create(id=30, idMap=0, idTypePremise=0, name="134", description="Кабинет 134")
    Premise.create(id=31, idMap=0, idTypePremise=0, name="133", description="Кабинет 133")
    Premise.create(id=32, idMap=0, idTypePremise=0, name="132", description="Кабинет 132")
    Premise.create(id=33, idMap=0, idTypePremise=0, name="132a", description="Кабинет 132a")
    Premise.create(id=34, idMap=0, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=35, idMap=0, idTypePremise=4, name="Вход", description="Вход 2")


def PremiseRemove():
    query = Premise.delete()
    query.execute()

os.chdir('../..')
PremiseRemove()
PremiseAdd()
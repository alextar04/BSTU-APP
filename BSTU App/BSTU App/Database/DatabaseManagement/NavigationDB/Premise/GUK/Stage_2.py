import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=36, idMap=2, idTypePremise=0, name="221", description="ГУК 221")
    Premise.create(id=37, idMap=2, idTypePremise=0, name="226", description="ГУК 226")
    Premise.create(id=38, idMap=2, idTypePremise=0, name="218", description="ГУК 218")
    Premise.create(id=39, idMap=2, idTypePremise=0, name="209", description="ГУК 209")
    Premise.create(id=40, idMap=2, idTypePremise=0, name="210", description="ГУК 210")
    Premise.create(id=41, idMap=2, idTypePremise=0, name="214", description="ГУК 214")
    Premise.create(id=42, idMap=2, idTypePremise=0, name="227", description="ГУК 227")
    Premise.create(id=43, idMap=2, idTypePremise=0, name="228", description="ГУК 228")
    Premise.create(id=44, idMap=2, idTypePremise=0, name="229", description="ГУК 229")
    Premise.create(id=45, idMap=2, idTypePremise=0, name="204", description="ГУК 204")
    Premise.create(id=46, idMap=2, idTypePremise=0, name="205", description="ГУК 205")
    Premise.create(id=47, idMap=2, idTypePremise=0, name="203", description="ГУК 203")
    Premise.create(id=48, idMap=2, idTypePremise=0, name="202", description="ГУК 202")
    Premise.create(id=49, idMap=2, idTypePremise=0, name="201", description="ГУК 201")
    Premise.create(id=50, idMap=2, idTypePremise=0, name="201a", description="ГУК 201a")
    Premise.create(id=51, idMap=2, idTypePremise=0, name="242", description="ГУК 242")
    Premise.create(id=52, idMap=2, idTypePremise=0, name="230", description="ГУК 230")
    Premise.create(id=53, idMap=2, idTypePremise=0, name="239", description="ГУК 239")
    Premise.create(id=54, idMap=2, idTypePremise=0, name="233", description="ГУК 233")
    Premise.create(id=55, idMap=2, idTypePremise=0, name="237", description="ГУК 237")
    Premise.create(id=56, idMap=2, idTypePremise=0, name="236", description="ГУК 236")
    Premise.create(id=57, idMap=2, idTypePremise=0, name="235", description="ГУК 235")
    Premise.create(id=58, idMap=2, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=59, idMap=2, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=60, idMap=2, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=61, idMap=2, idTypePremise=4, name="Вход", description="Главный вход")
    Premise.create(id=62, idMap=2, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=63, idMap=2, idTypePremise=4, name="Вход", description="Вход 2")

def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 2)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
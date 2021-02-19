import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=137, idMap=5, idTypePremise=0, name="515а", description="ГУК 515а")
    Premise.create(id=138, idMap=5, idTypePremise=0, name="517", description="ГУК 517")
    Premise.create(id=139, idMap=5, idTypePremise=0, name="519", description="ГУК 519")
    Premise.create(id=140, idMap=5, idTypePremise=0, name="520", description="ГУК 520")
    Premise.create(id=141, idMap=5, idTypePremise=0, name="515", description="ГУК 515")
    Premise.create(id=142, idMap=5, idTypePremise=0, name="514", description="ГУК 514")
    Premise.create(id=143, idMap=5, idTypePremise=0, name="513", description="ГУК 513")

    Premise.create(id=144, idMap=5, idTypePremise=0, name="512б", description="ГУК 512б")
    Premise.create(id=145, idMap=5, idTypePremise=0, name="512а", description="ГУК 512а")
    Premise.create(id=146, idMap=5, idTypePremise=0, name="512", description="ГУК 512")
    Premise.create(id=147, idMap=5, idTypePremise=0, name="511", description="ГУК 511")
    Premise.create(id=148, idMap=5, idTypePremise=0, name="510", description="ГУК 510")
    Premise.create(id=149, idMap=5, idTypePremise=0, name="509", description="ГУК 509")
    Premise.create(id=150, idMap=5, idTypePremise=0, name="508", description="ГУК 508")

    Premise.create(id=151, idMap=5, idTypePremise=0, name="506", description="ГУК 506")
    Premise.create(id=152, idMap=5, idTypePremise=0, name="505а", description="ГУК 505а")
    Premise.create(id=153, idMap=5, idTypePremise=0, name="504а", description="ГУК 504а")
    Premise.create(id=154, idMap=5, idTypePremise=0, name="504", description="ГУК 504")
    Premise.create(id=155, idMap=5, idTypePremise=0, name="502", description="ГУК 502")
    Premise.create(id=156, idMap=5, idTypePremise=0, name="501", description="ГУК 501")
    Premise.create(id=157, idMap=5, idTypePremise=0, name="523", description="ГУК 523")
    Premise.create(id=158, idMap=5, idTypePremise=0, name="524", description="ГУК 524")

    Premise.create(id=159, idMap=5, idTypePremise=0, name="525", description="ГУК 525")
    Premise.create(id=160, idMap=5, idTypePremise=0, name="526", description="ГУК 526")
    Premise.create(id=161, idMap=5, idTypePremise=0, name="528", description="ГУК 528")
    Premise.create(id=162, idMap=5, idTypePremise=0, name="528а", description="ГУК 528а")
    Premise.create(id=163, idMap=5, idTypePremise=0, name="529", description="ГУК 529")
    Premise.create(id=164, idMap=5, idTypePremise=0, name="530", description="ГУК 530")
    Premise.create(id=165, idMap=5, idTypePremise=0, name="531", description="ГУК 531")

    Premise.create(id=166, idMap=5, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=167, idMap=5, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=168, idMap=5, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=169, idMap=5, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=170, idMap=5, idTypePremise=4, name="Вход", description="Вход 2")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 5)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
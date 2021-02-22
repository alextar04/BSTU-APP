import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=64, idMap=3, idTypePremise=0, name="317а", description="ГУК 317а")
    Premise.create(id=65, idMap=3, idTypePremise=0, name="320", description="ГУК 320")
    Premise.create(id=66, idMap=3, idTypePremise=0, name="319", description="ГУК 319")
    Premise.create(id=67, idMap=3, idTypePremise=0, name="321", description="ГУК 321")
    Premise.create(id=68, idMap=3, idTypePremise=0, name="318", description="ГУК 318")
    Premise.create(id=69, idMap=3, idTypePremise=0, name="317", description="ГУК 317")
    Premise.create(id=70, idMap=3, idTypePremise=0, name="316", description="ГУК 316")
    Premise.create(id=71, idMap=3, idTypePremise=0, name="314а", description="ГУК 314а")
    Premise.create(id=72, idMap=3, idTypePremise=0, name="314", description="ГУК 314")
    Premise.create(id=73, idMap=3, idTypePremise=0, name="313", description="ГУК 313")
    Premise.create(id=74, idMap=3, idTypePremise=0, name="312", description="ГУК 312")
    Premise.create(id=75, idMap=3, idTypePremise=0, name="311", description="ГУК 311")
    Premise.create(id=76, idMap=3, idTypePremise=0, name="310", description="ГУК 310")
    Premise.create(id=77, idMap=3, idTypePremise=0, name="307а", description="ГУК 307а")
    Premise.create(id=78, idMap=3, idTypePremise=0, name="307", description="ГУК 307")
    Premise.create(id=79, idMap=3, idTypePremise=0, name="306", description="ГУК 306")
    Premise.create(id=80, idMap=3, idTypePremise=0, name="305", description="ГУК 305")
    Premise.create(id=81, idMap=3, idTypePremise=0, name="304", description="ГУК 304")
    Premise.create(id=82, idMap=3, idTypePremise=0, name="303", description="ГУК 303")
    Premise.create(id=83, idMap=3, idTypePremise=0, name="301", description="ГУК 301")
    Premise.create(id=84, idMap=3, idTypePremise=0, name="322", description="ГУК 322")
    Premise.create(id=85, idMap=3, idTypePremise=0, name="324", description="ГУК 324")
    Premise.create(id=86, idMap=3, idTypePremise=0, name="325", description="ГУК 325")
    Premise.create(id=87, idMap=3, idTypePremise=0, name="326", description="ГУК 326")
    Premise.create(id=88, idMap=3, idTypePremise=0, name="327", description="ГУК 327")
    Premise.create(id=89, idMap=3, idTypePremise=0, name="327а", description="ГУК 327а")
    Premise.create(id=90, idMap=3, idTypePremise=0, name="328", description="ГУК 328")
    Premise.create(id=91, idMap=3, idTypePremise=0, name="329а", description="ГУК 329а")
    Premise.create(id=92, idMap=3, idTypePremise=0, name="331", description="ГУК 331")
    Premise.create(id=93, idMap=3, idTypePremise=0, name="335", description="ГУК 335")
    Premise.create(id=94, idMap=3, idTypePremise=0, name="336", description="ГУК 336")
    Premise.create(id=95, idMap=3, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=96, idMap=3, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=97, idMap=3, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=98, idMap=3, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=99, idMap=3, idTypePremise=4, name="Вход", description="Вход 2")

def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 3)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
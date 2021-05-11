import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=205, idMap=6, idTypePremise=0, name="616", description="ГУК 616")
    Premise.create(id=206, idMap=6, idTypePremise=0, name="616б", description="ГУК 616б")
    Premise.create(id=207, idMap=6, idTypePremise=0, name="617", description="ГУК 617")
    Premise.create(id=208, idMap=6, idTypePremise=0, name="618/2", description="ГУК 618/2")

    Premise.create(id=209, idMap=6, idTypePremise=0, name="615", description="ГУК 615")
    Premise.create(id=210, idMap=6, idTypePremise=0, name="614", description="ГУК 614")
    Premise.create(id=211, idMap=6, idTypePremise=0, name="613", description="ГУК 613")

    Premise.create(id=212, idMap=6, idTypePremise=0, name="612а", description="ГУК 612а")
    Premise.create(id=213, idMap=6, idTypePremise=0, name="612", description="ГУК 612")
    Premise.create(id=214, idMap=6, idTypePremise=0, name="611", description="ГУК 611")

    Premise.create(id=215, idMap=6, idTypePremise=0, name="610", description="ГУК 610")
    Premise.create(id=216, idMap=6, idTypePremise=0, name="609", description="ГУК 609")
    Premise.create(id=217, idMap=6, idTypePremise=0, name="608", description="ГУК 608")

    Premise.create(id=218, idMap=6, idTypePremise=0, name="606", description="ГУК 606")
    Premise.create(id=219, idMap=6, idTypePremise=0, name="605", description="ГУК 605")
    Premise.create(id=220, idMap=6, idTypePremise=0, name="604", description="ГУК 604")
    Premise.create(id=221, idMap=6, idTypePremise=0, name="603", description="ГУК 603")
    Premise.create(id=222, idMap=6, idTypePremise=0, name="602", description="ГУК 602")
    Premise.create(id=223, idMap=6, idTypePremise=0, name="601", description="ГУК 601")

    Premise.create(id=224, idMap=6, idTypePremise=0, name="620", description="ГУК 620")
    Premise.create(id=225, idMap=6, idTypePremise=0, name="621", description="ГУК 621")
    Premise.create(id=226, idMap=6, idTypePremise=0, name="622", description="ГУК 622")

    Premise.create(id=227, idMap=6, idTypePremise=0, name="623", description="ГУК 623")
    Premise.create(id=228, idMap=6, idTypePremise=0, name="624", description="ГУК 624")
    Premise.create(id=229, idMap=6, idTypePremise=0, name="625", description="ГУК 625")
    Premise.create(id=230, idMap=6, idTypePremise=0, name="626", description="ГУК 626")
    Premise.create(id=231, idMap=6, idTypePremise=0, name="627а", description="ГУК 627а")
    Premise.create(id=232, idMap=6, idTypePremise=0, name="627", description="ГУК 627")
    Premise.create(id=233, idMap=6, idTypePremise=0, name="628", description="ГУК 628")
    Premise.create(id=234, idMap=6, idTypePremise=0, name="629", description="ГУК 629")

    Premise.create(id=235, idMap=6, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=236, idMap=6, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=237, idMap=6, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=238, idMap=6, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=239, idMap=6, idTypePremise=4, name="Вход", description="Вход 2")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 6)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
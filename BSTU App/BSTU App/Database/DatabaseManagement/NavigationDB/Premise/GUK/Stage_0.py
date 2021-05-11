import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():

    Premise.create(id=240, idMap=0, idTypePremise=0, name="014", description="ГУК 014")
    Premise.create(id=241, idMap=0, idTypePremise=0, name="014а", description="ГУК 014а")
    Premise.create(id=242, idMap=0, idTypePremise=0, name="015", description="ГУК 015")
    Premise.create(id=243, idMap=0, idTypePremise=0, name="013а", description="ГУК 013а")
    Premise.create(id=244, idMap=0, idTypePremise=0, name="013", description="ГУК 013")
    Premise.create(id=245, idMap=0, idTypePremise=0, name="012", description="ГУК 012")

    Premise.create(id=246, idMap=0, idTypePremise=0, name="006", description="ГУК 006")
    Premise.create(id=247, idMap=0, idTypePremise=0, name="009", description="ГУК 009")
    Premise.create(id=248, idMap=0, idTypePremise=0, name="008", description="ГУК 008")
    Premise.create(id=249, idMap=0, idTypePremise=0, name="007", description="ГУК 007")
    Premise.create(id=250, idMap=0, idTypePremise=3, name="WC", description="Туалет мужской")

    Premise.create(id=251, idMap=0, idTypePremise=0, name="003", description="ГУК 003")
    Premise.create(id=252, idMap=0, idTypePremise=0, name="001", description="ГУК 001")
    Premise.create(id=253, idMap=0, idTypePremise=4, name="Вход", description="Вход 2")
    Premise.create(id=254, idMap=0, idTypePremise=0, name="021", description="ГУК 021")
    Premise.create(id=255, idMap=0, idTypePremise=5, name="Лифт", description="Лифт")

    Premise.create(id=256, idMap=0, idTypePremise=0, name="022", description="ГУК 022")
    Premise.create(id=257, idMap=0, idTypePremise=0, name="024", description="ГУК 024")
    Premise.create(id=258, idMap=0, idTypePremise=0, name="026", description="ГУК 026")
    Premise.create(id=259, idMap=0, idTypePremise=0, name="027", description="ГУК 027")

    Premise.create(id=260, idMap=0, idTypePremise=0, name="030", description="ГУК 030")
    Premise.create(id=261, idMap=0, idTypePremise=0, name="031", description="ГУК 031")
    Premise.create(id=262, idMap=0, idTypePremise=0, name="032", description="ГУК 032")
    Premise.create(id=263, idMap=0, idTypePremise=0, name="033", description="ГУК 033")
    Premise.create(id=264, idMap=0, idTypePremise=0, name="034", description="ГУК 034")

    Premise.create(id=265, idMap=0, idTypePremise=0, name="013", description="ГУК 013")
    Premise.create(id=266, idMap=0, idTypePremise=0, name="016", description="ГУК 016")
    Premise.create(id=267, idMap=0, idTypePremise=0, name="017", description="ГУК 017")
    Premise.create(id=268, idMap=0, idTypePremise=0, name="018", description="ГУК 018")
    Premise.create(id=269, idMap=0, idTypePremise=0, name="019", description="ГУК 019")
    Premise.create(id=270, idMap=0, idTypePremise=0, name="020", description="ГУК 020")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 0)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
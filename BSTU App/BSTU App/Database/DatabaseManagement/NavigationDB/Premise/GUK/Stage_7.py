import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=171, idMap=7, idTypePremise=0, name="716а", description="ГУК 716а")
    Premise.create(id=172, idMap=7, idTypePremise=0, name="716", description="ГУК 716")
    Premise.create(id=173, idMap=7, idTypePremise=0, name="715", description="ГУК 715")
    Premise.create(id=174, idMap=7, idTypePremise=0, name="715а", description="ГУК 715а")
    Premise.create(id=175, idMap=7, idTypePremise=0, name="714", description="ГУК 714")
    Premise.create(id=176, idMap=7, idTypePremise=0, name="718", description="ГУК 718")
    Premise.create(id=177, idMap=7, idTypePremise=0, name="719", description="ГУК 719")

    Premise.create(id=178, idMap=7, idTypePremise=0, name="713а", description="ГУК 713а")
    Premise.create(id=179, idMap=7, idTypePremise=0, name="713", description="ГУК 713")
    Premise.create(id=180, idMap=7, idTypePremise=0, name="712", description="ГУК 712")
    Premise.create(id=181, idMap=7, idTypePremise=0, name="711а", description="ГУК 711а")
    Premise.create(id=182, idMap=7, idTypePremise=0, name="711", description="ГУК 711")
    Premise.create(id=183, idMap=7, idTypePremise=0, name="710", description="ГУК 710")
    Premise.create(id=184, idMap=7, idTypePremise=0, name="709", description="ГУК 709")

    Premise.create(id=185, idMap=7, idTypePremise=0, name="707", description="ГУК 707")
    Premise.create(id=186, idMap=7, idTypePremise=0, name="706", description="ГУК 706")
    Premise.create(id=187, idMap=7, idTypePremise=0, name="705", description="ГУК 705")
    Premise.create(id=188, idMap=7, idTypePremise=0, name="703", description="ГУК 703")
    Premise.create(id=189, idMap=7, idTypePremise=0, name="702", description="ГУК 702")
    Premise.create(id=190, idMap=7, idTypePremise=0, name="701", description="ГУК 701")
    Premise.create(id=191, idMap=7, idTypePremise=0, name="720", description="ГУК 720")
    Premise.create(id=192, idMap=7, idTypePremise=0, name="721", description="ГУК 721")

    Premise.create(id=193, idMap=7, idTypePremise=0, name="722", description="ГУК 722")
    Premise.create(id=194, idMap=7, idTypePremise=0, name="723", description="ГУК 723")
    Premise.create(id=195, idMap=7, idTypePremise=0, name="724", description="ГУК 724")
    Premise.create(id=196, idMap=7, idTypePremise=0, name="724а", description="ГУК 724а")
    Premise.create(id=197, idMap=7, idTypePremise=0, name="725", description="ГУК 725")
    Premise.create(id=198, idMap=7, idTypePremise=0, name="725а", description="ГУК 725а")
    Premise.create(id=199, idMap=7, idTypePremise=0, name="726", description="ГУК 726")

    Premise.create(id=200, idMap=7, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=201, idMap=7, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=202, idMap=7, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=203, idMap=7, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=204, idMap=7, idTypePremise=4, name="Вход", description="Вход 2")


def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 7)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
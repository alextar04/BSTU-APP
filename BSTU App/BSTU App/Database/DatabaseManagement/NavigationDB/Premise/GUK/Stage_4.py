import os
from peewee import *
from NavigationDB.Premise.PremiseDB import Premise


def PremiseAdd():
    Premise.create(id=100, idMap=4, idTypePremise=0, name="415", description="ГУК 415")
    Premise.create(id=101, idMap=4, idTypePremise=0, name="416", description="ГУК 416")
    Premise.create(id=102, idMap=4, idTypePremise=0, name="417", description="ГУК 417")
    Premise.create(id=103, idMap=4, idTypePremise=0, name="418", description="ГУК 418")
    Premise.create(id=104, idMap=4, idTypePremise=0, name="414а", description="ГУК 414а")
    Premise.create(id=105, idMap=4, idTypePremise=0, name="414", description="ГУК 414")
    Premise.create(id=106, idMap=4, idTypePremise=0, name="413в", description="ГУК 413в")
    Premise.create(id=107, idMap=4, idTypePremise=0, name="413б", description="ГУК 413б")
    Premise.create(id=108, idMap=4, idTypePremise=0, name="413", description="ГУК 413")
    Premise.create(id=109, idMap=4, idTypePremise=0, name="412а", description="ГУК 412а")
    Premise.create(id=110, idMap=4, idTypePremise=0, name="412", description="ГУК 412")
    Premise.create(id=111, idMap=4, idTypePremise=0, name="411а", description="ГУК 411а")
    Premise.create(id=112, idMap=4, idTypePremise=0, name="411", description="ГУК 411")
    Premise.create(id=113, idMap=4, idTypePremise=0, name="410", description="ГУК 410")
    Premise.create(id=114, idMap=4, idTypePremise=0, name="409", description="ГУК 409")
    Premise.create(id=115, idMap=4, idTypePremise=0, name="407", description="ГУК 407")
    Premise.create(id=116, idMap=4, idTypePremise=0, name="406", description="ГУК 406")
    Premise.create(id=117, idMap=4, idTypePremise=0, name="405", description="ГУК 405")
    Premise.create(id=118, idMap=4, idTypePremise=0, name="404", description="ГУК 404")
    Premise.create(id=119, idMap=4, idTypePremise=0, name="403", description="ГУК 403")
    Premise.create(id=120, idMap=4, idTypePremise=0, name="402", description="ГУК 402")
    Premise.create(id=121, idMap=4, idTypePremise=0, name="401", description="ГУК 401")
    Premise.create(id=122, idMap=4, idTypePremise=0, name="421", description="ГУК 421")
    Premise.create(id=123, idMap=4, idTypePremise=0, name="422", description="ГУК 422")
    Premise.create(id=124, idMap=4, idTypePremise=0, name="425а", description="ГУК 425а")
    Premise.create(id=125, idMap=4, idTypePremise=0, name="425", description="ГУК 425")
    Premise.create(id=126, idMap=4, idTypePremise=0, name="426", description="ГУК 426")
    Premise.create(id=127, idMap=4, idTypePremise=0, name="427", description="ГУК 427")
    Premise.create(id=128, idMap=4, idTypePremise=0, name="428", description="ГУК 428")
    Premise.create(id=129, idMap=4, idTypePremise=0, name="429а", description="ГУК 429а")
    Premise.create(id=130, idMap=4, idTypePremise=0, name="429", description="ГУК 429")
    Premise.create(id=131, idMap=4, idTypePremise=0, name="430", description="ГУК 430")

    Premise.create(id=132, idMap=4, idTypePremise=3, name="WC", description="Туалет мужской")
    Premise.create(id=133, idMap=4, idTypePremise=3, name="WC", description="Туалет женский")
    Premise.create(id=134, idMap=4, idTypePremise=5, name="Лифт", description="Лифт")
    Premise.create(id=135, idMap=4, idTypePremise=4, name="Вход", description="Вход 1")
    Premise.create(id=136, idMap=4, idTypePremise=4, name="Вход", description="Вход 2")

def PremiseRemove():
    query = Premise.delete().where(Premise.idMap == 4)
    query.execute()

os.chdir('../../..')
PremiseRemove()
PremiseAdd()
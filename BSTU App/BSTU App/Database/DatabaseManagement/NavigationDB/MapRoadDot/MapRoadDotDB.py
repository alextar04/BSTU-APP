from peewee import *
from NavigationDB.BaseModel import BaseModel

class MapRoadDot(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    idMap = IntegerField(column_name='idMap')
    idOnMap = IntegerField(column_name='idOnMap')
    idPremise = IntegerField(column_name='idPremise')
    x = IntegerField(column_name='x')
    y = IntegerField(column_name='y')
    audienceX = IntegerField(column_name='audienceX')
    audienceY = IntegerField(column_name='audienceY')
    class Meta:
        table_name = 'MapRoadDotDB'
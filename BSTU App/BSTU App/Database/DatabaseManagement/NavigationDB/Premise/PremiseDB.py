import os
from peewee import *
from NavigationDB.BaseModel import BaseModel

class Premise(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    idMap = IntegerField(column_name='idMap')
    idTypePremise = IntegerField(column_name='idTypePremise')
    name = CharField(column_name='name')
    description = CharField(column_name='description')
    class Meta:
        table_name = 'PremiseDB'
import os
from peewee import *
from NavigationDB.BaseModel import BaseModel

class Marker(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    idMap = IntegerField(column_name='idMap')
    idPremise = IntegerField(column_name='idPremise')
    x = IntegerField(column_name='x')
    y = IntegerField(column_name='y')
    class Meta:
        table_name = 'MarkerDB'
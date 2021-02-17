import os
from peewee import *
from NavigationDB.BaseModel import BaseModel

class Corp(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    name = CharField(column_name='name')
    class Meta:
        table_name = 'CorpDB'

def CorpAdd():
    Corp.create(id=0, name="Главный корпус")

def CorpRemove():
    query = Corp.delete()
    query.execute()

os.chdir('../..')
CorpRemove()
CorpAdd()
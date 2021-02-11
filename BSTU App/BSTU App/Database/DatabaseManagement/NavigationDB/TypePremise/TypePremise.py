import os
import io
from peewee import *
import sqlite3
from NavigationDB.BaseModel import BaseModel

class TypePremise(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    name = CharField(column_name='name')
    picture = BigBitField(column_name='picture')
    class Meta:
        table_name = 'TypePremiseDB'


def pictureToBinary(pictureName):
    with open("NavigationDB/TypePremise/images/"+pictureName, "rb") as f:
        bytesio_obj = io.BytesIO(f.read())
        binary = bytesio_obj.getvalue()
        return sqlite3.Binary(binary)


def TypePremiseAdd():
    TypePremise.create(id=0, name="Кабинет", picture=pictureToBinary('cabinet.png'))
    TypePremise.create(id=1, name="Буфет", picture=pictureToBinary('buffet.png'))
    TypePremise.create(id=2, name="Гардероб", picture=pictureToBinary('wardrobe.png'))
    TypePremise.create(id=3, name="Туалет", picture=pictureToBinary('wc.png'))
    TypePremise.create(id=4, name="Вход", picture=pictureToBinary('wc.png'))
    TypePremise.create(id=5, name="Лифт", picture=pictureToBinary('wc.png'))

def TypePremiseRemove():
    query = TypePremise.delete()
    query.execute()

os.chdir('../..')
TypePremiseRemove()
TypePremiseAdd()
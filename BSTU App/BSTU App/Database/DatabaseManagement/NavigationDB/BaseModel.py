from peewee import *

db = SqliteDatabase('admin_bstuDB.sqlite3')
class BaseModel(Model):
    """A base model that will use our Sqlite database."""
    class Meta:
        database = db
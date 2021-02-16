import io
import os
import sqlite3
from peewee import *
from NavigationDB.Map.MapDB import *
from NavigationDB.MapRoadDot.GUK.Stage2 import *


def MapAdd():
    result = searchShortestWays(roadDotsArray, connectedDots)
    matrixBestDistance = result[0]
    matrixBestWays = result[1]
    Map.create(id=2, idCorp=0, storey=2, plan=pictureToBinary(os.getcwd()+"/NavigationDB/Map/GUK/images/Stage_2.png"),
               matrixBestWays=matrixBestWays,
               matrixBestDistance=matrixBestDistance)

def MapRemove():
    query = Map.delete().where(Map.id == 2)
    query.execute()


connectedDots = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5),
                 (5, 9), (9, 10), (10, 11), (11, 12), (12, 13), (13, 14), (14, 15), (15, 16), (16, 17),
                 (5, 6), (6, 7), (7, 8),
                 (17, 18), (17, 19), (17, 20), (19, 20), (18, 20),
                 (21, 22), (22, 23), (22, 20), (23, 18),
                 (20, 24), (24, 25), (25, 26), (26, 27), (27, 28), (28, 29),
                 (18, 30), (30, 31), (31, 32), (32, 33), (33, 34)
                ]


MapRemove()
MapAdd()

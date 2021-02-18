import io
import os
import sqlite3
from peewee import *
from NavigationDB.Map.MapDB import *
from NavigationDB.MapRoadDot.GUK.Stage4 import *


def MapAdd():
    result = searchShortestWays(roadDotsArray, connectedDots)
    matrixBestDistance = result[0]
    matrixBestWays = result[1]
    Map.create(id=4, idCorp=0, storey=4, plan=pictureToBinary(os.getcwd()+"/NavigationDB/Map/GUK/images/Stage_4.png"),
               matrixBestWays=matrixBestWays,
               matrixBestDistance=matrixBestDistance)

def MapRemove():
    query = Map.delete().where(Map.id == 4)
    query.execute()


connectedDots = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7),
                 (7, 8), (8, 9), (9, 10), (10, 11), (11, 12), (12, 13), (13, 14), (14, 15), (15, 16), (16, 17),
                 (8, 18), (18, 19), (19, 20), (20, 21), (21, 22), (22, 23), (23, 24), (24, 25), (25, 26), (26, 27), (27, 28), (28, 29), (29, 30),
                 (27, 31), (27, 32), (31, 32), (29, 32),
                 (33, 34), (34, 35), (35, 36), (32, 34), (35, 29),
                 (32, 36), (36, 37), (37, 38), (38, 39), (39, 40), (40, 41), (41, 42), (42, 43)
                ]


MapRemove()
MapAdd()

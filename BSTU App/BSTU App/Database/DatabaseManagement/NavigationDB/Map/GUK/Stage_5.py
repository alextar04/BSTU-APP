import io
import os
import sqlite3
from peewee import *
from NavigationDB.Map.MapDB import *
from NavigationDB.MapRoadDot.GUK.Stage5 import *


def MapAdd():
    result = searchShortestWays(roadDotsArray, connectedDots)
    matrixBestDistance = result[0]
    matrixBestWays = result[1]
    Map.create(id=5, idCorp=0, storey=5, plan=pictureToBinary(os.getcwd()+"/NavigationDB/Map/GUK/images/Stage_5.png"),
               matrixBestWays=matrixBestWays,
               matrixBestDistance=matrixBestDistance)

def MapRemove():
    query = Map.delete().where(Map.id == 5)
    query.execute()


connectedDots = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7),
                 (6, 8), (8, 9), (9, 10), (10, 11), (11, 12), (12, 13), (13, 14), (14, 15), (15, 16),
                 (10, 39), (39, 40), (40, 17), (17, 18), (18, 19), (19, 20), (20, 21), (21, 22), (22, 23), (23, 24), (24, 25), (25, 26),
                 (23, 27), (23, 28), (27, 28), (25, 28),
                 (29, 30), (30, 31), (30, 28), (31, 25),
                 (28, 32), (32, 33), (33, 34), (34, 35), (35, 36), (36, 37), (37, 38),
                ]


MapRemove()
MapAdd()

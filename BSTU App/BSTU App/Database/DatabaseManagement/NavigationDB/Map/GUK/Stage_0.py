import io
import os
import sqlite3
from peewee import *
from NavigationDB.Map.MapDB import *
from NavigationDB.MapRoadDot.GUK.Stage0 import *


def MapAdd():
    result = searchShortestWays(roadDotsArray, connectedDots)
    matrixBestDistance = result[0]
    matrixBestWays = result[1]
    Map.create(id=0, idCorp=0, storey=0, plan=pictureToBinary(os.getcwd()+"/NavigationDB/Map/GUK/images/Stage_0.png"),
               matrixBestWays=matrixBestWays,
               matrixBestDistance=matrixBestDistance)

def MapRemove():
    query = Map.delete().where(Map.id == 0)
    query.execute()


connectedDots = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7),
                 (7, 8), (41, 9), (9, 10), (10, 11), (11, 12),
                 (8, 41), (41, 13), (13, 14), (14, 15), (15, 16), (16, 17), (17, 18), (18, 23),
                 (16, 19), (19, 20), (20, 22),
                 (21, 22), (22, 23),
                 (16, 22), (20, 17),
                 (20, 24), (24, 25), (25, 26), (26, 27), (27, 28),
                 (28, 30), (30, 29), (28, 31), (31, 32), (32, 33), (33, 34),
                 (34, 35), (35, 36), (36, 37), (37, 38), (38, 39), (39, 40),
                 (40, 6)
                ]


MapRemove()
MapAdd()

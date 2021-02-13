import io
import os
import sqlite3
from peewee import *
from NavigationDB.Map.MapDB import *
from NavigationDB.MapRoadDot.GUK.Stage1 import *


def MapAdd():
    result = searchShortestWays(roadDotsArray, connectedDots)
    matrixBestDistance = result[0]
    matrixBestWays = result[1]
    Map.create(id=0, idCorp=0, storey=1, plan=pictureToBinary(os.getcwd()+"/NavigationDB/Map/GUK/images/Stage_1.png"),
               matrixBestWays=matrixBestWays,
               matrixBestDistance=matrixBestDistance)

def MapRemove():
    query = Map.delete().where(Map.id == 0)
    query.execute()


connectedDots = [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7), (6, 13),
                 (7, 8), (8, 9), (9, 10), (10, 11), (11, 12),
                 (7, 13), (13, 14), (14, 15), (15, 16), (16, 17), (17, 18), (18, 19), (19, 20), (20, 21), (20, 22), (20, 23), (21, 23), (22, 23), (22, 39),
                 (22, 23), (23, 24), (24, 25), (25, 26), (26, 27), (27, 28), (28, 29), (29, 30), (30, 31),
                 (22, 32), (32, 33), (33, 34), (34, 35), (35, 36),
                 (37, 38), (38, 39), (38, 23)]


MapRemove()
MapAdd()

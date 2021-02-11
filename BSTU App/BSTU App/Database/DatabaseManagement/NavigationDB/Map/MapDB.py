import io
import math
import sys
import sqlite3
from peewee import *
from NavigationDB.BaseModel import BaseModel

class Map(BaseModel):
    id = IntegerField(column_name='id', primary_key=True)
    idCorp = IntegerField(column_name='idCorp')
    storey = IntegerField(column_name='storey')
    plan = BigBitField(column_name='plan')
    matrixBestWays = TextField(column_name='matrixBestWays')
    matrixBestDistance = TextField(column_name='matrixBestDistance')
    class Meta:
        table_name = 'MapDB'


# Расстояние между точками
def distancePoints(point1, point2):
    return math.sqrt(math.pow((point1[0] - point2[0]), 2) + math.pow((point1[1] - point2[1]), 2))


# Матрица смежности
def createAdjacenciesMatrix(roadDotsArray, connectedDots):
    adjacenciesMatrix = [[sys.maxsize for i in range(len(roadDotsArray))] for j in range(len(roadDotsArray))]
    for index in connectedDots:
        adjacenciesMatrix[index[0]][index[1]] = distancePoints((roadDotsArray[index[0]].x, roadDotsArray[index[0]].y),
                                                               (roadDotsArray[index[1]].x, roadDotsArray[index[1]].y))
        adjacenciesMatrix[index[1]][index[0]] = adjacenciesMatrix[index[0]][index[1]]

    for index in range(0, len(adjacenciesMatrix)):
        adjacenciesMatrix[index][index] = 0

    return adjacenciesMatrix


# Матрица смежности
def createMatrixShortestWays(roadDotsArray, connectedDots):
    nextMatrix = [[None for i in range(len(roadDotsArray))] for j in range(len(roadDotsArray))]
    for index in connectedDots:
        nextMatrix[index[0]][index[1]] = index[1]
        nextMatrix[index[1]][index[0]] = index[0]

    for index in range(0, len(nextMatrix)):
        nextMatrix[index][index] = index

    return nextMatrix


# Поиск кратчайших путей (Алгоритм Флойда-Уоршала)
def searchShortestWays(roadDotsArray, connectedDots):
    matrix = createAdjacenciesMatrix(roadDotsArray, connectedDots)
    nextMatrix = createMatrixShortestWays(roadDotsArray, connectedDots)

    for k in range(len(roadDotsArray)):
        for i in range(len(roadDotsArray)):
            for j in range(len(roadDotsArray)):
                if matrix[i][k] + matrix[k][j] < matrix[i][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]
                    nextMatrix[i][j] = nextMatrix[i][k]
    #printMatrix(nextMatrix)
    return [matrix, nextMatrix]


def printMatrix(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end="  ")
        print()


def pictureToBinary(pictureName):
    with open(pictureName, "rb") as f:
        bytesio_obj = io.BytesIO(f.read())
        binary = bytesio_obj.getvalue()
        return sqlite3.Binary(binary)
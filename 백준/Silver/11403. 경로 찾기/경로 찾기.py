# 11403 경로 찾기

import sys
input = sys.stdin.readline
INF = int(1e9)

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

for mid in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][j] or (graph[i][mid] and graph[mid][j]):
                graph[i][j] = 1

for i in range(N):
    for j in range(N):
        print(graph[i][j], end=' ')
    print()
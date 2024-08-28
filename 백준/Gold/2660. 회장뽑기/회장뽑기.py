# 2660 회장뽑기

import sys
input = sys.stdin.readline
INF = int(1e9)

N = int(input())
graph = [[INF] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    graph[i][i] = 0

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    graph[a][b] = 1
    graph[b][a] = 1

for mid in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            graph[i][j] = min(graph[i][j], graph[i][mid] + graph[mid][j])

res = [[] for _ in range(N + 1)]
for i in range(1, N + 1):
    temp = max(graph[i][1:])
    res[temp].append(i)

for i in range(1, N + 1):
    if res[i]:
        print(i, len(res[i]))
        for r in res[i]:
            print(r, end=' ')
        break
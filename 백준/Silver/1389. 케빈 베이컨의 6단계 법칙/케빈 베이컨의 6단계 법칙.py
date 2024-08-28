# 1389 케빈 베이컨의 6단계 법칙

import sys
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())
graph = [[INF] * (N + 1) for _ in range(N + 1)]
for i in range(N + 1):
    graph[i][i] = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for mid in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            graph[i][j] = min(graph[i][j], graph[i][mid] + graph[mid][j])

val = INF
res = 0
for i in range(1, N + 1):
    temp = sum(graph[i][1:])
    if temp < val:
        val = temp
        res = i
print(res)
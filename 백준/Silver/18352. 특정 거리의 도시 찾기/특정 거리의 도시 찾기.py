# 18352 특정 거리의 도시 찾기

import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
d = [INF] * (N + 1)
d[X] = 0

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    d[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if d[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + 1
            if cost < d[i]:
                d[i] = cost
                heapq.heappush(q, (cost, i))

dijkstra(X)
res = []
for i in range(1, N + 1):
    if d[i] == K:
        res.append(i)

if res:
    for i in res:
        print(i)
else:
    print(-1)
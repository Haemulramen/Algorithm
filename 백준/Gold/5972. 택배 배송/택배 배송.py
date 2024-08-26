# 5972 택배 배송

import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))
    graph[end].append((start, cost))
d = [INF] * (N + 1)
d[1] = 0

def dijkstra():
    q = [(0, 1)]
    while q:
        dist, now = heapq.heappop(q)
        for i in graph[now]:
            temp = dist + i[1]
            if temp >= d[i[0]]:
                continue
            d[i[0]] = temp
            heapq.heappush(q, (temp, i[0]))

dijkstra()
print(d[N])

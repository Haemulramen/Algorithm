# 1647 도시 분할 계획

import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
parent = [0] * (N + 1)
for i in range(1, N + 1):
    parent[i] = i

edges = []
for _ in range(M):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))
edges.sort()

res = []
for edge in edges:
    if find_parent(parent, edge[1]) == find_parent(parent, edge[2]):
        continue
    union_parent(parent, edge[1], edge[2])
    res.append(edge[0])

res.pop()
print(sum(res))
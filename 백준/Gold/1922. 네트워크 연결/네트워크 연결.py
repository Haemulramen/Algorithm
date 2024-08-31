# 1922 네트워크 연결

import sys
input = sys.stdin.readline

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

N = int(input().rstrip())
parent = [0] * (N + 1)
for i in range(1, N + 1):
    parent[i] = i

M = int(input().rstrip())
edges = []
for _ in range(M):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))
edges.sort()

res = 0
for cost, a, b in edges:
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a == b:
        continue
    res += cost
    union_parent(parent, a, b)

print(res)
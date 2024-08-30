# 14567 선수과목

def counter(parent, x, count):
    if count[x]:
        return count[x]
    if not parent[x]:
        count[x] = 1
        return 1
    for i in parent[x]:
        temp = counter(parent, i, count)
        count[x] = max(count[x], temp + 1)
    return count[x]

N, M = map(int, input().split())
parent = [[] for _ in range(N + 1)]
count = [0] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    parent[b].append(a)

for i in range(1, N + 1):
    print(counter(parent, i, count), end=' ')
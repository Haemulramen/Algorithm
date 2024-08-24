# 1446 지름길

import sys
input = sys.stdin.readline
INF = int(1e9)

N, D = map(int, input().split())
graph = [tuple(map(int, input().split())) for _ in range(N)]
dp = [INF] * (D + 1)
dp[0] = 0

for i in range(1, D + 1):
    for start, end, cost in graph:
        if i == end:
            dp[i] = min(dp[i], dp[i - 1] + 1, dp[start] + cost)
        else:
            dp[i] = min(dp[i], dp[i - 1] + 1)

print(dp[D])
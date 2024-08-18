# 14728 벼락치기

import sys
input = sys.stdin.readline

N, T = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * (T + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, T + 1):
        if j >= data[i - 1][0]:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - data[i - 1][0]] + data[i - 1][1])
        else:
            dp[i][j] = dp[i - 1][j]

print(max(dp[-1]))
# 1149 RGB거리

import sys
input = sys.stdin.readline

N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]
dp = [[0, 0, 0] for _ in range(N)]
dp[0][0] = data[0][0]
dp[0][1] = data[0][1]
dp[0][2] = data[0][2]

for i in range(1, N):
    for j in range(3):
        dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j - 2]) + data[i][j]

print(min(dp[N - 1]))

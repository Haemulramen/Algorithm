# 11660 구간 합 구하기 5

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
co = [list(map(int, input().split())) for _ in range(M)]

dp = [[0] * (N + 1) for _ in range(N + 1)]
dp[1][1] = data[0][0]
for i in range(2, N + 1):
    dp[i][1] = dp[i - 1][1] + data[i - 1][0]
    dp[1][i] = dp[1][i - 1] + data[0][i - 1]
for i in range(2, N + 1):
    for j in range(2, N + 1):
        dp[i][j] = data[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1]

for x1, y1, x2, y2 in co:
    res = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]
    print(res)
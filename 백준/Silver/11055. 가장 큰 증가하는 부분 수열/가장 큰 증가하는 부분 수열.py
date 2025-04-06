# 11055 가장 큰 증가하는 부분 수열

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
dp = [0] * N

for i in range(N):
    dp[i] = data[i]
    for j in range(i):
        if data[j] < data[i]:
            dp[i] = max(dp[j] + data[i], dp[i])

print(max(dp))
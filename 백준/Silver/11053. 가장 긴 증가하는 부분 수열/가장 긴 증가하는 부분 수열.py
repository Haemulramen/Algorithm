# 11053 가장 긴 증가하는 부분 수열

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
dp = [1] * N

for i in range(1, N):
    temp = 0
    for j in range(i):
        if data[j] < data[i]:
            temp = max(temp, dp[j])
    dp[i] = temp + 1

print(max(dp))
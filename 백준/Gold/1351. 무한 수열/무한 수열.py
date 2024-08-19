# 1351 무한 수열

from collections import deque
import sys
input = sys.stdin.readline

N, P, Q = map(int, input().split())

dp = [0] * 5000000
dp[0] = 1
for i in range(1, 5000000):
    dp[i] = dp[i // P] + dp[i // Q]
res = []
if N >= 5000000:

    queue = deque([N])
    while queue:
        temp = queue.pop()
        div_p, div_q = temp // P, temp // Q
        if div_p > 5000000:
            queue.append(div_p)
        else:
            res.append(div_p)
        if div_q > 5000000:
            queue.append(div_q)
        else:
            res.append(div_q)

    ans = 0
    for idx in res:
        ans += dp[idx]
else:
    ans = dp[N]

print(ans)
# 2293 동전1

n, k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input().rstrip()))

dp = [0] * (k + 1)
for i in range(1, k + 1):
    if i % coins[0] == 0:
        dp[i] = 1

for i in range(1, n):
    for j in range(1, k + 1):
        if j < coins[i]:
            continue
        if j - coins[i] == 0:
            dp[j] += 1
        else:
            dp[j] += dp[j - coins[i]]
print(dp[-1])
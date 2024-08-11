# 입국심사

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
times = [int(input()) for _ in range(N)]
start = 0
end = min(times) * M
res = 0

while start <= end:
    mid = (start + end) // 2
    temp = 0
    for tm in times:
        temp += mid // tm
    if temp >= M:
        end = mid - 1
        res = mid
    else:
        start = mid + 1

print(res)
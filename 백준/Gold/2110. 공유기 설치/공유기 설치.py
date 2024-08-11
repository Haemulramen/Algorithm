# 공유기 설치

import sys
input = sys.stdin.readline

N, C = map(int, input().split())
data = [int(input()) for _ in range(N)]
data.sort()

start = 0
end = data[-1] - data[0]
result = 0

while start <= end:
    mid = (start + end) // 2
    cur = data[0]
    cnt = 1

    for dt in data:
        if dt >= cur + mid:
            cur = dt
            cnt += 1

    if cnt >= C:
        start = mid + 1
        res = mid
    else:
        end = mid - 1

print(res)
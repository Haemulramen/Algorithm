# 기타 레슨

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = list(map(int, input().split()))

start = max(data)
end = sum(data)
res = 9999999999

while start <= end:
    mid = (start + end) // 2
    cnt, temp = 1, 0
    for lesson in data:
        if temp + lesson <= mid:
            temp += lesson
        else:
            cnt += 1
            temp = lesson
    if cnt <= M:
        res = min(res, mid)
        end = mid - 1
    else:
        start = mid + 1

print(res)
import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    data = list(map(int, input().split()))
    data.sort()
    level = 0
    res = [data[0]]
    for i in range(1, N):
        if len(res) % 2:
            res.append(data[i])
            if res[-1] - res[-2] > level:
                level = res[-1] - res[-2]
        else:
            res.insert(0, data[i])
            if res[0] - res[1] > level:
                level = res[0] - res[1]
    if abs(res[0] - res[-1]) > level:
        level = abs(res[0] - res[-1])
    print(level)

import sys

input = sys.stdin.readline
N = int(input())
data = list(map(int, input().split()))

data.sort()
start, end = 0, N - 1
min_value = sys.maxsize
res = [0, 0]

while start < end:
    temp = data[start] + data[end]
    if abs(temp) < min_value:
        min_value = abs(temp)
        res = [data[start], data[end]]

    if temp < 0:
        start += 1
    elif temp > 0:
        end -= 1
    else:
        break

print(res[0], res[1])

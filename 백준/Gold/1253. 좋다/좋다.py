import sys
input = sys.stdin.readline

def good(data, n, N):
    target = data[n]
    low = 0
    high = N - 1
    while low < high:
        if low == n:
            low += 1
        if high == n:
            high -= 1
        if low == high:
            return 0
        if data[low] + data[high] > target:
            high -= 1
        elif data[low] + data[high] < target:
            low += 1
        else:
            return 1
    return 0

N = int(input())
input_data = list(map(int, input().split()))
input_data.sort()

res = 0
for i in range(N):
    res += good(input_data, i, N)

print(res)

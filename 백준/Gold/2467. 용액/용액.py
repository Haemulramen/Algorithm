import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

left, right = 0, 0

diff = 9999999999
for i in range(N - 1):
    dt = data[i]
    start, end = i + 1, N - 1
    while start <= end:
        mid = (start + end) // 2
        temp = dt + data[mid]

        if abs(temp) < diff:
            diff = abs(temp)
            left = i
            right = mid
            if temp == 0:
                break
        if temp < 0:
            start = mid + 1
        else:
            end = mid - 1

print(data[left], data[right])
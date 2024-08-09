import sys
input = sys.stdin.readline

def binary_search(array, target, start, end):
    res = 0
    while start <= end:
        mid = (start + end) // 2
        temp = 0
        for line in array:
            temp += line // mid
        if temp >= target:
            res = mid
            start = mid + 1
        else:
            end = mid - 1
    return res

K, N = map(int, input().split())
data = [int(input()) for _ in range(K)]

print(binary_search(data, N, 1, max(data)))

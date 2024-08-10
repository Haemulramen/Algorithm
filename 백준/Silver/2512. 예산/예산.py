import sys
input = sys.stdin.readline

def binary_search(array, target):
    start = 0
    end = max(array)
    res = 0
    while start <= end:
        mid = (start + end) // 2
        temp = 0
        for money in array:
            if mid > money:
                temp += money
            else:
                temp += mid
        if temp <= target:
            res = mid
            start = mid + 1
        elif temp > target:
            end = mid - 1

    return res

N = int(input())
data = list(map(int, input().split()))
M = int(input())

res = binary_search(data, M)
print(res)

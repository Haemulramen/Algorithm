# 로봇 프로젝트
#
# import sys
# input = sys.stdin.readline
#
# def two_pointer(array, target, left, right):
#     start, end = left, right
#     while start < end:
#         if array[start] + array[end] == target:
#             return 1, array[start], array[end]
#         elif array[start] + array[end] < target:
#             end -= 1
#         elif array[start] + array[end] > target:
#             start += 1
#     return 0, None, None
#
# while True:
#     try:
#         x = int(input()) * 10000000
#     except:
#         break
#     n = int(input())
#     data = [int(input()) for _ in range(n)]
#     data.sort()
#     if n < 2:
#         print('danger')
#         continue
#
#     result, num1, num2 = two_pointer(data, x, 0, n - 1)
#     if result:
#         print('yes', num1, num2)
#     else:
#         print('danger')

import sys
input = sys.stdin.readline

while True:
    try:
        x = input().rstrip()
        x = int(x) * 10000000
        n = int(input().rstrip())
        data = [int(input().rstrip()) for _ in range(n)]
        data.sort()
        res = False
        for i in range(n):
            start = i + 1
            end = n - 1
            target = x - data[i]
            while start <= end:
                mid = (start + end) // 2
                if data[mid] == target:
                    res = True
                    break
                elif data[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            if res:
                print('yes', data[i], x - data[i])
                break
        if not res:
            print('danger')
    except:
        break

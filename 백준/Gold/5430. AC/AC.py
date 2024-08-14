# 5430 AC

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = input()
    n = int(input())
    data = input()[1:-2]
    data = data.split(',')
    reverse = False
    err_check = False
    start = 0
    end = n

    for alpha in p:
        if alpha == 'R':
            reverse = not reverse
        if alpha == 'D':
            if reverse:
                end -= 1
            else:
                start += 1
            if start > end:
                err_check = True
    if err_check:
        print('error')
        continue
    data = data[start:end]
    if reverse:
        data.reverse()
    print('[', end='')
    print(','.join(data), end='')
    print(']')
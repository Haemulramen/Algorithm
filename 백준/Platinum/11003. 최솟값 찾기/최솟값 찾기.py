# 11003 최솟값 구하기

import sys
from collections import deque
input = sys.stdin.readline

N, L = map(int, input().split())
data = list(map(int, input().split()))

queue = deque()
for i in range(N):
    if queue and queue[0][1] + L <= i:
        queue.popleft()
    while queue and queue[-1][0] > data[i]:
        queue.pop()

    queue.append((data[i], i))
    print(queue[0][0], end=' ')
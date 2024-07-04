import sys

T = int(sys.stdin.readline())
for _ in range(T):
    cnt = 0
    N = int(sys.stdin.readline())
    result = 0
    data = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    data.sort(key=lambda x:x[0])
    min_value = sys.maxsize
    for person in data:
        if person[1] < min_value:
            result += 1
            min_value = person[1]

    print(result)

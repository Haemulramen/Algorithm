import sys

N, M, B = map(int, input().split())

region = [list(map(int, input().split())) for _ in range(N)]

res = sys.maxsize
final = 0
for height in range(257):
    time = 0
    block = B
    for row in range(N):
        for col in range(M):
            if region[row][col] < height:
                time += height - region[row][col]
                block -= height - region[row][col]
            elif region[row][col] > height:
                time += 2 * (region[row][col] - height)
                block += region[row][col] - height
    if block >= 0 and res >= time:
        res = time
        final = height

print(res, final)

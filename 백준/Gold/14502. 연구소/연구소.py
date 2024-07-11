import copy

N, M = map(int, input().split())
region = [list(map(int, input().split())) for _ in range(N)]
length = N * M
max_value = -1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
location = []
for i in range(N):
    for j in range(M):
        if region[i][j] == 2:
            location.append([i, j])

def is_in_region(x, y):
    if 0 <= x < N and 0 <= y < M:
        return True

def virus():
    virus_queue = copy.deepcopy(location)
    virus_map = copy.deepcopy(region)
    while virus_queue:
        pos = virus_queue.pop(0)
        for i in range(4):
            nx = pos[0] + dx[i]
            ny = pos[1] + dy[i]
            if is_in_region(nx, ny) and virus_map[nx][ny] == 0:
                virus_map[nx][ny] = 2
                virus_queue.append([nx, ny])
    cnt = 0
    for i in range(N):
        for j in range(M):
            if virus_map[i][j] == 0:
                cnt += 1

    return cnt

def check_wall(n):
    global region
    if region[n // M][n % M] != 0:
        return True
    else:
        region[n // M][n % M] = 1

def break_wall(n):
    global region
    region[n // M][n % M] = 0

for i in range(length-2):
    if check_wall(i):
        continue
    for j in range(i+1, length-1):
        if check_wall(j):
            continue
        for k in range(j+1, length):
            if check_wall(k):
                continue
            else:
                temp = virus()
                break_wall(k)
                max_value = max(max_value, temp)
        break_wall(j)
    break_wall(i)

print(max_value)
import sys
sys.setrecursionlimit(2500)

def dfs(x, y, n, m):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False
    if region[x][y] == 1:
        region[x][y] = 0
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny, n, m)
        return True
    return False

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

w, h = map(int, input().split())
while w != 0 and h != 0:
    island = 0
    region = [list(map(int, input().split())) for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if dfs(i, j, h, w):
                island += 1
    print(island)
    w, h = map(int, input().split())

import copy
import sys
sys.setrecursionlimit(2500)

input = sys.stdin.readline
N = int(input().strip())
data = [list(input().strip()) for _ in range(N)]
weak_map = copy.deepcopy(data)
for i in range(N):
    for j in range(N):
        if weak_map[i][j] == 'R':
            weak_map[i][j] = 'G'

def dfs(x, y, region, color):
    if x < 0 or x >= N or y < 0 or y >= N or region[x][y] == 'O':
        return False
    if region[x][y] == color:
        region[x][y] = 'O'
        dfs(x + 1, y, region, color)
        dfs(x, y + 1, region, color)
        dfs(x - 1, y, region, color)
        dfs(x, y - 1, region, color)
        return True
    return False

normal = 0
color_weak = 0

for i in range(N):
    for j in range(N):
        if dfs(i, j, data, data[i][j]):
            normal += 1
        if dfs(i, j, weak_map, weak_map[i][j]):
            color_weak += 1

print(normal, color_weak)

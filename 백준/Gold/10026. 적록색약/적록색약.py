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

def dfs(x, y, color):
    if x < 0 or x >= N or y < 0 or y >= N or data[x][y] == 'O':
        return False
    if data[x][y] == color:
        data[x][y] = 'O'
        dfs(x + 1, y, color)
        dfs(x, y + 1, color)
        dfs(x - 1, y, color)
        dfs(x, y - 1, color)
        return True
    return False

def dfs_color(x, y, color):
    if x < 0 or x >= N or y < 0 or y >= N or weak_map[x][y] == 'O':
        return False
    if weak_map[x][y] == color:
        weak_map[x][y] = 'O'
        dfs_color(x + 1, y, color)
        dfs_color(x, y + 1, color)
        dfs_color(x - 1, y, color)
        dfs_color(x, y - 1, color)
        return True
    return False

normal = 0
color_weak = 0

for i in range(N):
    for j in range(N):
        if dfs(i, j, data[i][j]):
            normal += 1
        if dfs_color(i, j, weak_map[i][j]):
            color_weak += 1

print(normal, color_weak)

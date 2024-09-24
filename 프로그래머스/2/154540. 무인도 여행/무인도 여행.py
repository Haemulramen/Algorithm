import sys
sys.setrecursionlimit(10000)

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, maps, visited):
    cnt = int(maps[x][y])
    visited[x][y] = 'O'
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]):
            continue
        if visited[nx][ny] != 'O' and maps[nx][ny] != 'X':
            cnt += dfs(nx, ny, maps, visited)
    return cnt
            
def solution(maps):
    answer = []
        
    visited = [[] for _ in range(len(maps))]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            visited[i].append(maps[i][j])
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if visited[i][j] != 'O' and maps[i][j] != 'X':
                cnt = dfs(i, j, maps, visited)
                answer.append(cnt)
    
    if len(answer) == 0:
        answer.append(-1)
    else:
        answer.sort()
        
    return answer
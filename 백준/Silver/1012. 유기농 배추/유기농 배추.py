def dfs(x, y, graph):
    if 0 > x or x >= N or 0  > y or y >= M:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x + 1, y, graph)
        dfs(x, y + 1, graph)
        dfs(x - 1, y, graph)
        dfs(x, y - 1, graph)
        return True
    return False

T = int(input())

for _ in range(T):
    N, M, K = map(int, input().split())
    ground = [[0] * M for _ in range(N)]

    for _ in range(K):
        x, y = map(int, input().split())
        ground[x][y] = 1

    worms = 0
    for x in range(N):
        for y in range(M):
            if dfs(x, y, ground):
                worms += 1

    print(worms)

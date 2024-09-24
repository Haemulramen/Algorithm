def shortest_path(n, distance, graph):
    distance[1] = 0
    q = []
    q.append(1)
    while q:
        now = q.pop(0)
        for nxt in graph[now]:
            if distance[now] + 1 < distance[nxt]:
                distance[nxt] = distance[now] + 1
                q.append(nxt)

def solution(n, edge):
    answer = 0
    INF = int(1e9)
    distance = [INF] * (n + 1)
    distance[0] = 0
    graph = [[] for _ in range(len(edge) + 1)]
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])
        continue
    
    shortest_path(n, distance, graph)
    print(distance)
    
    m = max(distance)
    print(m)
    for i in range(n + 1):
        if distance[i] == m:
            answer += 1
        
    return answer
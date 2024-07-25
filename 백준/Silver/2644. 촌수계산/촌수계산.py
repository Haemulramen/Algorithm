from collections import deque

N = int(input())
target = list(map(int, input().split()))
M = int(input())
data = [[0] for _ in range(N + 1)]
check = [0] * (N + 1)

for _ in range(M):
    relation = list(map(int, input().split()))
    data[relation[0]].append(relation[1])
    data[relation[1]].append(relation[0])

queue = deque([(target[0], 0)])
res = -1
while queue and res == -1:
    person = queue.popleft()
    for temp in data[person[0]]:
        if check[temp] == 0:
            check[temp] = 1
            queue.append((temp, person[1] + 1))

        if temp == target[1]:
            res = person[1] + 1
            break

print(res)

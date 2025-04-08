N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]

data.sort(key=lambda x:(x[1], x[0]))

res = 0
t = 0

for i in data:
    if i[0] >= t:
        res += 1
        t = i[1]

print(res)
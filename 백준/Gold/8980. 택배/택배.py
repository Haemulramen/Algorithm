N, C = map(int, input().split())
M = int(input())
data = [tuple(map(int, input().split())) for _ in range(M)]
payload = set()
current = 0
result = 0

data.sort(key=lambda x:(-x[1], -x[0]))
for sending in data:
    arrived = set()
    for load in payload:
        if load[0] == sending[1]:
            arrived.add(load)
            current -= load[2]
    payload -= arrived
    if current < C:
        if C - current >= sending[2]:
            current += sending[2]
            payload.add(sending)
            result += sending[2]
        else:
            adding = (sending[0], sending[1], C - current)
            current = C
            result += adding[2]
            payload.add(adding)

print(result)
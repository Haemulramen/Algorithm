N, L = map(int, input().split())
pipes = list(map(int, input().split()))
pipes.sort()

cur = 0
res = 0

for pipe in pipes:
    if cur < pipe:
        cur = pipe + L - 0.5
        res += 1

print(res)
N, K = map(int, input().split())

cnt = 0
for i in range(N+1):
    for j in range(60):
        for k in range(60):
            if i // 10 == K or i % 10 == K:
                cnt += 1
            elif j // 10 == K or j % 10 == K:
                cnt += 1
            elif k // 10 == K or k % 10 == K:
                cnt += 1

print(cnt)

N, K = map(int, input().split())
data = [0 for i in range(N+1)]
min = 0
cnt = 0
for num in range(2, N + 1):
    if data[num] == 0:
        for i in range(1, N // num + 1):
            if data[num*i] == 0:
                data[num*i] = 1
                cnt += 1
            if cnt == K:
                min = num * i
                break
    if min != 0:
        break

print(min)

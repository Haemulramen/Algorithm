N = int(input())
data = [0] * 10001

for _ in range(N):
    num = int(input())
    data[num] += 1

for i in range(1, 10001):
    for j in range(data[i]):
        print(i)

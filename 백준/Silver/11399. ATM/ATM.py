N = int(input())
times = list(map(int, input().split()))
times.sort()
result = 0
for i in range(1, len(times) + 1):
    result += times[-i] * i

print(result)
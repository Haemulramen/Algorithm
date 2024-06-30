kg1 = 5
kg2 = 3
total = 0

N = int(input())

div = N // kg1
rem = N % kg1

for i in range(div, -1, -1):
    if rem % kg2 == 0:
        total = i + rem // kg2
        break
    rem += kg1

if total == 0:
    print(-1)
else:
    print(total)

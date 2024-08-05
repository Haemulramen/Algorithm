import sys

N = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
sort_data = data.copy()
sort_data = list(set(sort_data))
sort_data.sort()

res = dict()
for i in range(len(sort_data)):
    res[str(sort_data[i])] = i

for i in data:
    print(res[str(i)], end=' ')

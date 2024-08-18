import sys
input = sys.stdin.readline

ln1 = input().rstrip()
ln2 = input().rstrip()
mapping = [[0] * (len(ln2) + 1) for _ in range(len(ln1) + 1)]

for i in range(len(ln1) + 1):
    for j in range(len(ln2) + 1):
        if i == 0 or j == 0:
            mapping[i][j] = 0
        elif ln1[i - 1] == ln2[j - 1]:
            mapping[i][j] = mapping[i - 1][j - 1] + 1
        else:
            mapping[i][j] = max(mapping[i - 1][j], mapping[i][j - 1])

print(max(mapping[-1]))

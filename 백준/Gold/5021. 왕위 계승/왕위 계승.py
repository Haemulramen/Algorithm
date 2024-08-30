# 5021 왕위 계승

import sys
input = sys.stdin.readline
INF = int(1e9)

def blood_count(family, blood, person):
    if person not in family.keys():
        return 0
    if blood[person] != 0:
        return blood[person]
    parA = blood_count(family, blood, family[person][0])
    parB = blood_count(family, blood, family[person][1])
    blood[person] = (parA + parB) / 2
    return blood[person]

N, M = map(int, input().split())
king = input().rstrip()
family = dict()
family[king] = 1
blood = dict()
blood[king] = 1

for _ in range(N):
    a, b, c = input().split()
    family[a] = [b, c]
    blood[a] = 0

temp = (0, 0)
for _ in range(M):
    candidate = input().rstrip()
    candidate = (candidate, blood_count(family, blood, candidate))
    if temp[1] < candidate[1]:
        temp = candidate

print(temp[0])
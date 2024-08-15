# 2839 설탕 배달

N = int(input())
# div = N // 5
# rem = N % 5
# temp = -1
#
# while div >= 0:
#     if rem % 3 == 0:
#         temp = div + rem // 3
#         break
#     else:
#         div -= 1
#         rem += 5
#
# print(temp)

weights = [5001] * 5001
weights[3] = 1
weights[5] = 1

for i in range(6, N + 1):
    weights[i] = min(weights[i - 3] + 1, weights[i - 5] + 1)

if weights[N] >= 5001:
    print(-1)
else:
    print(weights[N])
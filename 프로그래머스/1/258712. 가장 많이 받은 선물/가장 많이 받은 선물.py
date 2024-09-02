def solution(friends, gifts):
    answer = 0
    data = [[0] * (len(friends)) for _ in range(len(friends))]
    gift_point = [0] * len(friends)
    for gift in gifts:
        gift = gift.split()
        giver = friends.index(gift[0])
        getter = friends.index(gift[1])
        data[giver][getter] += 1
        gift_point[giver] -= 1
        gift_point[getter] += 1
    
    res = [0] * len(friends)
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i == j:
                continue
            if data[i][j] > data[j][i]:
                res[i] += 1
            elif data[i][j] == data[j][i] and gift_point[i] < gift_point[j]:
                    res[i] += 1
    
    answer = max(res)
    return answer
def solution(N, stages):
    answer = []
    size = len(stages)
    stop = [0] * (N + 2)
    rate = []
    for stage in stages:
        stop[stage] += 1

    remain = stop[0]
    for i in range(1, N + 1):
        if size <= remain:
            rate.append((0, i))
            continue
        temp = stop[i] / (size - remain)
        remain += stop[i]
        rate.append((temp, i))
    
    rate.sort(key=lambda x:(x[0],-x[1]), reverse=True)
    print(rate)
    for i in rate:
        answer.append(i[1])
        
    return answer
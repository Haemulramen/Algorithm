def binary_search(n, times):
    left = 1
    right = max(times) * n
    res = -1
    
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for time in times:
            cnt += mid // time
        if cnt >= n:
            right = mid - 1
            res = mid
        else:
            left = mid + 1
    return res

def solution(n, times):
    answer = 0
    answer = binary_search(n, times)
    
    return answer
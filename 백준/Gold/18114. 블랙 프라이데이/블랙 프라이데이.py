N, C = map(int, input().split())
w = list(map(int, input().split()))
w.sort()

def binary_search(first, last, target):
    while first < last:
        mid = (first + last) // 2
        if w[mid] == target:
            return True
        elif w[mid] > target:
            last = mid - 1
        else:
            first = mid + 1

def check(n, c):
    if c in w:
        return True

    start, end = 0, len(w) - 1
    while start < end:
        temp = w[start] + w[end]
        if temp > c:
            end -= 1
        elif temp == c:
            return True
        else:
            diff = c - temp
            if w[start] != diff and w[end] != diff and binary_search(start, end, diff):
                return True
            start += 1

if check(N, C):
    print(1)
else:
    print(0)

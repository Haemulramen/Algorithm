N = int(input())
numbers = list(map(int, input().split()))

numbers.sort()

length = len(numbers)
if length % 2 == 0:
    print(numbers[length // 2 - 1])
else:
    print(numbers[length // 2])

N = int(input())

deque = []
for _ in range(N):
    user_input = input().split()
    if user_input[0] == "push_front":
        deque.insert(0, user_input[1])
    elif user_input[0] == "push_back":
        deque.append(user_input[1])
    elif user_input[0] == "pop_front":
        if len(deque) == 0: print(-1)
        else: print(deque.pop(0))
    elif user_input[0] == "pop_back":
        if len(deque) == 0: print(-1)
        else: print(deque.pop(-1))
    elif user_input[0] == "size":
        print(len(deque))
    elif user_input[0] == "empty":
        if len(deque) == 0: print(1)
        else: print(0)
    elif user_input[0] == "front":
        if len(deque) == 0: print(-1)
        else: print(deque[0])
    elif user_input[0] == "back":
        if len(deque) == 0: print(-1)
        else: print(deque[-1])

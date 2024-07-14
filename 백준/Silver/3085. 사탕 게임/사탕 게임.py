N = int(input())
data = [list(input()) for _ in range(N)]

def check_data():
    cnt = 0
    max_value = 0
    for row in data:
        temp = 0
        for idx in range(N):
            if row[idx] == temp:
                cnt += 1
            else:
                max_value = max(max_value, cnt)
                temp = row[idx]
                cnt = 1
        max_value = max(max_value, cnt)

    cnt = 0
    for col in range(N):
        temp = 0
        for row in range(N):
            if data[row][col] == temp:
                cnt += 1
            else:
                max_value = max(max_value, cnt)
                temp = data[row][col]
                cnt = 1
        max_value = max(max_value, cnt)
    return max_value

def change_in_col(x, y):
    global data
    data[x][y], data[x][y+1] = data[x][y+1], data[x][y]
    value = check_data()
    data[x][y], data[x][y+1] = data[x][y+1], data[x][y]
    return value

def change_in_row(x, y):
    global data
    data[x][y], data[x+1][y] = data[x+1][y], data[x][y]
    value = check_data()
    data[x][y], data[x+1][y] = data[x+1][y], data[x][y]
    return value

res = 0
for i in range(N):
    for j in range(N-1):
        res = max(res, change_in_col(i, j), change_in_row(j, i))

print(res)

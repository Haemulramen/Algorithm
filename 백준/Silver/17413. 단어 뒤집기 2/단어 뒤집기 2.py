line = list(input())

bracket = False
res = []
temp = []
for char in line:
    if char == '<':
        bracket = True
        if temp is not None:
            temp.reverse()
            res += temp
            temp.clear()
        res += '<'
        continue
    elif char == '>':
        bracket = False
        res += '>'
        continue
    elif char == ' ':
        if temp is not None:
            temp.reverse()
            res += temp
            temp.clear()
            res += ' '
            continue
    if bracket:
        res += char
    else:
        temp += char

if temp is not None:
    temp.reverse()
    res += temp

print(str(''.join(res)))

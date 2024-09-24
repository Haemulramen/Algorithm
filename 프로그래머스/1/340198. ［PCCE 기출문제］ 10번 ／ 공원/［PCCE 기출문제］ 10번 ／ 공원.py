def solution(mats, park):
    answer = 0
    mats.sort(reverse=True)
    for mat in mats:
        if mat > len(park) or mat > len(park[0]):
            continue
        for i in range(len(park) - mat + 1):
            for j in range(len(park[0]) - mat + 1):
                if park[i][j] != '-1':
                    continue
                check = True
                for ii in range(i, i + mat):
                    for jj in range(j, j + mat):
                        if park[ii][jj] != '-1':
                            check = False
                            break
                    if not check:
                        break
                if check:
                    return mat
    return -1
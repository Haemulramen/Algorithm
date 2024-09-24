def get_result(survey, choices, data):
    for i in range(len(survey)):
        ask = survey[i]
        ans = choices[i] - 4
        if ans >= 0:
            # temp = data.get(ask[1])
            # temp += ans
            data[ask[1]] += ans
        else:
            data[ask[0]] -= ans
            # temp = data.get(ask[0])
            # temp -= ans
    

def make_ans(data):
    answer = ""
    
    if data['R'] >= data['T']:
        answer += 'R'
    else:
        answer += 'T'
        
    if data['C'] >= data['F']:
        answer += 'C'
    else:
        answer += 'F'
        
    if data['J'] >= data['M']:
        answer += 'J'
    else:
        answer += 'M'
        
    if data['A'] >= data['N']:
        answer += 'A'
    else:
        answer += 'N'
    
    return answer

def solution(survey, choices):
    answer = ''
    data = dict()
    data['R'] = 0
    data['T'] = 0
    data['C'] = 0
    data['F'] = 0
    data['J'] = 0
    data['M'] = 0
    data['A'] = 0
    data['N'] = 0
    
    get_result(survey, choices, data)
    answer = make_ans(data)
    
    return answer
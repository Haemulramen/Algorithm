def time_to_sec(time):
    split = time.split(':')
    m, s = int(split[0]), int(split[1])
    
    sec = 60 * m + s
    return sec

def sec_to_time(sec):
    m = sec // 60
    s = sec % 60
    
    return f'{m:02}:{s:02}'

def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    video_len = time_to_sec(video_len)
    pos = time_to_sec(pos)
    op_start = time_to_sec(op_start)
    op_end = time_to_sec(op_end)
    
    if op_start <= pos <= op_end:
        pos = op_end
    
    for command in commands:
        if command == 'next':
            pos += 10
        elif command == 'prev':
            pos -= 10
            if pos < 0:
                pos = 0
        
        if op_start <= pos <= op_end:
            pos = op_end
        
        if pos > video_len:
            pos = video_len
    
    answer = sec_to_time(pos)
        
    return answer
word = list(input())
res_words = []

for i in range(1, len(word)-1):
    for j in range(i+1, len(word)):
        part1 = word[i-1::-1]
        part2 = word[j-1:i-1:-1]
        part3 = word[len(word)-1:j-1:-1]

        # part1.reverse()
        # part2.reverse()
        # part3.reverse()

        res_words.append(''.join(part1+part2+part3))

print(min(res_words))
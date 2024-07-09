word = list(input())
res_words = []

for i in range(1, len(word)-1):
    for j in range(i+1, len(word)):
        part1 = word[:i]
        part2 = word[i:j]
        part3 = word[j:]

        part1.reverse()
        part2.reverse()
        part3.reverse()

        res_words.append(''.join(part1+part2+part3))

print(min(res_words))
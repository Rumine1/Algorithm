import sys
input = sys.stdin.readline


def check(exam):
    N = len(exam)
    answer = 1
    for i in range(N):
        count = 1
        for j in range(1, N):
            if exam[i][j] == exam[i][j-1]:
                count += 1
            else:
                count = 1

            if answer < count:
                answer = count

        count = 1
        for j in range(1, N):
            if exam[j][i] == exam[j-1][i]:
                count += 1
            else:
                count = 1

            if answer < count:
                answer = count
    return answer


N = int(input())
exam = [list(input()) for _ in range(N)]
answer = 0

for i in range(N):
    for j in range(N):
        if j+1 < N:
            exam[i][j], exam[i][j+1] = exam[i][j+1], exam[i][j]

            temp = check(exam)

            if temp > answer:
                answer = temp

            exam[i][j], exam[i][j+1] = exam[i][j+1], exam[i][j]

        if i+1 < N:
            exam[i][j], exam[i+1][j] = exam[i+1][j], exam[i][j]
            temp = check(exam)

            if temp > answer:
                answer = temp

            exam[i][j], exam[i+1][j] = exam[i+1][j], exam[i][j]

print(answer)

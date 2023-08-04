import sys
input = sys.stdin.readline


def calc(i, step):
    global result
    result.append(exam[i])
    if step == M:
        print(*result, sep=" ")
        return
    previous = 0
    for j in range(len(exam)):
        if previous != exam[j] and visit[j] == False:
            visit[j] = True
            previous = exam[j]
            calc(j, step+1)
            result.pop()
            visit[j] = False


N, M = map(int, input().split())

exam = sorted(list(map(int, input().split())))
visit = [False for _ in range(N)]
result = []

for i in range(len(exam)):
    if exam[i] != exam[i-1]:
        visit[i] = True
        calc(i, 1)
        visit[i] = False
        result.clear()
    elif i == 0:
        visit[i] = True
        calc(i, 1)
        visit[i] = False
        result.clear()

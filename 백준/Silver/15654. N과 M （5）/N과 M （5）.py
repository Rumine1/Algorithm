import sys
input = sys.stdin.readline


def calc(i, step):
    global result
    result.append(exam[i])
    if step == M:
        print(*result, sep=" ")
        return

    for j in range(N):
        if visit[j] == False:
            visit[j] = True
            calc(j, step+1)
            result.pop()
            visit[j] = False


N, M = map(int, input().split())

exam = sorted(list(set(list(map(int, input().split())))))
visit = [False for _ in range(N)]
result = []

for i in range(N):
    visit[i] = True
    calc(i, 1)
    visit[i] = False
    result.clear()

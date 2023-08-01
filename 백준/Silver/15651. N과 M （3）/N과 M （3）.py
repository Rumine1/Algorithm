import sys
input = sys.stdin.readline


def calc(i, step):
    global result
    result.append(exam[i])
    if step == M:
        print(*result, sep=" ")
        return

    for j in range(N):
        calc(j, step+1)
        result.pop()


N, M = map(int, input().split())

exam = [x for x in range(1, N+1)]
result = []

for i in range(N):
    calc(i, 1)
    result.clear()

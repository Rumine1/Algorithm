import sys
input = sys.stdin.readline


def calc(i, step):
    global result
    result.append(exam[i])
    if step == M:
        print(*result, sep=" ")
        return

    for j in range(N):
        if result[-1] < exam[j]:
            calc(j, step+1)
            result.pop()


N, M = map(int, input().split())

exam = sorted(list(set(list(map(int, input().split())))))
result = []

for i in range(N):
    calc(i, 1)
    result.clear()

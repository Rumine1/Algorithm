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
        if previous != exam[j]:
            previous = exam[j]
            calc(j, step+1)
            result.pop()

N, M = map(int, input().split())

exam = sorted(list(map(int, input().split())))
result = []

for i in range(len(exam)):
    if exam[i] != exam[i-1]:
        calc(i, 1)
        result.clear()
    elif i == 0:
        calc(i, 1)
        result.clear()

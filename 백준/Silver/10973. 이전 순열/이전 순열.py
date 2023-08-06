import sys
input = sys.stdin.readline

N = int(input())
exam = list(map(int, input().split()))

for i in range(N-1, 0, -1):
    if exam[i] < exam[i-1]:
        for j in range(N-1, i-1, -1):
            if exam[i-1] > exam[j]:
                exam[i-1], exam[j] = exam[j], exam[i-1]
                exam = exam[:i] + sorted(exam[i:], reverse=True)
                print(*exam)
                exit()

print(-1)

import sys
input = sys.stdin.readline


def dfs(idx):
    global result, visit

    if idx == N:
        print(*result)

        return

    for i in range(N):
        if visit[i] == False:
            visit[i] = True
            result.append(lst[i])
            dfs(idx+1)
            result.pop()
            visit[i] = False


N = int(input())
exam = [x for x in range(1, N+1)]
lst = [x for x in range(1, N+1)]
result = []
visit = [False for _ in range(N)]
check = False

dfs(0)

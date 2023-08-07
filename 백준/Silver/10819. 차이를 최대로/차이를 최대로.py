import sys
input = sys.stdin.readline


def dfs(idx):
    global visit, result

    if idx == N:
        temp = 0
        for i in range(1, N):
            temp += abs(temp_lst[i]-temp_lst[i-1])
        result = max(result, temp)
        return

    for i in range(N):
        if visit[i] == False:
            visit[i] = True
            temp_lst.append(A[i])
            dfs(idx+1)
            temp_lst.pop()
            visit[i] = False


N = int(input())
A = list(map(int, input().split()))

visit = [False for _ in range(N)]
temp_lst = []
result = 0

dfs(0)
print(result)

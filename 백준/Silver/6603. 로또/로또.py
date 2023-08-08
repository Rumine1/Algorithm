import sys
input = sys.stdin.readline


def dfs(idx, start):
    global visited

    if idx == 6:
        print(*result)
        return

    for i in range(start, N):
        if visited[i] == False:
            visited[i] = True
            result.append(testCase[i])
            dfs(idx+1, i)
            result.pop()
            visited[i] = False


while True:
    testCase = list(map(int, input().split()))

    if testCase[0] == 0:
        break

    N = testCase[0]
    testCase = testCase[1:]
    visited = [False for _ in range(N)]
    result = []

    dfs(0, 0)
    print()

import sys
input = sys.stdin.readline


def dfs(i, j, step, total):
    global result

    if total + max_value*(4-step) <= result:
        return

    if step == 4:
        result = max(total, result)
        return

    for add_i, add_j in move:
        recent_i = i + add_i
        recent_j = j + add_j

        if 0 <= recent_i < N and 0 <= recent_j < M and not visited[recent_i][recent_j]:

            if step == 2:
                visited[recent_i][recent_j] = True
                dfs(i, j, step+1, total+board[recent_i][recent_j])
                visited[recent_i][recent_j] = False

            visited[recent_i][recent_j] = True
            dfs(recent_i, recent_j, step+1, total+board[recent_i][recent_j])
            visited[recent_i][recent_j] = False


N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

max_value = max(map(max, board))
visited = [[False for _ in range(M)] for _ in range(N)]
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]
result = 0

for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, 1, board[i][j])
        visited[i][j] = False

print(result)

import sys
input = sys.stdin.readline

N = int(input())
color = [list(map(int, input().split())) for _ in range(N)]
minimum = sys.maxsize

for k in range(3):
    dp = [[1001 for _ in range(3)] for _ in range(N)]
    dp[0][k] = color[0][k]
    for i in range(1, N):
        dp[i][0] = color[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = color[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = color[i][2] + min(dp[i-1][0], dp[i-1][1])

    for j in range(3):
        if j != k:
            minimum = min(minimum, dp[N-1][j])

print(minimum)

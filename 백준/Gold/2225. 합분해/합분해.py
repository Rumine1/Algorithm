a, b = map(int, input().split())

dp = [[0 for _ in range(201)] for _ in range(201)]

for i in range(1, 201):
    dp[i][1] = 1
    dp[1][i] = i

for i in range(2, a+1):
    for j in range(2, b+1):
        dp[i][j] = dp[i][j-1]+dp[i-1][j]

print(dp[a][b] % 1000000000)

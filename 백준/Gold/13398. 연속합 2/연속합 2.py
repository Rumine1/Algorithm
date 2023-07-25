N = int(input())
exam = list(map(int, input().split()))

dp = [[x for x in exam] for _ in range(2)]

for i in range(1, N):
    dp[0][i] = max(dp[0][i-1] + exam[i],  dp[0][i])
    dp[1][i] = max(dp[0][i-1], dp[1][i-1]+exam[i], )

print(max(map(max, dp)))

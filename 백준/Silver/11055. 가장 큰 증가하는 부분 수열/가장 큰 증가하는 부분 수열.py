N = int(input())
A = list(map(int, input().split()))
dp = [0 for _ in range(N)]
dp[0] = A[0]

for i in range(1, N):
    dp[i] = A[i]
    for j in range(i):
        if A[i] > A[j] and dp[i] < dp[j] + A[i]:
            dp[i] = dp[j] + A[i]

print(max(dp))

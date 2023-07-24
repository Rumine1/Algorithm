N = int(input())
A = list(map(int, input().split()))
dp = [1 for _ in range(N)]
dp_revese = [1 for _ in range(N)]

for i in range(1, N):
    for j in range(i):
        if A[i] > A[j] and dp[i] < dp[j] + 1:
            dp[i] = dp[j] + 1

A.reverse()
for i in range(1, N):
    for j in range(i):
        if A[i] > A[j] and dp_revese[i] < dp_revese[j] + 1:
            dp_revese[i] = dp_revese[j] + 1

dp_revese.reverse()

print(max([dp[i] + dp_revese[i] for i in range(len(dp))])-1)

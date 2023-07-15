import sys
input = sys.stdin.readline

num = int(input())
exam = list(map(int, input().split()))
dp = [1 for _ in range(num)]

for i in range(num):
    for j in range(i):
        if exam[i] > exam[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))

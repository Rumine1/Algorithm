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

dp.reverse()
exam.reverse()
result = []
check = 0
for i in range(max(dp), 0, -1):
    temp = dp.index(i, check)
    result.append(exam[temp])
    check = temp
result.reverse()
print(*result, sep=" ")

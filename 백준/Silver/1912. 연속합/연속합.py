import sys
input = sys.stdin.readline

length = int(input())
exam = list(map(int, input().split()))

dp = [exam[0]]

for i in range(1, length):
    dp.append(max(dp[-1]+exam[i], exam[i]))

print(max(dp))

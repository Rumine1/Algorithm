n = int(input())
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    temp = []
    for j in range(1, int(i**(0.5))+1):
        if i-j**2 > 0:
            temp.append(dp[i-j**2] + 1)
        elif i-j**2 == 0:
            temp.append(1)
    dp[i] = min(temp)

print(dp[n])

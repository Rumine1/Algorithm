import sys
input = sys.stdin.readline

target = int(input())
num = int(input())
lose = list(map(int, input().split()))

mini = abs(target-100)

for nums in range(1000001):
    nums = str(nums)

    for j in range(len(nums)):
        if int(nums[j]) in lose:
            break
        elif j == len(nums)-1:
            mini = min(mini, abs(int(nums)-target)+len(nums))

print(mini)

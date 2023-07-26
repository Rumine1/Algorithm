height = [int(input()) for _ in range(9)]

for i in range(8):
    entire = sum(height)
    entire -= height[i]
    for j in range(i+1, 9):
        entire -= height[j]
        if entire == 100:
            n1 = height[i]
            n2 = height[j]
            height.remove(n1)
            height.remove(n2)
            break
        else:
            entire += height[j]
    if len(height) == 7:
        break

height.sort()
print(*height, sep="\n")

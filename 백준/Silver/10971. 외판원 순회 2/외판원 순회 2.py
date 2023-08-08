import sys
input = sys.stdin.readline


def dfs(start, now, visited, temp_distance):
    global min_distance

    if len(visited) == N:
        if W[now][start] != 0:
            min_distance = min(min_distance, temp_distance + W[now][start])
        return

    for next in range(N):
        if W[now][next] != 0 and next != start and next not in visited and temp_distance < min_distance:
            visited.append(next)
            dfs(start, next, visited, temp_distance + W[now][next])
            visited.pop()


N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]
min_distance = 1000000 * N + 1
temp_distance = 0

for i in range(N):
    dfs(i, i, [i], temp_distance)

print(min_distance)

import sys
input = sys.stdin.readline


def calc(length):
    global N
    if length == 1:
        if len(N) == 1:
            return int(N[(len(N)-length):])
        return 9

    return length * 9 * (10 ** (length-1)) + calc(length-1)


N = int(input())
N = str(N)
length = len(N)

if length == 1:
    print(calc(length))
else:
    print(length * ((int(N)-(10**(length-1))) + 1) + calc(length-1))
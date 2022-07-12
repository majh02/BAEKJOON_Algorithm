import sys

x, y, w, h = map(int, sys.stdin.readline().split())

Min = min(x, w-x)
Min = min(Min, min(y, h-y))
print(Min)
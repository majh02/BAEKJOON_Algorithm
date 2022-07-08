import sys

N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    x, y = map(int, sys.stdin.readline().split())
    arr.append([x,y])

arr.sort()
for i in arr:
    x = i[0]
    y = i[1]
    print(str(x)+" "+str(y))


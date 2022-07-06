import sys

N = int(sys.stdin.readline())
arr = [10001 for i in range(10000001)]
for i in range(N):
    arr[i] = int(sys.stdin.readline())

arr.sort()
for i in range(N):
    print(arr[i])
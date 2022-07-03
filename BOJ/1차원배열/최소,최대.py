import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

arr.sort()

print(str(arr[0])+" "+str(arr[N-1]))
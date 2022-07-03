import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

M = arr[N-1]
sum = 0
for i in range(N):
    arr[i] = arr[i]/M*100
    sum += arr[i]

print(sum/N)

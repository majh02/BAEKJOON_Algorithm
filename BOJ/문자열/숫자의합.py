import sys

N = int(sys.stdin.readline())
tmp = sys.stdin.readline()

arr = [0 for i in range(N)]
sum = 0
for i in range(0, N):
    arr[i] = int(tmp[i:i+1])
    sum+=arr[i]

print(sum)
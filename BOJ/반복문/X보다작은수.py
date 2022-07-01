import sys

N, X = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

result = ""
for i in range(0, N):
    if(A[i] < X) : result+=(str(A[i])+" ")

print(result)

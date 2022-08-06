import sys

def P(N):
    if arr[N]!=0:
        return arr[N]
    arr[N] = P(N-3)+P(N-2)
    return arr[N]
    
T = int(sys.stdin.readline())
arr = [0]*101
arr[1] = 1; arr[2] = 1; arr[3] = 1

for i in range(T):
    N = int(sys.stdin.readline())
    print(P(N))
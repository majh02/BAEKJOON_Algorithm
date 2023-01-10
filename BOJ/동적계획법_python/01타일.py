# 1904번_01타일

import sys

N = int(sys.stdin.readline())
if(N==1): print(1)
elif(N==2): print(2)
else:
    arr = [0]*(N+1)
    arr[1] = 1
    arr[2] = 2
    for i in range(3, N+1):
        arr[i] = (arr[i-1]+arr[i-2])%15746

    print(arr[N])

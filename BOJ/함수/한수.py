import sys

def hansu(n):
    arr = list(map(int, str(n)))
    for i in range(arr.__len__()):
        if(i+2>=arr.__len__()):
            return 1
        if(arr[i]-arr[i+1] == arr[i+1]-arr[i+2]): continue
        else: return 0

N = int(sys.stdin.readline())

if(N<=100): count = N
if(N>=100):
    count = 99
    for i in range(100, N+1):
        count+=hansu(i)

print(count)
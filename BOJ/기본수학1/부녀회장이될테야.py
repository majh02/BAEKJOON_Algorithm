import sys

T = int(sys.stdin.readline())
result = ""

for i in range(T):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    room = [[0 for i in range(n+1)] for j in range(k+1)]
    
    for i in range(k+1):
        for j in range(n+1):
            if(i==0): room[i][j] = j
            else:
                sum=0
                for h in range(j+1):
                    sum+=room[i-1][h]
                room[i][j] = sum
    
    result += str(room[k][n])+"\n"

print(result)
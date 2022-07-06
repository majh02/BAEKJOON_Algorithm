import sys

X = int(sys.stdin.readline())

n = 1
index = 0
up = 0
down = 0
while True:
    if(n*(n+1)/2 > X):
        index = int(n*(n-1)/2)+1
        if(n%2==0):
            up = 1
            down = n
            for i in range(index, X):
                up+=1
                down-=1
        else:
            up = n
            down = 1
            for i in range(index, X):
                up-=1
                down+=1
        break
    elif(n*(n+1)/2 == X):
        if(n%2==0):
            up = n
            down = 1
        else:
            up = 1
            down = n
        break
    n+=1

print(str(up)+"/"+str(down))
import re
import sys

K = int(sys.stdin.readline())
x = 0; y = 0
arr = list()
arr.append([x, y])
while True:
    dir, len = map(int, sys.stdin.readline().split())
    if(dir==1): x+=len
    elif(dir==2): x-=len
    elif(dir==3): y-=len
    else: y+=len
    
    if(x==0 and y==0): break
    arr.append([x, y])

print(arr)
length = arr.__len__()
i = 0
result = 0
while i < length-1:
    x1 = arr[i][0]; y1 = arr[i][1]
    for j in range(i+1, length):
        x2 = arr[j][0]; y2 = arr[j][1]
        w = abs(x2-x1)
        h = abs(y2-y1)
        if(w==0  or h==0): continue
        else:
            result+=w*h
            # print(str(i)+" "+str(j)+" "+str(w*h))
            i = j+1
            break

print(result*K)
import sys

N = sys.stdin.readline()
origin_N = int(N)
if(origin_N<10) : N = "0"+N

count = 0
while True:
    new = int(N[1])*10 +(int(N[0])+int(N[1]))%10
    count+=1
    if(new == origin_N) :
        print(count)
        break
    if(new<10) : N = "0"+str(new)
    else : N = str(new)
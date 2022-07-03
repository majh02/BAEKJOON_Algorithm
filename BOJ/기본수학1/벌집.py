import sys

N = int(sys.stdin.readline())

num = 1
count = 0
while True:
    count +=1
    if(num<N):
        num+=6*count
    else: break
print(count)
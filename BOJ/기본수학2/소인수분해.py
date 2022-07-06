import sys

N = int(sys.stdin.readline())

result = ""
while N>0:
    if(N==1): break
    for i in range(2, N+1):
        if(N%i==0):
            result+=str(i)+"\n"
            N = int(N/i)
            break

print(result)
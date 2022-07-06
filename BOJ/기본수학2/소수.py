import sys

def isPrime(num):
    if(num==0 or num==1): return False
    for i in range(2, int(num/2)+1):
        if(num%i==0): return False
    return True

M = int(sys.stdin.readline())
N = int(sys.stdin.readline())

sum = 0
min = 0
for i in range(M, N+1):
    if(isPrime(i)==True):
        sum+=i
        if(min==0): min = i

if(min==0 and sum==0): print(-1)
else:
    print(sum)
    print(min)

import sys
import math

def isPrime(num):
    if(num==0 or num==1): return False
    for i in range(2, int(math.sqrt(num))+1):
        if(num%i==0): return False
    return True

M, N = map(int, sys.stdin.readline().split())

result = ""
for i in range(M, N+1):
    if(isPrime(i)==True):
        result+=str(i)+"\n"

print(result)

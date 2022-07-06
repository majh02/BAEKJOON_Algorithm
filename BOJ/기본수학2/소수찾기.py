import sys

def isPrime(num, n):
    if(num==0 or num==1): return False
    elif(n>int(num/2)): return True
    elif(num%n==0): return False

    return isPrime(num, n+1)


N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

count = 0
for i in range(N):
    if(isPrime(arr[i], 2)==True): count+=1

print(count)
import sys
import math

def isPrime(num):
    if(num==0 or num==1): return False
    for i in range(2, int(math.sqrt(num))+1):
        if(num%i==0): return False
    return True

def save_prime(prime_list:list, n):
    for i in range(2, n+1):
        if(prime_list.__contains__(i)): continue
        if(dp[i]==False): continue
        elif(isPrime(i)):
            prime_list.append(i)
            j=2
            while i*j <= n:
                dp[i*j] = False
                j+=1

T = int(sys.stdin.readline())
dp = [True]*10000
prime_list = []

for t in range(T):
    n = int(sys.stdin.readline())
    save_prime(prime_list, n)
    X = 0; Y = 0
    for i in prime_list:
        if(i>int(n/2)): break
        x = i
        y = n-x
        if(prime_list.__contains__(y)):
            X = x; Y = y
    
    print(str(X)+" "+str(Y))
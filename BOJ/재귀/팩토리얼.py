import sys

def factorial(n):
    if(n==0): return 0
    if(n==1): return 1
    return n*factorial(n-1)

N = int(sys.stdin.readline())

print(factorial(N))

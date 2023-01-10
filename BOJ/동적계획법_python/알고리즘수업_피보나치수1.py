# 24416번_알고리즘 수업 - 피보나치수1

import sys

global count1
count1 = 0
def fib(n):
    global count1
    if(n==1 or n==2):
        count1+=1
        return 1
    else:
        return fib(n-1) + fib(n-2)

def fibonacci(n, f, count2):
    f[1] = 1
    f[2] = 1
    for i in range(3, n+1):
        count2+=1
        f[i] = f[i-1] + f[i-2]
    
    return (f[n], count2)

n = int(sys.stdin.readline())
f = [0]*(n+1)

fib1 = fib(n)
fib2, count2 = fibonacci(n, f, 0)
print(count1, end = " ")
print(count2)

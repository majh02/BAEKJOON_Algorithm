import sys

from cv2 import RETR_CCOMP

def fibo(n):
    if(n==0): return 0
    elif(n==1): return 1
    return fibo(n-1)+fibo(n-2)

n = int(sys.stdin.readline())
print(fibo(n))
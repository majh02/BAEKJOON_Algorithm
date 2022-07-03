import sys

A, B = map(int, sys.stdin.readline().split())

A2 = 0; B2 = 0
while A>0 :
    A2 = A2*10 + A%10
    A = int(A/10)

while B>0 :
    B2 = B2*10 + B%10
    B = int(B/10)

if(A2>B2): print(A2)
else: print(B2)


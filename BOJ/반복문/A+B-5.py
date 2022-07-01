import sys

result = ""
while True:
    A, B = map(int, sys.stdin.readline().split())
    if(A==0 and B==0) : break
    sum = A+B
    result+=str(sum)+"\n"

print(result)
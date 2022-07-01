import sys

T = int(sys.stdin.readline())
result = ""
for i in range(1, T+1):
    a, b = map(int, sys.stdin.readline().split())
    sum = a+b
    result+=("Case #"+str(i)+": "+str(sum)+"\n")

print(result)
import sys

T = int(sys.stdin.readline())
result = ""
for i in range(0, T):
    a, b = map(int, sys.stdin.readline().split())
    sum = a+b
    result+=(str(sum)+"\n")

print(result)
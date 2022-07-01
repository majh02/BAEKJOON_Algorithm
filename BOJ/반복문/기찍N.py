import sys

N = int(sys.stdin.readline())
result = ""

for i in range(0, N):
    sum = N-i
    result+=(str(sum)+"\n")

print(result)
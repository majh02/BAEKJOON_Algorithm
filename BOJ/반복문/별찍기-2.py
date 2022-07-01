import sys

N = int(sys.stdin.readline())
result = ""

for i in range(1, N+1):
    for j in range(0, N-i):
        result+=" "
    for j in range(0, i):
        result+="*"
    result+="\n"

print(result)
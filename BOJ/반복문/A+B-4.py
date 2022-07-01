import sys

result = ""
while True:
    try:
        A, B = map(int, sys.stdin.readline().split())
        sum = A+B
        result+=(str(sum)+"\n")
    except:
        break

print(result)
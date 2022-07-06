import sys

T = int(sys.stdin.readline())
result = ""

for i in range(T):
    H, W, N = map(int, sys.stdin.readline().split())
    width = int(N/H)+1
    height = N-(width-1)*H
    if(N%H==0):
        width -= 1
        height = H

    if(width<10): result += str(height)+"0"+str(width)+"\n"
    else: result += str(height)+str(width)+"\n"

print(result)
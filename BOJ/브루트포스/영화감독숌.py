import sys

N = int(sys.stdin.readline())

num = 666
pre_num = 666
for i in range(2, N+1):
    for j in range(int(pre_num)+1, sys.maxsize):
        num = str(j)
        if(num.__contains__("666")):
            pre_num = num
            break

print(num)
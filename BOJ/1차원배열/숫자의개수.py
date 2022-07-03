import sys

A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())

result = A*B*C
arr = [0,0,0,0,0,0,0,0,0,0]
while result>0 :
    index = int(result % 10)
    arr[index] += 1
    result = int(result/10)

for i in range(10):
    print(arr[i])

import sys

C = int(sys.stdin.readline())
result = ""

for c in range(C):
    arr = list(map(int, sys.stdin.readline().split()))
    n = arr[0]
    avg = 0
    for i in range(1, arr[0]+1):
        avg+=arr[i]
    avg /= n
    
    arr[0] = 0
    arr.sort()
    
    count = 0
    for i in range(1, n+1):
        if(arr[i]>avg):
            count = n+1-i
            break

    tmp = round(count/n*100, 3)
    num = "{:.3f}".format(tmp)
    result += num+"%\n"

print(result)

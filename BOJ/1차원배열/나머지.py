import sys

arr = [0 for i in range(42)]
while True:
    try:
        n = int(sys.stdin.readline())
        arr[n%42] = 1
    except: break

count = 0
for i in range(42):
    if(arr[i]==1) : count+=1

print(count)
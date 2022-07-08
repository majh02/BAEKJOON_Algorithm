import sys

N = int(sys.stdin.readline())
len  = str(N).__len__()

result = 0
for num in range(N-9*len, N):
    sum = num
    num_copy = num
    while num_copy>0:
        sum += num_copy%10
        num_copy = int(num_copy/10)
    if(sum==N):
        result = num
        break

print(result)

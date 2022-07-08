import sys
import collections

N = int(sys.stdin.readline())
arr = [0 for i in range(N)]

sum = 0
for i in range(N):
    arr[i] = int(sys.stdin.readline())
    sum+=arr[i]

arr.sort()
print(round(sum/N)) # 평균
print(arr[int(N/2)]) # 중앙값

# 최빈값
counts = collections.Counter(arr)
if(arr.__len__()==1):
    print(arr[0])
else:
    counts = counts.most_common(2)
    if(counts[0][1]==counts[1][1]):
        print(counts[1][0])
    else: print(counts[0][0])

print(arr[N-1]-arr[0]) # 범위

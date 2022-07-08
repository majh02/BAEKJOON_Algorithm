# https://claude-u.tistory.com/122 참고했음
import sys

N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    w, h = map(int, sys.stdin.readline().split())
    arr.append([w, h])

for i in range(N):
    rank = 1
    w = arr[i][0]
    h = arr[i][1]
    for j in range(N):
        if(i==j): continue
        w2 = arr[j][0]
        h2 = arr[j][1]
        if(w<w2 and h<h2): rank+=1
    print(rank, end=" ")
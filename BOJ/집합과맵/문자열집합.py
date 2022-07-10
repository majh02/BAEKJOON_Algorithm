import sys

N, M = map(int, sys.stdin.readline().split())
S = list()
for i in range(N):
    S.append(input())

count = 0
for j in range(M):
    check = input()
    if(S.__contains__(check)): count+=1

print(count)
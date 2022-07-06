import sys

A, B, V = map(int, sys.stdin.readline().split())

day = int((V-A)/(A-B))
current = (A-B)*day
while True:
    day+=1
    current+=A
    if(current>=V): break
    current-=B

print(day)
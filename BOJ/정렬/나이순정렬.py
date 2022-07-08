import sys

N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    age, name = sys.stdin.readline().split()
    arr.append([i, int(age), name])

arr.sort(key = lambda x: (x[1],x[0]))
for i in arr:
    age = i[1]
    name = i[2]
    print(str(age)+" "+name)
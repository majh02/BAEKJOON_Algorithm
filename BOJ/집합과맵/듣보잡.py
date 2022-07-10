import sys

N, M = map(int, sys.stdin.readline().split())
my_dict = dict()
for i in range(N):
    name = sys.stdin.readline().rstrip()
    my_dict[name] = True

arr = list()
for i in range(M):
    name = sys.stdin.readline().rstrip()
    if name in my_dict.keys():
        arr.append(name)

arr.sort()

print(arr.__len__())
for i in range(arr.__len__()):
    print(arr[i])


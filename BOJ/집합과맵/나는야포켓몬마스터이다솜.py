import sys

N, M = map(int, sys.stdin.readline().split())
my_dict = dict()
for i in range(N):
    name = sys.stdin.readline().rstrip()
    my_dict[name] = i+1
    my_dict[i+1] = name


for j in range(M):
    quest = sys.stdin.readline().rstrip()

    if(quest.isdigit()):
        print(my_dict[int(quest)])
    else:
        print(my_dict[quest])
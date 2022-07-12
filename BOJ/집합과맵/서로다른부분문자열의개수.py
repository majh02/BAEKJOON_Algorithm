import sys

S = sys.stdin.readline().rstrip()
len = S.__len__()
my_dict = dict()

for size in range(1, len+1):
    for i in range(len):
        tmp = S[i:i+size]
        my_dict[tmp] = True

print(my_dict.__len__())
import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
my_set = list(set(arr))
arr2 = sorted(my_set)
my_dict = dict()
for i in range(arr2.__len__()):
    my_dict[arr2[i]] = i
print(my_dict)
# print(arr2)

for i in arr:
    print(my_dict[i], end=" ")

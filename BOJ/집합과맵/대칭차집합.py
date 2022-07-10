from os import remove
import sys

from numpy import delete

A_num, B_num = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

A_dict = dict()
B_dict = dict()
count = A_num+B_num
for a in A:
    A_dict[a] = True
for b in B:
    B_dict[b] = True
    if b in A_dict.keys():
        del(A_dict[b])
for a in A:
    if a in B_dict.keys():
        del(B_dict[a])

print(A_dict.__len__()+B_dict.__len__())
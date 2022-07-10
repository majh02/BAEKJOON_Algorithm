import sys

N = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

card.sort()

my_dict = dict()
for card_num in card:
    if card_num not in my_dict.keys():
        my_dict[card_num]=1
    else: my_dict[card_num]+=1

for check in arr:
    if check not in my_dict.keys():
        print(0, end=" ")
    else: print(my_dict[check], end=" ")

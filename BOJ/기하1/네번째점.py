import sys
from typing import Counter

arr_x = list()
arr_y = list()
for i in range(3):
    x, y = map(int, sys.stdin.readline().split())
    arr_x.append(x)
    arr_y.append(y)

x_counter = Counter(arr_x)
y_counter = Counter(arr_y)
print(x_counter.most_common(2)[1][0], end = " ")
print(y_counter.most_common(2)[1][0], end = " ")
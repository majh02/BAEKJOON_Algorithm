# https://somjang.tistory.com/entry/Mxmxmxm 참고했음
import sys

N = int(sys.stdin.readline())
dictionary = dict()
for i in range(N):
    num = int(sys.stdin.readline())
    if num not in dictionary.keys():
        dictionary[num] = 1
    else: dictionary[num] += 1
dictionary = sorted(dictionary.items())

for i in range(dictionary.__len__()):
    for j in range(dictionary[i][1]):
        print(dictionary[i][0])
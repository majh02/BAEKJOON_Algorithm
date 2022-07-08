import sys

N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    word = sys.stdin.readline()
    if(arr.__contains__(word)): continue
    else: arr.append(word)
arr.sort()
arr.sort(key=len)

for word in arr:
    len = word.__len__()-1
    print(word[0:len])
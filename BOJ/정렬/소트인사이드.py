import sys

N = sys.stdin.readline()
arr = list()
for i in range(N.__len__()-1):
    arr.append(int(N[i]))

arr.sort(reverse=True)
result = ""
for i in arr:
    result+=str(i)
print(result)
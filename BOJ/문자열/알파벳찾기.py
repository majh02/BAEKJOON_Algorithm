import sys

S = sys.stdin.readline()
arr = [-1 for i in range(26)]

for i in range(S.__len__()-1):
    tmp = S[i:i+1]
    index = int(ord(tmp)-ord('a'))
    print(index)
    if(arr[index]==-1): arr[index] = i

result = ""
for i in range(26):
    result+=str(arr[i])+" "

print(result)
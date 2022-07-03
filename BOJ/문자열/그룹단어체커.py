import sys

N = int(sys.stdin.readline())
count = 0

for i in range(N):
    word = sys.stdin.readline()
    flag = True
    arr = [-1 for i in range(26)]
    for j in range(word.__len__()-1):
        index = ord(word[j:j+1])-ord('a')
        if(arr[index]==-1): arr[index] = j
        else:
            if(arr[index]+1==j): arr[index] = j
            else:
                flag = False
                break
    if(flag==True): count+=1

print(count)
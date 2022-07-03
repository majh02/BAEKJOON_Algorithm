import sys

word = sys.stdin.readline()
arr = [0 for i in range(26)]

for i in range(word.__len__()-1):
    tmp = word[i:i+1]
    tmp = tmp.lower()
    index = int(ord(tmp)-ord('a'))
    arr[index] += 1

max = 0
max_index = 0
identity = False
for i in range(26):
    if(max < arr[i]):
        max = arr[i]
        max_index = i
        identity = False
    elif(max == arr[i]):
        identity = True

if(identity==True): print('?')
else: print(chr(max_index+ord('a')).upper())
import sys

word = sys.stdin.readline()

time = 0
for i in range(word.__len__()-1):
    tmp = word[i:i+1]
    if(tmp=='S'): number = 7
    elif(tmp=='Z'): number = 9
    elif(ord(tmp) > ord('S')):
        number = 2+int((ord(tmp)-1-ord('A'))/3)
    else: number = 2+int((ord(tmp)-ord('A'))/3)
    time += number+1

print(time)

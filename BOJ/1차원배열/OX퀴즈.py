import sys

T = int(sys.stdin.readline())

result = ""
for t in range(T):
    score = 0
    count = 0
    tmp = sys.stdin.readline()
    for i in range(tmp.__len__()):
        if(tmp[i:i+1]=='O'):
            count+=1
            score+=count
        else: count = 0

    result += str(score)+"\n"

print(result)

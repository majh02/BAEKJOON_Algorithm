import sys

word = list(sys.stdin.readline())

count = 0
length = word.__len__()-1
i = 0
while i<length:
    if(i==length-1):
        count+=1
        break

    if(word[i]=='c'):
        if(word[i+1]=='=' or word[i+1]=='-'):
            i+=1
    elif(word[i]=='d'):
        if(i+2 < length and word[i+1]=='z' and word[i+2]=='='):
            i+=2
        elif(word[i+1]=='-'):
            i+=1
    elif(word[i]=='l' and word[i+1]=='j'):
        i+=1
    elif(word[i]=='n' and word[i+1]=='j'):
        i+=1
    elif(word[i]=='s' and word[i+1]=='='):
        i+=1
    elif(word[i]=='z' and word[i+1]=='='):
        i+=1
        
    count+=1
    i+=1

print(count)
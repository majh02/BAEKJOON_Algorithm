import sys

N = int(sys.stdin.readline())

count = int(N/5)
while count>=0:
    sugar = N-(count*5)
    if(sugar%3==0):
        count+=int(sugar/3)
        break
    elif(count==0 and sugar%3!=0):
        count=-1
        break
    count-=1

print(count)
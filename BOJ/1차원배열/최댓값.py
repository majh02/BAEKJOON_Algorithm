import sys

index = 0
max = 0

i = 1
while True:
    try:
        n = int(sys.stdin.readline())
        if(n > max):
            max = n
            index = i
        i+=1
    except: break

print(max)
print(index)
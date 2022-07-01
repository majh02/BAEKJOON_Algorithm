h, m = input().split()
time = int(input())
h = int(h)
m = int(m)

hour = int(time / 60)
min = time % 60
h += hour
m += min
if(h>=24) : h -= 24
if(m>=60) :
    if(h==23) : h = 0
    else : h += 1
    m -= 60

print(str(h)+" "+str(m))
h, m = input().split()
h = int(h)
m = int(m)

if(m-45<0) :
    if(h==0) : h = 23
    else : h -= 1
    m = 60+(m-45)
else : m -= 45;

print(str(h)+" "+str(m))
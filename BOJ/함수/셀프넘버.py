def d(n):
    sum = 0
    n2 = n
    while n2>0:
        sum+=n2%10
        n2 = int(n2/10)
    n+=sum
    return n


arr = [0 for i in range(10001)]

for i in range(10001):
    if(arr[i]==True): continue
    n = i
    while True:
        n = d(n)
        if(n>10000): break
        if(arr[n]==True) : break
        arr[n] = True

for i in range(1, 10001):
    if(arr[i]==False): print(i)
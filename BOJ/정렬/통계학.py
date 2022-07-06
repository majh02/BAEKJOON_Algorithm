import sys

N = int(sys.stdin.readline())
arr = [0 for i in range(N)]

sum = 0
for i in range(N):
    arr[i] = int(sys.stdin.readline())
    sum+=arr[i]

arr.sort()
print(int(sum/N))
print(arr[int(N/2)])

max = 0
count = 0
save = []
for i in range(N):
    if(i==0):
        count = 1
        if(i==N-1):
            save.append([count,[arr[i-1]]])
    elif(arr[i-1]!=arr[i]):
        if(max <= count):
            max = count
            save.append([count,[arr[i-1]]])
        count = 1
    elif(arr[i-1]==arr[i]):
        count+=1

save.sort()
min = 10000
max = save[save.__len__()-1][0]
cnt = 0
for i in range(save.__len__()):
    value = int(str(save[i][0]))
    num = str(save[i][1])
    num = int(num[1:num.__len__()-1])
    if(value==max):
        cnt+=1
        if(cnt==2 or i==N-1):
            print(num)
            break

print(arr[N-1]-arr[0])

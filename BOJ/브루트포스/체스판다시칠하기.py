import sys

def paint(index, first, color):
    if(first=="W"):
        if(index%2==0 and color!="W"):
            return 1
        elif(index%2==1 and color!="B"):
            return 1
    else:
        if(index%2==0 and color!="B"):
            return 1
        elif(index%2==1 and color!="W"):
            return 1

    return 0


N, M = map(int, sys.stdin.readline().split())
arr = list()
result = int(sys.maxsize)
for i in range(N):
    colors = sys.stdin.readline()
    arr.append(colors)

for i in range(N-7):
    for j in range(M-7):
        count1 = 0
        count2 = 0
        for k in range(i, i+8):
            colors = arr[k]
            first1 = ""; first2 = ""
            
            if((k-i)%2==0):
                first1 = "B"
                first2 = "W"
            else:
                first1 = "W"
                first2 = "B"
            
            for index in range(j, j+8):
                count1 += paint(index-j, first1, colors[index])
                count2 += paint(index-j, first2, colors[index])

        count = min(count1, count2)
        result = min(result, count)

print(result)
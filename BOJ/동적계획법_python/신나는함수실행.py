# 9184번_신나는 함수 실행
import sys

global arr
def w(a, b, c):
    global arr
    if(a<=0 or b<=0 or c<=0):
        return 1
    elif(a>20 or b>20 or c>20):
        arr[20][20][20] = w(20, 20, 20)
        return arr[20][20][20]
    elif(arr[a][b][c]!=0):
        return arr[a][b][c]
    
    if(a<b and b<c):
        arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        
    return arr[a][b][c]
    
result = ""
arr = [[[0 for col in range(21)] for row in range(21)] for depth in range(21)]
while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if(a==-1 and b==-1 and c==-1): break
    result += f'w({a}, {b}, {c}) = {w(a, b, c)}\n'
    
print(result)
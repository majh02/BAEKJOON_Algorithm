import sys
import math

N, M = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))
card.sort()

len = card.__len__()
result = 0
for i in range(len):
    num1 = card[i]
    if(num1>M): break
    for j in range(i+1, len):
        num2 = card[j]
        if(num2>M): break
        for k in range(j+1, len):
            num3 = card[k]
            sum = num1+num2+num3
            if(sum>M): break
            elif(sum==M):
                result = sum
                break
            elif(M-sum < M-result):
                result = sum
        if(result==M): break
    if(result==M): break

print(result)
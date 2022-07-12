import sys
import math

while True:
    arr = list(map(int, sys.stdin.readline().split()))
    if(arr[0]==0 and arr[1]==0 and arr[2]==0):
        break
    arr.sort(reverse=True)
    if(math.pow(arr[0],2) == math.pow(arr[1],2)+math.pow(arr[2],2)):
        print("right")
    else: print("wrong")
    
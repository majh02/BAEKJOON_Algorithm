# https://hongcoding.tistory.com/4 참고했음
import sys

N = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

card.sort()

def binary_search(card, target, start, end):
    while start<=end:
        mid = int((start+end)/2)
        if(card[mid] == target):
            return mid
        elif(card[mid] > target):
            end = mid-1
        else:
            start = mid+1

    return None

for num in arr:
    if(binary_search(card, num, 0, N-1) is not None):
        print(1, end=" ")
    else: print(0, end=" ")
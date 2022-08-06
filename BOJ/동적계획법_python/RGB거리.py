import sys
import numpy as np

def find_min(index, RGB):
    global prev_color
    if index == 0:
        return np.argmin(RGB)
    
    if prev_color == 0:
        return np.argmin(RGB[1:])
    elif prev_color == 1:
        RGB.pop(RGB[1])
        print(RGB)
        return np.argmin(RGB)
    else:
        return np.argmin(RGB[:2])

N = int(sys.stdin.readline())
RGB = [[0 for col in range(3)] for row in range(N)]
for i in range(N):
    RGB[i] = list(map(int, sys.stdin.readline().split()))
    
dp = [0]*N
prev_color = find_min(0, RGB[0])
dp[0] = RGB[0][prev_color]

for i in range(1, N):
    prev_color = find_min(i, RGB)
    print(prev_color)
    dp[i] = dp[i-1] + RGB[i][prev_color-1]

print(dp[N-1])
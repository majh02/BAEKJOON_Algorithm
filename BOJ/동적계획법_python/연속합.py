# https://kyoung-jnn.tistory.com/entry/%EB%B0%B1%EC%A4%801912%EB%B2%88%ED%8C%8C%EC%9D%B4%EC%8D%ACPython-%EC%97%B0%EC%86%8D-%ED%95%A9-DP 참고했음
import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

min_value = min(arr)
dp = [0]*n
dp[0] = arr[0]
for i in range(n):
    dp[i] = max(arr[i], dp[i-1]+arr[i])

print(max(dp))
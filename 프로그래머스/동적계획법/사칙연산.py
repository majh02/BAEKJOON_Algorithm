def solution(arr):
    n = len(arr)
    sign_cnt = int(n/2)+1
    
    max_dp = [[float('-inf') for _ in range(sign_cnt)] for _ in range(sign_cnt)]
    min_dp = [[float('inf') for _ in range(sign_cnt)] for _ in range(sign_cnt)]
    
    for i in range(sign_cnt):
        min_dp[i][i] = int(arr[i*2])
        max_dp[i][i] = int(arr[i*2])
    
    for mid in range(1, sign_cnt):
        for i in range(sign_cnt-mid):
            j = i+mid
            for k in range(i, j):
                if arr[k*2+1]=='+':
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k]+max_dp[k+1][j])
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k]+min_dp[k+1][j])
                    
                else:
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k]-min_dp[k+1][j])
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k]-max_dp[k+1][j])
                print(max_dp)
                
    return max_dp[0][sign_cnt-1]


print(solution(["1", "-", "3", "+", "5", "-", "8"]))
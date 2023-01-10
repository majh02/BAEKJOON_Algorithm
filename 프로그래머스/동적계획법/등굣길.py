dx = [1, 0]
dy = [0, 1]
def solution(m, n, puddles):
    dp = [[-1 for _ in range(m)] for _ in range(n)]
    return (DFS(0, 0, n, m, puddles, dp))
    

def DFS(x, y, n, m, puddles, dp):
    
    if x==n-1 and y==m-1:
        return 1
    
    if dp[x][y]!=-1:
        return dp[x][y]
    
    dp[x][y] = 0
    for i in range(2):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or ny<0 or nx>=n or ny>=m:
            continue
        if [nx, ny] in puddles:
            continue
        dp[x][y] += DFS(nx, ny, n, m, puddles, dp)
    
    return dp[x][y] % 1000000007

print(solution(4, 3, [[2, 2]]))
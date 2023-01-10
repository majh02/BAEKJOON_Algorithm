from collections import deque

maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]

def solution(maps):
    answer = BFS(maps)
    return answer

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def BFS(maps):
    n = len(maps); m = len(maps[0])
    queue = deque()
    queue.append((0,0))
    
    while queue:
        x, y = queue.popleft()
        if x==n-1 and y==m-1:
            return maps[x][y]
        
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if maps[nx][ny]==1:
                maps[nx][ny] = maps[x][y]+1
                queue.append((nx, ny))
                print(nx, ny, maps[nx][ny])
    return -1

solution(maps)
            
            
            
            
            
            
            
            
            
            
            
            
            
        
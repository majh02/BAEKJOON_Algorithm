def solution(n, results):
    answer = 0
    
    win, lose = []*(n+1), []*(n+1)
    for result in results:
        x, y = result[0], result[1]
        win[x].append(y)
        lose[y].append(x)
    
    rank = [0]*(n+1)
    for i in range(1, n+1):
        if len(win[i])+len(lose[i])==n-1 and rank[i]==0:
            rank[i] = len(lose[i])+1
            DFS(i, win, lose, rank, n)
    
    for i in range(1, n+1):
        if rank[i]>0:
            answer+=1
    return answer
            
            
def DFS(player, win, lose, rank, n):
    
    for p in win[player]:
        if lose[player] + lose[p] == n-1:
            rank[p] = rank[player]+1
            DFS(p, win, lose, rank, n)
            
    for p in lose[player]:
        if win[player] + win[p] == n-1:
            rank[p] = rank[player]-1
            DFS(p, win, lose, rank, n)
            
    return
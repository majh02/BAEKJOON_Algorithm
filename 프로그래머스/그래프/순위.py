def solution(n, results):
    answer = 0
    
    win, lose = [[] for _ in range(n+1)], [[] for _ in range(n+1)]
    for result in results:
        x, y = result[0], result[1]
        win[x].append(y)
        lose[y].append(x)
    
    global rank
    rank = [0]*(n+1)
    for i in range(1, n+1):
        if len(win[i])+len(lose[i])==n-1 and rank[i]==0:
            rank[i] = len(lose[i])+1
            DFS(i, win, lose, n)
    
    for i in range(1, n+1):
        if rank[i]>0:
            answer+=1
    return answer
            
            
def DFS(player, win, lose, n):
    global rank
    for p in win[player]:
        if len(lose[player]) + len(lose[p]) == n-1:
            rank[p] = rank[player]+1
            DFS(p, win, lose, n)
            
    for p in lose[player]:
        if len(win[player]) + len(win[p]) == n-1:
            rank[p] = rank[player]-1
            DFS(p, win, lose, n)
            
    return

print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))
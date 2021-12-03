#include <stdio.h>
#include <stdbool.h>
#define MAX 8

int N, M;
int arr[MAX] = {0,};
int visited[MAX] = {0,};

void dfs(int cnt)
{
    if(cnt == M)
    {
        for(int i = 0; i < M; i++)
            printf("%d ",arr[i]);
        printf("\n");
        return;
    }
    for(int i = 1; i <= N; i++)
    {   
        if(visited[i]!=M)
        {   
            visited[i]++;
            arr[cnt] = i;
            dfs(cnt+1);
            visited[i]--;
        }
    }
}

int main() {
    scanf("%d%d",&N,&M);
    if(N<1||M<1||N>7||M>7||M>N) return 0;
    dfs(0);
}
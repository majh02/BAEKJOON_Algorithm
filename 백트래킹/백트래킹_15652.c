#include <stdio.h>
#define MAX 9

int N, M;
int arr[MAX] = {0,};
int visited[MAX] = {0,};

void dfs(int num, int cnt)
{
    if(cnt == M)
    {
        for(int i = 0; i < M; i++)
            printf("%d ",arr[i]);
        printf("\n");
        return;
    }
    for(int i = num; i <= N; i++)
    {   
        if(visited[i]!=M)
        {   
            visited[i]++;
            arr[cnt] = i;
            dfs(i, cnt+1);
            visited[i]--;
        }
    }
}

int main() {
    scanf("%d%d",&N,&M);
    if(N<1||M<1||N>8||M>8||M>N) return 0;
    dfs(1, 0);
}
// #pragma warning(disable:4996)
// #include <stdio.h>

// void BackTracking(int num[], int N, int M, int count);

// int main(){
    
//     int N,M;
//     int num[8]={0};
//     scanf("%d%d",&N,&M);
//     if(N<1||M<1||N>8||M>8||M>N) return 0;

//     BackTracking(num,N,M,0);

//     return 0;
// }

// void BackTracking(int num[], int N, int M, int count){
//     for(int i=1;i<=N;i++){
//         int j=0;

//         if(count==0) num[0]=i;
//         else{
//             for(j=0;j<count;j++){
//                 if(num[j]==i) break;
//             }
//             if(j==count) num[count] = i;
//             else continue;
//         }

//         if(M-1 == count){
//             for(int k=0;k<M;k++){
//                 printf("%d", num[k]);
//                 if(k!=M-1) printf(" ");
//             }
//             printf("\n");
//         }
//         else BackTracking(num,N,M,count+1);
//     }
// }

#include <stdio.h>
#include <stdbool.h>
#define MAX 9

int n,m;
int arr[MAX] = {0,};
bool visited[MAX] = {0,};

void dfs(int cnt)
{
    if(cnt == m)
    {
        for(int i = 0; i < m; i++)
            printf("%d ",arr[i]);
        printf("\n");
        return;
    }
    for(int i = 1; i <= n; i++)
    {   
        if(visited[i]==0)
        {   
            visited[i] = true;
            arr[cnt] = i;
            dfs(cnt+1);
            visited[i] = false;
        }
    }
}

int main() {
    scanf("%d%d",&n,&m);
    dfs(0);
}
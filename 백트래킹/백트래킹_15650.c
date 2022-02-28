// #pragma warning(disable:4996)
// #include <stdio.h>

// void BackTracking(int num[], int passed[], int N, int M, int count, int bt_num);

// int main(){

//     int N,M;
//     int num[8]={0}, passed[8]={0};
//     scanf("%d%d",&N,&M);
//     if(N<1||M<1||N>8||M>8||M>N) return 0;

//     BackTracking(num,passed,N,M,0,1);
//     return 0;
// }

// void BackTracking(int num[], int passed[], int N, int M, int count, int bt_num){
//     for(int i=0;i<N;i++){
//         if(passed[i]==0){
//             num[count]=i+1;
//             passed[i]=1;
//         }
//         else continue;

//         if(M-1 == count){
//             for(int k=0;k<M;k++){
//                 printf("%d ", num[k]);
//             }
//             printf("\n");

//             if(i==N-1){
//                 int index = num[count-1];
//                 for(int j=index; j<N;j++){
//                     passed[j]=0;
//                 }
//                 if(num[count-1]==num[count]-1){
//                     if(num[0]==N-M+1) break;
//                     if(count-bt_num==0) bt_num--;
//                     if(num[count]-num[count-bt_num]==bt_num){
//                         bt_num++;
//                     }
//                     else{
//                         for(int k=count-bt_num;k<count-1;k++){
//                             if(num[k+1]-num[k]>1) bt_num = count-k;
//                         }
//                     }
//                     index = num[count-bt_num];
//                     for(int k=index;k<N;k++){
//                         passed[k] = 0;
//                     }
//                     BackTracking(num,passed,N,M,count-bt_num, bt_num);
//                 }
//             }
//         }
//         else BackTracking(num,passed,N,M,count+1, bt_num);
//     }
// }


#include <stdio.h>
#include <stdbool.h>
#define MAX 9

int n,m;
int arr[MAX] = {0,};
bool visited[MAX] = {0,};

void dfs(int num, int cnt)
{
    if(cnt == m)
    {
        for(int i = 0; i < m; i++)
            printf("%d ",arr[i]);
        printf("\n");
        return;
    }
    for(int i = num; i <= n; i++)
    {   
        if(visited[i]==0)
        {   
            visited[i] = true;
            arr[cnt] = i;
            dfs(i+1,cnt+1);
            visited[i] = false;
        }
    }
}

int main() {
    scanf("%d%d",&n,&m);
    dfs(1,0);
}
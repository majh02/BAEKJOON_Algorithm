#include <stdio.h>
#include <stdbool.h>

int N;
int A[11]={0,}; //A1, A2, ... , AN
int sig[4] = {0, }; //signal
int sig_index[10] = {0,}; //signal index
int sig_arr[10] = {0, }; //signal array(using dfs)
bool visited[10] = {0,};

int min=0, max=0;
int count=0;

int calculate(int sum, int n, int sig){
    if(sig==0) sum+=n;
    else if(sig==1) sum-=n;
    else if(sig==2) sum*=n;
    else sum/=n;
    return sum;
}
void dfs(int cnt)
{
    if(cnt == N-1){
        int sum=A[0];
        for(int i=0;i<N-1;i++){
            sum = calculate(sum,A[i+1],sig_arr[i]);
        }
        
        if(count==0){
            min = sum; max = sum;
            count++;
        }
        else{
            if(sum<min) min = sum;
            else if(sum>max) max = sum;
        }
        return;
    }
    for(int i = 0; i < N-1; i++){
        if(!visited[i]){
            visited[i]=true;
            sig_arr[cnt] = sig_index[i];
            dfs(cnt+1);
            visited[i]=false;
        }
    }
}

int main() {
    scanf("%d",&N);
    if(N<2||N>11) return 0;

    for(int i=0;i<N;i++){
        scanf("%d",&A[i]);
    }

    int sum=0;
    int index=0;
    for(int i=0;i<4;i++){
        scanf("%d",&sig[i]);
        sum+=sig[i];
    }
    if(sum!=N-1) return 0;
    for(int i=0;i<4;i++){
        for(int j=sig[i];j>0;j--){
            sig_index[index] = i;
            index++;
        }
    }

    dfs(0);
    printf("%d\n%d\n", max, min);
    return 0;
}
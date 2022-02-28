#include <stdio.h>
#include <stdbool.h>
#define Max 20

int N;
int S[Max][Max]={0};
bool visited[Max]={0};
int min = 0, count=0, result=0;

void dfs(int num, int cnt){
    if(cnt == N/2){
        int start =0, link=0;
        for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (visited[i] == true && visited[j] == true) start += S[i][j];
				if (visited[i] == false && visited[j] == false) link += S[i][j];
			}
		}
        result = start-link;
        if(result<0) result*=(-1);

        if(count==0){
            min = result;
            count++;
        }
        else if(result < min) min = result;
    }
    for(int i = num; i < N; i++){
        if(!visited[i]){
            visited[i]=true;
            dfs(i+1,cnt+1);
            visited[i]=false;
        }
    }
}

int main(){
    scanf("%d",&N);
    if(N<4||N>20||N%2!=0) return 0;

    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            scanf("%d",&S[i][j]);
            if(i==j && S[i][j]!=0) return 0;
            else if(i!=j&&(S[i][j]<1||S[i][j]>100)) return 0;
        }
    }

    dfs(0,0);
    printf("%d\n",min);

    return 0;
}
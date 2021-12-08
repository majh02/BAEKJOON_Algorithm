#include <iostream>
#include <math.h>
using namespace std;
#define Max 100000

int N, K;
int W[100]={0,}, V[100]={0,};
int dp[100][Max]={0,};
bool visited[100][Max]={0,};

int knapsack(int i, int k){
    if(i<0) return 0;
    if(!visited[i][k]){
        if(W[i]>k){
            dp[i][k] = knapsack(i-1,k);
        }
        else if(W[i]<=k){
            dp[i][k] = max(knapsack(i-1,k),knapsack(i-1,k-W[i])+V[i]);
        }
        visited[i][k]=true;
    }
    return dp[i][k];
}

int main(){
    cin>>N>>K;
    if(N<1||N>100||K<1||K>Max) return 0;
    for(int i=0;i<N;i++){
        cin>>W[i]>>V[i];
        if(W[i]<1||W[i]>Max) return 0;
        if(V[i]<0||V[i]>1000) return 0;
    }

    
    cout<<knapsack(N-1,K)<<endl;

    return 0;
}
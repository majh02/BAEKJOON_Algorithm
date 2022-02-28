#include <iostream>
#include <math.h>
using namespace std;
#define Max 1000000

int make_1(int N, int i){
    if(N==1) return count;

    if(dp[i-1]%3==0) dp1 = dp[i-1]/3;
    else dp1=N;
    if(dp[i-1]%2==0) dp2 = dp[i-1]/2;
    else dp1=N+1;
    dp3 = dp[i-1]-1;
    if(dp1==1||dp2==1||dp3==1) {
        dp[i] = 1;
    }
    else dp[i] = min(min(dp1, dp2),dp3);
    cout<<"dp1: "<<dp1<<", dp2: "<<dp2<<", dp3: "<<dp3<<", dp[i]: "<<dp[i]<<endl;
    count++;
    if(dp[i]==1) return count;
    else if(dp[i]<0) ;
}

int main(){
    int N;
    int dp[1000]={0,};
    int count=0;
    cin>>N;
    if(N<1||N>Max) return 0;

    int dp1=0, dp2=0, dp3=0;
    dp[0] = N;
    for(int i=1;i<Max;i++){
        if(dp[i-1]%3==0) dp1 = dp[i-1]/3;
        else dp1=N;
        if(dp[i-1]%2==0) dp2 = dp[i-1]/2;
        else dp1=N+1;
        dp3 = dp[i-1]-1;
        if(dp1==1||dp2==1||dp3==1) {
            dp[i] = 1;
        }
        else dp[i] = min(min(dp1, dp2),dp3);
        cout<<"dp1: "<<dp1<<", dp2: "<<dp2<<", dp3: "<<dp3<<", dp[i]: "<<dp[i]<<endl;
        count++;
        if(dp[i]==1) break;

        else if(dp[i]<0) break;
    }

    cout<<count<<endl;
    return 0;
}
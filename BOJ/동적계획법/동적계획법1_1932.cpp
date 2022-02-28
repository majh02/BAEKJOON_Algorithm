#include <iostream>
#include <math.h>
using namespace std;
#define Max 500

int main(){

    int n;
    int dp[Max][Max]={0,};
    int result = 0;
    cin>>n;
    if(n<1||n>Max) return 0;

    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cin>>dp[i][j];
        }
    }

    if(n==1) result = dp[0][0];
    else{
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0) dp[i][j] = dp[i-1][0]+dp[i][j];
                else if(j==i) dp[i][j] = dp[i-1][j-1]+dp[i][j];
                else dp[i][j] = max(dp[i-1][j-1]+dp[i][j],dp[i-1][j]+dp[i][j]);

                result = max(result,dp[i][j]);
            }
        }
    }

    cout<<result<<endl;

    return 0;
}
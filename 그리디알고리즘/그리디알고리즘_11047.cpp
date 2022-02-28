//11047_동전 0
#include <iostream>
using namespace std;
#define MAX 100000000

int main(){
    int N,K;
    int money[10]={0,};
    cin>>N>>K;
    if(N<1||N>10||K<1||K>MAX) return 0;
    for(int i=0;i<N;i++){
        cin>>money[i];
    }

    int count=0;
    for(int i=N-1;i>=0;i--){
        int result = K/money[i];
        if(result==0) continue;
        else{
            count+=result;
            K %= money[i];
        }
        if(K==0) break;
    }
    cout<<count<<endl;
    return 0;
}
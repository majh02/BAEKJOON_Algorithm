#include <iostream>
using namespace std;
#define Max 1000000

int array[Max]={0,};

int zero_one(int N){
    if(N==1) return array[1];
    else if(N==2) return array[2];
    else if(array[N]!=0) return array[N];

    array[N] = (zero_one(N-2) + zero_one(N-1))%15746;
    return array[N];
}

int main(){

    int N;
    cin>>N;
    if(N<1||N>Max) return 0;
    array[1] = 1; array[2] = 2;

    cout<<zero_one(N)<<endl;
    return 0;
}

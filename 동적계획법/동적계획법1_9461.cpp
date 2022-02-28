#include <iostream>
using namespace std;
#define Max 10000

long long int array[Max] = {0,};

long long int padovan(int N){
    if(N==1) return array[1];
    else if(N==2) return array[2];
    else if(N==3) return array[3];
    else if(array[N]!=0) return array[N];

    array[N] = padovan(N-3) + padovan(N-2);
    return array[N];
}

int main(){
    int T, N[Max]={0,};
    cin>>T;
    for(int i=0;i<T;i++){
        cin>>N[i];
        if(N[i]<1||N[i]>100) return 0;
    }
    array[1] = 1; array[2] = 1; array[3] = 1;

    for(int i=0;i<T;i++)
        cout<<padovan(N[i])<<endl;

    return 0;
}
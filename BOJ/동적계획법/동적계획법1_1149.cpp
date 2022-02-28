//https://m.blog.naver.com/occidere/220785383050 참고함
#include <iostream>
using namespace std;
#define Max 1000

int house[Max][Max+1]={0,};
int array[Max][Max+1]={0,};

int Min(int a, int b){
    return a<b ? a:b;
}

int main(){
    int N;
    cin>>N;
    if(N<2||N>Max) return 0;

    int cost=0;
    for(int i=1;i<=N;i++){
        for(int j=0;j<3;j++){
            cin>>cost;
            if(cost<0||cost>Max) return 0;
            house[i][j] = cost;
        }
    }
    
    for(int i=1;i<=N;i++){
        array[i][0] = Min(array[i-1][1], array[i-1][2])+house[i][0];
        array[i][1] = Min(array[i-1][0], array[i-1][2])+house[i][1];
        array[i][2] = Min(array[i-1][0], array[i-1][1])+house[i][2];
    }

    int result = Min(Min(array[N][0],array[N][1]),array[N][2]);
    cout<<result<<endl;

    return 0;
}
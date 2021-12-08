//1931_회의실 배정
#include <iostream>
#include <cmath>
using namespace std;
#define MAX 100000

int main(){
    int N;
    int meeting[MAX][2]={0,};
    int count=1;
    cin>>N;
    if(N<1||N>MAX) return 0;
    for(int i=0;i<N;i++){
        cin>>meeting[i][0]>>meeting[i][1];
        if(meeting[i][0]<0||meeting[i][1]<0) return 0;
        if(meeting[i][1]>pow(2,31)-1||meeting[i][1]>pow(2,31)-1) return 0;
    }

    for(int i=0;i<N;i++){
        for(int j=i+1;j<N;j++){
            if(meeting[i][0]>meeting[j][0]){
                int tmp0 = meeting[i][0];
                int tmp1 = meeting[i][1];
                meeting[i][0] = meeting[j][0];
                meeting[i][1] = meeting[j][1];
                meeting[j][0] = tmp0;
                meeting[j][1] = tmp1;
            }
            else if(meeting[i][0]==meeting[j][0]&&meeting[i][1]>meeting[j][1]){
                int tmp = meeting[i][1];
                meeting[i][1] = meeting[j][1];
                meeting[j][1] = tmp;
            }
        }
    }

    int a=0, b=1;
    int max_count=0;
    for(int i=0;i<N;i++){
        count=1;
        a=i; b=i+1;
        while(1){
            if(meeting[a][1]<=meeting[b][0]){
                count++;
                cout<<"a: "<<a<<", b: "<<b<<", count: "<<count<<endl;
                a=b;
            }
            b++;
            if(b>=N) break;
        }
        max_count=max(max_count,count);
        cout<<endl;
    }

    cout<<max_count<<endl;

    return 0;
}
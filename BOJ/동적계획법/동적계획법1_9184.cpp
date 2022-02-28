#include <iostream>
using namespace std;
#define Max 100000

int W[21][21][21]={0,};

int w(int a, int b, int c){
    if(a<=0||b<=0||c<=0){
        return W[0][0][0];
    }
    else if(a>20||b>20||c>20){
        return w(20,20,20);
    }
    else if(W[a][b][c]!=0) return W[a][b][c];

    if(a<b&&b<c)
        W[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    else W[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    
    return W[a][b][c];
}

int main(){
    int a[Max],b[Max],c[Max];
    int i=0;
    W[0][0][0]=1;
    while(1){
        cin>>a[i]>>b[i]>>c[i];
        if(a[i]<-50||b[i]<-50||c[i]<-50) return 0;
        if(a[i]>50||b[i]>50||c[i]>50) return 0;
        if(a[i]==-1&&b[i]==-1&&c[i]==-1) break;
        i++;
    }
    for(int j=0;j<i;j++){
        int result = w(a[j],b[j],c[j]);
        cout<<"w("<<a[j]<<", "<<b[j]<<", "<<c[j]<<") = "<<result<<endl;
    }
    return 0;
}
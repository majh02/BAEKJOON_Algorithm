#include <iostream>
using namespace std;
#define Max 100000

int N, K;
int W[100]={0,}, V[100]={0,};
int arr[100]={0,};
bool visited[100]={0,};


int Bag(int num, int weight, int MAX){
    for(int i=num;i<N;i++){
        if(!visited[i]){
            visited[i] = true;
            if(weight+W[i]>K) return 0;
            weight += W[i];
            // cout<<"num: "<<num<<", weight: "<<weight<<", V[i]: "<<V[i]<<", MAX: "<<MAX<<endl;
            return Bag(i+1,weight,MAX)+V[i];
        }
    }
    return MAX;
}

int main(){
    cin>>N>>K;
    if(N<1||N>100||K<1||K>Max) return 0;
    for(int i=0;i<N;i++){
        cin>>W[i]>>V[i];
        if(W[i]<1||W[i]>Max) return 0;
        if(V[i]<0||V[i]>1000) return 0;
    }

    for(int i=0;i<N-1;i++){
        for(int j=i+1;j<N;j++){
            if(W[i]>W[j]){
                int tmp_w = W[i]; int tmp_v = V[i];
                W[i] = W[j]; V[i] = V[j];
                W[j] = tmp_w; V[j] = tmp_v;
            }
            else if(W[i]==W[j]&&V[i]<V[j]){
                int tmp_v = V[i];
                V[i] = V[j];
                V[j] = tmp_v;
            }
        }
    }

    int MAX_value=0;
    for(int n=0;n<N;n++){
        int result = Bag(n,0,0);
        if(MAX_value<result){
            MAX_value = result;
            // cout<<"MAX value: "<<MAX_value<<endl;
        }
        for(int i=n+1;i<N;i++){
            visited[i] = false;
        }
    }
    cout<<MAX_value<<endl;

    return 0;
}
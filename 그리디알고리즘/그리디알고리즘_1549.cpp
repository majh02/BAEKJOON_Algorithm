#include <iostream>
using namespace std;

int main(){

    int number[50];
    char sign[50];
    
    int i=0;
    while(1){
        if(sign[i-1]=='\n') break;
        cin>>number[i];
        cin>>sign[i];
        if(cin.get()=='\n') cout<<"enter pressed"<<endl;
        i++;
    }

    for(int j=0;j<i;j++){
        cout<<number[j]<<sign[j];
    }

    return 0;
}
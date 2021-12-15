#pragma warning(disabled:4996)
#include <stdio.h>
#include <stdlib.h>
#define MAX 100
#define visited 2;

int n;
int pixel[MAX][MAX]={0,};
int index = 0;
int find_component(int i, int j){
    if(i<0||i>=n||j<0||j>=n) return 0;
    else if(pixel[i][j]!=1) return 0;
    else{
        pixel[i][j]=visited;
        int result = find_component(i-1,j+1)+find_component(i,j+1)+find_component(i+1,j+1)
        +find_component(i-1,j-1)+find_component(i,j-1)+find_component(i+1,j-1)
        +find_component(i-1,j)+find_component(i+1,j);
        if(result==0) index++;
        return 1+result;
    }
    return 0;
}

int main(){
    FILE* fp = fopen("input.txt","r");
    while(!feof(fp)){
        fscanf(fp,"%d",&n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                fscanf(fp,"%d",&pixel[i][j]);
            }
        }
    }
    fclose(fp);

    int count[MAX] = {0,};
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            count[index]+=find_component(i,j);
        }
    }
    for(int i=0;i<index;i++){
        if(count[i]==0) continue;
        printf("%d ",count[i]);
    }
    
    return 0;
}

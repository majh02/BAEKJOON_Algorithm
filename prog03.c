// #define _CRT_SECURE_NO_WARNINGS
#pragma warning(disabled:4996)
#include <stdio.h>
#include <stdlib.h>
#define MAX 100
#define visited 2;

int n;
int pixel[MAX][MAX]={0,};
int find_component(int i, int j){
    if(i<0||i>=n||j<0||j>=n) return 0;
    if(pixel[i][j]==1){
        pixel[i][j]==2;
        printf("%d %d\n",i,j);
        int result = find_component(i-1,j-1)+find_component(i,j-1)+find_component(i+1,j-1)+find_component(i-1,j)+find_component(i+1,j)+find_component(i-1,j+1)+find_component(i,j+1)+find_component(i+1,j+1);
        if(result == 0) return result+1;
        else return 1;
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

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d\n",find_component(i,j));
        }
    }
    // printf("%d\n",find_component(0,0));
    
    
    return 0;
}

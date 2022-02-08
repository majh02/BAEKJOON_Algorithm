#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000000

int main(){
    FILE *fp = fopen("pride_and_prejudice.txt","r");
    char *voca[MAX] = (char**)malloc(MAX*sizeof(char*));

    while(!feof(fp)){
        char str[MAX] = fscanf(fp,"%s",)
    }

}
#include <stdio.h>
#define Max 100000

int fiboData[Max]={0,};
int count[Max]={0,};

int fibonacci(int n) {
    if(n==0) return 0;
    else if(n<=2) return 1;
    if (fiboData[n]==0){
        fiboData[n] = fibonacci(n-1) + fibonacci(n-2);
        count[n] = count[n-1]+count[n-2];
    }
    return fiboData[n];
}
int main(){
    int T, N[Max]={0,};
    scanf("%d",&T);
    for(int i=0;i<T;i++){
        scanf("%d",&N[i]);
        if(N[i]<0||N[i]>40) return 0;
    }

    count[0] = 1, count[2] = 1;
    for(int i=0;i<T;i++){
        int fibo = fibonacci(N[i]);
        printf("%d %d\n",count[N[i]], fibo);
    }
    return 0;
}
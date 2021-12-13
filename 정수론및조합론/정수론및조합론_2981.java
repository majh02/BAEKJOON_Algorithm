//2981번 검문 - [미해결]
package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정수론및조합론_2981 {
    public static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<2||N>100) return;

        long[] num = new long[N];
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(br.readLine());
            if(num[i]<1||num[i]>1000000000) return;
        }
        Arrays.sort(num);

        long[] arr = new long[100];
        int arr_index=0;
        long first_m = 0,second_m = 0;
        for(long i=2;i<=num[1]-num[0];i++) {
            long spare = num[0] % i;
            for (int j = 1; j < N; j++) {
                if (num[j] % i != spare) break;
                else if (j == N - 1) {
                    arr[arr_index] = i;
                    arr_index++;
                    System.out.print(i + " ");
                    if(arr_index==1) {first_m = second_m = i;}
                    else{
                        first_m = second_m;
                        second_m = i;
                    }
                    long GCD = gcd(first_m,second_m);
                    long LCM = second_m*(first_m/GCD);
                    if(GCD==first_m&&arr_index!=1){
                        i = second_m*num[0]-1;
                    }
                    else if(GCD==1) continue;
                    else if(LCM!=second_m) i = LCM-1;
                }
            }
        }
    }
}

//1671번_팩토리얼 0의 개수
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수론및조합론_1676 {
    public static long[] div = new long[501];
    public static int count=0;
    public static long factorial(int n){
        if(n<=1) div[n] = 1;
        else if(div[n]!=0) return div[n];
        else div[n] = n*factorial(n-1);

        while(true){
            if(div[n]%10==0){
                div[n]/=10;
                count++;
            }
            else break;
        }
        return div[n]%(1000);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        factorial(N);
        System.out.println(count);
    }
}

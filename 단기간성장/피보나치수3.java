//2749번_피보나치 수3
package 단기간성장;

import java.io.*;

public class 피보나치수3 {
    public static int div = 1000000;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int N = (int)(n%500000);
        int[] dp = new int[div];
        dp[0] = 0; dp[1] = 1;
        for(long i=2;i<=n;i++){
            int a = (int)(i%div);
            int b = (int)((i-1)%div);
            int c = (int)((i-2)%div);
            dp[a] = (dp[b]+dp[c])%div;
            if(dp[a]==619445) System.out.println(i);
        }

        System.out.println("N: "+N+", dp: "+dp[N]);
        System.out.println("index: "+(int)(n%div)+", dp: "+dp[(int)(n%div)]);
    }
}

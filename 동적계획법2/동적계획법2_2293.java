//2293번_동전1
//https://dragon-h.tistory.com/10 참고했음
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_2293 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        for(int i = 1 ; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            for (int j = coin[i]; j <= k; j++)
                dp[j] += dp[j - coin[i]];
        }

        System.out.println(dp[k]);
    
    }
}

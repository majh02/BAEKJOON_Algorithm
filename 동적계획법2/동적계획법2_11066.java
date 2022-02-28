//11066번_파일 합치기★★★★★
//https://guy-who-writes-sourcecode.tistory.com/43 참고했음

package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_11066 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int K = Integer.parseInt(br.readLine());
            
            int[] cost = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            int[] sum = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=1;i<=K;i++){
                cost[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + cost[i];
            }

            for(int i=1;i<=K;i++){
                for(int from=1;from+i<=K;from++){
                    int to = from+i;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide=from;divide<to;divide++){
                        int value1 = dp[from][to];
                        int value2 = dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1];
                        dp[from][to]=Math.min(value1, value2);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}

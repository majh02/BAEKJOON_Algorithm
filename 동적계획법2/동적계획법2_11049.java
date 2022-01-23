//11049번_행렬 곱셈 순서
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_11049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N+1];
        int[] col = new int[N+1];
        long[][] dp = new long[N+1][N+1];
        for(int n=1;n<=N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            row[n] = Integer.parseInt(st.nextToken());
            col[n] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int from=1;from+i<=N;from++){
                int to = from+i;
                dp[from][to] = Integer.MAX_VALUE;
                for(int divide = from;divide<to;divide++){
                    long value1 = dp[from][to];
                    long value2 = dp[from][divide]+dp[divide+1][to]+(row[from]*col[divide]*col[from+i]);
                    dp[from][to]=Math.min(value1, value2);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
    
}

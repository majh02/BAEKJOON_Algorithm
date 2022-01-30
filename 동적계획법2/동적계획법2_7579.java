//7579번_앱
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동적계획법2_7579 {
    public static int N,M;
    public static int[] m,c;
    public static int[][] sum;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //현재 활성화 된 앱의 수
        M = Integer.parseInt(st.nextToken()); //필요한 메모리 크기
        
        m = new int[N+1]; //메모리 바이트 수
        sum = new int[N+1][N+1]; //from~to 메모리 바이트의 합
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            m[i] = Integer.parseInt(st.nextToken());
            sum[i][i] = m[i];
        }
        for(int i=1;i<=N;i++){
            for(int j=i+1;j<=N;j++){
                sum[i][j] = sum[i][j-1]+m[j];
            }
            System.out.println(Arrays.toString(sum[i]));
        }

        c = new int[N+1]; //비활성화 비용
        dp = new int[N+1][N+1]; //from~to 최소비용
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            c[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = c[i];
        }

        for(int i=0;i<=N;i++){
            for(int from=1;from+i<=N;from++){
                int to = from+i;
                if(sum[from][to]>=M){
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide=from;divide<to;divide++){
                        int value = dp[from][divide]+dp[divide+1][to];
                        dp[from][to] = Math.min(dp[from][to], value);
                    }
                }
            }
        }
        
        System.out.println(dp[1][N]);
    }

}
package 프로그래머스._다시풀어보기;

import java.util.*;

public class DP_등굣길 {
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m, n, puddles));
    }

    public static int max = Integer.MAX_VALUE;
    public static long[][] dist;
    public static long[][] dp;
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dist = new long[n+1][m+1];
        dp = new long[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dist[i], max);
        }
        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = max;
        }
        dist[1][1] = 0;
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j]!=0) continue;
                dist[i][j] = Math.min(dist[i][j-1], dist[i-1][j])+1;
                if(dist[i][j]==dist[i][j-1]+1 && dp[i][j-1]!=max){
                    dp[i][j]+=dp[i][j-1];
                }
                if(dist[i][j]==dist[i-1][j]+1 && dp[i-1][j]!=max){
                    dp[i][j]+=dp[i-1][j];
                }
                dp[i][j]%=1000000007;
            }
        }

        answer = (int)(dp[n][m]%1000000007);
        return answer;
    }
}

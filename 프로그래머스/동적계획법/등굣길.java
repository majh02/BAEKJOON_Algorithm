//동적계획법_3번_등굣길

package 프로그래머스.동적계획법;

import java.util.*;

public class 등굣길 {
    public static void main(String args[]){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m, n, puddles));
    }

    public static int div = 1000000007;
    public static int max = Integer.MAX_VALUE;
    public static long[][] dp;
    public static long[][] dist;
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new long[n+1][m+1];
        for(int[] pud : puddles){
            dp[pud[1]][pud[0]] = max;
        }
        dist = new long[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dist[i], max);
        }

        dp[1][1] = 1;
        dist[1][1] = 0;
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
                if(dp[i][j]>div) dp[i][j]%=div;
            }
        }

        answer = (int)(dp[n][m]%div);
        return answer;
    }
    
}

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
    public static int[] dx = {1,0};
    public static int[] dy = {0,1};
    public static int[][] dp;
    public static int[][] dist;
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];

        dp[0][0] = 1;
        dist[0][0] = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]!=0) continue;
                dist[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+1;
                for(int[] pud : puddles){
                    if(i==pud[0] && j==pud[1]) continue;
                }
                for(int k=0;k<2;k++){
                    
                }
            }
        }

        return answer;
    }
    
}

package SK_1차_코테;

import java.math.BigInteger;
import java.util.*;

public class SK3 {
    public static int width, height;
    public static void main(String args[]){
        // width = 2;
        // height = 2;
        // int[][] diagonals = {{1,1},{2,2}};
        width = 51;
        height = 37;
        int[][] diagonals = {{17,19}};
        System.out.println(solution(width, height, diagonals));
    }

    public static int max = Integer.MAX_VALUE;
    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        BigInteger dp[][] = new BigInteger[height+2][width+2];
        long dist[][] = new long[height+2][width+2];
        for(int i=0;i<=height+1;i++){
            Arrays.fill(dist[i], max);
            Arrays.fill(dp[i], BigInteger.valueOf((long)0));
        }

        dp[1][1] = BigInteger.valueOf((long)1);
        dist[1][1] = 0;
        for(int i=1;i<=height+1;i++){
            for(int j=1;j<=width+1;j++){
                if(dp[i][j].longValue()!=0) continue;
                dist[i][j] = Math.min(dist[i-1][j], dist[i][j-1])+1;
                if(dist[i][j]==dist[i-1][j]+1){
                    dp[i][j] = dp[i][j].add(dp[i-1][j]);
                }
                if(dist[i][j]==dist[i][j-1]+1){
                    dp[i][j] = dp[i][j].add(dp[i][j-1]);
                }
            }
        }

        for(int i=1;i<=height+1;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        BigInteger result = BigInteger.valueOf((long)0);
        for(int[] diag : diagonals){
            int dx = (height+1)-(diag[1]);
            int dy = (width+1)-(diag[0]);
            result = result.add(dp[diag[1]][diag[0]+1].multiply(dp[dx][dy+1]));
            result = result.add(dp[diag[1]+1][diag[0]].multiply(dp[dx+1][dy]));
        }
        BigInteger mod_num = BigInteger.valueOf((long)10000019);
        result = result.mod(mod_num);
        answer = result.intValue();
        return answer;
    }
}

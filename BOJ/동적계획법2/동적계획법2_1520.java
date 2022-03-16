//1520번_내리막 길★★★
package BOJ.동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_1520 {
    public static int M, N;
    public static int[][] map, dp;
    public static int[] rangeX = {-1, 0, 1, 0};
    public static int[] rangeY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        for(int m=1;m<=M;m++){
            st = new StringTokenizer(br.readLine()," ");
            for(int n=1;n<=N;n++){
                map[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M+1][N+1];
        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                dp[i][j] = -1;
            }
        }

        long H = DFS(1,1); //이동가능한 경로의 수
        System.out.println(H);
    }

    public static long DFS(int x, int y){
        if(x == M && y == N) return 1;
        if(dp[x][y]!=-1) return dp[x][y];

        dp[x][y]=0;
        for(int i=0;i<4;i++){
            int dx = x+rangeX[i];
            int dy = y+rangeY[i];

            if(dx<1||dy<1||dx>M||dy>N) continue;
            if(map[x][y]>map[dx][dy]){
                dp[x][y] += DFS(dx,dy);
            }
        }
        return dp[x][y];
    }
    
}

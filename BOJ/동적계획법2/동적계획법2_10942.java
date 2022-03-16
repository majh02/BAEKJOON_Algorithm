//10942번_펠린드롬?
package BOJ.동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_10942 {
    public static int N;
    public static int[] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) dp[i][j] = 1;
                else dp[i][j]=-1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(DFS(S,E)).append("\n");
        }

        System.out.println(sb);
    }

    public static int DFS(int from, int to){
        if(from<1||to>N) return 0;
        else if(dp[from][to]!=-1) return dp[from][to];

        dp[from][to]=0;
        if(arr[from]==arr[to]){
            if(from==to) dp[from][to] = 1;
            else if(from+1==to) dp[from][to] = 1;
            else dp[from][to] = 1&DFS(from+1, to-1);
        }
        else dp[from][to] = 0;

        return dp[from][to];
    }
    
}


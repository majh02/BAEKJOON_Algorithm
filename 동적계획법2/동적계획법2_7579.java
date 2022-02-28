//7579번_앱
//https://dragon-h.tistory.com/9 참고했음
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_7579 {
    public static int N,M;
    public static int[] m,c;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //현재 활성화 된 앱의 수
        M = Integer.parseInt(st.nextToken()); //필요한 메모리 크기
        
        m = new int[N+1]; //메모리 바이트 수
        c = new int[N+1]; //비활성화 비용
        dp = new int[N+1][10001]; //from~to 최소비용
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            m[i] = Integer.parseInt(st1.nextToken());
            c[i] = Integer.parseInt(st2.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            int memory = m[i];
            int cost = c[i];

            for(int j=1;j<=10000;j++){
                if(i==1){
                    if(j>=cost) dp[i][j] = memory;
                }
                else{
                    if(j>=cost) dp[i][j] = Math.max(dp[i-1][j-cost]+memory, dp[i-1][j]);
                    else dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j]>=M) result = Math.min(result,j);
            }
        }
        
        System.out.println(result);
    }
}
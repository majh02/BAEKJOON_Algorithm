//2629번_양팔저울★★★★★
//https://arinnh.tistory.com/4 참고했음
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_2629 {
    public static int N;
    public static int[] weight, marble;
    public static boolean[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); //추의 개수
        weight = new int[N+1]; //추들의 무게
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); //확인하고자 하는 구슬의 개수
        marble = new int[M+1]; //구슬들의 무게
        st = new StringTokenizer(br.readLine(), " ");
        
        dp = new boolean[N+1][15001];
        DFS(0,0);
        for(int i=0;i<M;i++){
            marble[i] = Integer.parseInt(st.nextToken());
            if(marble[i]>15000)  sb.append("N ");
            else sb.append(dp[N][marble[i]]?"Y ":"N ");
        }
        
        System.out.println(sb);

    } 

    public static void DFS(int index, int Marble){
        if(dp[index][Marble]) return;
        dp[index][Marble]=true;
        if(index==N) return;

        DFS(index+1, Marble+weight[index+1]);
        DFS(index+1, Marble);
        DFS(index+1, Math.abs(Marble-weight[index+1]));
    }
}

//15684번_사다리 조작

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 사다리조작 {
    public static int[][] graph;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        graph = new int[N+1][H+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b][a] = b+1;
            graph[b+1][a] = b;
        }

        int count = 0;
        int[][] dp = new int[N+1][H+1];
        for(int i=1;i<=N;i++){
            int start = i;
            for(int h=1;h<=H;h++){
                if(graph[start][h]!=0){
                    start = graph[start][h];
                }
                // if(h==H && start!=i){  
                //     while(true){
                //         graph[start][H]
                //     }
                // }
            }
            int end = start;
            System.out.println("start: "+i+", end: "+end);
        }

    }
    
}

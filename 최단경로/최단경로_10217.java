//10217번_KCM Travel
package 최단경로;

import java.io.*;
import java.util.*;

class Airport{
    int end, cost, time;
    public Airport(int end, int cost, int time){
        this.end = end;
        this.cost = cost;
        this.time = time;
    }
}

public class 최단경로_10217 {
    public static int N, M, K;
    public static ArrayList<Airport>[] graph;
    public static boolean visited[];
    public static long[] dist;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); //N : 공항의 수
            M = Integer.parseInt(st.nextToken()); //M : 총 지원비용
            K = Integer.parseInt(st.nextToken()); //K : 티켓정보의 수
        
            graph = (ArrayList[])new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                graph[i] = new ArrayList<Airport>();
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine()," ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[u].add(new Airport(v, c, d));
            }
        }
    }

    public static void Dynamic(){
        Queue<Airport> queue = new Queue<Airport>();
        visited = new boolean[N+1];
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        queue.add(new Airport(1, 0, 0));

        while(!queue.isEmpty()){
            int current_Airport = queue.poll();
            int u = 
        }
        
    }
}
//10217번_KCM Travel
//https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-10217%EB%B2%88-KCM-Travel-Java-Python 참고했음
package 최단경로;

import java.io.*;
import java.util.*;

class Airport implements Comparable<Airport>{
    int end;
    int cost;
    int time;
    public Airport(int end, int cost, int time){
        this.end = end;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Airport o){
        if(time==o.time) return cost-o.cost;
        return time-o.time;
    }
}

public class 최단경로_10217 {
    public static int N, M, K;
    public static ArrayList<Airport>[] graph;
    public static boolean visited[];
    public static int[][] dp;
    public static int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();
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

            int answer = Dijkstra();
            if(answer==INF) sb.append("Poor KCM\n");
            else sb.append(answer+"\n");
        }
        System.out.println(sb);
    }

    public static int Dijkstra(){
        PriorityQueue<Airport> queue = new PriorityQueue<>();
        visited = new boolean[N+1];
        dp = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;
        queue.add(new Airport(1, 0, 0));

        while(!queue.isEmpty()){
            Airport current_Airport = queue.poll();
            int u = current_Airport.end;
            int prev_c = current_Airport.cost;
            int prev_t = current_Airport.time;

            if(dp[u][prev_c] < prev_t) continue;
            dp[u][prev_c] = prev_t;

            for(Airport airport : graph[u]){
                int v = airport.end;
                int c = prev_c + airport.cost;
                int t = prev_t + airport.time;

                if(c > M) continue;
                if(dp[v][c] > t){
                    for(int j = c;j<=M;j++){
                        if(dp[v][j] > t) dp[v][j] = t;
                    }
                    queue.add(new Airport(v, c, t));
                }
            }
        }

        int result = INF;
        for(int i=1;i<=M;i++){
            result = Math.min(result,dp[N][i]);
        }
        return result;
    }
}
//1753번_최단경로
package 최단경로;

import java.io.*;
import java.util.*;

import javax.sound.midi.ShortMessage;

public class 최단경로_1753 {
    public static int V, E, K;
    public static int[][] graph;
    public static int[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new int[V+1][V+1];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
        }

        for(int i=1;i<=V;i++){
            int result = BFS(i)-1;

            if(result==-1) sb.append("INF");
            else sb.append(result+"\n");
        }

        System.out.println(sb);
    }

    public static int BFS(int end){
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[V+1];
        queue.add(K);
        visited[K] = 1;

        while(!queue.isEmpty()){
            if(visited[end]!=0) return visited[end];

            int u = queue.poll();
            for(int v=1;v<=V;v++){
                if(graph[u][v]!=0 && visited[v]==0){
                    queue.add(v);
                    visited[v] = visited[u]+graph[u][v];
                }
            }
        }
        return 0;
    }
    
}

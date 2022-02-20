//1504번_특정한 최단 경로
package 최단경로;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight-o.weight;
    }
}

public class 최단경로_1504 {
    public static int N, E;
    public static int v1, v2;
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int[] dist;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = (ArrayList[])new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result = Dijkstra(v1, v2);
        int result1 = Dijkstra(1, v1)+Dijkstra(v2, N)+result;
        int result2 = Dijkstra(1, v2)+Dijkstra(v1, N)+result;
        
        result = (result1>=INF && result2>=INF) ? -1 : Math.min(result1, result2);
        System.out.println(result);
    }

    public static int Dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current_Node = queue.poll();
            int u = current_Node.end;
            
            if(visited[u]==true) continue;
            visited[u] = true;

            for(Node node : graph[u]){
                int v = node.end;
                int w = node.weight;
                if(dist[v]>dist[u]+w){
                    dist[v] = dist[u]+w;
                    queue.add(new Node(v,dist[v]));
                }
            }

        }
        return dist[end];
    }
    
}

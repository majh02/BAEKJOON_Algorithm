//1753번_최단경로 ★★★
//https://dragon-h.tistory.com/20 참고했음
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

public class 최단경로_1753 {
    public static int V, E, K;
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int[] dist;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = (ArrayList[])new ArrayList[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<Node>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }

        Dijkstra();
        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }

        System.out.println(sb);
    }

    public static void Dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited = new boolean[V+1];
        queue.add(new Node(K,0));
        dist[K] = 0;

        while(!queue.isEmpty()){
            Node current_Node = queue.poll();
            int u = current_Node.end;

            if(visited[u]==true) continue;
            visited[u] = true;

            for(Node node:graph[u]){
                int v = node.end;
                int w = node.weight;
                if(dist[v] > dist[u]+w){
                    dist[v] = dist[u]+w;
                    queue.add(new Node(v,dist[v]));
                }
            }
        }
    }
    
}

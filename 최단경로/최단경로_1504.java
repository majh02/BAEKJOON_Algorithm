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
    public static int[] dist;
    public static boolean[] visited = new boolean[2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = (ArrayList[])new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<Node>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

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

        Dijkstra();
        if(dist[N]==Integer.MAX_VALUE) System.out.println(-1);
        else{
            if(visited[0] && visited[1]) System.out.println(dist[N]);
            else if(!visited[0] && visited[1]) System.out.println(dist[N]+dist[v1]);
            else if(visited[0] && !visited[1]) System.out.println(dist[N]+dist[v2]);
            else System.out.println(dist[N]+dist[v1]+dist[v2]);
        }
    }

    public static void Dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current_Node = queue.poll();
            int u = current_Node.end;
            for(Node node : graph[u]){
                int v = node.end;
                int w = node.weight;
                if(dist[v]>dist[u]+w){
                    if(v==v1 && !visited[0]) visited[0] = true;
                    else if(v==v1 && visited[0]) visited[0] = false;
                    else if(v==v2 && !visited[1]) visited[1] = true;
                    else if(v==v2 && visited[1]) visited[1] = false;
                    else{
                        visited[0] = false;
                        visited[1] = false;
                    }
                    dist[v] = dist[u]+v;
                    queue.add(new Node(v,dist[v]));
                }
            }

        }

    }
    
}

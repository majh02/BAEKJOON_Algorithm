//9370번_미확인 도착지
package BOJ.최단경로;

import java.io.*;
import java.util.*;

public class 최단경로_9370 {
    public static int n, m, t;
    public static int s, g, h; //(g != h)
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static boolean passed_g, passed_h;
    public static int[] dist;
    static final int INF = 200000000;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //T : 테스트케이스
        
        for(int test=0;test<T;test++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); //m : 교차로
            m = Integer.parseInt(st.nextToken()); //n : 도로
            t = Integer.parseInt(st.nextToken()); //t : 목적지
            
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken()); //s : 출발지
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = (ArrayList[]) new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                graph[i] = new ArrayList<Node>();
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b,d));
                graph[b].add(new Node(a,d));
            }

            ArrayList<Integer> Dest = new ArrayList<>();
            int length_btw_gh = Dijkstra(g, h);
            for(int i=0;i<t;i++){
                int destination = Integer.parseInt(br.readLine()); //dest : 목적지 후보
                int result1 = Dijkstra(s, g) + Dijkstra(h, destination) + length_btw_gh;
                int result2 = Dijkstra(s, h) + Dijkstra(g, destination) + length_btw_gh;
                int result = (result1>=INF && result2>=INF) ? -1 : Math.min(result1, result2);
                //System.out.println(result1+",  "+result2+",  "+Dijkstra(s, destination));
                if(result==Dijkstra(s, destination)) Dest.add(destination);
            }
            Collections.sort(Dest);

            for(int i=0;i<Dest.size();i++){
                sb.append(Dest.get(i)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int Dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        passed_g = false; passed_h = false;
        
        queue.add(new Node(start,0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current_Node = queue.poll();
            int u = current_Node.end;

            if(visited[u]) continue;
            visited[u] = true;
            
            for(Node node : graph[u]){
                int v = node.end;
                int w = node.weight;
                if(dist[v]>dist[u]+w){
                    dist[v] = dist[u]+w;
                    queue.add(new Node(v,dist[v]));
                    //System.out.println("v: "+v+", passed_g: "+passed_g+", passed_h: "+passed_h);
                }
            }
        }
        return dist[end];
    }   
    
}

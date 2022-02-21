//11657번_타임머신
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

public class 최단경로_11657 {
    public static int N, M;
    public static ArrayList<Node>[] graph;
    public static int[] visited;
    public static int[] Time;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = (ArrayList[]) new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<Node>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B,C));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            int result = Dijkstra(i);
            if(result==Integer.MIN_VALUE){
                System.out.println(-1);
                return;
            }
            else if(result==Integer.MAX_VALUE){
                sb.append(-1).append("\n");
            }
            else sb.append(result).append("\n");
        }

        System.out.print(sb);

    }

    public static int Dijkstra(int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited = new int[N+1];
        Time = new int[N+1];
        Arrays.fill(Time, Integer.MAX_VALUE);
        
        queue.add(new Node(1,0));
        Time[1] = 0;

        int tmp = 0;
        while(!queue.isEmpty()){
            Node current_Node = queue.poll();
            int u = current_Node.end;

            if(visited[u]==3) continue;
            visited[u]++;

            for(Node node : graph[u]){
                int v = node.end;
                int t = node.weight;
                if(Time[v] > Time[u]+t){
                    Time[v] = Time[u]+t;
                    queue.add(new Node(v,Time[v]));
                }
                if(Time[end]<0 && tmp==0){
                    tmp = Time[end];
                }
                else if(Time[end]<0 && Time[end]<tmp){
                    Time[end] = Integer.MIN_VALUE;
                }
            }
        }
        
        return Time[end];
    }

    
}

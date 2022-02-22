//11657번_타임머신 - 음수가 있을 경우 벨만포드 알고리즘으로 해결
package 최단경로;

import java.io.*;
import java.util.*;

class City{
    int end, time;

    public City(int end, int time){
        this.end = end;
        this.time = time;
    }
}

public class 최단경로_11657 {
    public static int N, M;
    public static ArrayList<City>[] graph;
    public static int[] visited;
    public static long[] Time;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = (ArrayList[]) new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<City>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new City(B,C));
        }

        StringBuilder sb = new StringBuilder();
        
        if(BellmanFord()){
            System.out.println(-1);
            return;
        }
        else{
            for(int i=2;i<=N;i++){
                if(Time[i]==Long.MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(Time[i]).append("\n");
            }
        }
        System.out.println(sb);

    }

    public static boolean BellmanFord(){
        Time = new long[N+1];
        Arrays.fill(Time, Long.MAX_VALUE);
        Time[1] = 0;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(City city : graph[j]){
                    if(Time[j]==Long.MAX_VALUE) break;

                    int e = city.end;
                    int t = city.time;
                    if(Time[e] > Time[j]+t){
                        Time[e] = Time[j]+t;
                        if(i==N) return true;
                    }
                }
            }
        }
        return false;
    }

    // public static int Dijkstra(int end){
    //     PriorityQueue<Node> queue = new PriorityQueue<>();
    //     visited = new int[N+1];
    //     Time = new int[N+1];
    //     Arrays.fill(Time, Integer.MAX_VALUE);
        
    //     queue.add(new Node(1,0));
    //     Time[1] = 0;

    //     int tmp = 0;
    //     while(!queue.isEmpty()){
    //         Node current_Node = queue.poll();
    //         int u = current_Node.end;

    //         if(visited[u]==3) continue;
    //         visited[u]++;

    //         for(Node node : graph[u]){
    //             int v = node.end;
    //             int t = node.weight;
    //             if(Time[v] > Time[u]+t){
    //                 Time[v] = Time[u]+t;
    //                 queue.add(new Node(v,Time[v]));
    //             }
    //             if(Time[end]<0 && tmp==0){
    //                 tmp = Time[end];
    //             }
    //             else if(Time[end]<0 && Time[end]<tmp){
    //                 Time[end] = Integer.MIN_VALUE;
    //             }
    //         }
    //     }
        
    //     return Time[end];
    // }

    
}

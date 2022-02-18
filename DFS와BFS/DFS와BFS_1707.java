//1707번_이분 그래프
package DFS와BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_1707 {
    public static int K, V, E;
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static boolean flag;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K = Integer.parseInt(br.readLine());
        for(int k=0;k<K;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = (ArrayList<Integer>[])new ArrayList[V+1];
            for (int i=1;i<=V;i++) {
				graph[i] = new ArrayList<Integer>();
			}
            visited = new int[V+1];
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
            }

            flag = false;

            for(int i=1;i<=V;i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    DFS(i,graph[i].get(0));
                }
            }
            // BFS(x);
            if(flag==false) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y){

        visited[y] = visited[x]*(-1);
        for(int i : graph[y]){
            if(visited[i]==0){
                DFS(y,i);
            }
            else if(visited[y]!=0 && visited[i]!=0 &&visited[y]==visited[i]){
                flag = false;
                return;
            }
        }
        flag = true;
        return;
    }

    // public static void BFS(int x){
    //     Queue<Integer> queue = new LinkedList<>();
    //     queue.add(x);
    //     visited[x] = 1;

    //     while(!queue.isEmpty()){
    //         int tmp = queue.poll();

    //         for(int i=0;i<E;i++){
    //             int p1 = graph[i][0];
    //             int p2 = graph[i][1];
    //             if(p1==tmp && visited[p2]==0){
    //                 visited[p2] = visited[p1]*(-1);
    //                 queue.add(p2);
    //             }
    //             else if(p2==tmp && visited[p1]==0){
    //                 visited[p1] = visited[p2]*(-1);
    //                 queue.add(p1);
    //             }
    //             else if(visited[p1]!=0 && visited[p2]!=0 && visited[p1]==visited[p2]){
    //                 flag = false;
    //                 return;
    //             }
    //         }
    //     }
    //     flag = true;
    //     return;
    // }
    
}

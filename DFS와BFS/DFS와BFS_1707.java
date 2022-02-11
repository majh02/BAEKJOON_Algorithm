//1707번_이분 그래프
package DFS와BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_1707 {
    public static int K, V, E;
    public static int[][] graph;
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

            graph = new int[V+1][V+1];
            visited = new int[V+1];
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = graph[y][x] = 1;
            }

            flag = false;
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    if(graph[i][j]==1 && visited[i]==0){
                        BFS(i);
                        // DFS(i,j);
                    }
                }
                if(flag==false) sb.append("NO\n");
                else sb.append("YES\n");
                break;
            }
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y){

        graph[x][y] = graph[y][x] = 0;
        visited[y] = visited[x]*(-1);
        
        for(int i=1;i<=V;i++){
            if(graph[y][i]==1 && visited[i]==0){
                DFS(y,i);
            }
            else if(graph[y][i]==1 && visited[y]==visited[i]){
                flag = false;
                return;
            }
        }

        flag = true;
        return;
    }

    public static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = 1;

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            for(int i=1;i<=V;i++){
                if(graph[tmp][i]==1 && visited[i]==0){
                    graph[tmp][i] = graph[i][tmp] = 0;
                    visited[i] = visited[tmp]*(-1);
                    queue.add(i);
                }
                else if(graph[tmp][i]==1 && visited[tmp]+visited[i]==0){
                    flag = false;
                    return;
                }
                else if(graph[tmp][i]==1 && visited[tmp]==visited[i]){
                    flag = false;
                    return;
                }
            }
        }
        flag = true;
        return;
    }
    
}

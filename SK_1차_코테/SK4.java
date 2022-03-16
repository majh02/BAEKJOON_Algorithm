package SK_1차_코테;

import java.util.*;

public class SK4 {
    public static void main(String args[]){
        int n = 5;
        int[][] edges = {{0,1},{0,2},{1,3},{1,4}};
        System.out.println(solution(n, edges));
    }

    public static ArrayList<Integer>[] graph;
    public static int[][] distance;
    public static boolean[] visited;
    public static long solution(int n, int[][] edges) {
        long answer = 0;
        distance = new int[n][n];
        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] Edge : edges){
            graph[Edge[0]].add(Edge[1]);
            graph[Edge[1]].add(Edge[0]);
        }

        for(int i=0;i<n;i++){
            BFS(n, edges, i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                for(int k=0;k<n;k++){
                    if(i==k || j==k) continue;
                    if(distance[i][k]== distance[i][j]+distance[j][k]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void BFS(int n, int[][] edges, int p){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n];
        queue.add(p);
        visited[p] = true;

        while(!queue.isEmpty()){
            int edge = queue.poll();
            for(int i : graph[edge]){
                if(!visited[i]){
                    distance[edge][i] = 1;
                    distance[p][i] = distance[p][edge]+distance[edge][i];
                    visited[i] = true;
                    queue.add(i);
                }
            }
            //System.out.println(queue);
        }


    }
    
}

//그래프_1번_가장 먼 노드
package 프로그래머스.그래프;

import java.util.*;

public class 가장먼노드 {
    public static void main(String args[]){
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    } 

    public static ArrayList<Integer>[] graph;
    public static int[] dist;
    public static boolean[] visited;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        graph = (ArrayList<Integer>[])new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        visited = new boolean[n+1];
        
        for(int[] EDGE : edge){
            graph[EDGE[0]].add(EDGE[1]);
            graph[EDGE[1]].add(EDGE[0]);
        }

        answer = BFS(n, edge);

        return answer;
    }
    public static int BFS(int n, int[][] vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while(true){
            Queue<Integer> tmp = new LinkedList<>();
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int i : graph[cur]){
                    if(!visited[i]){
                        tmp.add(i);
                        visited[i] = true;
                    }
                }
            }
            if(tmp.isEmpty()) break;
            queue.addAll(tmp);
            cnt = tmp.size();
        }
        return cnt;
    }
}

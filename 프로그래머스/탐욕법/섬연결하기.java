//탐욕법_5번_섬 연결하기

package 프로그래머스.탐욕법;

import java.util.*;

public class 섬연결하기 {
    public static void main(String args[]){
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] graph = new int[n][n];
        for(int[] cost : costs){
            int x = cost[0];
            int y = cost[1];
            int c = cost[2];
            graph[x][y] = c;
            graph[y][x] = c;
        }

        // for(int i=0;i<n;i++){
        //     for(int j =i+1;j<n;j++){
        //         for(int mid = 1;mid<j-i;mid++){
        //             System.out.println("graph["+i+"]["+j+"]: "+graph[i][j]+", graph["+i+"]["+mid+"]+graph["+mid+"]["+j+"]: "+graph[i][mid]+"+"+graph[mid][j]);
        //             graph[i][j] = Math.min(graph[i][j],graph[i][mid]+graph[mid][j]);
        //             graph[j][i] = graph[i][j];
        //         }
        //     }
        // }

        for(int i=0;i<n;i++){
            boolean[][] visited = new boolean[n][n];
            visited[i][i] = true;
            find_min(visited, 1, 0, i, graph, n);
            //min = Math.min(min, result);
            // System.out.println("find min: "+min);
        }

        answer = min;
        return answer;
    }

    public static int min = Integer.MAX_VALUE;
    public static void find_min(boolean[][] visited, int count, int result, int start, int[][] graph, int n){
        if(result>min) return;
        if(count==n) {
            min = Math.min(min, result);
            return;
        }
        for(int i=0;i<n;i++){
            if(graph[start][i]==0) continue;
            if(visited[start][i]) continue;

            System.out.println("result: "+result+", graph["+start+"]["+i+"]: "+graph[start][i]);
            // System.out.println("start: "+start+", i: "+i+", result: "+result+", "+graph[start][i]+",   "+Arrays.toString(visited)+", count: "+count);
            visited[start][i] = true;
            visited[i][start] = true;
            find_min(visited, count+1, result+graph[start][i], i, graph, n);
            visited[start][i] = false;
            visited[i][start] = false;
            System.out.println("return!");
        }

        return;
    }
}

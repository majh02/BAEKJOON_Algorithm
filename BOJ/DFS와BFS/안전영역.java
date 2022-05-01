//2468번_안전영역
package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class 안전영역 {
    public static boolean[][] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int max = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 0;
        for(int depth=max-1;depth>=0;depth--){
            int count = 0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]>depth && !visited[i][j]){
                        count++;
                        dfs(N, map, depth, i, j);
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void dfs(int N, int[][] map, int depth, int x, int y){
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(map[nx][ny]>depth && !visited[nx][ny]){
                dfs(N, map, depth, nx, ny);
            }
        }
        return;
    }
    
}

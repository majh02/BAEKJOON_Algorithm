//2573번_빙산
package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class 빙산 {
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        int count = 0;
        while(true){
            visited = new boolean[N][M];
            count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0 && !visited[i][j]){
                        count++;
                        dfs(N, M, map, visited, i, j);
                    }
                }
            }
            System.out.println("count: "+count);

            if(count>1) break;
            if(count==0){
                System.out.println(0);
                return;
            }

            boolean[][] melted = new boolean[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0){
                        melted[i][j] = true;
                        map[i][j] -= melting(N, M, map, i, j, melted);
                        if(map[i][j]<0) map[i][j] = 0;
                    }
                }
            }
            year++;
        }

        System.out.println(year);
    }
    public static int melting(int N, int M, int[][] map, int x, int y, boolean[][] melted){
        int count = 0;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(map[nx][ny]==0 && !melted[nx][ny]) count++;
        }
        return count;
    }

    public static void dfs(int N, int M, int[][] map, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(map[nx][ny]!=0 && !visited[nx][ny]){
                dfs(N, M, map, visited, nx, ny);
            }
        }

        return;
    }
    
}

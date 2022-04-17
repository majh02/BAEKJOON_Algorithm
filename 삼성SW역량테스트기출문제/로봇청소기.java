//14503번_로봇 청소기

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //d=0(북), d=1(동), d=2(남), d=3(서)
        
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        dfs(N, M, map, visited, r, c, d, 1);

        System.out.println(result);

    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int dir_cnt = 0;
    public static int result = 0;
    public static void dfs(int N, int M, int[][] map, boolean[][] visited, int x, int y, int dir, int cleaned_count){
        if(dir_cnt == 5) return;
        // System.out.println("x: "+x+", y: "+y+", dir: "+dir+", cleaned: "+cleaned_count);

        int direction = dir;
        for(int i=3;i>=0;i--){
            direction = dir+i>3 ? dir+i-4 : dir+i;
            // System.out.println("direction: "+direction);
            int nx = x+dx[direction];
            int ny = y+dy[direction];
            if(nx<0 || ny<0 || nx>=N || ny>=M) return;
            if(map[nx][ny]==1 || visited[nx][ny]) {
                dir_cnt++;
                continue;
            }
            else{
                visited[nx][ny] = true;
                dir_cnt = 0;
                dfs(N, M, map, visited, nx, ny, direction, cleaned_count+1);
                visited[nx][ny] = false;
                break;
            }
        }
            
        if(dir_cnt == 5) return;
        else if(dir_cnt == 4){
            int nx = x-dx[dir];
            int ny = y-dy[dir];
            if(map[nx][ny]==1){
                dir_cnt=5;
                result = cleaned_count;
                return;
            }
            else{
                dir_cnt = 0;
                dfs(N, M, map, visited, nx, ny, dir, cleaned_count);
            }
        }
        
    }
    
}
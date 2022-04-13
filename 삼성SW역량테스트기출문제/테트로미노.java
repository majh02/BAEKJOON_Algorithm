//14500번_테트로미노

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 테트로미노 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] paper = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = true;
                find_max(N, M, paper, 1, visited, i, j, paper[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
    public static int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
    public static int max = Integer.MIN_VALUE;
    public static void find_max(int N, int M, int[][] paper, int count, boolean[][] visited, int x, int y, int sum){
        if(count==4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(visited[nx][ny]) continue;

            boolean flag = false;
            if(i>=4 && count==3){
                if(sum+paper[nx][ny]<max) continue;
                for(int j=0;j<4;j++){
                    int neihbor_x = nx+dx[j];
                    int neihbor_y = ny+dy[j];
                    if(neihbor_x<0 || neihbor_y<0 || neihbor_x>=N || neihbor_y>=M) continue;
                    if(visited[neihbor_x][neihbor_y]){
                        flag = true;
                        break;
                    }
                }
            }
            if(i>=4 && !flag) continue;
            
            visited[nx][ny] = true;
            find_max(N, M, paper, count+1, visited, nx, ny, sum+paper[nx][ny]);
            visited[nx][ny] = false;
        }

        return;
    }
}

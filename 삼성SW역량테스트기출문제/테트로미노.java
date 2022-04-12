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

        int max_value = 0;
        int[][] paper = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
                max_value = Math.max(max_value, paper[i][j]);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(paper[i][j]!=max_value) continue;
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                find_max(N, M, paper, 1, visited, i, j, paper[i][j]);
                if(max == max_value*4) break;
            }
            if(max == max_value*4) break;
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

            if(i>=4 && count==3){
                boolean flag = false;
                for(int j=0;j<4;j++){
                    int neihbor_x = nx+dx[j];
                    int neihbor_y = ny+dy[j];
                    if(neihbor_x<0 || neihbor_y<0 || neihbor_x>=N || neihbor_y>=M) continue;
                    // System.out.println("nx: "+nx+", ny: "+ny+", n_x: "+neihbor_x+", n_y: "+neihbor_y);
                    if(visited[neihbor_x][neihbor_y]){
                        flag = true;
                        break;
                    }
                }
                if(!flag) continue;
            }
            
            visited[nx][ny] = true;
            find_max(N, M, paper, count+1, visited, nx, ny, sum+paper[nx][ny]);
            visited[nx][ny] = false;
        }

        return;
    }
}

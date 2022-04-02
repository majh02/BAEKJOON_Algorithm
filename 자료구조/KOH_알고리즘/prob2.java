package 자료구조.KOH_알고리즘;

import java.util.Scanner;

public class prob2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] maze = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();

        if(escape_maze(N, maze, K, 0, 0, 0)) System.out.println("Yes");
        else System.out.println("No");
    }
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean escape_maze(int N, int[][] maze, int K, int x, int y, int bomb){
        if(x<0 || y<0 || x>=N || y>=N) return false;
        if(x==N-1 && y==N-1){
            return true;
        }

        maze[x][y] = 1;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(maze[nx][ny]==1) continue;
            else if(maze[nx][ny]==2){
                if(bomb < K) bomb++;
                else continue;
            }

            boolean flag = escape_maze(N, maze, K, nx, ny, bomb);
            if(flag) return true;
        }
        return false;
    }
}

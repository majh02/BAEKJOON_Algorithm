package 자료구조.KOH_알고리즘;

import java.util.*;

public class prob3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] maze = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maze[i][j] = sc.nextInt();
            }
        }

        int result = Integer.MAX_VALUE;
        for(int dir=0;dir<4;dir++){
            count = 0;
            boolean flag = escape_maze(N, maze, 0, 0, dir);
            if(flag) result = Math.min(count, result);
        }
        if(result==Integer.MAX_VALUE) System.out.println("No path");
        else System.out.println(result+1);
        
    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int count = 0;
    public static boolean escape_maze(int N, int[][] maze, int x, int y, int dir){
        if(x<0 || y<0 || x>=N || y>=N) return false;
        if(x==N-1 && y==N-1) return true;

        boolean flag = false;
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        if((nx>=0 && ny>=0 && nx<N && ny<N) && maze[nx][ny]==0){
            maze[nx][ny] = 1;
            flag = escape_maze(N, maze, nx, ny, dir);
            maze[nx][ny] = 0;
        }
        else{
            for(int i=0;i<4;i++){
                if(i==dir) continue;
                nx = x+dx[i];
                ny = y+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(maze[nx][ny]==1) continue;
                
                maze[nx][ny] = 1;
                count++;
                flag = escape_maze(N, maze, nx, ny, i);
                maze[nx][ny] = 0;

                if(flag) return true;
            }
        }

        return flag;
    }
    
}

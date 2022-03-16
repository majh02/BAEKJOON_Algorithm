//2178번_미로탐색 (DFS로 할 경우 시간초과 -> BFS로 풀어야함)
package BOJ.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_2178 {
    public static int[] dx = {1, 0, 0, -1};
    public static int[] dy = {0, 1, -1, 0};
    public static int N, M;
    public static boolean[][] maze;
    public static boolean[][] visited;
    public static int min_count = 0;
    public static int[][] road;
    public static int index = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        road = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            String tmp = br.readLine();
            for(int j=1;j<=M;j++){
                if(tmp.substring(j-1, j).equals("1"))
                    maze[i][j] = true;
            }
        }

        // DFS(1,1,0);
        // System.out.println(min_count);

        BFS(1,1);
        System.out.println(road[N][M]+1);
    }

    public static void DFS(int x, int y, int count){
        
        visited[x][y] = true;
        count++;
        
        if(x==N && y==M){
            if(min_count==0) min_count = count;
            else min_count = Math.min(min_count, count);
        }

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(count>min_count && min_count!=0) break;
            if(nx>0 && ny>0 && nx<=N && ny<=M){
                if(maze[nx][ny]&&!visited[nx][ny]){
                    DFS(nx,ny,count);
                }
            }
        }
        visited[x][y] = false;
    }

    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int Y = queue.peek()[1];
            queue.poll();

            for(int i=0;i<4;i++){
                int nx = X+dx[i];
                int ny = Y+dy[i];

                if(nx>0 && ny>0 && nx<=N && ny<=M){
                    if(maze[nx][ny]&&!visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        road[nx][ny] = road[X][Y]+1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

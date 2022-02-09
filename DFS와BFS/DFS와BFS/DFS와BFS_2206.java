//2206번_벽 부수고 이동하기
package DFS와BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_2206 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int N, M;
    public static int[][] map;
    public static int[][] dist;
    public static boolean[][][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        for(int i=1;i<=N;i++){
            String tmp = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(tmp.substring(j-1,j));
            }
        }

        BFS();
        
    }

    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        visited[1][1][0] = true;
        queue.add(new int[]{1,1,0});

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int Break = queue.peek()[2];
            queue.poll();

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>0 && ny>0 && nx<=N && ny<=M){
                    if(map[nx][ny]==0 && !visited[nx][ny][Break]){
                        visited[nx][ny][Break] = true;
                        queue.add(new int[]{nx,ny,Break});
                        dist[nx][ny] = dist[x][y]+1;
                    }
                    else if(Break==0 && !visited[nx][ny][Break]){
                        visited[nx][ny][1] = true;
                        queue.add(new int[]{nx,ny,1});
                        dist[nx][ny] = dist[x][y]+1;
                    }
                }
                if(nx==N && ny==M){
                    System.out.println(dist[N][M]+1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }   
}

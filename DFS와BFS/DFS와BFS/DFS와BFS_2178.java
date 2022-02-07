//2178번_미로탐색
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS와BFS_2178 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int N, M;
    public static boolean[][] maze;
    public static boolean[][] visited;
    public static int[] road;
    public static int index = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        road = new int[N*M];
        for(int i=1;i<=N;i++){
            String tmp = br.readLine();
            for(int j=1;j<=M;j++){
                if(tmp.substring(j-1, j).equals("1"))
                    maze[i][j] = true;
            }
        }

        DFS(1,1,0);
        // Arrays.sort(road);
        System.out.println(Arrays.toString(road));
        for(int i=0;i<road.length;i++){
            if(road[i]!=0){
                System.out.println(road[i]);
                // break;
            }
        }
    }

    public static boolean flag;
    public static void DFS(int x, int y, int count){
        
        visited[x][y] = true;
        count++;
        System.out.println("x: "+x+", y: "+y+", index: "+index+", count: "+count);
        
        if(x==N && y==M){
            flag = true;
            road[index] = count;
            index++;
        }

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>0 && ny>0 && nx<=N && ny<=M){
                if(maze[nx][ny]&&!visited[nx][ny]){
                    DFS(nx,ny,count);
                }
            }
        }
        if(flag) {
            visited[x][y] = false;
            flag = false;
        }
        return;
    }
}

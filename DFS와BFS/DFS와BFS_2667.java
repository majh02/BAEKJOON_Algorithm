//2667번_단지번호붙이기
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS_2667 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int N;
    public static boolean[][] house = new boolean[26][26];
    public static int[] complex; //단지 수
    public static boolean[][] visited = new boolean[26][26];
    public static int num = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        house = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++){
            String tmp = br.readLine();
            for(int j=1;j<=N;j++){
                if(tmp.substring(j-1, j).equals("1")){
                    house[i][j] = true;
                }
                // house[i][j] = Integer.parseInt(tmp.substring(j-1, j));
            }
        }

        visited = new boolean[N+1][N+1];
        complex = new int[N*N];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(house[i][j] && !visited[i][j]){
                    // DFS(i,j);
                    BFS(i,j);
                    num++;
                }
            }
        }
        Arrays.sort(complex);

        System.out.println(num);
        for(int i=0;i<complex.length;i++){
            if(complex[i]==0) continue;
            System.out.println(complex[i]);
        }
    }

    public static void DFS(int x, int y){

        visited[x][y] = true;
        complex[num]++;
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>0 && ny>0 && nx<=N && ny<=N){
                if(house[nx][ny] && !visited[nx][ny]){
                    DFS(nx,ny);
                }
            }
        }
    }

    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        complex[num]++;

        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int Y = queue.peek()[1];
            queue.poll();

            for(int i=0;i<4;i++){
                int nx = X+dx[i];
                int ny = Y+dy[i];
                if(nx > 0 && ny > 0 && nx<=N && ny<=N){
                    if(house[nx][ny] && !visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        complex[num]++;
                    }
                }
            }
        }
    }
    
}

//2667번_단지번호붙이기
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DFS와BFS_2667 {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int N;
    private static boolean[][] house = new boolean[26][26];
    private static int[] complex; //단지 수
    private static boolean[][] visited = new boolean[26][26];
    private static int num = 0;
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
        complex = new int[(N+1)*(N+1)];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(house[i][j] && !visited[i][j]){
                    DFS(i,j);
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

    private static void DFS(int x, int y){

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
    
}

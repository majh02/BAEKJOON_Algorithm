//7569번_토마토(3차원 배열)
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_7569 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int N, M, H;
    public static int tomato[][][];
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H+1][N+1][M+1];
        for(int k=1;k<=H;k++){
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=1;j<=M;j++){
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                    if(tomato[k][i][j]==1) queue.add(new int[]{k,i,j});
                }
            }
        }

        BFS();

        int result = -1;
        for(int k=1;k<=H;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    if(tomato[k][i][j]==0){
                        System.out.println("-1");
                        return;
                    }
                    result = Math.max(result,tomato[k][i][j]);
                }
            }
        }

        if(result==1){
            System.out.println("0");
            return;
        }
        else System.out.println(result-1);

    }

    public static void BFS(){
        while(!queue.isEmpty()){
            int height = queue.peek()[0];
            int X = queue.peek()[1];
            int Y = queue.peek()[2];
            queue.poll();

            for(int i=0;i<4;i++){
                int nx = X+dx[i];
                int ny = Y+dy[i];

                if(nx>0 && ny>0 && nx<=N && ny<=M){
                    if(tomato[height][nx][ny]==0){
                        queue.add(new int[]{height,nx,ny});
                        tomato[height][nx][ny] = tomato[height][X][Y]+1;  
                    }
                }
            }
            
            if(height-1>0){
                if(tomato[height-1][X][Y]==0){
                    queue.add(new int[]{height-1,X,Y});
                    tomato[height-1][X][Y] = tomato[height][X][Y]+1;
                }
            }
            if(height+1<=H){
                if(tomato[height+1][X][Y]==0){
                    queue.add(new int[]{height+1,X,Y});
                    tomato[height+1][X][Y] = tomato[height][X][Y]+1;
                }
            }  
        }
    }
    
}

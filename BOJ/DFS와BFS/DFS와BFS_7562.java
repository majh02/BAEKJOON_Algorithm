//7562번_나이트의 이동
package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_7562 {
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int l;
    public static int[][] board;
    public static int start_x, start_y;
    public static int end_x, end_y;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            start_x = Integer.parseInt(st1.nextToken());
            start_y = Integer.parseInt(st1.nextToken());
            end_x = Integer.parseInt(st2.nextToken());
            end_y = Integer.parseInt(st2.nextToken());

            BFS();
        }

        System.out.println(sb);

    }

    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start_x, start_y});

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            if(x==end_x && y==end_y){
                sb.append(board[x][y]+"\n");
                return;
            }

            for(int i=0;i<8;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<l &&ny<l){
                    if(board[nx][ny]==0){
                        queue.add(new int[]{nx,ny});
                        board[nx][ny] = board[x][y]+1;
                    }
                }
            }
        }
    }
    
}

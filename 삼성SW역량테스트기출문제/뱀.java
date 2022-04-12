//3190번_뱀

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 뱀 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = -1;
        }
        int L = Integer.parseInt(br.readLine());
        int[][] direction = new int[L][2];
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            direction[i][0] = Integer.parseInt(st.nextToken());
            if(st.nextToken().equals("L")) direction[i][1] = 1;
            else direction[i][1] = -1;
            // System.out.println(Arrays.toString(direction[i]));
        }

        board[1][1] = 2;
        int[] head = {1,1};
        int[] tail = {1,1};
        int answer = solution(N, direction, 0, head, tail, 1, board, 1, 0);
        System.out.println(answer+1);
    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int solution(int N, int[][] direction, int index, int[] head, int[] tail, int dir ,int[][] board, int length, int time){
        // System.out.println("index: "+index);

        int nx = head[0], ny = head[1];
        int tail_x = tail[0], tail_y = tail[1];

        int Time = 0;
        if(index==direction.length) Time = Integer.MAX_VALUE;
        else Time = direction[index][0]-time;

        for(int i=0;i<Time;i++){
            nx += dx[dir];
            ny += dy[dir];
            if(nx<=0 || ny<=0 || nx>N || ny>N) return time;
            if(board[nx][ny]>0) return time;

            if(board[nx][ny]==-1){
                length++;
            }
            else {
                int d = board[tail_x][tail_y]-1;
                board[tail_x][tail_y] = 0;
                tail_x += dx[d];
                tail_y += dy[d];
            }

            board[nx][ny] = dir+1;
            time++;
            // for(int j=1;j<=N;j++){
            //     System.out.println(Arrays.toString(board[j]));
            // }
            // System.out.println();
        }

        int next_dir = dir+direction[index][1];
        if(next_dir==-1) next_dir = 3;
        if(next_dir==4) next_dir = 0;
        
        board[nx][ny] = next_dir+1;
        head[0] = nx; head[1] = ny;
        tail[0] = tail_x; tail[1] = tail_y;
        // System.out.println("recursion!"+ next_dir);
        return solution(N, direction, index+1, head, tail, next_dir, board, length, time);
    }
    
}

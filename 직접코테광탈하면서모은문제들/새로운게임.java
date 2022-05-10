//17780번_새로운 게임
package 직접코테광탈하면서모은문제들;

import java.io.*;
import java.util.*;

public class 새로운게임{
    public static ArrayList<Integer>[][] horse;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        horse = new ArrayList[N+1][N+1];
        int[][] board = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                horse[i][j] = new ArrayList<>();
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

        }
    }

    public static int[] dx = {0, 0, 0, -1, 1};
    public static int[] dy = {0, 1, -1, 0, 0};
    public static boolean move(int N, int[][] board, int num, int x, int y, int dir){
        if(horse[x][y].size()>=4) return false;
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        if(nx<=0 || ny<=0 || nx>N || ny>N){
            if(dir==1) dir=2;
            else if(dir==2) dir=1;
            else if(dir==3) dir=4;
            else dir=3;
        }

        if(board[nx][ny]==0){ //흰색
            for(int horse_num : horse[x][y]){
                horse[nx][ny].add(horse_num);
            }
            horse[x][y].clear();
        }
        else if(board[nx][ny]==1){ //빨간색
            for(int i = horse[x][y].size()-1;i>=0;i++){
                horse[nx][ny].add(horse[x][y].get(i));
            }
            horse[x][y].clear();
        }
        else{ //파란색
            if(dir==1) dir=2;
            else if(dir==2) dir=1;
            else if(dir==3) dir=4;
            else dir=3;
            
            nx = x+dx[dir]; ny = y+dy[dir];
            if(nx<=0 || ny<=0 || nx>N || ny>N || board[nx][ny]==2){
                return true;
            }
            
        }
        return true;
    }

}
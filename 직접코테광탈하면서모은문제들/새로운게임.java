//17780번_새로운 게임
package 직접코테광탈하면서모은문제들;

import java.io.*;
import java.util.*;

import javax.swing.text.TabExpander;

public class 새로운게임{
    public static ArrayList<Integer>[][] horse;
    public static int[][] board;
    public static int[][] location;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        horse = new ArrayList[N+1][N+1];
        board = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++){
                horse[i][j] = new ArrayList<>();
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int turn = 1;
        location = new int[K+1][3];
        for(int i=1;i<=K;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            location[i][0] = x;
            location[i][1] = y;
            location[i][2] = dir;
            horse[x][y].add(i);
        }

        while(true){
            for(int i=1;i<=K;i++){
                int x = location[i][0];
                int y = location[i][1];
                int dir = location[i][2];
                if(turn>1){
                    if(horse[x][y].get(0)!=i) continue;
                }
                flag = move(N, i, x, y, dir);
                if(!flag){
                    break;
                }
            }

            // for(int i=1;i<=K;i++){
            //     System.out.println("num: "+i+", x: "+location[i][0]+", y: "+location[i][1]+", dir: "+location[i][2]);
            // }
            // for(int i=1;i<=N;i++){
            //     for(int j=1;j<=N;j++){
            //         if(horse[i][j].size()!=0){
            //             for(int h : horse[i][j]){
            //                 System.out.print("("+i+", "+j+"), "+h+" // ");
            //             }
            //             System.out.println();
            //         }
            //     }
            // }
            if(!flag) break;
            if(turn>1000) break;
            turn++;
        }

        if(!flag) System.out.println(turn);
        else System.out.println(-1);
    }

    public static int[] dx = {0, 0, 0, -1, 1};
    public static int[] dy = {0, 1, -1, 0, 0};
    public static boolean move(int N, int num, int x, int y, int dir){
        if(horse[x][y].size()>=4) return false;
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        
        if(nx<=0 || ny<=0 || nx>N || ny>N){
            return blue(N, num, x, y, dir);
        }
        else if(board[nx][ny]==0){ //흰색
           return white(x, y, nx, ny);
        }
        else if(board[nx][ny]==1){ //빨간색
            return red(x, y, nx, ny);
        }
        else{ //파란색
            return blue(N, num, x, y, dir); 
        }
    }

    public static boolean white(int x, int y, int nx, int ny){
        for(int horse_num : horse[x][y]){
            horse[nx][ny].add(horse_num);
            location[horse_num][0] = nx;
            location[horse_num][1] = ny;
        }
        horse[x][y].clear();

        if(horse[nx][ny].size()>=4) return false;
        return true;
    }

    public static boolean red(int x, int y, int nx, int ny){
        for(int i = horse[x][y].size()-1;i>=0;i--){
            horse[nx][ny].add(horse[x][y].get(i));
            location[horse[x][y].get(i)][0] = nx;
            location[horse[x][y].get(i)][1] = ny;
        }
        horse[x][y].clear();

        if(horse[nx][ny].size()>=4) return false;
        return true;
    }

    public static boolean blue(int N, int num, int x, int y, int dir){
        if(dir==1) dir=2;
        else if(dir==2) dir=1;
        else if(dir==3) dir=4;
        else dir=3;
        location[num][2] = dir;
            
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        if(nx<=0 || ny<=0 || nx>N || ny>N || board[nx][ny]==2){
            return true;
        }
        else if(board[nx][ny]==0){
            return white(x, y, nx, ny);
        }
        else if(board[nx][ny]==1){
            return red(x, y, nx, ny);
        }

        return true;
    }

}
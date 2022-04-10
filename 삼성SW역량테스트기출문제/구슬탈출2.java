//13460번_구슬탈출2

package 삼성SW역량테스트기출문제;

// import java.io.*;
// import java.util.*;

// public class 구슬탈출2 {

//     public static int R_x = 0, R_y = 0;
//     public static int B_x = 0, B_y = 0;
//     public static int O_x = 0, O_y = 0;
//     public static void main(String args[]) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
        
//         char[][] board = new char[N][M];
//         for(int i=0;i<N;i++){
//             String tmp = br.readLine();
//             for(int j=0;j<M;j++){
//                 board[i][j] = tmp.charAt(j);
//                 if(board[i][j]=='R'){
//                     R_x = i; R_y = j;
//                 }
//                 else if(board[i][j]=='B'){
//                     B_x = i; B_y = j;
//                 }
//                 else if(board[i][j]=='O'){
//                     O_x = i; O_y = j;
//                 }
//             }
//         }

//         System.out.println(solution(N, M, board));
//     }
    
//     public static int[] dx = {1, 0, -1, 0};
//     public static int[] dy = {0, 1, 0, -1};
//     public static int solution(int N, int M, char[][] board){
//         int answer = 0;
//         find_goal(N, M, board, 1, -1, R_x, R_y, B_x, B_y);
//         if(result==Integer.MAX_VALUE || result>=10) return -1;
//         answer = result;
        
//         return answer;
//     }

//     public static int result = Integer.MAX_VALUE;
//     public static void find_goal(int N, int M, char[][] board,int count, int direction, int rx, int ry, int bx, int by){
//         if(count>=10) return;
//         char[][] board2 = new char[N][M];
//         for(int i=0;i<N;i++){
//             for(int j=0;j<M;j++){
//                 board2[i][j] = board[i][j];
//             }
//         }
//         // char[][] board2 = board.clone();

//         int goal_num = 0;
        
//         for(int i=0;i<4;i++){
//             if(i%2==direction%2) continue;
//             int x = rx; int y = ry;
//             int x2 = bx; int y2 = by;
//             System.out.println("dir: "+i+", direction: "+direction+", rx: "+rx+", ry: "+ry);
//             board = board2.clone();
//             while(true){
//                 int nx = x+dx[i];
//                 int ny = y+dy[i];

//                 int nx2 = x2+dx[i];
//                 int ny2 = y2+dy[i];

//                 if(nx<0 || ny<0 || nx>=N || ny>=M) break;
//                 if(nx2<0 || ny2<0 || nx2>=N || ny2>=M) break;

//                 System.out.println("Red: "+board[nx][ny]+", nx: "+nx+", ny: "+ny);
//                 System.out.println("Blue: "+board[nx2][ny2]+", nx2: "+nx2+", ny2: "+ny2);

//                 if(goal_num==1){
//                     if(board[nx2][ny2]=='O') {
//                         x2 = O_x; y2 = O_y;
//                         goal_num=2;
//                         result = Integer.MAX_VALUE;
//                         return;
//                     }
//                 }

//                 // if(board[nx][ny]=='#' && nx-dx[i]==rx && ny-dy[i]==ry){
//                 //     System.out.println("noway cnt++++: "+noway_cnt);
//                 //     break;
//                 // }

//                 if(board[nx2][ny2]=='O') {
//                     x2 = O_x; y2 = O_y;
//                     if(x2==x+dx[i] && y2==y+dy[i]){
//                         result = Integer.MAX_VALUE;
//                         return;
//                     }
//                     break;
//                 }
//                 if(board[nx][ny]=='O'){
//                     R_x = O_x; R_y = O_y;
//                     if(x==x2+dx[i] && y==y2+dy[i]) return;
//                     result = Math.min(result, count);
//                     System.out.println("GOAL!!!!!!!,   count: "+count);
//                     return;
//                 }

//                 if(board[nx][ny]=='#' && board[nx2][ny2]=='#') break;
//                 else if(board[nx][ny]=='#' && board[nx2][ny2]=='R') break;
//                 else if(board[nx][ny]=='B' && board[nx2][ny2]=='#') break;

                
//                 if(board[nx][ny]=='.' || board[nx][ny]=='B'){
//                     board[x][y] = '.';
//                     board[nx][ny] = 'R';
//                     x = nx; y = ny;
//                     if(board[nx2][ny2]=='.' || board[nx2][ny2]=='R'){
//                         board[x2][y2] = '.';
//                         board[nx2][ny2] = 'B';
//                         x2 = nx2; y2 = ny2;
//                     }
//                 }
//                 else if(board[nx2][ny2]=='.' || board[nx2][ny2]=='R'){
//                     board[x2][y2] = '.';
//                     board[nx2][ny2] = 'B';
//                     x2 = nx2; y2 = ny2;
//                 }
//             }
//             if(x==rx && y==ry) continue;
//             if(x2==O_x && y2==O_y) continue;
//             else{
//                 rx = x; ry = y;
//                 bx = x2; by = y2;
//             }
//             System.out.println("rx: "+rx+", ry: "+ry+", bx: "+bx+", by: "+by+", direction: "+i);
//             for(int k=0;k<N;k++){
//                 System.out.println(Arrays.toString(board[k]));
//             }
//             System.out.println();
//             find_goal(N, M, board, count+1, i, rx, ry, bx, by);
//             if(R_x==O_x && R_y==O_y) return;
//         }

//         // System.out.println("noway cnt: "+noway_cnt);
//         return;
//     }
// }

import java.io.*;
import java.util.*;

public class 구슬탈출2 {

    public static int R_x = 0, R_y = 0;
    public static int B_x = 0, B_y = 0;
    public static int O_x = 0, O_y = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = tmp.charAt(j);
                if(board[i][j]=='R'){
                    R_x = i; R_y = j;
                }
                else if(board[i][j]=='B'){
                    B_x = i; B_y = j;
                }
                else if(board[i][j]=='O'){
                    O_x = i; O_y = j;
                }
            }
        }

        System.out.println(solution(N, M, board));
    }
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int solution(int N, int M, char[][] board){
        int answer = 0;
        find_goal(N, M, board, 1, -1, R_x, R_y, B_x, B_y);
        if(result==Integer.MAX_VALUE || result>=10) return -1;
        answer = result;
        
        return answer;
    }

    public static int result = Integer.MAX_VALUE;
    public static void find_goal(int N, int M, char[][] board,int count, int direction, int rx, int ry, int bx, int by){
        if(count>=10) return;
        char[][] board2 = new char[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board2[i][j] = board[i][j];
            }
        }

        for(int i=0;i<4;i++){
            if(i%2==direction%2) continue;
            int x = rx; int y = ry;
            int x2 = bx; int y2 = by;
            board = board2.clone();
            while(true){
                int nx = x+dx[i];
                int ny = y+dy[i];

                int nx2 = x2+dx[i];
                int ny2 = y2+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) break;
                if(nx2<0 || ny2<0 || nx2>=N || ny2>=M) break;

                if(board[nx2][ny2]=='O') {
                    x2 = O_x; y2 = O_y;
                    if(x2==x+dx[i] && y2==y+dy[i]){
                        result = Integer.MAX_VALUE;
                        return;
                    }
                    break;
                }
                if(board[nx][ny]=='O'){
                    R_x = O_x; R_y = O_y;
                    if(x==x2+dx[i] && y==y2+dy[i]) return;
                    result = Math.min(result, count);
                    return;
                }

                if(board[nx][ny]=='#' && board[nx2][ny2]=='#') break;
                else if(board[nx][ny]=='#' && board[nx2][ny2]=='R') break;
                else if(board[nx][ny]=='B' && board[nx2][ny2]=='#') break;

                
                if(board[nx][ny]=='.' || board[nx][ny]=='B'){
                    board[x][y] = '.';
                    board[nx][ny] = 'R';
                    x = nx; y = ny;
                    if(board[nx2][ny2]=='.' || board[nx2][ny2]=='R'){
                        board[x2][y2] = '.';
                        board[nx2][ny2] = 'B';
                        x2 = nx2; y2 = ny2;
                    }
                }
                else if(board[nx2][ny2]=='.' || board[nx2][ny2]=='R'){
                    board[x2][y2] = '.';
                    board[nx2][ny2] = 'B';
                    x2 = nx2; y2 = ny2;
                }
            }
            if(x==rx && y==ry) continue;
            if(x2==O_x && y2==O_y) continue;
            else{
                rx = x; ry = y;
                bx = x2; by = y2;
            }
            find_goal(N, M, board, count+1, i, rx, ry, bx, by);
            if(R_x==O_x && R_y==O_y) return;
        }

        return;
    }
}
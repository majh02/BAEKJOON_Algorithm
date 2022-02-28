//1992번_쿼드트리
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분할정복_1992 {
    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        DAC(0, 0, N, 1);
        System.out.println(sb);
    }

    public static void DAC(int row, int col, int size, int count){
        if(count==0) sb.append("(");
        if(Check_Board(row, col, size)){
            sb.append(board[row][col]);
            return;
        }
        int newsize = size/2;
        DAC(row,col,newsize,0);
        DAC(row,col+newsize,newsize,1);
        DAC(row+newsize,col,newsize,1);
        DAC(row+newsize,col+newsize,newsize,1);
        sb.append(")");
    }

    public static boolean Check_Board(int row, int col, int size){
        int color = board[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(board[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
    
}

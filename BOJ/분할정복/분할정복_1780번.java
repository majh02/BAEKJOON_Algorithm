//1780번_종이의 개수
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_1780번 {
    public static int minusone = 0;
    public static int zero = 0;
    public static int one = 0;
    public static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        DAC(0,0,N);
        System.out.println(minusone+"\n"+zero+"\n"+one);

    }

    public static void DAC(int row, int col, int size){
        if(Check_Board(row, col, size)){
            if(board[row][col]==-1) minusone++;
            else if(board[row][col]==0) zero++;
            else one++;
            return;
        }

        int newsize = size/3;
        DAC(row,col,newsize);
        DAC(row,col+newsize,newsize);
        DAC(row,col+newsize*2,newsize);
        DAC(row+newsize,col,newsize);
        DAC(row+newsize,col+newsize,newsize);
        DAC(row+newsize,col+newsize*2,newsize);
        DAC(row+newsize*2,col,newsize);
        DAC(row+newsize*2,col+newsize,newsize);
        DAC(row+newsize*2,col+newsize*2,newsize);
    }

    public static boolean Check_Board(int row, int col, int size){
        int value = board[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(value!=board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }  
}

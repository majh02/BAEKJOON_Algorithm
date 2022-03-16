//2630번_색종이 만들기
package BOJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_2630{
    public static int white = 0;
    public static int blue = 0;
    public static int[][] confetti;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        confetti = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DAC(0,0,N);
        System.out.println(white+"\n"+blue);

        
    }
    public static void DAC(int row, int col, int size){
        if(colorCheck(row,col,size)){
            if(confetti[row][col]==0) white++;
            else blue++;
            return;
        }

        int newsize = size/2;
        DAC(row,col,newsize);
        DAC(row,col+newsize,newsize);
        DAC(row+newsize,col,newsize);
        DAC(row+newsize,col+newsize,newsize);
    }
    public static boolean colorCheck(int row, int col, int size){
        int color = confetti[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(confetti[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}
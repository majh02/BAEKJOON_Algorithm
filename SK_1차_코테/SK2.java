package SK_1차_코테;

import java.util.Arrays;

public class SK2 {
    public static void main(String args[]){
        int n = 9;
        boolean clockwise = false;

        answer = solution(n, clockwise);
        for(int i=0;i<answer.length;i++){
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    public static int[][] answer;
    public static int[] dir_x = {1, 0, -1, 0};
    public static int[] dir_y = {0, 1, 0, -1};
    public static boolean cw;
    public static int[][] solution(int n, boolean clockwise) {
        answer = new int[n][n];
        cw = clockwise;
        
        whirlpool(n, -1, 0, 0, 1, 0);
        whirlpool(n, n-1, -1, 0, 1, 1);
        whirlpool(n, n, n-1, 0, 1, 2);
        whirlpool(n, 0, n, 0, 1, 3);

        return answer;
    }

    public static void whirlpool(int n, int x, int y, int value, int count, int index){
        int num = n-(2*count)+1;
        if(num<0) return;
        else if(num==0) num = 1;
        
        for(int i=0;i<num;i++){
            x = x+dir_x[index];
            y = y+dir_y[index];
            value++;
            if(cw){
                if(answer[y][x]!=0) break;
                answer[y][x] = value;
            }
            else{
                if(answer[x][y]!=0) break;
                answer[x][y] = value;
            }
        }
        
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(answer[i]));
        // }
        // System.out.println();
        whirlpool(n, x, y, value, count+1, (index+1)%4);
    }
    
}

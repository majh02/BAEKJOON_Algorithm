//14891번_톱니바퀴

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 톱니바퀴 {

    public static int[][] gear;
    public static int[] direction;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        for(int i=0;i<4;i++){
            String pole = br.readLine();
            for(int j=0;j<8;j++){
                gear[i][j] = pole.charAt(j)-'0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] rotate_gear = new int[K];
        int[] rotate_dir = new int[K];
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            rotate_gear[i] = Integer.parseInt(st.nextToken());
            rotate_dir[i] = Integer.parseInt(st.nextToken()); //1(시계방향), -1(반시계방향)
        }

        // direction = new int[4];
        // for(int j=0;j<4;j++){
        //     rotate(j, direction[j]);
        //     System.out.println("dir: "+direction[j]+", gear["+j+"]: "+Arrays.toString(gear[j]));
        // }
        // System.out.println();
        for(int i=0;i<K;i++){
            direction = new int[4];
            int rg = rotate_gear[i]-1;
            int rd = rotate_dir[i];
            direction[rg] = rd;
            solution(rg);

            for(int j=0;j<4;j++){
                rotate(j, direction[j]);
                // System.out.println("dir: "+direction[j]+", gear["+j+"]: "+Arrays.toString(gear[j]));
            }
            // System.out.println();
        }

        int result = 0;
        for(int i=0;i<4;i++){
            // System.out.println(gear[i][0]+", "+Math.pow(gear[i][0]*2,i));
            if(gear[i][0]==0) continue;
            result+=Math.pow(gear[i][0]*2,i);
        }
        System.out.println(result);


    }

    public static void rotate(int gear_num, int dir){
        if(dir==-1){ //반시계방향
            int tmp = gear[gear_num][0];
            for(int i=0;i<7;i++){
                gear[gear_num][i] = gear[gear_num][i+1];
            }
            gear[gear_num][7] = tmp;
        }
        else if(dir==1){ //시계방향
            int tmp = gear[gear_num][7];
            for(int i=7;i>0;i--){
                gear[gear_num][i] = gear[gear_num][i-1];
            }
            gear[gear_num][0] = tmp;
        }
        return;
    }

    public static void solution(int gear_num){
        int dir = direction[gear_num];
        if(dir==2) return;
        
        if(gear_num+1<4 && direction[gear_num+1]==0 && gear[gear_num][2]!=gear[gear_num+1][6]){
            direction[gear_num+1] = dir*-1;
            solution(gear_num+1);
        }
        else if(gear_num+1<4 && direction[gear_num+1]==0 && gear[gear_num][2]==gear[gear_num+1][6]){
            direction[gear_num+1] = 2;
            solution(gear_num+1);
        }

        if(gear_num-1>=0 && direction[gear_num-1]==0 && gear[gear_num][6]!=gear[gear_num-1][2]){
            direction[gear_num-1] = dir*-1;
            solution(gear_num-1);
        }
        else if(gear_num-1>=0 && direction[gear_num-1]==0 && gear[gear_num][6]==gear[gear_num-1][2]){
            direction[gear_num-1] = 2;
            solution(gear_num-1);
        }

        return;
    }

    
}

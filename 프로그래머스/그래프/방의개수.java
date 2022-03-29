//그래프_3번_방의 개수

package 프로그래머스.그래프;

import java.util.ArrayList;

public class 방의개수 {
    public static void main(String args[]){
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.println(solution(arrows));
    }

    public static int solution(int[] arrows) {
        int answer = 0;
        int[][] graph = new int[10000][10000];
        int x = 5000, y = 5000;
        
        int count = 0;
        graph[x][y] = 1;
        for(int arrow : arrows){
            if(arrow==0) y--;
            else if(arrow==1){x++; y--;}
            else if(arrow==2) x++;
            else if(arrow==3){x++; y++;}
            else if(arrow==4) y++;
            else if(arrow==5){x--; y++;}
            else if(arrow==6) x--;
            else if(arrow==7){x--; y--;}

            if(graph[x][y]==1 && count!=0) {
                count = 0;
                answer++;
            }
            else{
                count++;
                graph[x][y] = 1;
            }
        }

        return answer;
    }
    
}

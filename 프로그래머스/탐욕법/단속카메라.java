//탐욕법_6번_단속카메라

package 프로그래머스.탐욕법;

import java.util.*;

public class 단속카메라 {
    public static void main(String args[]){
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        // int[][] routes = {{15,20}, {5,14}, {13,18}, {13,15},{-20,5}};
        System.out.println(solution(routes));
    }
    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        
        int count = 0;
        int min[] = new int[routes.length];
        int max[] = new int[routes.length];
        for(int i=0;i<routes.length;i++){
            int x = routes[i][0];
            int y = routes[i][1];
            if(i==0){
                min[count] = x;
                max[count] = y;
            }
            else{
                boolean flag = false;
                for(int cnt = 0; cnt<=count;cnt++){
                    if(x-min[cnt]>=0 && x-max[cnt]<=0) {
                        min[cnt] = x;
                        flag = true;
                    }
                    if(y-max[cnt]<=0 && y-min[cnt]>=0) {
                        max[cnt] = y;
                        flag = true;
                    }
                    if(flag) break;
                }
                if(!flag){
                    count++;
                    min[count] = x;
                    max[count] = y;
                }
            }
        }

        answer = count+1;
        return answer;
    }
    
}

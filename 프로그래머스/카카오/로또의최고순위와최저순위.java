package 프로그래머스.카카오;

import java.util.*;

public class 로또의최고순위와최저순위 {
    public static void main(String args[]){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);

        int count = 0;
        int zero_count = 0;
        for(int num : lottos){
            if(num==0){
                zero_count++;
                continue;
            }
            for(int win_num : win_nums){
                if(num == win_num){
                    count++;
                }
            }
        }

        answer[0] = 6-(count+zero_count-1);
        if(count+zero_count==0) answer[0] = 6;
        answer[1] = 6-(count-1);
        if(count==0) answer[1] = 6;

        return answer;
    }
    
}

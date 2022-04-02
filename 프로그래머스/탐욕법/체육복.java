//탐욕법_1번_체육복

package 프로그래머스.탐욕법;

import java.util.*;

public class 체육복 {
    public static void main(String args[]){
        int n = 3;
        int[] lost = {1,2};
        int[] reserve = {};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] student = new int[n+1];
        Arrays.fill(student, 1);
        Arrays.sort(lost);

        for(int lost_student : lost){
            student[lost_student]--;
        }
        for(int reserve_student : reserve){
            student[reserve_student]++;
        }

        for(int lost_student : lost){
            int num = lost_student;

            if(student[num]!=0) continue;
            if(num-1>0 && student[num-1]>1){
                student[num-1] = 1;
                student[num] = 1;
            }
            else if(num+1<=n && student[num+1]>1){
                student[num+1] = 1;
                student[num] = 1;
            }
            else answer--;
        }

        return answer;
    }
    
}
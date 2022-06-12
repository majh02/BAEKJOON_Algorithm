package 프로그래머스._다시풀어보기;

import java.util.*;

public class Greedy_체육복 {
    public static void main(String args[]){
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(solution(n, lost, reserve));

    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] student = new int[n+1];
        Arrays.fill(student, 1);

        Arrays.sort(lost);
        for(int l:lost){
            student[l] = 0;
        }
        for(int r: reserve){
            student[r] = 2;
        }

        for(int l : lost){
            if(l==1 && student[l+1]==2){
                student[l]=student[l+1]=1;
            }
            else if(l==n && student[l-1]==2){
                student[l]=student[l-1]=1;
            }
            else if(l!=1 && student[l-1]==2){
                student[l]=student[l-1]=1;
            }
            else if(l!=n && student[l+1]==2){
                student[l]=student[l+1]=1;
            }
            
            if(student[l]==0) answer--;
        }
        return answer;
    }
}
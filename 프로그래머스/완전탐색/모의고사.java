//완전탐색_1번_모의고사
package 프로그래머스.완전탐색;

import java.util.*;

public class 모의고사 {
    public static void main(String args[]){
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        int score_A=0, score_B=0, score_C=0;

        for(int i=0;i<answers.length;i++){
            int Answer = answers[i];
            if(Answer==A[i%A.length]) score_A++;
            if(Answer==B[i%B.length]) score_B++;
            if(Answer==C[i%C.length]) score_C++;
        }

        ArrayList<Integer> answer_arr = new ArrayList<>();
        int max = Math.max(score_A, Math.max(score_B, score_C));
        if(score_A==max) answer_arr.add(1);
        if(score_B==max) answer_arr.add(2);
        if(score_C==max) answer_arr.add(3);

        // HashMap<Integer,Integer> score = new HashMap<>();
        // for(int i=1;i<=3;i++){
        //     score.put(i, 0);
        // }
        // for(int i = 0;i<answers.length;i++){
        //     int Answer = answers[i];
        //     if(Answer==A[i%A.length]){
        //         score.put(1, score.getOrDefault(1, 0)+1);
        //     }
        //     if(Answer==B[i%B.length]){
        //         score.put(2, score.getOrDefault(2, 0)+1);
        //     }
        //     if(Answer==C[i%C.length]){
        //         score.put(3, score.getOrDefault(3, 0)+1);
        //     }
        // }

        // ArrayList<Integer> student = new ArrayList<>(score.keySet());
        // Collections.sort(student, (o1,o2)->(score.get(o2).compareTo(score.get(o1))));
        // System.out.println(score+"\n"+student);

        // ArrayList<Integer> answer_arr = new ArrayList<>();
        // for(int i=0;i<3;i++){
        //     if(i==0) answer_arr.add(student.get(i));
        //     else{
        //         if(score.get(answer_arr.get(0))==score.get(student.get(i))){
        //             answer_arr.add(student.get(i));
        //         }
        //         else break;
        //     }
        // }

        answer = new int[answer_arr.size()];
        for(int i=0;i<answer_arr.size();i++){
            answer[i] = answer_arr.get(i);
        }
        
        return answer;
    }
    
}

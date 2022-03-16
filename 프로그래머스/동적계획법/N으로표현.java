package 프로그래머스.동적계획법;

import java.util.*;

public class N으로표현 {
    public static void main(String args[]){
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));

    }

    public static int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        for(int i=0;i<9;i++){
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);
        System.out.println(dp.get(1));

        for(int i=2;i<9;i++){
            Set<Integer> countSet = dp.get(i);
            for(int j=1;j<i;j++){
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i-j);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        countSet.add(preNum+postNum);
                        countSet.add(preNum-postNum);
                        countSet.add(preNum*postNum);
                        if(preNum!=0 && postNum!=0){
                            countSet.add(preNum/postNum);
                        }
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));

            System.out.println(countSet);
            if(countSet.contains(number)){
                answer = i;
                break;
            }
        }

        if(answer==0) answer=-1;

        return answer;

    }
    
}

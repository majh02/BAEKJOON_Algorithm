//동적계획법_1번_N으로 표현
//https://small-stap.tistory.com/65 참고했음

package 프로그래머스.동적계획법;

import java.util.*;

public class N으로표현 {
    public static void main(String args[]){
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));

    }

    public static int solution(int N, int number) {
        int answer = -1;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        for(int i=0;i<9;i++){
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);

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
            if(countSet.contains(number)){
                break;
            }
        }
        
        for(Set<Integer> sub : dp){
            if(sub.contains(number))
                return dp.indexOf(sub);
        }
        return answer;

    }
    
}

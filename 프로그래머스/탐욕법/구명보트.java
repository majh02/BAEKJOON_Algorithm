//탐욕법_4번_구명보트
//https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java 참고했음

package 프로그래머스.탐욕법;

import java.lang.reflect.Array;
import java.util.*;

public class 구명보트 {
    public static void main(String args[]){
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution2(people, limit));
    }

    public static int solution2(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayList<Integer> p = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            p.add(people[i]);
        }

        while(!p.isEmpty()){
            int weight = p.get(0);
            p.remove(0);
            ArrayList<Integer> index = new ArrayList<>();
            for(int max = p.size()-1;max>=0;max--){
                if(weight+p.get(max)<=limit){
                    weight+=p.get(max);
                    p.remove(max);
                    break;
                }
            }
            answer++;
        }
        return answer;
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
    
        int min = 0;
        for(int max = people.length-1;min<=max;max--){
            if(people[min]+people[max]<=limit) min++;
            answer++;
        }
        return answer;
    }
}

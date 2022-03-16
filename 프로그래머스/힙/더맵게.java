//힙_1번_더 맵게
package 프로그래머스.힙;

import java.util.*;

public class 더맵게 {
    public static void main(String args[]){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int scov : scoville){
            queue.add(scov);
        }

        while(queue.peek()<K){
            if(queue.size()<2){
                answer=-1;
                break;
            }
            int first = queue.poll();
            int second = queue.poll();
            queue.add(first+second*2);
            answer++;
        }
        return answer;
    }
    
}

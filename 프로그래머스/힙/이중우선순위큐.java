//힙_3번_이중우선순위큐

package 프로그래머스.힙;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String args[]){
        String[] operations = {"I 16","D 1"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String str : operations){
            if(str.equals("D 1")){
                if(min_pq.isEmpty() && max_pq.isEmpty()){
                    continue;
                }
                int value = max_pq.poll();
                min_pq.remove(value);
            }
            else if(str.equals("D -1")){
                if(min_pq.isEmpty() && max_pq.isEmpty()){
                    continue;
                }
                int value = min_pq.poll();
                max_pq.remove(value);
            }
            else{
                StringTokenizer st = new StringTokenizer(str, " ");
                st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                min_pq.add(value);
                max_pq.add(value);
            }
        }

        if(min_pq.isEmpty() && max_pq.isEmpty()){
            return answer;
        }
        else{
            answer[0] = max_pq.peek();
            answer[1] = min_pq.peek();
        }
        return answer;
    }
    
}

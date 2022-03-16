//스택큐_2번_프린터
package 프로그래머스.스택큐;

import java.io.*;
import java.util.*;

public class 프린터 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int priorities[] = new int[4];
        for(int i=0;i<priorities.length;i++){
            priorities[i] = Integer.parseInt(br.readLine());
        }
        int location = Integer.parseInt(br.readLine());

        int result = solution(priorities,location);

        System.out.println(result);
    }
    
    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
        }

        int answer = 0;
        while(!queue.isEmpty()){ //큐에서 최대값과 그 인덱스 찾기
            int size = queue.size();
            int max = 0;
            int max_index = -1;
            for(int i=0;i<size;i++){
                if(max<queue.peek()){
                    max = queue.peek();
                    max_index = i;
                }
                queue.add(queue.poll());
            }

            for(int i=0;i<max_index;i++){ //최대 인덱스 만큼 프린터 큐 돌리기
                queue.add(queue.poll());
                if(location==0) location = size-1;
                else location--;
            }
            queue.remove();
            location--;
            answer++;
            if(location==-1) break;
        }
        
        return answer;
    }
}

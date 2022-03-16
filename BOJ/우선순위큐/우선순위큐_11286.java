//11286번_절댓값 힙
//https://dragon-h.tistory.com/5 참고했음
package BOJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 우선순위큐_11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1==abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
            else queue.add(x);
            System.out.println(queue);
        }
        System.out.println(sb);
    }
    
} 

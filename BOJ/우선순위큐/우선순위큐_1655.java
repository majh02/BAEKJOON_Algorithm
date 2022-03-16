//1655번_가운데를 말해요
//https://gh402.tistory.com/32 참고했음
package BOJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 우선순위큐_1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> MinPQ = new PriorityQueue<>();
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(MinPQ.size()==MaxPQ.size()){
                MaxPQ.add(x);
                if(!MinPQ.isEmpty()&&(MaxPQ.peek()>MinPQ.peek())){
                    MinPQ.add(MaxPQ.poll());
                    MaxPQ.add(MinPQ.poll());
                }
            }
            else{
                MinPQ.add(x);
                if(MaxPQ.peek()>MinPQ.peek()){
                    MinPQ.add(MaxPQ.poll());
                    MaxPQ.add(MinPQ.poll());
                }
            }
            sb.append(MaxPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
    
}

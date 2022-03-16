//1927번_최소 힙
package BOJ.우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 우선순위큐_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
            else queue.add(x);
        }
        System.out.println(sb);
    }
    
}

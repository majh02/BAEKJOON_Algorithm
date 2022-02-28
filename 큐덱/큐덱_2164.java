//2164번_카드2
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 큐덱_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        int count=0;
        while(true){
            if(queue.size()==1) break;
            if(count%2==0){
                queue.remove();
            }
            else{
                queue.add(queue.peek());
                queue.remove();
            }
            count++;
        }

        System.out.println(queue.peek());
    }
    
}

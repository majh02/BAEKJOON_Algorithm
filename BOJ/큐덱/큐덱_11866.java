//11866번_요세푸스 문제0
package BOJ.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐덱_11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        int count=1;
        StringBuilder sb = new StringBuilder();
        while(queue.size()>1){
            if(count%K==0){
                if(sb.length()==0) sb.append('<');
                sb.append(queue.poll()).append(", ");
                count=1;
            }
            else{
                queue.add(queue.peek());
                queue.remove();
                count++;
            }
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
    
}

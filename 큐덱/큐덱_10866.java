//10866번_덱
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐덱_10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num=0;

            if(command.equals("push_front")){
                num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }
            else if(command.equals("push_back")){
                num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }
            else if(command.equals("pop_front")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if(command.equals("pop_back")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.pollLast()).append("\n");
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(deque.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(command.equals("front")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.peekFirst()).append("\n");
            }
            else if(command.equals("back")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
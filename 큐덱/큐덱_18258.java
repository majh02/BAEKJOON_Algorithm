//18258번_큐2
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐덱_18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue  = new LinkedList<>();

        String command;
        int num=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            command = st.nextToken();
            if(command.equals("push")){
                num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }
            else if(command.equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else sb.append(queue.poll()).append('\n');
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append('\n');
            }
            else if(command.equals("empty")){
                if(queue.isEmpty()){
                    sb.append(1).append('\n');
                }
                else sb.append(0).append('\n');
            }
            else if(command.equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else sb.append(queue.peek()).append('\n');
            }
            else if(command.equals("back")){
                if(queue.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else sb.append(num).append('\n');
            }
        }

        System.out.println(sb);
    }
}

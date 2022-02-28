//5340번_AC
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐덱_5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            LinkedList<Integer> deque = new LinkedList<>();
            for(int i=0;i<n;i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean R = false;
            for(int i=0;i<p.length();i++){
                String P = p.substring(i,i+1);
                if(P.equals("R")){
                    R = !R;
                }
                else if(P.equals("D")){
                    if(deque.isEmpty()){
                        n=-1;
                        break;
                    }
                    if(R==true){
                        deque.removeLast();
                    }
                    else deque.removeFirst();
                }
            }
            if(n==-1) sb.append("error\n");
            else if (deque.isEmpty()) sb.append("[]\n");
            else if(R==true){
                sb.append('[').append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollLast());
                }
                sb.append(']').append('\n');
            }
            else{
                sb.append('[').append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
                sb.append(']').append('\n');
            }
        }
        System.out.println(sb);
    }
}

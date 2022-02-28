//10828번_스택
package 스택;

import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스택_10828 {
    public static Stack<Integer> stack = new Stack<>(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] result = new int[N];
        int count = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if(command.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            }
            else if(command.equals("pop")){
                if(stack.empty()) result[count] = -1;
                else result[count] = stack.pop();
                count++;
            }
            else if(command.equals("size")){
                result[count] = stack.size();
                count++;
            }
            else if(command.equals("empty")){
                if(stack.empty()) result[count] = 1;
                else result[count] = 0;
                count++;
            }
            else if(command.equals("top")){
                if(stack.empty()) result[count] = -1;
                else result[count] = stack.peek();
                count++;
            }
        }

        for(int i=0;i<count;i++){
            System.out.println(result[i]);
        }
    }
    
}

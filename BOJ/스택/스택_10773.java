//10773번_제로
package BOJ.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i=0;i<K;i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                result-=stack.peek();
                stack.pop();
            }
            else{
                result+=n;
                stack.push(n);
            }
        }
        System.out.println(result);
    }
    
}

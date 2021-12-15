//1874번_스택 수열
package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        for(int i=1;i<=n;i++){
            while(true){
                if(!stack.empty()&&stack.peek()==array[index]){
                    stack.pop(); 
                    index++;
                    System.out.println("-");
                }
                else break;
            }
            stack.push(i);
            System.out.println("+");
        }
    }
}
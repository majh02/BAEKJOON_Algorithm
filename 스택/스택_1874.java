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
        String[] sign = new String[n*3];
        int sign_index = 0;
        for(int i=1;i<=n;i++){
            while(true){
                if(!stack.empty()&&stack.peek()==array[index]){
                    stack.pop();
                    index++;
                    sign[sign_index] = "-";
                    sign_index++;
                }
                else if(!stack.empty()&&stack.peek()>array[index]){
                    index=-1;
                    break;
                }
                else break;
            }
            if(i==n+1||index==-1) break;
            stack.push(i);
            sign[sign_index] = "+";
            sign_index++;
        }

        if(index==-1) {
            System.out.println("NO");
            return;
        }
        else{
            while(true){
                if(stack.peek()==array[index]){
                    sign[sign_index] = "-";
                    sign_index++;
                    index++;
                    stack.pop();
                }
                else{
                    System.out.println("NO");
                    return;
                }
                if(stack.empty()) break;
            }
        }

        for(int j=0;j<sign_index;j++){
            System.out.println(sign[j]);
        }
    }
}
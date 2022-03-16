//9012번_괄호
package BOJ.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] result = new String[T];
        for(int i=0;i<T;i++){
            Stack<Integer> stack = new Stack<>();
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                if(str.substring(j,j+1).equals("(")){
                    stack.push(1);
                }
                else if(str.substring(j,j+1).equals(")")){
                    if(stack.empty()) {
                        result[i] = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(result[i]==null&&stack.size()==0){
                result[i] = "YES";
            }
            else if(stack.size()!=0) result[i] = "NO";
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
}
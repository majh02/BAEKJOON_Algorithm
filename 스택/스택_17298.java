//17298번_오큰수
package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class 스택_17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            stack.clear();
            int NGE = arr[i];
            while(true){
                //System.out.println("size = "+stack.size());
                if(stack.size()==i+1){
                    if(NGE==arr[i]){
                        NGE = -1;
                    }
                    break;
                }
                if(stack.peek()>arr[i]){
                    NGE = stack.peek();
                }
                stack.pop();
            }
            System.out.print(NGE+" ");
        }
    }
}

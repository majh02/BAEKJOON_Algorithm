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
            while(!stack.empty()&&arr[stack.peek()]<arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int v:arr){
            sb.append(v).append(' ');
        }
        System.out.println(sb);
    }
}

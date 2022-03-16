//6549번_히스토그램에서 가장 큰 직사각형
//https://st-lab.tistory.com/255 참고했음
package BOJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class 분할정복_6549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            Stack<Integer> height = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break; //0 입력시 종료

            long[] histogram = new long[n];
            for(int i=0;i<n;i++){
                histogram[i] = Long.parseLong(st.nextToken());
            }
            long max = 0;
            for(int i=0;i<n;i++){
                while((!height.isEmpty())&&histogram[height.peek()]>=histogram[i]){
                    long h = histogram[height.pop()];
                    long w = height.isEmpty()? i:i-1-height.peek();
                    max = Math.max(max, h*w);
                }
                height.push(i);
            }
            while(!height.isEmpty()){
                long h = histogram[height.pop()];
                long w = height.isEmpty() ? n:n-1-height.peek();
                max = Math.max(max, h*w);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

//6549번_히스토그램에서 가장 큰 직사각형 - 미해결
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class 분할정복_6549 {
    public static int n;
    public static Stack<Integer> height;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            height = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            long max = 0;
            long count=0;
            for(int i=0;i<=n;i++){
                long H;
                if(i==n) H=0;
                else H = Long.parseLong(st.nextToken());
                if(height.empty()) height.add(i);
                else if(H>=height.peek()) height.add(i);
                else{
                    count=0;
                    while(!height.empty()){
                        if(height.size()==1){
                            count++;
                            count*=height.peek();
                            height.pop();
                            break;
                        }
                        height.pop();
                        count++;
                    }
                    if(max==0) max=count;
                    else if(max<count) max = count;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

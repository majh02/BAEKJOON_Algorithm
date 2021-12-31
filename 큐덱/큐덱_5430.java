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
            String P = br.readLine();
            String[] p_arr = new String[P.length()];
            for(int i=0;i<P.length();i++){
                p_arr[i] = P.substring(i,i+1);
            }
            
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> deque = new LinkedList<>();
            String arr = br.readLine();
            if(n==0){
                sb.append("error"); continue;
            }

            int k=1;
            while(k<arr.length()){
                int num = Integer.parseInt(arr.substring(k, k+1));
                deque.addLast(num);
                if(deque.size()==n) break;
                else k+=2;
            }

            for(int i=0;i<p_arr.length;i++){
                if(p_arr[i].equals("R")){
                    for(int j=0;j<deque.size();j++){
                        int index = j;
                        deque.addFirst(deque.get(index*2));
                    }
                    for(int j=0;j<deque.size()/2;j++){
                        deque.removeLast();
                    }
                }
                else if(p_arr[i].equals("D")){
                    if(deque.isEmpty()){
                        n=-1;
                        break;
                    }
                    deque.removeFirst();
                }
            }
            if(n==-1) sb.append("error\n");
            else sb.append(deque).append("\n");
            deque.clear();
        }
        System.out.println(sb);
    }
}

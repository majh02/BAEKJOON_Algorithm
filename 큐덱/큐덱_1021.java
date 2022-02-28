//1021번_회전하는 큐
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐덱_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1;i<=N;i++){
            deque.add(i);
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());  
        }

        int n=0;
        int count=0;
        while(n<M){
            int i,j;
            for(i=0,j=deque.size()-1;i<deque.size();i++,j--){
                if(deque.get(i)==arr[n]){
                    j=-1;
                    break;
                }
                else if(deque.get(j)==arr[n]){
                    i=-1;
                    break;
                }
            }

            if(j<0){
                while(true){
                    if(deque.getFirst()==arr[n]){
                        deque.remove();
                        n++;
                        break;
                    }
                    else{
                        deque.addLast(deque.pollFirst());
                        count++;
                    }
                }
            }
            else{
                while(true){
                    if(deque.getFirst()==arr[n]){
                        deque.remove();
                        n++;
                        break;
                    }
                    else{
                        deque.addFirst(deque.pollLast());
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    
}

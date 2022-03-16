//1966번_프린터 큐
package BOJ.큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐덱_1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, doc;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            doc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> queue = new LinkedList<>();
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }

            int count=0;
            while(!queue.isEmpty()){
                int index=doc;
                for(int k=0;k<queue.size();k++){
                    if(queue.get(index)<queue.get(k)){
                        index=k;
                    }
                }
                if(index!=doc){
                    for(int n=0;n<index;n++){
                        queue.add(queue.poll());
                        if(doc==0) doc = queue.size()-1;
                        else doc--;
                    }
                    queue.remove();
                    count++;
                    if(doc==0) doc = queue.size()-1;
                    else doc--;
                }
                else{
                    int value = queue.get(doc);
                    for(int n=0;n<=doc;n++){
                        if(queue.peek()<value){
                            queue.add(queue.poll());
                        }
                        else{
                            queue.remove();
                            count++;
                        }
                    }
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
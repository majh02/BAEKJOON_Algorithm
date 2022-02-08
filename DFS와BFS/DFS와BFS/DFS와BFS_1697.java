//1697번_숨바꼭질
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1697 {
    public static int N, K;
    public static int sec[];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sec = new int[K*2];
        queue.add(N);
        BFS();

        System.out.println(sec[K]);
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current>K){
                if(current-1>=N){
                    queue.add(current-1);
                    sec[current-1] = sec[current]+1;
                }
            }
            else{
                if(Math.abs(K-current*2)<Math.abs(K-current+1)){
                    queue.add(current*2);
                    sec[current*2] = sec[current]+1;
                }
                else if(current+1<=K){
                    queue.add(current+1);
                    sec[current+1] = sec[current]+1;
                }
            }
            System.out.println(Arrays.toString(sec));
        }
    }
    
}

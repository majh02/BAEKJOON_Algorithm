//15591번_MooTube(Silver)
package 직접코테광탈하면서모은문제들;

import java.io.*;
import java.util.*;

public class MooTube {
    public static ArrayList<int[]>[] video;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        video = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            video[i] = new ArrayList<int[]>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            video[p].add(new int[]{q,r});
            video[q].add(new int[]{p,r});
        }

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            int count = 0;
            boolean[] visited = new boolean[N+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            while(!queue.isEmpty()){
                int current = queue.poll();
                visited[current] = true;

                for(int[] next : video[current]){
                    int nv = next[0]; //next video
                    int value_nv = next[1]; //value of next video

                    if(!visited[nv] && value_nv>=k){
                        queue.add(nv);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}

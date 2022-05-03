//9205번_맥주 마시면서 걸어가기
package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class 맥주마시면서걸어가기 {
    public static int[] home, fest;
    public static int[][] conv;
    public static boolean[] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int T=0;T<t;T++){
            int n = Integer.parseInt(br.readLine());
            home = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            conv = new int[n][2];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine(), " ");
                conv[i][0] = Integer.parseInt(st.nextToken());
                conv[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(conv, (o1, o2)->{
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            });

            fest = new int[2];
            st = new StringTokenizer(br.readLine(), " ");
            fest[0] = Integer.parseInt(st.nextToken());
            fest[1] = Integer.parseInt(st.nextToken());

            boolean flag = bfs(n);
            if(flag) sb.append("happy\n");
            else sb.append("sad\n");
        }
        System.out.print(sb);
    }

    public static boolean bfs(int n){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(home);
        
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];

            if(Math.abs(x-fest[0])+Math.abs(y-fest[1])<=1000) return true;
            for(int i=0;i<n;i++){
                int cx = conv[i][0];
                int cy = conv[i][1];
                if(!visited[i] && Math.abs(x-cx)+Math.abs(y-cy)<=1000){
                    visited[i] = true;
                    queue.add(conv[i]);
                }
            }
        }
        return false;
    }
}

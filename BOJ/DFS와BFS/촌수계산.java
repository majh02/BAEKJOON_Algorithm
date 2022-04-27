//2644번_촌수계산

package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] people = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            people[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[x].add(y);
            people[y].add(x);
        }

        int result =bfs(n, a,  b, people);
        System.out.println(result);
    }

    public static int bfs(int n, int a, int b, ArrayList<Integer>[] people){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.add(new int[]{a, 0});
        visited[a] = true;
        while(!queue.isEmpty()){
            int[] person = queue.poll();
            int p = person[0];
            int p_num = person[1];

            if(p==b) return p_num;
            for(int P : people[p]){
                if(!visited[P]){
                    visited[P] = true;
                    queue.add(new int[]{P, p_num+1});
                }
            }
        }

        return -1;
    }
    
}

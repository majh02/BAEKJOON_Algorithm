//5014번_스타트링크

package BOJ.DFS와BFS;

import java.io.*;
import java.util.*;

public class 스타트링크 {
    public static int F, G, S, U, D;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken()); //건물의 층수
        S = Integer.parseInt(st.nextToken()); //강호가 현재 있는 층
        G = Integer.parseInt(st.nextToken()); //스타트링크가 있는 층
        U = Integer.parseInt(st.nextToken()); //위로 U층을 가는 버튼
        D = Integer.parseInt(st.nextToken()); //아래로 D층을 가는 버튼

        System.out.println(bfs());
    }

    public static String bfs(){
        Queue<Integer> queue = new LinkedList<>();
        int[] move = new int[F+1];
        queue.add(S);
        move[S] = 1;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current==G) return String.valueOf(move[current]-1);
            
            if(current+U<=F && move[current+U]==0){
                move[current+U] = move[current]+1;
                queue.add(current+U);
            }
            if(current-D>0 && move[current-D]==0){
                move[current-D] = move[current]+1;
                queue.add(current-D);
            }
        }

        return "use the stairs";
    }

    // public static int count = 0;
    // public static void dfs(boolean[] visited, int current, int cnt){
    //     if(current>F || current<=0) return;
    //     if(count!=0) return;
    //     if(current == G) {
    //         count = cnt;
    //         return;
    //     }

    //     if(!visited[current]){
    //         visited[current] = true;
    //         dfs(visited, current+U, cnt+1);
    //         if(count!=0) return;
    //         dfs(visited, current-D, cnt+1);
    //         if(count!=0) return;
    //         visited[current] = false;
    //     }

    //     return;
    // }
    
}

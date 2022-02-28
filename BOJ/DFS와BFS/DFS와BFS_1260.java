//1260번_DFS와 BFS
//https://m.blog.naver.com/lm040466/221787478911 참고했음
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260{
    public static int N, M, V;
    public static int[][] check = new int[1001][1001];
    public static boolean visited[] = new boolean[1001];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = 1;
        }

        DFS(V);
        sb.append("\n");

        visited = new boolean[1001];
        BFS();

        // visited[V] = true;
        // sb.append(V+" ");
        // DFS(V,1);

        // visited = new boolean[1001];
        // visited[V] = true;
        // sb.append("\n"+V+" ");
        // BFS(V,1);

        System.out.println(sb);
    }

    public static void DFS(int p){
        visited[p] = true;
        sb.append(p+" ");

        for(int i=1;i<=N;i++){
            if(check[p][i]==1&&visited[i]==false){
                DFS(i);
            }
        }
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        sb.append(V+" ");

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            for(int i=1;i<=N;i++){
                if(check[tmp][i]==1&&visited[i]==false){
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i+" ");
                }
            }
        }
    }

    // public static void DFS(int value, int count){
    //     if(count==N) return;
    //     int START=Integer.MAX_VALUE;
    //     int END = Integer.MAX_VALUE;
    //     for(int i=1;i<=M;i++){
    //         if(start[i]==value){
    //             if(visited[end[i]]) continue;
    //             START = value;
    //             if(end[i]<END) END = end[i];
    //         }
    //         else if(end[i]==value&&START!=value){
    //             if(visited[start[i]]) continue;
    //             END = value;
    //             if(start[i]<START) START = start[i];
    //         }
    //     }

    //     if(START==value){
    //         if(!visited[END]){
    //             visited[END] = true;
    //             sb.append(END+" ");
    //             DFS(END, count+1);
    //         }
    //     }
    //     else if(END==value){
    //         if(!visited[START]){
    //             visited[START] = true;
    //             sb.append(START+" ");
    //             DFS(START, count+1);
    //         }
    //     }
    // }

    // public static void BFS(int value, int count){
    //     if(count==N) return;
    //     int START=Integer.MAX_VALUE;
    //     int END = Integer.MAX_VALUE;
    //     int value2 = Integer.MAX_VALUE;
    //     for(int i=1;i<=M;i++){
    //         if(start[i]==value){
    //             if(visited[end[i]]) {
    //                 if(end[i]<value2)
    //                     value2 = end[i];
    //                 continue;
    //             }
    //             START = value;
    //             if(end[i]<END) END = end[i];
    //         }
    //         else if(end[i]==value&&START!=value){
    //             if(visited[start[i]]){
    //                 if(start[i]<value2)
    //                     value2 = start[i];
    //                 continue;
    //             }
    //             END = value;
    //             if(start[i]<START) START = start[i];
    //         }
    //     }
    //     if(START!=value&&END!=value){
    //         if(visited[value]&&visited[value2]) return;
    //         BFS(value2,count);
    //     }

    //     if(START==value){
    //         if(!visited[END]){
    //             visited[END] = true;
    //             sb.append(END+" ");
    //             BFS(value, count+1);
    //         }
    //     }
    //     else if(END==value){
    //         if(!visited[START]){
    //             visited[START] = true;
    //             sb.append(START+" ");
    //             BFS(value, count+1);
    //         }
    //     }
    // }
}
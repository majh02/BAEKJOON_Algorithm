//1012번_유기농 배추
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1012 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int M, N, K;
    public static boolean[][] location;
    public static boolean[][] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            location = new boolean[N][M];
            visited = new boolean[N][M];
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                location[x][y] = true;
            }

            int count = 0;
            for(int a=0;a<N;a++){
                for(int b=0;b<M;b++){
                    if(location[a][b]&&!visited[a][b]){
                        count++;
                        // DFS(a, b);
                        BFS(a, b);
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y){
        
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0&&ny>=0&&nx<N&&ny<M){
                if(location[nx][ny]&&!visited[nx][ny]){
                    DFS(nx,ny);
                }
            }
        }
        return;
    }

    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int Y = queue.peek()[1];
            queue.poll();

            for(int i=0;i<4;i++){
                int nx = X+dx[i];
                int ny = Y+dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M){
                    if(location[nx][ny]&&!visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        BFS(nx,ny);
                    }
                }
            }
        }
        return;
    }
    
}

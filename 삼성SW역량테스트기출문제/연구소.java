//14502번_연구소
//https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java 참고했음

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 연구소 {
    public static ArrayList<int[]> virus;
    public static int result = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        virus = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) virus.add(new int[]{i, j});
            }
        }

        dfs(N, M, map, 0);
        System.out.println(result);
    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int count = 0;
    public static void dfs(int N, int M, int[][] map, int depth){

        if(count==3) {
            bfs(N, M, map);
            return;
        }
        for(int i=depth;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    count++;
                    dfs(N, M, map, i);
                    map[i][j] = 0;
                    count--;
                }
            }
        }
    }

    public static void bfs(int N, int M, int[][] map){
        int[][] virus_map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                virus_map[i][j] = map[i][j];
            }
        }

        for(int i=0;i<virus.size();i++){
            int[] v = virus.get(i);
            queue.add(new int[]{v[0], v[1]});
        }

        while(!queue.isEmpty()){
            int[] v = queue.poll();

            for(int i=0;i<4;i++){
                int nx = v[0]+dx[i];
                int ny = v[1]+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(virus_map[nx][ny]==0){
                    virus_map[nx][ny] = 2;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        
        int safezone = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(virus_map[i][j]==0){
                    safezone++;
                }
            }
        }

        result = Math.max(result, safezone);   
    }
}

//15683번_감시

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 감시 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        ArrayList<int[]> cctv = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>=1 && map[i][j]<=5) cctv.add(new int[]{i,j});
            }
        }
        Collections.sort(cctv, (o1, o2)->map[o1[0]][o1[1]]-map[o2[0]][o2[1]]);
        
        //1번(한쪽), 2번(왼,오), 3번(위,오), 4번(위,왼,오), 5번(위,아래,왼,오)
        //0(빈칸), 1~5(CCTV), 6(벽)
        boolean[][] visited = new boolean[N][M];
        CCTV(N, M, map, visited, cctv, 0);
        if(min==Integer.MAX_VALUE){
            min = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]==0) min++;
                }
            }
        }
        System.out.println(min);

    }

    public static int min = Integer.MAX_VALUE;
    public static void CCTV(int N, int M, int[][] map, boolean[][] visited, ArrayList<int[]> cctv, int index){
        if(index==cctv.size()) {
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]==0) count++;
                }
            }

            min = Math.min(min, count);
            return;
        }
        int x = cctv.get(index)[0];
        int y = cctv.get(index)[1];
        visited[x][y] = true;
        ArrayList<int[]>[] direction = find_dir(map[x][y]);
        
        for(int i=0;i<direction.length;i++){
            boolean[][] visited_copy = new boolean[N][M];
            for(int a=0;a<N;a++){
                for(int b=0;b<M;b++){
                    visited_copy[a][b] = visited[a][b];
                }
            }

            for(int j=0;j<direction[i].size();j++){
                int dx = direction[i].get(j)[0];
                int dy = direction[i].get(j)[1];
                int nx = x+dx;
                int ny = y+dy;
            
                while(true){
                    if(nx<0 || ny<0 || nx>=N || ny>=M) break;
                    if(map[nx][ny]==6) break;
                    visited_copy[nx][ny] = true;
                    nx+=dx; ny+=dy;
                }
            }
            CCTV(N, M, map, visited_copy, cctv, index+1);
        }
        return;
    }

    public static ArrayList<int[]>[] find_dir(int cctv_num){
        ArrayList<int[]>[] direction;
        
        if(cctv_num==1){
            direction = new ArrayList[4];
            for(int i=0;i<4;i++){
                direction[i] = new ArrayList<>();
            }
            direction[0].add(new int[]{-1, 0});
            direction[1].add(new int[]{0, 1});
            direction[2].add(new int[]{1, 0});
            direction[3].add(new int[]{0, -1});  
        }
        else if(cctv_num==2){
            direction = new ArrayList[2];
            for(int i=0;i<2;i++){
                direction[i] = new ArrayList<>();
            }
            direction[0].add(new int[]{0, -1});
            direction[0].add(new int[]{0, 1});
            direction[1].add(new int[]{1, 0});
            direction[1].add(new int[]{-1, 0});
        }
        else if(cctv_num==3){
            direction = new ArrayList[4];
            for(int i=0;i<4;i++){
                direction[i] = new ArrayList<>();
            }
            direction[0].add(new int[]{-1, 0});
            direction[0].add(new int[]{0, 1});
            direction[1].add(new int[]{0, 1});
            direction[1].add(new int[]{1, 0});
            direction[2].add(new int[]{1, 0});
            direction[2].add(new int[]{0, -1});
            direction[3].add(new int[]{0, -1});
            direction[3].add(new int[]{-1, 0});
        }
        else if(cctv_num==4){
            direction = new ArrayList[4];
            for(int i=0;i<4;i++){
                direction[i] = new ArrayList<>();
            }
            direction[0].add(new int[]{0, -1});
            direction[0].add(new int[]{-1, 0});
            direction[0].add(new int[]{0, 1});
            direction[1].add(new int[]{-1, 0});
            direction[1].add(new int[]{0, 1});
            direction[1].add(new int[]{1, 0});
            direction[2].add(new int[]{0, 1});
            direction[2].add(new int[]{1, 0});
            direction[2].add(new int[]{0, -1});
            direction[3].add(new int[]{1, 0});
            direction[3].add(new int[]{0, -1});
            direction[3].add(new int[]{-1, 0});
        }
        else{
            direction = new ArrayList[1];
            direction[0] = new ArrayList<>();
            direction[0].add(new int[]{-1, 0});
            direction[0].add(new int[]{0, 1});
            direction[0].add(new int[]{1, 0});
            direction[0].add(new int[]{0, -1});
        }

        return direction;
    }
    
}

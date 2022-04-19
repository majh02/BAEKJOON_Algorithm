//15685번_드래곤 커브

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.security.Key;
import java.util.*;

public class 드래곤커브 {
    public static boolean[][] visited;
    public static ArrayList<int[]> total_xy;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dc = new int[N][4]; //x, y, d, g
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<4;j++){
                dc[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[101][101];
        total_xy = new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> dir = new ArrayList<>();
            int x = dc[i][0], y = dc[i][1];
            dragon_curb(N, dc[i], dir, y, x, 0);
            // System.out.println(dir);
        }

        // for(int i=0;i<total_xy.size();i++){
        //     System.out.println(Arrays.toString(total_xy.get(i)));
        // }
        // System.out.println(total_xy);

        int count = 0;
        for(int[] xy : total_xy){
            int x = xy[0];
            int y = xy[1];
            if(visited[x][y]){
                if(x+1>100 || y+1>100) continue;
                if(visited[x+1][y] && visited[x][y+1] && visited[x+1][y+1]) count++;
            }
        }
        System.out.println(count);
        
        
    }

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static void dragon_curb(int N, int[] dc, ArrayList<Integer> dir, int x, int y, int g){
        if(g>dc[3]) return;
        int nx = x, ny = y;
        if(g==0){
            if(!visited[x][y]){
                visited[x][y] = true;
                total_xy.add(new int[]{x,y});
            }
            dir.add(dc[2]);
            nx += dx[dc[2]]; ny += dy[dc[2]];
            if(nx>=0 && ny>=0 && nx<=100 && ny<=100){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    total_xy.add(new int[]{nx, ny});
                }
            }
        }
        else{
            int length = dir.size()-1;
            for(int i=length;i>=0;i--){
                int nd = dir.get(i)+1==4 ? 0 : dir.get(i)+1;
                dir.add(nd);
                nx += dx[nd]; ny += dy[nd];
                if(nx>=0 && ny>=0 && nx<=100 && ny<=100){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        total_xy.add(new int[]{nx, ny});
                    }
                }
            }
        }
        dragon_curb(N, dc, dir, nx, ny, g+1);

        return;
    }
    
}

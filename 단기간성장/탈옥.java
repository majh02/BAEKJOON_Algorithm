//9376번_탈옥
package 단기간성장;

import java.io.*;
import java.util.*;

public class 탈옥 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int T=0;T<t;T++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];
            ArrayList<int[]> thief = new ArrayList<>();
            for(int i=0;i<h;i++){
                String tmp = br.readLine();
                for(int j=0;j<w;j++){
                    if(tmp.charAt(j)=='.') map[i][j] = 0;
                    else if(tmp.charAt(j)=='*') map[i][j] = -1;
                    else if(tmp.charAt(j)=='#') map[i][j] = -2;
                    else if(tmp.charAt(j)=='$'){
                        map[i][j] = 0;
                        thief.add(new int[]{i,j});
                    }
                }
            }

            boolean[][] visited = new boolean[h][w];
            // boolean[][] opened = new boolean[h][w];
            DFS(map, visited, h, w, thief.get(0)[0], thief.get(0)[1], 0);
            
            for(int i=0;i<h;i++){
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println("\nmin:"+min);
            min = Integer.MAX_VALUE;
            visited = new boolean[h][w];
            for(int[] point : end){
                int x = point[0];
                int y = point[1];
            }
            DFS(map, visited, h, w, thief.get(1)[0], thief.get(1)[1], 0);
            for(int i=0;i<h;i++){
                System.out.println(Arrays.toString(map[i]));
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<int[]> end = new ArrayList<>();
    public static boolean DFS(int[][] map, boolean[][] visited, int h, int w, int x, int y, int count){
        if(x==0 || x==h-1 || y==0 || y==w-1){
            end.add(new int[]{x,y});
            return true;
        }

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
            if(!visited[nx][ny] && map[nx][ny]!=-1){
                boolean flag = false;
                visited[nx][ny] = true;
                if(map[nx][ny]==0){
                    flag = DFS(map, visited, h, w, nx, ny, count);
                }
                else{
                    if(map[nx][ny]<0) map[nx][ny] = count+1;
                    else map[nx][ny] = Math.min(map[nx][ny], count+1);
                    System.out.println("x: "+nx+", y: "+ny+", count: "+(count+1));
                    flag = DFS(map, visited, h, w, nx, ny, count+1);
                    System.out.println("flag: "+flag);
                }
                visited[nx][ny] = false;
            }
        }

        return false;
    }

    public static void DFS2(int[][] map, boolean[][] visited, int x, int y, int end_x, int end_y, int h, int w, int cnt){
        if(x==0 || y==0 || x==h-1 || y==w-1){
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=h  || ny>=w) continue;
            if(!visited[nx][ny] && map[nx][ny]!=-1){
                if(map[nx][ny]==0){
                    DFS2(map, visited, x, y, end_x, end_y, h, w, cnt);
                }
                else{
                    if(map[nx][ny]==cnt-1){
                        DFS2(map, visited, nx, ny, end_x, end_y, h, w, cnt-1);
                    }
                    else{

                    }
                }
            }
        }
    }





    public static int BFS(int[][] map, int h, int w, ArrayList<int[]> thief){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited1 = new boolean[h][w];
        boolean[][] visited2 = new boolean[h][w];
        int x1 = thief.get(0)[0]; int y1 = thief.get(0)[1];
        int x2 = thief.get(1)[0]; int y2 = thief.get(1)[1];
        queue.add(new int[]{x1,y1,x2,y2,0});
        visited1[x1][y1] = true;
        visited2[x2][y2] = true;
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            x1 = tmp[0]; y1 = tmp[1];
            x2 = tmp[2]; y2 = tmp[3];
            int count = tmp[4];
            // System.out.println("x: "+x+", y: "+y+", count: "+count);

            if((x1==0 || x1==h-1 || y1==0 || y1==w-1) && (x2==0 || x2==h-1 || y2==0 || y2==w-1)){
                min = Math.min(count, min);
                // System.out.println("");
                continue;
            }
            for(int i=0;i<4;i++){
                int nx1 = x1+dx[i];
                int ny1 = y1+dy[i];
                if(nx1<0 || ny1<0 || nx1>=h || ny1>=w) continue;

                boolean flag = false;
                int count_tmp  = count;
                if(!visited1[nx1][ny1] && map[nx1][ny1]!=1){
                    flag = true;
                    visited1[nx1][ny1] = true;
                    if(map[nx1][ny1]==2){
                        map[nx1][ny1] = 0;
                        count_tmp++;
                    }
                }

                int nx2 = x2+dx[i];
                int ny2 = y2+dy[i];
                if(nx2<0 || ny2<0 || nx2>=h || ny2>=w) continue;


            }
        }

        return min;
    }
    
}

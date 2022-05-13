//18500번_미네랄2
package 직접코테광탈하면서모은문제들;

import java.awt.*;
import java.io.*;
import java.util.*;

public class 미네랄2{
    public static int R, C;
    public static char[][] cave;
    public static boolean[][] visited;
    public static ArrayList<Point> cluster;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new char[R][C];
        visited = new boolean[R][C];
        cluster = new ArrayList<>();
        for(int i=0;i<R;i++){
            String tmp = br.readLine();
            for(int j=0;j<C;j++){
                cave[i][j]=tmp.charAt(j);
            }
        }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int t=0;t<T;t++){
            int h = R-Integer.parseInt(st.nextToken());
            Point target = null;

            if(t%2==0){
                for(int y=0;y<C;y++){
                    if(cave[h][y]=='.') continue;

                    cave[h][y]='.';
                    target = new Point(h, y);
                    break;
                }
            }
            else{
                for(int y=C-1;y>=0;y--){
                    if(cave[h][y]=='.') continue;

                    cave[h][y]='.';
                    target = new Point(h, y);
                    break;
                }
            }

            if(target==null) continue;
            findCluster(target);
        }

        for(int i=0;i<R;i++){
            System.out.println(cave[i]);
        }
    }

    public static void findCluster(Point target){
        for(int d=0;d<4;d++){
            cluster.clear();
            
            Point next = new Point(target.x+dx[d], target.y+dy[d]);
            
            if(!check(next.x, next.y)) continue;

            if(cave[next.x][next.y]=='x'){
                Queue<Point> queue = new LinkedList<>();
                for(int i=0;i<R;i++){
                    Arrays.fill(visited[i], false);
                }

                queue.add(next);
                visited[next.x][next.y] = true;
                cluster.add(next);

                while(!queue.isEmpty()){
                    Point now = queue.poll();

                    if(now.x==R-1){
                        cluster.clear();
                        break;
                    }
                    
                    for(int dd=0;dd<4;dd++){
                        int nx = now.x+dx[dd];
                        int ny = now.y+dy[dd];

                        if(!check(nx, ny) || visited[nx][ny] || cave[nx][ny]=='.') continue;

                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                        cluster.add(new Point(nx, ny));
                    }

                    if(!cluster.isEmpty()) down();
                }
            }
        }
    }

    public static void down(){
        while(true){
            boolean bottom = false;

            for(Point p : cluster){
                if(p.x==R-1 || (p.x+1<=R-1 && cave[p.x+1][p.y]=='x' && !cluster.contains(new Point(p.x+1, p.y)))){
                    bottom = true;
                }
            }

            if(bottom) break;

            for(Point p : cluster){
                cave[p.x][p.y] = '.';
            }

            for(Point p : cluster){
                cave[p.x+1][p.y] = 'x';
                p.x++;
            }
        }
    }

    public static boolean check(int x, int y){
        if(x<0 || y<0 || x>=R || y>=C) return false;
        return true;
    }
} 
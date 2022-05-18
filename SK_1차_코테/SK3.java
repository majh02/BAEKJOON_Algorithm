package SK_1차_코테;

import java.math.BigInteger;
import java.util.*;

public class SK3 {
    public static int width, height;
    public static void main(String args[]){
        width = 51;
        height = 37;
        int[][] diagonals = {{17,19}};
        System.out.println(solution(width, height, diagonals));
    }

    public static int max = Integer.MAX_VALUE;
    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        BigInteger dp[][] = new BigInteger[height+2][width+2];
        long dist[][] = new long[height+2][width+2];
        for(int i=0;i<=height+1;i++){
            Arrays.fill(dist[i], max);
        }
        dp[1][1] = BigInteger.valueOf((long)1);
        dist[1][1] = 0;
        for(int i=1;i<=height+1;i++){
            for(int j=1;j<=width+1;j++){
                if(dp[i][j]!=BigInteger.valueOf((long)0)) continue;
                dist[i][j] = Math.min(dist[i-1][j], dist[i][j-1])+1;
                if(dist[i][j]==dist[i-1][j]+1){
                    dp[i][j] = dp[i][j].add(dp[i-1][j]);
                }
                if(dist[i][j]==dist[i][j-1]+1){
                    dp[i][j] = dp[i][j].add(dp[i][j-1]);
                }
                // dp[i][j]%=10000019;
            }
        }

        for(int i=1;i<=height+1;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        long result = dp[height+1][width+1].longValue();
        for(int[] diag : diagonals){
            long tmp = dp[diag[1]+1][diag[0]+1].longValue();
            answer+=dp[diag[1]][diag[0]+1].longValue() * (result/tmp)%10000019;
            answer+=dp[diag[1]+1][diag[0]].longValue() * (result/tmp)%10000019;
        }

        // for(int[] diag : diagonals){
        //     int x = height-diag[0];
        //     int y = diag[1]-1;
        //     visited = new boolean[height+1][width+1];
        //     dfs(2, 0, 2, 0, x, y);
        //     System.out.println();
        //     dfs(x+1, y+1, x+1, y+1, 0, width);
        //     answer+=dp[2][0][x][y]*dp[x+1][y+1][0][width]%10000019;
        //     System.out.println(dp[2][0][x][y]+", "+dp[x+1][y+1][0][width]);

        //     System.out.println();
        //     dfs(2, 0, 2, 0, x+1, y+1);
        //     System.out.println();
        //     dfs(x, y, x, y, 0, width);
        //     answer+=dp[2][0][x+1][y+1]*dp[x][y][0][width]%10000019;
        //     System.out.println(dp[2][0][x+1][y+1]+", "+dp[x][y][0][width]);
        // }

        return answer;
    }

    // public static int[] dx = {0, -1};
    // public static int[] dy = {1, 0};
    // public static int count = 0;
    // public static void dfs(int x, int y, int sx, int sy, int gx, int gy){
    //     if(x<0 || y<0 || x>height || y>width) return;
    //     if(visited[x][y]) return;

    //     dp[sx][sy][x][y]++;
    //     if(x==gx && y==gy){
    //         System.out.println("arrived");
    //         return;
    //     }

    //     for(int i=0;i<2;i++){
    //         int nx = x+dx[i];
    //         int ny = y+dy[i];
    //         if(nx<0 || ny<0 || nx>height || ny>width) continue;
    //         dp[sx][sy][nx][ny] += dp[sx][sy][x][y];
    //         // visited[nx][ny] = true;
    //         dfs(nx, ny, sx, sy, gx, gy);
    //         dp[sx][sy][nx][ny] -= dp[sx][sy][x][y];
    //         visited[nx][ny] = false;
    //     }
    // }

    // public static int[] x_direction = {0, 1};
    // public static int[] y_direction = {-1, 0};
    // public static int[][][] dp;
    // public static boolean[][] visited;
    // public static int answer;
    // public static int solution(int width, int height, int[][] diagonals) {
    //     answer = 0;
    //     dp = new int[2][width+1][height+1];
    //     visited = new boolean[width+1][height+1];
    //     // BFS(width, height, diagonals);
    //     DFS(width, height, diagonals, 0, height, 0);
    //     return answer;
    // }

    // public static void DFS(int width, int height, int[][] diagonals, int x, int y, int count){
    //     if(x==width && y==0){
    //         if(count==0) return;
    //         System.out.println("count: "+count);
    //         answer=(answer+1)%10000019;
    //         // for(int i=0;i<visited.length;i++){
    //         //     System.out.println(Arrays.toString(visited[i]));
    //         // }
    //         return;
    //     }

    //     visited[x][y] = true;
    //     // System.out.println("");

    //     if(count==0){
    //         for(int j=0;j<diagonals.length;j++){
    //             int cx = diagonals[j][0];
    //             int cy = diagonals[j][1];
    //             if(cx<0 || cy<0 || cx>width || cy>height) continue;
    //             if(x==cx-1 && y==height-cy){
    //                 if(x+1>width || y+1>height) continue;
    //                 // visited[x+1][y+1] = true;
    //                 DFS(width, height, diagonals, x+1, y+1, 1);
    //                 visited[x+1][y+1] = false;
    //                 break;
    //             }
    //             else if(x==cx && y==height-cy+1){
    //                 if(x-1<0 || y-1<0) continue;
    //                 // visited[x-1][y-1] = true;
    //                 DFS(width, height, diagonals, x-1, y-1, 1);
    //                 visited[x-1][y-1] = false;
    //                 break;
    //             }
    //         }
    //     }

    //     for(int i=0;i<2;i++){
    //         int nx = x+x_direction[i];
    //         int ny = y+y_direction[i];
    //         if(nx<0 || ny<0 || nx > width || ny>height) continue;
    //         if(!visited[nx][ny]){
    //             visited[nx][ny] = true;
    //             DFS(width, height, diagonals, nx, ny, count);
    //             visited[nx][ny] = false;
    //         }
    //     }
    // }

    // public static void BFS(int width, int height, int[][] diagonals){
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.add(new int[]{0,height,0});
    //     visited[0][height] = true;

    //     while(!queue.isEmpty()){
    //         int[] edge = queue.poll();
    //         int x = edge[0];
    //         int y = edge[1];
    //         int count = edge[2];
            
    //         if(x==width && y==0 && count==1){
    //             answer++;
    //             if(answer>10000019) answer%=10000019;
    //         }

    //         if(count==0){
    //             for(int j=0;j<diagonals.length;j++){
    //                 int cx = diagonals[j][0];
    //                 int cy = diagonals[j][1];
    //                 if(x==cx-1 && y==height-cy){
    //                     if(x+1>width || y+1>height) continue;
    //                     visited[x+1][y+1] = true;
    //                     queue.add(new int[]{x+1,y+1,1});
    //                     visited[x+1][y+1] = false;
    //                     break;
    //                 }
    //                 if(x==cx && y==height-cy+1){
    //                     if(x-1<0 || y-1<0) continue;
    //                     visited[x-1][y-1] = true;
    //                     queue.add(new int[]{x-1,y-1,1});
    //                     visited[x-1][y-1] = false;
    //                     break;
    //                 }
    //             }
    //         }

    //         for(int i=0;i<2;i++){
    //             int nx = x+x_direction[i];
    //             int ny = y+y_direction[i];
    //             if(nx<0 || ny<0 || nx > width || ny>height) continue;
    //             if(!visited[nx][ny]){
    //                 visited[nx][ny] = true;
    //                 queue.add(new int[]{nx,ny,count});
    //                 visited[nx][ny] = false;
    //             }
    //         }
    //     }
    // }
    
}

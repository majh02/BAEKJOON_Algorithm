package SK_1차_코테;

import java.util.*;

public class SK3 {
    public static void main(String args[]){
        int width = 51;
        int height = 37;
        int[][] diagonals = {{17,19}};
        System.out.println(solution(width, height, diagonals));
    }

    public static int[] x_direction = {0, 1};
    public static int[] y_direction = {-1, 0};
    public static boolean[][] visited;
    public static int answer;
    public static int solution(int width, int height, int[][] diagonals) {
        answer = 0;
        visited = new boolean[width+1][height+1];
        BFS(width, height, diagonals);
        // DFS(width, height, diagonals, 0, height, 0, 0);
        return answer;
    }

    // public static void DFS(int width, int height, int[][] diagonals, int x, int y, int count, int dist){
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
    //                 visited[x+1][y+1] = true;
    //                 DFS(width, height, diagonals, x+1, y+1, 1, dist+1);
    //                 visited[x+1][y+1] = false;
    //                 break;
    //             }
    //             else if(x==cx && y==height-cy+1){
    //                 if(x-1<0 || y-1<0) continue;
    //                 visited[x-1][y-1] = true;
    //                 DFS(width, height, diagonals, x-1, y-1, 1, dist+1);
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
    //             DFS(width, height, diagonals, nx, ny, count, dist+1);
    //             visited[nx][ny] = false;
    //         }
    //     }
    // }

    public static void BFS(int width, int height, int[][] diagonals){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,height,0});
        visited[0][height] = true;

        while(!queue.isEmpty()){
            int[] edge = queue.poll();
            int x = edge[0];
            int y = edge[1];
            int count = edge[2];
            
            if(x==width && y==0 && count==1){
                answer++;
                if(answer>10000019) answer%=10000019;
            }

            if(count==0){
                for(int j=0;j<diagonals.length;j++){
                    int cx = diagonals[j][0];
                    int cy = diagonals[j][1];
                    if(x==cx-1 && y==height-cy){
                        if(x+1>width || y+1>height) continue;
                        visited[x+1][y+1] = true;
                        queue.add(new int[]{x+1,y+1,1});
                        visited[x+1][y+1] = false;
                        break;
                    }
                    if(x==cx && y==height-cy+1){
                        if(x-1<0 || y-1<0) continue;
                        visited[x-1][y-1] = true;
                        queue.add(new int[]{x-1,y-1,1});
                        visited[x-1][y-1] = false;
                        break;
                    }
                }
            }

            for(int i=0;i<2;i++){
                int nx = x+x_direction[i];
                int ny = y+y_direction[i];
                if(nx<0 || ny<0 || nx > width || ny>height) continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,count});
                    visited[nx][ny] = false;
                }
            }
        }
    }
    
}

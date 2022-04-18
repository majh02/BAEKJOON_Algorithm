//14890번_경사로
//https://yubh1017.tistory.com/55 참고했음

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 경사로 {
    public static boolean[] bridge;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //지도의 크기(N*N)
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i=0;i<N;i++){
            if(solution(N, L, map, i, 0, true)) result++; //행
            if(solution(N, L, map, 0, i, false)) result++; //열
        }

        System.out.println(result);
    }

    public static boolean solution(int N, int L, int[][] map, int x, int y, boolean flag){
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++){
            if(flag) height[i] = map[x][i]; //행 검사
            else height[i] = map[i][y]; //열 검사
        }

        for(int i=0;i<N-1;i++){
            if(height[i]==height[i+1]) continue; //높이가 같은 경우
            else if(height[i]-height[i+1]==1){ //내려가는 경사
                for(int j=i+1;j<=i+L;j++){
                    if(j>=N || height[i+1]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            else if(height[i]-height[i+1]==-1){ //올라가는 경사
                for(int j=i;j>i-L;j--){
                    if(j<0 || height[i]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            else return false;
        }

        return true;
    }
}

    // public static int[] dx = {1, 0};
    // public static int[] dy = {0, 1};
    // public static boolean solution(int N, int L, int[][] map, int x, int y, int dir, int height){
    //     int count = 0;
    //     int nx = x;
    //     int ny = y;
    //     if(height > map[x][y]) height = map[x][y]; 
    //     if(Math.abs(height-map[x][y])==2) return false;
    //     while(map[nx][ny]==height){
    //         count++;
    //         // System.out.println("<eqaul>   map["+nx+"]["+ny+"]: "+map[nx][ny]+", count: "+count);
    //         if((dir==0 && nx==N-1) || (dir==1 && ny==N-1)) break;
    //         nx += dx[dir];
    //         ny += dy[dir];
    //     }
    //     if(map[nx][ny]==map[x][y] && count>=L && (nx==N-1 || ny==N-1)) return true;
        
    //     if(map[nx][ny]-1 == map[x][y] && count>=L){ //다음칸이 높이가 1만큼 더 높은 경우
    //         for(int i=0;i<L;i++){
    //             int installed = dir==0 ? nx : ny;
    //             if(bridge[installed-i]) return false;
    //             bridge[installed-i] = true;
    //         }
    //         return solution(N, L, map, nx, ny, dir, map[nx][ny]);
    //     }
    //     else if(map[nx][ny]+1 == map[x][y]){ //다음칸의 높이가 1만큼 더 낮은 경우
    //         int nnx = nx;
    //         int nny = ny;
    //         count = 0;
    //         while(map[nnx][nny]==map[nx][ny]){
    //             count++;
    //             // System.out.println("<next>   map["+nnx+"]["+nny+"]: "+map[nnx][nny]+", count: "+count);
    //             if((dir==0 && nnx==N-1) || (dir==1 && nny==N-1)) break;
    //             if(count==L) break;
                
    //             int installed = dir==0 ? nx : ny;
    //             if(bridge[installed]) return false;
    //             bridge[installed] = true;
    //             nnx += dx[dir];
    //             nny += dy[dir];
    //         }
    //         if(count==L){
    //             if((dir==0 && nnx==N-1) || (dir==1 && nny==N-1)) return true;
    //             return solution(N, L, map, nx+dx[dir]*L, ny+dy[dir]*L, dir, map[nx][ny]);
    //         }
    //         else return false;
    //     }

    //     return false;
    // }
    

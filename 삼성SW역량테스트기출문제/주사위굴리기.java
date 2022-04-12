//14499번_주사위 굴리기

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 주사위굴리기 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //지도의 세로크기
        int M = Integer.parseInt(st.nextToken()); //지도의 가로크기
        int x = Integer.parseInt(st.nextToken()); //주사위 x좌표
        int y = Integer.parseInt(st.nextToken()); //주사위 y좌표
        int K = Integer.parseInt(st.nextToken()); //명령의 개수
        
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] direction = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<K;i++){
            direction[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static void solution(int N, int M, int[][] map, int[] direction, int x, int y, int ceil, int north, int east){
        int[] dice = new int[6];

        for(int i=0;i<direction.length;i++){
            int dir = direction[i]-1;
            int floor = 5-ceil;
            int south = 5-north;
            int west = 5-east;

            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(dir==0){ //동(east)
                int tmp = west;
                east = ceil;
                ceil = tmp;
            }
            else if(dir==1){ //서(west)
                int tmp = east;
                east = floor;
                ceil = tmp;

            }
            else if(dir==2){ //북(north)
                north = ceil;
                ceil = south;
            }
            else{ //남(south)
                north = floor;
                ceil = north;
            }
        }
    }
}
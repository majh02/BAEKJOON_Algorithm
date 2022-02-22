//11404번_플로이드 - 플로이드워셜 알고리즘 사용
//https://sskl660.tistory.com/61 참고했음
package 최단경로;

import java.io.*;
import java.util.*;

public class 최단경로_11404 {
    public static int n, m;
    public static long[][] dist;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //n : 도시의 개수
        m = Integer.parseInt(br.readLine()); //m : 버스의 개수
        
        //dist 배열 초기화
        dist = new long[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) dist[i][j] = 0; //자기자신으로 가는 비용 = 0
                else dist[i][j] = INF;
            }
        }
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            dist[a][b] = Math.min(dist[a][b], c);
        }
        FloydWarshall();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j]>=INF) sb.append(0+" ");
                else sb.append(dist[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void FloydWarshall(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    dist[j][k] = Math.min(dist[j][k], dist[j][i]+dist[i][k]);
                }
            }
        }
    }  
}

//1956번_운동
package BOJ.최단경로;

import java.io.*;
import java.util.*;

public class 최단경로_1956 {
    public static int V, E;
    public static long[][] dist;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new long[V+1][V+1];
        for(int i=1;i<=V;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        long result = FloydWarshall();
        if(result>=INF) System.out.println(-1);
        else System.out.println(result);
    }

    public static long FloydWarshall(){

        for(int mid=1;mid<=V;mid++){
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid]+dist[mid][j]);
                }
            }
        }

        long result = INF;
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                if(i!=j && dist[i][j]<INF && dist[j][i]<INF){
                    result = Long.min(result, dist[i][j]+dist[j][i]);
                }
            }
        }

        return result;
    }
    
}

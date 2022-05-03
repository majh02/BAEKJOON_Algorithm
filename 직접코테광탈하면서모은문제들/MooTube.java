//15591번_MooTube(Silver)
package 직접코테광탈하면서모은문제들;

import java.io.*;
import java.util.*;

public class MooTube {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] video = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(video[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            video[p][q] = r;
            video[q][p] = r;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                if(video[i][j]!=Integer.MAX_VALUE) continue;
                video[i][j] = dfs(N, video, i, j);
                video[j][i] = video[i][j];
            }
            // System.out.println(Arrays.toString(video[i]));
        }

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            int count = 0;
            for(int j=1;j<=N;j++){
                if(v==j) continue;
                if(video[v][j]>=k) count++;
            }

            sb.append(count+"\n");
        }

        System.out.print(sb);
    }

    public static int dfs(int N, int[][] video, int p, int q){
        if(p<=0 || q<=0 || p>N || q>N) return Integer.MAX_VALUE;
        // System.out.println("p: "+p+", q: "+q);
        if(video[p][q]!=Integer.MAX_VALUE) return video[p][q];
        for(int mid=1;mid+p<q;mid++){
            video[p][q] = Math.min(video[p][q], Math.min(dfs(N, video, p, p+mid), dfs(N, video, p+mid, q)));
            video[q][p] = video[p][q];
        }
        return video[p][q];
    }
}

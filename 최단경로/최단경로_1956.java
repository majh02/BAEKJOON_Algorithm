//1956번_운동
package 최단경로;

import java.io.*;
import java.util.*;

public class 최단경로_1956 {
    public static int V, E;
    public static ArrayList<Node>[] graph;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = (ArrayList[]) new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<Node>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }
    }
    
}

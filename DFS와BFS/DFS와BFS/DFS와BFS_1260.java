//1260번_DFS와 BFS

package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.TextUI;

public class DFS와BFS_1260{
    public static int N, M, V;
    public static int[] start, end;
    public static boolean visited[] = new boolean[1001];
    public static int count = 0;
    public static boolean flag = false;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        start = new int[M+1];
        end = new int[M+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        DFS(V);
        System.out.println(sb);


    }

    public static void DFS(int value){
        System.out.println("count: "+count+", value: "+value+", flag: "+flag);
        if(flag) return;
        if(count==N) {flag = true; return;}
        if(count==0){
            for(int i=1;i<=M;i++){
                if(V==start[i]){
                    visited[start[i]] = true;
                    visited[end[i]] = true;
                    sb.append(start[i]+" "+end[i]+" ");
                    count=2;
                    DFS(end[i]);
                }
                else if(V==end[i]){
                    visited[end[i]] = true;
                    visited[start[i]] = true;
                    sb.append(end[i]+" "+start[i]+" ");
                    count=2;
                    DFS(start[i]);
                }
            }
        }
        else{
            for(int i=1;i<=M;i++){
                if(flag) return;
                if(start[i]==value){
                    if(!visited[end[i]]){
                        visited[end[i]] = true;
                        sb.append(end[i]+" ");
                        count+=1;
                        DFS(end[i]);
                    }
                }
                else if(end[i]==value){
                    if(!visited[start[i]]){
                        visited[start[i]] = true;
                        sb.append(start[i]+" ");
                        count+=1;
                        DFS(start[i]);
                    }
                }
            }
        }

    }

    public static void BFS(int START, int END){

    }
}
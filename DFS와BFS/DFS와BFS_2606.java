//2606번_바이러스
package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS와BFS_2606 {
    public static int N, M;
    public static boolean check[][] = new boolean[101][101];
    public static boolean visited[] = new boolean[101];
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        M = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍의 수

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = true;
        }

        DFS(1);
        System.out.println(count);
    }

    public static void DFS(int p){
        
        visited[p] = true;

        for(int i=1;i<=N;i++){
            if(check[p][i]==true&&visited[i]==false){
                count++;
                DFS(i);
            }
        }
        return;
    }
    
}

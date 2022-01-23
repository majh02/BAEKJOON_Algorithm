//11066번_파일 합치기
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적계획법2_11066 {
    public static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            K = Integer.parseInt(br.readLine());
            int[] cost = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<K;i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }


        }
    }


    public static int[][] dp = new int[][];
    public static int Find_Mincost(){
        return 0;
    }
    
}

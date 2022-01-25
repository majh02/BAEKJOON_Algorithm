//2293번_동전1
package 동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동적계획법2_2293 {
    public static int n, k;
    public static int[] coin;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n+1];
        for(int i=1;i<=n;i++){
            int value = Integer.parseInt(br.readLine());
            if(coin[i-1]==value) continue;
            coin[i] = value;
        }
        Arrays.sort(coin);
        System.out.println(Arrays.toString(coin));

        dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=-1;
            }
        }

        DFS(1,0,k);
        for(int i=1;i<=n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(count);
    }
 
    public static long count=0;
    public static int DFS(int index, int num, int K){
        System.out.println("index: "+index+", num: "+num+", K: "+K+"  first!!");
        if(index>n || index<1) return 0;
        int value=coin[index]*num;;
        while(true){
            if(index>n || index<1) return 0;
            value = coin[index]*num;
            if(value>K){
                value = coin[index]*(num-1);
                break;
            }
            else if(dp[index][K-value]!=-1)
                return dp[index][K-value];
            if(K-value==0){
                dp[index][K-value] = 1;
                System.out.println("coin: "+coin[index]+", num: "+num+", K: "+(K-value)+", value: "+value+"!!!");
                count+=dp[index][K-value];
                return dp[index][K-value];
            }

            System.out.println("coin: "+coin[index]+", num: "+num+", K: "+K+", value: "+value);
            dp[index][K-value] = 1;
            dp[index][K-value] *= DFS(index+1, 0, K-value);  

            if(dp[index][K-value]==1){
                System.out.println("coin: "+coin[index]+", num: "+num+", K: "+(K-value)+", value: "+value+"~~~");
            }
            count+=dp[index][K-value];
            num++;
        }

        return dp[index][K-value];
    }
    
}

//1010번_다리 놓기
package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_1010 {
    public static long[][] div = new long[31][31];
    public static long nCr(int n, int r){
        if(r==0||n==r) div[n][r]=1;
        else if(r==1) div[n][r] = n;
        else if(div[n][r]!=0) return div[n][r];
        else div[n][r] = nCr(n-1,r-1)+nCr(n-1,r);
        return div[n][r];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] west = new int[T];
        int[] south = new int[T];
        StringTokenizer st;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            west[i] = Integer.parseInt(st.nextToken());
            south[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<T;i++){
            System.out.println(nCr(south[i],west[i]));
        }
    }
    
}

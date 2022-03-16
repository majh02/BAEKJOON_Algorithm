//3036번_링
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_3036 {
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<3||N>100) return;
        int[] ring = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            ring[i] = Integer.parseInt(st.nextToken());
        }

        int A = ring[0];
        for(int i=1;i<N;i++){
            int B = ring[i];
            int GCD = gcd(A,B);
            System.out.println(A/GCD+"/"+B/GCD);
        }
    }
}

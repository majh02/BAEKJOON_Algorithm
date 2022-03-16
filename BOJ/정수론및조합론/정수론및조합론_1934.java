//1934번 최소공배수
package BOJ.정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_1934 {
    public static int max(int a, int b){
        return a>b ? a:b;
    }
    public  static int min(int a, int b){
        return a<b ? a:b;
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if(T<1||T>1000) return;

        int[] A = new int[T];
        int[] B = new int[T];
        StringTokenizer st;
        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            if (A[i] < 1 || B[i] < 1 || A[i] > 45000 || B[i] > 45000) return;
        }
        for(int i=0;i<T;i++){
            int GCD = gcd(max(A[i],B[i]),min(A[i],B[i]));
            int result = max(A[i],B[i])*(min(A[i],B[i])/GCD);
            System.out.println(result);
        }
    }
}

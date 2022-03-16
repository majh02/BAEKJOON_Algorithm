//11401번_이항계수3
//nCk = n!/(k!(n-k)!) (k!=0,k!=n)
//https://st-lab.tistory.com/241 참고했음
package BOJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_11401 {
    public static long P = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long fac = factorial(N); //N!
        long denom = factorial(K)*factorial(N-K)%P; //(K!*(N-K)!) mod P
        System.out.println(fac*pow(denom,P-2)%P);

    }

    public static long factorial(long n){
        long result = 1;
        while(n>1){
            result = (result*n)%P;
            n--;
        }
        return result;
    }

    public static long pow(long base, long expo){
        if(expo==1){
            return base%P;
        }

        long tmp = pow(base,expo/2);
        if(expo%2==1){
            return (tmp*tmp%P)*base%P;
        }
        return tmp*tmp%P;
    }
    
}

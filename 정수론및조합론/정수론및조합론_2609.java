//2609번 최대공약수와 최소공배수
package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수론및조합론_2609 {
    public static long min(long a,long b){
        return a<b ? a:b;
    }
    public static long max(long a, long b){
        return a>b ? a:b;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        if(a<1||a>10000||b<1||b>10000) return;

        long gcd = 0;
        long lcm = 0;
        long i = min(a,b);
        while(true){
            if(i==0) break;
            if(a%i==0&&b%i==0){
                gcd = i;
                break;
            }
            i--;
        }

        int j = 1;
        while(true){
            if((min(a,b)*j)%max(a,b)==0){
                lcm = min(a,b)*j;
                break;
            }
            j++;
        }

        System.out.println(gcd);
        System.out.println(lcm);
    }
}

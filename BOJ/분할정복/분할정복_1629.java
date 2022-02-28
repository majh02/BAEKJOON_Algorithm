//1629번_곱셈
//https://st-lab.tistory.com/237 참고했음
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_1629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A,B,C));
    }

    public static long pow(long A, long expo, long C){
        if(expo==1){
            return A%C;
        }

        long tmp = pow(A, expo/2,C);
        if(expo%2==1){
            return (tmp*tmp%C)*A%C;
        }

        return tmp*tmp%C;
    }
}

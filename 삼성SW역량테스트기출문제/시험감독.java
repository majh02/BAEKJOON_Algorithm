//13458번_시험 감독

package 삼성SW역량테스트기출문제;

import java.io.*;
import java.util.*;

public class 시험감독 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //시험장의 개수
        int[] A = new int[N]; //각 시험장의 응시자의 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken()); //총감독관 감시가능 응시자 수 (1명)
        int C = Integer.parseInt(st.nextToken()); //부감독관 감시가능 응시자 수 (여러명)

        long result = 0;
        for(int i=0;i<N;i++){
            A[i] -= B;
            result++;
            if(A[i]<=0) continue;
            result += A[i]%C==0 ? A[i]/C : A[i]/C+1;
        }

        System.out.println(result);
    }
    
}

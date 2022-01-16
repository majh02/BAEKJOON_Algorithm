//1300번_K번째 수
//https://st-lab.tistory.com/281 참고함
package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이분탐색_1300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int count=0;
        int start = 1, end = K;
        while(start<end){
            count=0;
            int mid = (start+end)/2;
            for(int i=1;i<=N;i++){
                count+=Math.min(mid/i, N);
            }

            if(K<=count) end = mid;
            else start = mid+1;
        }

        System.out.println(start);
    }
    
}

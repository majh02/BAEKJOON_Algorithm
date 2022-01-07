//1654번_랜선 자르기
package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이분탐색_1654 {
    public static long[] lines;
    public static long Max = 0, Min = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        lines = new long[K];
        for(int i=0;i<K;i++){
            lines[i] = Long.parseLong(br.readLine());
            Max = Math.max(Max,lines[i])+1;
        }

        System.out.println(find_minlen(K, N));


    }

    public static long find_minlen(int K, long N){
        while(Min<Max){
            long mid = (Max+Min)/2;
            long count = 0;

            for(int i=0;i<K;i++){
                count+=(lines[i]/mid);
            }
            System.out.println("count: "+count+", Max: "+Max+", Min: "+Min);

            if(count < N) Max = mid;
            else Min = mid+1;
        }
        return Min-1;
    }
    
}

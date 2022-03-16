//10816번_숫자카드2
//https://yhwan.tistory.com/10 참고했음
package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_10816 {
    public static long[] A;
    public static long[] B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        A = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        B = new long[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++){
            B[i] = Long.parseLong(st.nextToken());
            int upper_index = upper_binary(B[i], N);
            int lower_index = lower_binary(B[i], N);
            int result = upper_index-lower_index;

            if(upper_index==N-1&&A[N-1]==B[i]) result+=1;
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }

    public static int lower_binary(long target, int size){
        int start = 0, end = size-1;
        while(end>start){
            int mid = (start+end)/2;
            if(A[mid]>=target) end = mid;
            else start = mid+1;
        }
        return end;
    }

    public static int upper_binary(long target, int size){
        int start = 0, end = size-1;
        while(end>start){
            int mid = (start+end)/2;
            if(A[mid]>target) end = mid;
            else start = mid+1;
        }
        return end;
    }
}

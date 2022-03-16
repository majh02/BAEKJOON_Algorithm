//1920번_수 찾기
package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        long[] B = new long[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            B[i] = Long.parseLong(st.nextToken());
            sb.append(binary_search(A, B[i], 0, N-1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int binary_search(long[] A, long target, int start, int end){
        if(start>end) return 0;
        int mid = (start+end)/2;
        if(A[mid]==target) return 1;
        else if(A[mid]>target) return binary_search(A, target, start, mid-1);
        return binary_search(A, target, mid+1, end);
    }
}

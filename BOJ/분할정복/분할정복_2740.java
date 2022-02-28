//2740번_행렬곱셈
package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_2740{
    public static int[][] A;
    public static int[][] B;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<K;j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matrix_mul(N, M, K);
    }

    public static void matrix_mul(int N, int M, int K){
        for(int i=0;i<N;i++){
            for(int j=0;j<K;j++){
                int result = 0;
                for(int k=0;k<M;k++){
                   result+=A[i][k]*B[k][j];
                }
                sb.append(result).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}